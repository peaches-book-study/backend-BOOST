### Topic : Redis
### Item : Redis 세션 관리
### Assignee : hyunsoo10

--- ---

Redis를 세션 키에 대한 적절한 TTL과 함께 빠른 키 값 스토어로 사용하면 간단하게 세션 정보를 관리할 수 있다.

# 🍑 Sub-Topic 1. Spring Session

### Spring Session
📌 스프링 세션은 스프링 기반 어플리케이션에서 세션을 효율적으로 관리하고 처리하기 위한 기술이다. 스프링 세션은 기본적으로 세션 데이터를 서버의 메모리에 저장하는 대신 외부 스토리지에 저장하고 관리한다.

📌 외부 스토리지에 세션을 관리함으로써 여러 서버 간에 세션 데이터를 공유할 수 있기 때문에, 분산 환경에서 활용하기 유용하다.

### Session Clustering
Sessin Clustering이란, 여러 WAS의 Session이 모두 공유되도록 하는 방법을 말한다. 단일 서버 환경에서는 문제가 되지 않지만, 로드 밸런싱을 통해 스케일 아웃된 분산 서버 환경에서는 문제가 발생할 수 있다.

#### 🔧해결 방법

**Sticky Session** : 
- ✅ 로드 밸런서의 설정을 통해 사용자의 요청이 처음 세션을 저장한 서버로만 가도록 설정하는 방법
- ⚠️실시간 트래픽과 상관 없이 세션이 저장된 서버에 요청이 가기 때문에 로드 밸런싱을 한 의미가 없음
- ⚠️특정 서버에 장애가 발생하면 해당 서버에 존재하는 세션이 모두 사라짐

  
**Session Clustering** :  
- ✅ 여러 WAS의 Session이 모두 공유되도록 하는 방법
- ✅ 하나의 서버에 세션이 생성되면 나머지 모든 서버의 세션 저장소에 같은 Session을 생성하는 방식을 이용
- ⚠️ 만약 서버가 많아진다면 하나의 세션이 생성될 때마다 모든 서버에 세션을 생성해야하기 때문에 서버의 메모리 부하


**Redis Session Clustering**
- ✅ Session 저장소를 외부로 분리해서 Redis Session Storage를 활용
- ✅ 하나의 서버에서 세션이 생성될 때 마다 한 번만 저장소에 저장
- ✅ Session 저장소는 거의 모든 인가 요청시에 사용되기 때문에 접근 빈도수가 매우 높은데, 인메모리 기반 Redis를 활용하면 디스크 I/O작업 없이 빠른 속도로 접근하고 조회할 수 있다.



# 🍑 Sub-Topic 2. Redis Client

❗ Redis Client의 오픈소스로 Lettuce, Jedis가 있는데 Spring에서는 현재 Lettuce를 기본으로 사용하고 있다.

- Jedis의 경우 멀티 쓰레드 환경에서 Thread-safe를 보장하지 않는다.
- Lettuce는 netty 기반으로 멀티 쓰레드 환경에서 강태를 가지고 공유할 수 있다. 따라서 멑티쓰레드 환경에서 Lettuce와 상호작용을 할때 여러 쓰레드에서 각각 독립적인 커넥션을 만들 필요가 없다.

# 🍑 Sub-Topic 3. Redis Session 테스트





# 🍑 결론

--- ---
## Referenced by
- https://escapefromcoding.tistory.com/702 (Redis를 로그인 Session Storage로 이용하기)
- https://zuminternet.github.io/spring-session/ (https://zuminternet.github.io/spring-session/)
- https://ksh-coding.tistory.com/128 ( Spring에서 Session 저장소로 Redis 사용하기)
- https://jojoldu.tistory.com/418 (Jedis vs Lettuce)
