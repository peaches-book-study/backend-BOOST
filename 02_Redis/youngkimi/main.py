import redis, os
import datetime, time

redis_client = redis.Redis(host='localhost', port=6379, db=0)

from fastapi import FastAPI

app = FastAPI()

@app.get("/")
def root() :
    return {"message" : "Hello, World!"}

# 문자열을 사용한 속도 제한
@app.get("/request-by-count/{user}")
def request(user: str) :
    # 요청 초기화 시간 5초
    interval = 5
    # 5초 간 최대 5회
    limit = 5
    endpoint='request-by-count'
    key = f'ratelimit:{endpoint}:{user}'
    count = redis_client.incr(key)
    print('redis_count : ', count)
    redis_client.expire(key, interval)
    
    can_request = count <= limit
    print('current_time : ', datetime.datetime.now());
    print('can_request : ', can_request);
    return can_request

# 해시를 사용한 속도 제한
@app.get("/request-by-hash/{user}")
def request(user: str) :
    # 요청 초기화 시간 5초
    interval = 5
    # 5초 간 최대 5회
    limit = 5
    endpoint='request-by-hash'
    key = f'ratelimit:{endpoint}:{user}'
    now = time.time()
    p = redis_client.pipeline()
    # hincrby : 
    # return count
    p.hincrby(key, 'count', 1)
    # hsetnx : 
    # 해쉬 테이블이 존재하지 않는 경우, 새로운 해시 테이블이 생성되어 HSET 동작된다. (return 1)
    # 존재하는 경우에는 동작하지 않는다 (return 0)
    p.hsetnx(key, 'timestamp', now)
    # expire : 설정 여부 반환 (True / False)
    p.expire(key, interval)
    p.execute()

    count = int(redis_client.hget(key, 'count'))
    timestamp = float(redis_client.hget(key, 'timestamp'))
    print('count : ', count)
    print('timestamp : ', timestamp)
    
    # 요청 interval 동안 지나치게 많이 들어온 경우 
    if (count > limit):
        print('Too Many Requests ...')
        return False
    # 현재와 이전 timestamp 비교해서 interval 보다 작으면 유효
    # Limit 넘지 않았고 interval 지났으면 시간초 갱신
    print(now)
    if (now - timestamp < interval) :
        print('Request Ok... But TOOOO FAST')
        return True
    redis_client.hset(key, 'timestamp', now)
    print('RESET TIMESTAMP')
    return True