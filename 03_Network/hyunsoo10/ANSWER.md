# 네트워크 예상질문 리스트

1. TCP와 UDP에 대해 설명하고, TCP와 UDP의 차이에 대해 설명해주세요 ⭐️⭐️⭐️⭐️⭐️
2. TCP에서 데이터의 신뢰성을 보장하기 위한 방법은 어떤 것이 있는지 설명해주세요. ⭐️
    1. 오류제어란 ?
    2. 혼잡제어란 ?
3. 3-way handshaking과 4-way handshaking에 대해 설명해주세요. ⭐️⭐️⭐️
4. 사용자가 URL을 입력한 후 화면이 출력되기까지의 과정을 설명해주세요 ****⭐️⭐️⭐️⭐️⭐️
5. HTTP 프로토콜에 대해 설명해주세요 ⭐️⭐️⭐️
6. HTTP와 HTTPS의 차이점에 대해서 설명해주세요. ⭐️⭐️⭐️⭐️⭐️
    1. 암호화 방식
7. HTTP 1.0과 1.1의 차이에 대해 설명하세요. ⭐️⭐️⭐️
8. 쿠키(Cookie)와 세션(Session)의 차이점에 대해 설명해주세요 ⭐️⭐️
9.  OSI 7 layer와 각 계층에 대해 아는대로 설명해주세요. ⭐️⭐️⭐️⭐️
10. TCP/IP 프로토콜을 스택 4계층으로 설명해주세요. ⭐️⭐️
11. HTTP에서 사용되는 Method와 각 용도에 대해서 설명해주세요. ⭐️⭐️⭐️
12. GET과 POST의 차이를 설명하세요. ⭐️⭐️⭐️⭐️
13. REST(REST API)에 대해 설명하고 RESTful이란 무엇인지 설명해주세요. ⭐️⭐️
14. 공인(public) IP와 사설(private) IP의 차이에 대해 설명해주세요. ⭐️⭐️⭐️
15. 라우팅 알고리즘에 대해서 설명해주세요
16. 라우터와 스위치의 차이에 대해 설명해주세요. ⭐️
17. 세션 기반 인증과 토큰 기반 인증의 차이에 대해 설명하고, 어느 경우에 적합한지 설명해주세요. ⭐️⭐️
18. CORS에 대해 설명해주세요.
19. 유니캐스트, 브로드캐스트, 멀티캐스트, 애니캐스트에 대해 설명해주세요.
20. JWT 토큰에 대해 설명해주세요. ⭐️
21. Connection timeout 과 Read timeout의 차이에 대해 설명해주세요. ⭐️⭐️
22. IOCP에 대해 설명해주세요.
23. POOLING은 무엇인지 설명해주세요.
24. 대칭키, 비대칭키 암호화 방식에 대해 설명해주세요. 
25. DNS란 무엇인지 설명해주세요.

<br>

# 예상 답변

### ✏️ 1. TCP와 UDP에 대해 설명하고, TCP와 UDP의 차이에 대해 설명해주세요.


TCP와 UDP는 네트워크의 계층 중에서 전송 계층(Transport Layer)에서 사용되는 프로토콜

TCP
- 연결 지향적(데이터 전송 전에 연결하고 전송 후에 연결을 종료)
- 데이터 순서 보장과 신뢰성(손실된 패킷은 재전송)
- 흐름 제어 및 혼잡 제어(네트워크의 혼잡 상태나 수신자의 처리 능력에 따라 데이터 전송 속도 조절)

UDP
- 비연결 지향적(연결 설정 없이 데이터 바로 전송)
- 데이터의 신뢰성이나 순서가 보장되지 않음
- 흐름 제어나 혼잡 제어가 불가능하고, 필요하다면 개발자가 직접 구현해야 함

TCP는 데이터의 정확성과 순서를 중시하고, UDP는 빠른 전송 속도와 효율성을 중시



#### ✏️ 1-1. TCP와 UDP를 사용하는 애플리케이션들은 어떤 것들이 있는지 말해보세요.


**TCP를 사용:** 웹브라우저, 이메일, 파일 전송

**UDP를 사용:** 음성 통화, 동영상 스트리밍, DNS  

#### ✏️1-2. UDP에서는 데이터의 순서나 신뢰성을 확보할 수는 없을까요?

실시간 스트리밍에서는 UDP 위에 RTP(Real-time Transport Protocol)를 사용하여 비이도 및 오디오 데이터를 전송하는데, RTP는 실시간성을 우선시하면서도 데이터의 순서와 타이밍 정보를 관리해주는데, 이처럼 추가적인 프로토콜을 사용하거나 개발자가 애플리케이션 레벨에서 추가적인 로직을 통해 구현할 수 있다.

---

### ✏️ 2. TCP에서 데이터의 신뢰성을 보장하기 위한 방법은 어떤 것이 있는지 설명해주세요.

1. 오류제어란 ?
2. 혼잡제어란 ?


**흐름제어:** 송신 측과 수신 측의 데이터 처리 속도가 다를 수 있는데 송신 측이 너무 빠르면 수신측에서 버퍼가 넘치는 오버 플로우 현상이 발생할 수 있기 때문에 윈도우 크그리르 조절하면서 흐름을 제어한다. 

**오류제어:** 전송된 데이터에 오류가 발생했을 때 이를 감지하고 수정하는 것. 긍정 확인 응답(ACK)과 NAK(부정 확인 응답), timeout 기법 등을 통해 데이터가 전달됐는지 여부를 확인한다.

**혼잡제어:** 네트워크 내의 패킷의 수가 과도하게 증가하는 현상을 혼잡이라고 하는데, 이런 현상을 제거하기 위한 기능


#### ✏️ 2-1. AIMD 방식과 Slow start 방식에 대해서 설명해주세요.

**AIMD(Additive Increase / Multiplicative Decrease):** 처음에 패킷을 하나씩 보내고 문제가 발생하지 않으면 위도우 크기를 1씩 증가시키고 패킷 전송에 실패하거나 일정 시간을 넘으면 패킷 전송 속도를 절반으로 줄인다. 윈도우 사이즈를 하나씩 늘려가기 때문에 초기 네트워크의 큰 대역폭을 바로 사용할 수 없다는 단점을 가지며 네트워크가 혼잡해지는 상황을 미리 감지할 수 없고 혼잡 상태가 발생한 이후에 대역폭을 감소시킨다는 특징이 있다.

**Slow start :** 패킷이 문제 없이 도착하면 각각의 ACK 패킷마다 window size를 하나씩 증가시킨다. 즉, 윈도우 사이즈를 두배씩 빠르게 증가시키는 방식으로 AIMD가 선형적으로 증가하는 것과 달리 지수적으로 윈도우 사이즈를 증가시켜 빠르게 네트워크의 대역폭을 사용하게 된다.
하지만 윈도우 사이즈가 임계 값에 도달하면 윈도우 사이즈는 다시 선형적으로 증가하고 혼잡 회피 방식으로 전환된다. 만약 패킷 손실이 감지되면 임계 값을 현재 윈도우 사이즈의 절반으로 감소시키고 윈도우 사이즈는 1로 재설정한다. 이후 다시 slow start를 시작


#### ✏️ 2-2 TCP 혼잡 정책중 Tahoe와 Reno 방식에 대해서 설명해주세요.

**TCP Tahoe :** 쳐음에는 slow start 방식을 사용하다 임계점에 도달하면 AIMD 방식을 사용하는 것이다. 그러다 3 ACK 중복 상황과 타임 아웃이 발생하면 혼잡이라고 판단하여 임계점은 혼잡이 발생한 윈도우 사이즈의 절반으로, 윈도우 크기는 1로 줄인다.

**TCP Reno :** TCP Tahoe 방식이 혼잡 상황이 발생했을 때 윈도우 크기를 1부터 시작해야 한다는 단점을 극복하기 위해 등장한 정책으로, slow start로 시작하여 임계점을 넘어서면 AIMD를 사용하는 점에는 TCP Tahoe 방식과 동일하다. 하지만, 3 ACK 중복 상화과 timeout 혼잡 상황을 구분한다는 것에서 차이가 있다.
Reno은 3 ACK 중복 상황에 윈도우 크기를 1로줄이는 것이 아니라 AIMD 처럼 반으로만 줄이고 임계점도 줄어든 윈도우 값으로 설정한다. 
타임 아웃이 발생하면 TCP Tahoe와 동일하게 윈도우 사이즈를 1로 줄이고 slow start를 시작하지만 임계점의 값은 변경하지 않는다. 즉 타임아웃에 비해 3 ACK 중복상황은 심각한 혼잡상황이라고 판단하지 않는 것이다.

#### ✏️ 2-3 빠른 회복과 빠른 재전송에 대해서 설명해주세요.


빠른 회복 : 패킷 손실이 발생하면 혼잡 회피 방식 때처럼 윈도우 사이즈를 1로 재설정하는 것이 아니라 윈도우 사이즈의 절반으로 줄이고 AIMD 방식으로 동작시킨다.

빠른 재전송 : 먼저 도착해야할 패킷이 도착하지 않고 다음 패킷이 도착한 경우에도 ACK를 보내는데, 이 ACK에 원래 도착해야할 패킷 번호를 담아서 보낸다. 따라서 송신측에 원래 보내야할 패킷이 연속적으로 가게 되고, 송신측에서는 3번 중복해서 패킷을 받으면 해당 패킷을 재전송한다.

🌐 ref. https://yeoneeds.tistory.com/25

---

### ✏️ 3. 3-way handshaking과 4-way handshaking에 대해 설명해주세요.


3-way는 TCP 연결을 시작할 때의 프로세스
4-way는 TCP 연결을 종료할 때의 프로세스

3-way handshaking :
SYN: 클라이언트가 서버에게 연결 요청(SYN 패킷)
SYN-ACK: 서버는 클라이언트의 요청을 받고, 연결을 수락(SYN-ACK패킷을 클라이언트에 보냄)
ACKL 클라이언트는 서버로 부터 SYN-ACK 패킷을 받고 ACK 패킷을 서버에 보내 연결이 성공적으로 설정되었음을 알림

4-way handshaking : 
FIN : 연결을 종료하고자하는 호스트가 FIN 패킷을 보냄
ACK : 상대방은 FIN 패킷을 받고 ACK 패킷을 보내어 FIN 패킷 수신을 알림
FIN : 상대방도 연결 종료를 알리기 위해 FIN 패킷을 보냄
ACK : FIN 패킷을 받은 호스트가 ACK 패킷을 보내 연결 종료


#### ✏️ 3-1. TCP 커넥션을 끊을 때 time wait 상태로 소켓을 지속하는 이유에 대해서 설명해주세요.

1. 종료 요청 전에 전송한 패킷이 라우팅 지연이나 유실로인한 재전송 등으로 인해 FIN 패킷보다 늦게 도착할 수 있는 가능성을 고려해서 해당 소켓이 즉시 재사용되지 못하도록 하기 위함
2. 종료과정에서 마지막 ACK가 손실될 경우 문제가 발생할 수 있기 때문에 이러한 상황을 방지하기 위한 것


#### ✏️ 3-2.  TIM_WAIT의 정해진 표준 시간은?

2MSL로 Maximum Segment Lifetime의 2배에 해당하는 시간이다. MSL은 패킷이 폐기되기전에 네트워크에 존재할 수 있는 시간을 의미한다.

---

### ✏️ 4. 사용자가 URL을 입력한 후 화면이 출력되기까지의 과정을 설명해주세요

1. URL구조를 확인한 후에 
https ://www.naver.com : 443
{protocol} :// {domain} : {port}
구조로 파싱해서 사용할 프로토콜을 정한다.

2. 이후 DNS 서버를 통해 도메인을 IP주소로 변환

3. 서버의 IP 주소를 알았으면 브라우저는 서버와 TCP 연결을 시작(3-way handshaking)

4. 연결이 성공적으로 이루어졌으면 브라우저는 웹서버에 웹 페이지 데이터를 요청

5. 웹 서버는 요청 받은 웹 페이지 데이터를 브라우저로 전송(주로, HTML, CSS, Javascript파일)

6. 브라우저는 받은 데이터를 해석하고 처리하여 사용자에게 표시


#### ✏️ 4-1. HSTS(Http Strict-Transport Security) 가 무엇인지 설명해보세요


웹사이트가 오직 https 를 통해서만 접근이 가능하다고 선언하여 보안 연결을 강제하는 정책으로 웹서버가 모든 클라이언트에 대해 안전하지 않은 HTTP 연결은 거부하고 HTTPS만을 허용한다고 명시하는 것

#### ✏️ 4-2. IP 주소와 MAC 주소의 역할에 대해서 말해보세요.

IP 주소는 우리가 접속하려는 서버의 네트워크를 찾기위해서 필요한 것이고, MAC 주소는 그 네트워크 내부에 있는 컴퓨터와 통신하기 위해 필요하다. IP 주소는 OS에서 설정한 논리적인 주소이고 MAC 주소는 컴퓨터의 NIC에 할당되어 있는 물리적인 주소다.


### ✏️ 5. HTTP 프로토콜에 대해 설명해주세요


Hyper Text Transfer Protocol의 약자로 웹 서버와 클라이언트 간의 데이터 교환을 위한 프로토콜
HTTP는 TCP/IP 통신을 사용해서 데이터를 주고 받음
다양한 요청방식(GET, POST, PUT, PATCH, DELETE)과 상태 코드(200, 404, 500) 를 포함하여 데이터 교환과 통신의 효율성을 높임 


#### ✏️ 5-1. HTTP 서비스를 제공하는 서버 소프트웨어는 어떤 것들이 있나요?

오픈 소스인 아파치와 엔진엑스와 윈도우 OS에 기본적으로 탑재되어 있는 IIS 이렇게 3가지 가 제일 유명함


#### ✏️ 5-2.  HTTP 상태 코드의 종류에 대해서 설명해주세요

200번 대의 상태 코드는 성공을 의미
300번 대의 상태 코드는 클라이언트의 요청을 마치기 위해 추가 동작을 취해야 함을 의미하는 것으로 리다이렉션과 관련된 상태
400번 대의 상태 코드는 유효하지 않은 자원을 요청하거나 권한이 잘못된 경우 등 클라이언트 에러를 의미
500번 대의 상태 코드는 서버쪽에서 오류가난 서버에러를 의미

---

### ✏️ 6. HTTP와 HTTPS의 차이점에 대해서 설명해주세요.
- 암호화 방식

두 프로토콜의 차이는 HTTPS가 HTTP에 비해 데이터 전송시에 보안을 강화한 것
HTTP는 기본 포트가 80
HTTPS 는 기본 포트가 443
HTTP는 데이터가 암호화되지 않아 중간에 누군가 데이터를 가로챌 경우 정보가 노출될 위험이 있는 반면 HTTPS는 데이터를 암호화하여 전송하기 때문에 중간에 데이터를 가로채더라도 해독하기 쉽지 않다. 

HTTPS의 암호화는 SSL(Secure Socket Layer)/TLS(Transport Layer Security) 프로토콜을 사용하여 구현하는데 SSL이 버전업되면서 더 발전된 보안 기능을 제공하는 것이 TLS이다. 
SSL/TLS를 사욤함으로써 데이터의 도청, 데이터의 변조, 통신 상대의 위장을 막을 수 있다.
암호화 : 데이터를 암호화해서 제 3자가 도청해도 내용을 알 수 없게 함
해시화 : 해시값을 계산해서 데이터와 함께 전송함으로써, 제 3자가 데이터를 변조하더라도 서버에서 해시값을 비교해 변조를 파악할 수 있음
디지털 인증서 : 서버에 디지털 인증서를 요구하면 서버는 디지털 인증서를 보내고, 클라이언트는 전송받은 디지털 인증서를 보고 서버의 신원을 확인할 수 있음

#### ✏️ 6-1. 공통키 암호화 방식과 공개키 암호화 방식에 대해서 설명해주세요.

암호화 방식
암호화 방식을 사용하기 위해선 암호화할 수 있는 '암호화 키'와 해석할 수 있는 '복호화 키'가 필요한데, 해당 키를 어떻게 사용하고 관리하느냐에 따라 두 가지 방식으로 나뉜다.
공통키 암호화 방식 : 서버와 클라이언트가 암호화 키와 복호화 키로 같은 키를 사용하는 방식으로 클라이언트가 암호화 키로 암호화 하면 서버가 완전히 동일한 키로 복호화 하는 방법. 구조가 단순하기 때문에 처리 부하가 걸리지 않지만 사전에 키를 공유해야 하므로 키 배송 문제를 고려해야 함
공개키 암호화 방식 : 암호화 키와 복호화 키로 다른 키를 사용하는 암호화 방식. 수학적인 관계로 만들어진 암호화 키와 복호화 키는 해당 암호화 키로 암호화 한 것은 해당 복호화 키로만 풀 수 있다. 서버에는 암호화 키를 '공개키'로 인터넷 상에 공개하고, 복호화 키를 '비밀키'로 서버에 저장한다. 클라이언트는 공개된 키를 사용해 데이터를 암호화해서 서버에 보내고, 서버는 비밀키로 복호화한다. 해당 키로부터 복호화 키를 만들어 낼 수 없기 때문에 키 배송 문제에 신경 쓸 필요가 없지만 처리가 복잡하기 때무에 처리 부하를 고려해야 한다.

두 가지 암호화 방식의 조합
SSL/TLS는 두 가지 방식을 조합한다. 서버가 공통키를 생성하고, 데이터를 공통키로 암화하고 해당 공통키를 클라이언트A의 공개키로 암호화 하여 클라이언트A에 전송한다. 클라이언트A는 개인키를 사용해서 공통키를 해독하고, 해독한 공통키를 사용해서 데이터를 복호화 한다. 

#### ✏️ 6-2. HTTPS는 보안 말고 또 다른 장점은 없나요?

SEO 품질에도 우위가 있다. 구글이 HTTPS 웹사이트에 가산점을 주기도 하지만, 사용자들은 결국 안전하다고 생각하는 사이트를 더 많이 방문하기 때문에 HTTPS를 지원하는 웹사이트르 더 많이 방문하게 된다.

---

### ✏️ 7. HTTP 1.0과 1.1의 차이에 대해 설명하세요.

HTTP 1.0 과 1.1의 가장 큰 차이는 연결의 지속성이다
HTTP 1.0 : 매번 데이터를 요청하고 수신할 때마다 새로운 TCP 세션을 맺어야 함
HTTP 1.1 : 한번의 TCP 세션에 여러개의 요청을 보내고 응답을 수신할 수 있음

HTTP 1.0은 파이프라이닝을 제공하지 않는 반면 HTTP 1.1은 파이프라이닝 기능을 제공한다. 파이프라이니닝 기능이란, 송신자가 다수의 패킷을 한번에 보내는 것을 말한다. 즉, ACK 신호를 받고 다음 데이터를 보내는 stop and wait 방식이 아니라 송신자가 ACK 신호를 받지 않아도 패킷 여러 개를 보내는 방식인 Go-Back-N 혹은 Selective Rpeat 방식으로 데이터를 주고받을 수 있다.

호스트헤더 : HTTP 1.0은 하나의 IP 주소에 여러 개의 도메인을 운영할 수 없었기 때문에 도메인 별로 IP를 구분해야 했지만 HTTP 1.1은 가상 호스팅이 가능해졌기 때문에 하나의 IP 주소에 여러 개의 도메인을 적용시킬 수 있다.

### ✏️ 7-1. Go-Back-N 방식과 Selective Repeat 방식에 대해서 설명해주세요.

Go-Back-N 방식은 오류가 감지된 패킷과 그 이후의 모든 패킷을 재전송하기 때문에 네트워크 대역폭을 많이 소모하며 패킷 손실률이 높은 환경에서 효율성이 크게 떨어진다.
Selective Repeat 방식은 오류가 감지된 패킷만을 재전송함으로써 네트워크 자원을 효율적으로 사용할 수 있다. 하지만 Selective Repeat 방식은 수신측의 윈도우 사이즈를 sequence number 개수의 절반 이하로 설정해야 중복된 패킷을 받는 문제를 해결 할 수 있다.

### ✏️ 7-2. HTTP 2.0에 대해서 설명해주세요

HTTP 2.0은 HTTP 1.1과 달리 여러 개의 요청을 병렬적으로 처리하고, 요청 및 응답 헤더를 텍스트로 보내는 것이 아니라 이진 형식으로 인코딩하여 압축하여 보냄으로써 더 효율적으로 데이터를 전송할 수 있다.

🌐 ref. https://code-lab1.tistory.com/27

---

### ✏️ 8. 쿠키(Cookie)와 세션(Session)의 차이점에 대해 설명해주세요

쿠키와 세션은 사용자의 상태 정보를 관리하기 위해 사용되는 기술로 stateless를 지향하는 HTTP 프로토콜의 특성상 사용자의 상태 정보를 유지할 방법이 필요한데, 이를 위해 사용되는 것이 바로 쿠키와 세션이다.

쿠키와 세션의 가장 큰 차이는 저장 위치
쿠키는 클라이언트 측에 저장하고, 세션은 서버 측에 저장된다.

쿠키
- 클라이언트에 총 300개의 쿠키를 저장
- 도메인 당 20개의 쿠키
- 하나의 쿠키는 4KB까지 저장 가능
- 만료기간을 지정할 수 있지만 브라우저를 종료해도 정보가 유지
세션
- 저장 데이터에 제한이 없음(서버 용량이 허용하는 만큼)
- 각 클라이언트에 고유 Session ID를 부여하고 세션 ID로 클라이언트 구분
- 만료기간을 정할 수 있지만, 브라우저가 종료되면 만료기관에 상관없이 삭제된다.

#### ✏️ 8-1. 세션이 보안이 더 좋은데 쿠키를 사용하는 이유는?

세션이 쿠키에 비해 보안이 높지만, 세션은 서버의 자원을 활용하기 때문에 서버 자원의 낭비를 방지하고자 쿠키와 세션을 적절한 요소 및 기능에 맞게 병행 사용하여 효율적으료 사용할 수 있음.

#### ✏️ 8-2. 쿠키와 세션을 사용하지 않을 때 발생할 수 있는 문제의 간단한 사례를 이야기해주세요.

HTTP 프로토콜은 클라이언트의 상태정보를 유지하지 않는 stateless 특성을 가지고 있기 때문에 문제가 발생할 수 있다. 예를 들어 페이지를 이동할 때마다 로그인을 다시 해야하고, 상품 선택 후 구매 페이지에서 선택한 상품의 정보가 없어지는 등의 문제가 발생한다. 이러한 문제를 해결하기 위해서 사용하는 방법이 쿠키와 세션이다.

🌐 ref. https://dev-coco.tistory.com/61

---

### ✏️ 9. OSI 7 layer와 각 계층에 대해 아는대로 설명해주세요.

OSI 7게층 모델은 네트워크 통신을 위한 표준 모델로 데이터 전송 과정을 7개의 계층으로 나누어 각각의 역할을 정의한 것이다. 각 계층은 독립적으로 작동하면서 하위 계층의 기능을 상위 게층에 제공한다.
상위 계층은 주로 통신 기능에 집중하고, 하위 계층은 데이터 전송 및 오류 제어를 담당
7 -  Application Layer : 사용자 및 응용 프로그램간의 통신을 지원하는 계층으로 대표적인 프로토콜로 HTTP가 있다.
6 - Presentation Layer : 데이터의 형식을 변환하고 암호화 하여 상위 계층으로 전달.
5 - Session Layeer : 데이터 동기화, 세션 관리, 다중 사용자 접근 관리 등 통신하는 두 장치간의 세션을 관리
4 - Transport Layer : 송신자와 수신자 간의 신뢰성 있는 데이터 전송을 담당. 데이터의 분할 및 제조립, 흐름 제어, 오류 검사 및 복구 등을 수행. TCP/UDP 프로토콜이 사용됨
3 - Network Layer : 데이터 패킷의 경로 선택 및 전달을 관리. 라우팅과 네트워크에서의 트래픽 제어를 담당
2 - Data Link Layer : 패킷 데이터를 프레임이라는 작은 단위로 분할해서 물리 계층으로 전달. 이더넷, MAC 주소를 사용하는 스위치 등이 해당
1 - Physical Layer : 데이터 링크에서 전송된 데이터를 물리적인 전송 매체(케이블)를 통해 다른 시스템에 전기적 신호를 전송하는 역할

#### ✏️ 9-1. 데이터라는 이름이 계층별로 어떻게 불리는지와 그 이유에 대해서 설명하시오.

사용자가 데이터라고 부르는 단위는 계층별로 정보들이 추가되면서 각각 다른 용어로 불리게 된다.
전송 계층에서는 포트와 seq 넘버 등의 정보가 추가되면서 세그먼트라고 불림
전송 계층에서 전달받은 세그먼트는 네트워크 계층의 정보를 포함하면서 패킷이라고 불림. 패킷에는 IP 주소의 정보가 추가됨.
데이터 링크 계층에서는 물리적인 매체를 통해 데이터를 전송하기 위해 프레임 형식으로 데이터를 구성하기 때문에 프레임으로 불린다.
물리 계층에서는 해당 프레임을 비트로 연산하고 다룬다.

#### ✏️ 9-2. OSI 7계층으로 나눈 이유가 무엇일까요?

우선 통신이 일어나는 과정을 단계별로 파악함으로써 흐름을 알기 쉽게한다.
하지만 무엇보다 특정한 곳에 이상이 생기면 다른 단계의 장비나 소프트웨어를 건들이지 않고 이상이 생긴 단계의 문제만 해결하면 되기 때문에 문제 파악과 해결에도 용이하다.

---

### ✏️ 10. TCP/IP 프로토콜을 스택 4계층으로 설명해주세요. 

TCP/IP 프로토콜의 4계층 모델


응용 계층(Application Layer) - 사용자와 서비스 제공자 간의 상호작용을 관리

전송 계층(Transport Layer) - 데이터의 신뢰성있는 전송을 보장

인터넷 계층(Internet Layer) - 데이터의 경로 선택 및 전송을 관리하고 라우팅 수행

네트워크 접근 계층(Network Access Layer) - 물리적인 네트워크에 직접적으로 접근하여 데이터 전송을 관리

#### ✏️ 10-1. 각 계층에서 사용되는 프로토콜은 뭐가 있나요?

응용 계층 - HTTP, HTTPS, FTP, SMTP, DNS 등이 있다.

전송 계층 - TCP, UDP, RTP

인터넷 계층 - IP, ARP

네트워크 접근 계층 - 이더넷, 와이파이

#### 10-2. TCP/IP 계층의 캡슐화와 역캡슐화에 대해서 설명해주세요.

데이터 전송시 상위 계층에서 하위 계층으로 이동할 때 필요한 정보가 헤더에 추가되는 것을 캡슐화라고 하고, 데이터 수신시 추가된 해더를 읽고 알맞은 행동을 취한 후에 헤더를 제거하는 것을 역캡슐화라고 한다. 

---

### ✏️ 11. HTTP에서 사용되는 Method와 각 용도에 대해서 설명해주세요. 

GET : 서버에서 리소스를 가져오기 위해 사용

POST : 서버로 데이터를 보내기위해 사용

PUT : 서버에 리소스를 업데이트하기 위해 사용

DELETE : 서버에서 리소스를 삭제하기 위해 사용

PATCH : 리소스의 부분적인 업데이트를 위해 사용

#### ✏️ 11-1 위의 메서드 말고 다른 메서드가 있는지? 있다면 설명해주세요.

HEAD, OPTIONS, CONNECT, TRACE 등의 메서드가 존재

HEAD : GET 메서드와 유사하지만, 실제 데이터를 반환하지 않고 응답 헤더만을 반환

OPTIONS : 서버에서 지원되는 HTTP 메서드를 확인하기 위해 사용. 브라우저는 OPTIONS 요청을 보내서 서버로부터 특정 리소스에 대한 권환을 확인

CONNECT : 클라이언트와 대상 서버간이 TCP/IP 터널을 설정할 때 사용

TRACE : 클라이언트가 서버로 보낸 요청 메시지가 서버에 도달했을 때 해당 요청 메시지를 서버가 다시 클라이언트로 보내는 데 사용. 주로 디버깅과 테스트 목적으로 사용

#### ✏️ 11-2. REST API에 대해서 설명해주세요.

REST API란 REST 기반으로 만들어진 API를 뜻한다. REST란 Representational State Transfer의 약자로 자원의 이름으로 구분하여 해당 자원의 상태를 주고 받는 것을 의미한다. 즉, HTTP URI를 통해 자원을 명시하고, HTTP 메서드를 통해 해당 자원에 대한 CRUD 작업을 적용하는 것을 의미한다. 이런 REST 원리를 지켜서 만드는 API를 REST API라고 한다.

### ✏️ 12. GET과 POST의 차이를 설명하세요.

GET : URL의 쿼리 문자열을 통해 데이터를 전송하기 때문에 보안에 취약하고 주로 작은 양의 데이터를 전송하는데 사용

POST : 요청 본문에 데이터를 포함하여 전송하기 때문에 URL에 직접 노출되지 않고 보안적으로 더 우수함. 전송할 수 있는 데이터의 양에 제한도 없음

메서드의 목적에도 차이가 있는데 GET 요청은 주로 서버로부터 데이터를 요청하고 가져오는 데 사용되고 POST 요청은 서버로 데이터를 제출하고 업데이트 하는 데 사용된다. 

캐싱의 가능 여부에서도 차이가 있다. GET 요청은 캐싱이 가능하기 때문에 동일한 요청에 대해서 응답이 캐시될 수 있지만, POST 요청은 캐싱이 불가능해서 항상 새로운 응답을 받는다.

#### ✏️ 12-1.  PUT과 POST의 차이

PUT과 POST의 차이는 멱등성으로 PUT 메서드는 멱등성을 가진다. 즉, PUT 메서드는 같은 객체를 여러번 보내도 한 번만 생성되거나 계속해서 같은 값을 보낸다. 반면에, POST 메서드는 동일한 데이터를 여러번 보내면 중복된 데이터가 생성될 수 있다.

#### ✏️ 12-2. PUT과 PATCH의 차이

PUT메서드는 리소스의 완전한 교체를 위해 사용하고, PATCH 메서드는 부분적인 교체를 할 때 사용하는 메서드이다. 또한, PUT은 세로운 리소스를 생성할 수 있지만 PATCH는 새로운 리소스를 생성하지 않는다.

---

### ✏️ 13. REST(REST API)에 대해 설명하고 RESTful이란 무엇인지 설명해주세요.

REST API란 REST 기반으로 만들어진 API를 뜻합니다. <br>
REST란 Representational State Transfer의 약자로 자원의 이름으로 구분하여 해당 자원의 상태를 주고 받는 것을 의미합니다.<br>
API 개발은 여러 아키텍처를 사용해서 API를 설계할 수 있는데, REST 아키텍처 스타일을 따르는 API를 REST API라 하고, 해당 규약을 잘 따라서 설계된 것을 RESTful하다고 말합니다. <br>

REST 스타일은 쉽게 말하면 <br>
HTTP URI를 통해 자원을 명시하고, <br>
HTTP 메서드를 통해 해당 자원에 대한 CRUD 작업을 적용하는 것을 의미합니다. <br>

REST의 특징으로는
- 서버-클라이언트 구조 : 시스템은 클라이언트와 서버로 분리되어야 하며, 각각의 역할은 독립적으로 발전할 수 있어야 합니다.
- 무상태 : 서버는 각각의 요청을 독립적인 요청으로 처리하고 클라이언트의 상태를 저장하지 않아야 합니다. 각 요청은 필요한 모든 정보를 포함해야 합니다.
- 캐시 처리 가능 : 클라이언트는 서버의 응답을 캐시할 수 있어야 합니다. 서버는 응답에 캐싱 가능성을 명시해야 합니다.
- 계층화 : 클라이언트는 서버와 직접 통신할 때, 중간 서버(로드 밸런서, 캐시 등)를 거칠 수 있어야 합니다. 이는 시스템의 확장성과 보안성을 향상시킵니다.
- 인터페이스 일관성 : 시스템의 인터페이스는 일관성 있어야 하며, 리소스에 대한 식별을 위한 URI, 리소스에 대한 행위를 나타내는 HTTP 메서드, 메시지 내용을 표현하는 MIME 타입 등이 포함되어야 합니다.

#### ✏️ 13-1. API란 무엇인가요

API(Application Programming Interface)<br>
API는 소프트웨어 프로그램이 서로 상호작용할 수 있도록 정의하는 인터페이스입니다. API를 통해 한 소프트웨어의 기능이 다른 소프트웨어에서 사용될 수 있습니다. 즉, 개발자가 다른 소프트웨어 시스템과 통신하기 위해 따라야 하는 규칙을 명확하게 정의하는 것을 말합니다.

#### ✏️ 13-2. REST API의 설계 규칙에 대해서 아는대로 설명해주세요.
- URI는 동사보다 명사를, 대문자보다는 소문자를 사용하여야 한다.
- 마지막에 슬래시를 포함하지 않는다.
- 언더바 대신 하이폰을 사용한다.
- 파일확장자는 URI에 포함하지 않는다.
- 행위를 포함하지 않는다.

🌐 ref. https://aws.amazon.com/ko/what-is/restful-api

---

### ✏️ 14. 공인(public) IP와 사설(private) IP의 차이에 대해 설명해주세요.

공인 IP 주소는 인터넷에서 유일한 IP 주소입니다. ICANN(Interner Corporation for Assigned Names and Numbers)라는 민간 비영리 법인과 그 하부조직에 의해 계층적으로 관리 및 할당되며, 자유롭게 할당할 수 없습니다.<br>
사설 IP 주소는 조직이나 가정 등의 LAN에서 자유롭게 할당할 수 있는 IP 주소입니다.


#### ✏️ 14-1. 사설 IP 주소의 클래스별 IP 범위 값에 대해 아시나요?

클래스 A : 10.0.0.0 ~ 10.255.255.255
클래스 B : 172.26.0.0 ~ 172.31.255.255
클래스 C : 192.168.0.0 ~ 192.168.255.255

#### ✏️ 14-2. 서브넷과 서브넷 마스크에 대해서 아는대로 설명해주세요.

서브넷은 하나의 대규모 네트워크를 작은 부분으로 나누는 것을 의미합니다. IP 주소 공간을 논리적으로 분할하여 네트워크를 세분화하여 관리할 수 있습니다. 이를 실현하기 위해서사용하는 방법이 서브넷 마스크라는 기술입니다. 서브넷 마스크는 IP 주소를 네트워크과 호스트 부분으로 구분하는 역할을 합니다. IP 주소와 같은 길이를 가지며, 네트워크 부분은 1로, 호스트 부분은 0으로 표시됩니다.
서브넷 마스크는 IP주소와 함께 사용되어 특정 IP 주소가 속한 서브넷을 결정하는 데 사용됩니다. 
예를들어 어떤 가정의 IP 주소를 192.168.1.0"라고 한다면, 이 주소는 네트워크 주소를 나타냅니다. 그리고 각 디바이스는 이 네트워크 안에서 특정한 주소를 가지게 됩니다. 예를 들어, 컴퓨터는 "192.168.1.10", 스마트폰은 "192.168.1.20" 등등의 주소를 할당받을 수 있습니다.

#### ✏️ 14-3. NAT(Network Address Translation)이란 무엇이며, 어떻게 작동하나요? 왜 사용되나요?

NAT는 사설 네트워크 내부의 여러 장치가 단일 공인 IP 주소를 사용하여 외부 네트워크와 통신할 수 있도록 하는 기술입니다. 이는 IP 주소 부족 문제를 해결하고 네트워크 보안을 강화하는 데 도움이 됩니다. <br>
작동원리는 LAN으로 부터 외부 네트워크로 접근할 때는 송신원 IP 주소를 공인 IP주소로 변환하고, 외부 네트워크에서 LAN으로 들어올 때는 수신IP 주소가 사설 IP주소로 변환됩니다. 그리고 이런 변경 전후의 IP 주소는 NAT 테이블에 저장되고 관리됩니다. 

---

### ✏️ 15. 라우팅 알고리즘에 대해서 설명해주세요

라우팅 알고리즘은 네트워크에서 데이터 패킷이 출발지에서 목적지까지 전달되는 경로를 결정하는 방법으로, 여러 경로 중에 최적의 경로를 선택하고 데이터를 전달합니다.
<br>
라우팅 알고리즘에는 크게 두 가지 종류가 있다.
<br>
전체적인 네트워크 상황을 알고, 이를 토대로 라우팅 경로를 판단하는 Link State 알고리즘, <br>
특정 라우터와 연결된 이웃 라우터의 정보만을 가지고 판단하는 Distance Vector 알고리즘이다.

Link State 알고리즘에는 다익스트라 알고리즘이,<br>
Distance Vector 알고리즘에는 벨만포드 알고리즘이 있다. <br>
다익스트라 알고리즘은 음의 가중치를 처리하지 못하는 반면 벨만포드 알고리즘은 음의 가중치가 있는 경우에도 사용할 수 있습니다.

#### ✏️ 15-1. 동적 라우팅과 정적 라우팅에 대해서 설명해주세요.
라우터는 미리 만들어진 라우팅 테이블을 사용해 IP 패킷의 전달 대상지를 관리합니다. 라우팅 테이블에는 수신 네트워크와 그 수신 네트워크에 대한 수신지 IP 주소인 네트워크 홉으로 구성되어있습니다. 이런 라우팅 테이블을 만드는 방법으로 바로 동적 라우팅과 정적 라우팅이 있습니다. 정적 라우팅은 수동으로 라우팅 테이블을 만드는 방법으로 수신지 네트워크와 넥스트 홉을 일일이 설정합니다. 설정과 관리가 쉽기 때문에 소규모 네트워크에서 주로 사용합니다.
동적 라우팅은 근처에 있는 라우터 사이에서 경로 정보를 교환하면서 자동으로 라우팅 테이블을 만드는 방법으로 네트워크 환경의 변화에 대응하기 쉬으므로 중간 규모에서 대규모의 네트워크 환경에서 자주 사용됩니다.

#### ✏️ 15-2. ARP 에 대해서 설명해주세요.
ARP는 IP 주소를 MAC 주소로 매핑하여 네트워크 통신을 가능하게 하는 프로토콜입니다. MAC 주소는 컴퓨터의 NIC에 할당되는 물리적 주소인 반면 IP주소는 OS에서 설정하는 논리적인 주소입니다.
컴퓨터는 네트워크층으로부터 받은 IP 패킷을 이더넷 프레임으로 만들어서 케이블로 흘려보내야 하는데 이때 MAC 주소가 필요합니다. 따라서 ARP를 사용해서 MAC 주소를 구합니다. <br>

수신지와 송신지 컴퓨터가 같은 네트워크에 속해있는 경우 송신지 컴퓨터가 ARP요청을 브로드캐스트 방식으로 날립니다.
네트워크게 연결된 모든 장비들이 해당 요청을 수신하고, 해당 IP 주소를 가진 컴퓨터가 자신의 MAC 주소를 응답합니다. 그리고 해당 IP와 MAC 주소의 관계는 ARP 테이블이라는 물리 메모리상의 테이블에 등록되고 관리됩니다. 스위치가 ARP 요청을 받아서 응답하고 기록해주는 역할을 합니다.

다른 네트워크에 속해있다면, ARP 요청을 라우터를 통해 이루어집니다.
송신지 컴퓨터는 자신의 디폴트 게이트웨이인 라우터에 ARP 요청을 보내고, 라우터는 ARP 프로토콜을 사용하여 다른 네트워크로 패킷을 전달할 수 있는 적절한 라우터나 스위치의 MAC 주소를 찾습니다. 이러한 과정을 통해 최종 목적지 장비인 수신지 컴퓨터의 MAC주소를 찾을 수 있습니다.

---

### ✏️ 16. 라우터와 스위치의 차이에 대해 설명해주세요.

라우터는 서로 다른 네트워크 간의 통신을 관리하고 결정하는 역할을 하며 네트워크 계층에서 작동합니다. <br>
스위치는 내부 네트워크에서 장치들 간의 통신을 관리하고 흐름을 제어하는 역할을 하며 데이터 링크 계층에서 작동합니다.

라우터의 주된 역할은 패킷을 전달하는 것으로,
- 두 개 이상의 네트워크를 연결하고 데이터를 이동시킵니다.
- IP 주소를 기반으로 패킷을 전달하며, 네트워크 간의 통신을 가능하게 합니다.
- 라우터는 패킷의 출발지와 목적지를 확인하고 최적의 경로를 결정하여 전송합니다.

스위치의 주된 역할은 물리적인 네트워크를 연결하고 네트워크에서의 트래픽 흐름을 제어하는 것입니다.
- 패킷을 받아 해당 패킷을 받아야 할 포트로 전송하며, 이를 통해 효율적인 네트워크 통신을 가능하게 합니다.
- 주로 이더넷 기반의 네트워크에서 사용되며, 스위치 내에는 여러 개의 포트가 있어 여러 장치를 연결할 수 있습니다.

#### ✏️ 16-1. 스위치와 허브의 차이에 대해서 아시나요.
스위치는 특정 데이터를 목적지 포트로만 전달하는 반면에, 허브는 데이터를 모든 포트로 전송합니다.

#### ✏️ 16-2. 라우터의 NAT와 NAPT에 대해서 설명해주세요.
기업이나 가정의 LAN에서 사용하는 사설 IP 주소를 인터넷에서 사용하는 공인 IP 주소로 변환하는 기술입니다. NAT는 사설 IP 주소와 공인 IP 주소를 1:1로 묶어서 변환합니다. NAPT는 IP 주소뿐만 아니라 포트 번호도 사용해 하나의 공인 IP 주소에 여러 사설 IP 주소를 변환할 수 있습니다. 

--- 

### ✏️ 17. 세션 기반 인증과 토큰 기반 인증의 차이에 대해 설명하고, 어느 경우에 적합한지 설명해주세요.

세션 기반 인증과 토큰 기반 인은 웹 애플리케이션에서 사용자 인증/인가 방법입니다. <br>
세션 기반 인증방식은 서버는 사용자의 상태를 세션에 저장하고 이를 통해 사용자를 인증하고 인가합니다.
토큰 기반 인증방식은 사용자의 상태를 서버에 저장하는 대신 클라이언트 측에서 상태를 관리합니다. 사용자가 로그인하면 서버는 토큰을 생성하고 이를 클라이언트에게 전달합니다. 클라이언트는 이 토큰을 보관하고, 인증이 필요한 모든 요청에 해당 토큰을 함께 전송합니다. 서버는 토큰을 검증하여 사용자를 인증하고 인가합니다. 토큰은 일반적으로 JSON Web Token(JWT)의 형태로 사용됩니다.

세션 기반 인증은 서버에서 사용자 상태를 저장하고 관리하기 때문에 보안 문제가 발생할 가능성이 높은 경우에 사용하기 적합하고, 토큰 기반 인증 방식은 분산 시스템 환경에서 서버의 확장성을 높이고 싶을때 사용하기 적합합니다.

#### ✏️ 17-1. 인증과 인가의 개념에 대해서 설명해주세요
인증 : 스스로를 증명하다는 뜻이며, 흔히 말하는 로그인 개념. 아이디와 패스워드를 통해 자신임을 증명하는 것을 의미합니다.<br>
인가 : 허가나 권한이라는 개념으로, 인증이된 사용자라도 이에 접근할 수 있는 권한이 있는지 확인하는 과정을 의미합니다.

---

### ✏️ 18. CORS에 대해 설명해주세요.

CORS(Cross-Origin Resource Sharing)는 교차 출처 리소스 공유 정책이라는 뜻입니다. 여기서 Origin이란 프로토콜+호스트(도메인)+port로 이루어진 URL을 의미합니다. 웹 브라우저는 보안적인 이유로  SOP(Same Origin Policy), 즉 동이란 출처에서만 리소스를 공유할 수 있다는 정책을 가지고 있습니다. 만일 이러한 제약이 없다면 해커가 CSRF(Cross-Site Request Forgery) 혹은 XSS(Cross-Site Scripting) 등의 방법을 이용해서 사용자 모르게 악의적인 홈페이지에 접속해서 정보를 유출시킬 수 있는 문제가 발생하기 쉽습니다. 하지만 인터넷 환경에서 다른 출처에 있는 리소스를 가져와 사용하는 일은 매우 흔한 일이기 때문에 이를 무턱대고 막을 수 없습니다. 그래서 예외적으로 다른 출처의 리소스 요청이라도 허용하는 것이 CORS 정책입니다.

#### ✏️ 18-1. CSRF, XSS에 대해 설명해주세요

CSRF는 사용자가 자신의 의지와는 무관하게 웹 애플리케이션에 대한 악의적인 요청을 전송하도록 유도하는 공격 기법<br>
XSS는 웹 애플리케이션에서 사용자로부터 입력을 받아들이고 해당 입력을 그대로 사용할 때 발생할 수 있는 취약점을 이용한 공격 기법입니다. 

#### ✏️ 18-2. pre-flight(예비 요청)에 대해서 설명해주세요.
클라이언트가 실제 요청을 보내기 전에 서버로 보내는 추가적인 사전 요청(pre-flight request)입니다. OPTIONS메서드를 통해 실제 요청을 전송하기 전에 안전한지 확인하기 위한 작업을 위한 것입니다.

🌐 ref. https://inpa.tistory.com/entry/WEB-%F0%9F%93%9A-CORS-%F0%9F%92%AF-%EC%A0%95%EB%A6%AC-%ED%95%B4%EA%B2%B0-%EB%B0%A9%EB%B2%95-%F0%9F%91%8F

---

### ✏️ 19. 유니캐스트, 브로드캐스트, 멀티캐스트, 애니캐스트에 대해 설명해주세요.

네트워크 통신에서 사용되는 다양한 전송방식입니다.

- 유니캐스트 :  출발지와 목적지가 명확히 하나로 정해져 있는 1:1 통신 방식
- 브로드캐스트 : 목적지 주소가 "모든"으로 표기되어 있는 통신 방식으로 유니캐스트로 통신하기 전, 주로 상대방의 정확한 위치를 알기 위해 사용됩니다.
- 멀티캐스트: 그룹 주소를 이용해 해당 그룹에 속한 다수의 호스트로 패킷을 전송하기 위한 통신 방식으로, 사내 방송이나 증권 시세 전송과 같이 단방향으로 다수에게 동시에 같은 내용을 전달해야할 때 사용됩니다.
- 애니캐스트 : 주소가 같은 호스트들 중에서 가장 가깝거나 가장 효율적으로 서비스할 수 있는 호스트와 통신하는 방식

#### ✏️ 19-1. 각 방식이 사용되는 예시를 말씀해주세요.

- 유니캐스트:  HTTP 요청
- 멀티캐스트 : 온라인 동영상 스트리밍 서비스
- 브로드캐스트 : ARP 요청에서 IP주소에 해당하는 MAC 주소를 얻기위해서 사용하는 요청 방식
- 애니캐스트 : CDN 서비스에서 사용자의 요청이 가장 가까운 서버로 라우팅하기위해서 사용합니다. 

### ✏️ 20. JWT 토큰에 대해 설명해주세요.

JSON 데이터를 Base64 URL-safe Encode 를 통해 인코딩하여 직렬화한 JSON토큰<br>

- 헤더(Header): JWT의 유형과 해싱 알고리즘 등의 메타데이터를 포함합니다. 일반적으로는 토큰의 유형과 해싱 알고리즘을 지정합니다.

- 페이로드(Payload): 실제 전달되는 데이터를 포함합니다. 클레임(Claim)이라고도 불리는 페이로드에는 클라이언트와 서버 간에 공유되는 사용자 식별 정보 및 추가 정보가 포함될 수 있습니다.

- 서명(Signature): 헤더와 페이로드를 조합하고, 비밀 키를 사용하여 서명합니다. 이 서명은 토큰의 무결성을 보장하고 변조를 방지합니다.

#### ✏️ 20-1. Access Token과 Refresh Token에 대해서 설명해주세요.
- Access Token : 클라이언트가 갖고있는 실제로 유저의 정보가 담긴 토큰으로, 클라이언트에서 요청이 오면 서버에서 해당 토큰에 있는 정보를 활용하여 사용자 정보에 맞게 응답을 진행합니다.
- Refresh Token: 새로운 Access Token을 발급해주기 위해 사용하는 토큰으로 짧은 수명을 가지는 Access Token에게 새로운 토큰을 발급해주기 위해 사용. 해당 토큰은 보통 데이터베이스에 유저 정보와 같이 기록합니다.

---

### ✏️ 21. Connection timeout 과 Read timeout의 차이에 대해 설명해주세요.

Connection timeout은 클라이언트가 서버에 연결할 때까지 기다리는 시간을, Read timeout은 클라이언트가 서버로부터 데이터를 수신하는 동안 기다리는 시간을 말합니다.

#### ✏️ 21-1. RTT(Round Trip Time)과 RTO(Retransmission Timeout)에 대해서 설명해주세요.
- RTT : RTT는 한 패킷이 출발 지점에서 목적지로 가는 데 걸리는 시간입니다. 즉, 데이터를 보내고 도착지로부터 응답을 받을 때까지 걸리는 시간입니다. 즉, 네트워크 지연 시간을 나타냅니다.
- RTO :  패킷을 보낸 후 응답을 기다리는 시간으로, 패킷을 보낸 후 응답을 받지 못했을 때 해당 패킷을 재전송하기 위해 기다리는 시간을 의미합니다.

#### ✏️ 21-2. 네트워크 혼잡이 심할 때는 RTO를 어떻게 조정하나요?
네트워크 혼잡이 심할 때는 RTO를 증가시켜 재전송 횟수를 줄이는 방식으로 조정합니다. 

### ✏️ 22. IOCP에 대해 설명해주세요.

Input/Ouptput Completion Port의 약자로 입력과 출력을 담당할 포트를 지정해서 처리하는 윈도우 운영체제에서 사용하는 비동기 I/O작업 메커니즘입니다.
<br>
구동 방식을 정리하면<br>
먼저, 적당한 수의 워커 쓰레드를 생성합니다.<br>
그리고 소켓을 생성하고, 클라이언트 연결 완료시 Complete port를 할당합니다.<br>
입출력 디바이스에서 입출력이 완료되면 completion queue에 등록하고 워커 쓰레드에 할당한다.<br>

일반적으로 보이는 쓰레드 풀 방식에 비해 쓰레드에 작업을 할당하는 방식을 원도우에서 자동으로 해주는 점에서 편하다고 할수 있습니다.

### ✏️ 23. POLLING은 무엇인지 설명해주세요.
폴링은 리얼타임 웹을 위한 기법으로, 일정한 주기(특정한 시간)을 가지고 서버와 응답을 주고 받는 방식을 말합니다.
이렇게 서버와 응답을 주고 받는 이유는 HTTP의 특성상 지속적인 연결이 불가능하기 때문입니다. 

### ✏️ 24. 대칭키, 비대칭키 암호화 방식에 대해 설명해주세요. 

암호화 방식
암호화 방식을 사용하기 위해선 암호화할 수 있는 '암호화 키'와 해석할 수 있는 '복호화 키'가 필요한데, 해당 키를 어떻게 사용하고 관리하느냐에 따라 두 가지 방식으로 나뉜다.<br>

대칭키(공통키 암호화 방식) : 서버와 클라이언트가 암호화 키와 복호화 키로 같은 키를 사용하는 방식으로 클라이언트가 암호화 키로 암호화 하면 서버가 완전히 동일한 키로 복호화 하는 방법. 구조가 단순하기 때문에 처리 부하가 걸리지 않지만 사전에 키를 공유해야 하므로 키 배송 문제를 고려해야 함<br>

비대칭키(공개키 암호화 방식) : 암호화 키와 복호화 키로 다른 키를 사용하는 암호화 방식. 수학적인 관계로 만들어진 암호화 키와 복호화 키는 해당 암호화 키로 암호화 한 것은 해당 복호화 키로만 풀 수 있다. 서버에는 암호화 키를 '공개키'로 인터넷 상에 공개하고, 복호화 키를 '비밀키'로 서버에 저장한다. 클라이언트는 공개된 키를 사용해 데이터를 암호화해서 서버에 보내고, 서버는 비밀키로 복호화한다. 해당 키로부터 복호화 키를 만들어 낼 수 없기 때문에 키 배송 문제에 신경 쓸 필요가 없지만 처리가 복잡하기 때무에 처리 부하를 고려해야 한다.

두 가지 암호화 방식의 조합
SSL/TLS는 두 가지 방식을 조합한다. 서버가 공통키를 생성하고, 데이터를 공통키로 암화하고 해당 공통키를 클라이언트A의 공개키로 암호화 하여 클라이언트A에 전송한다. 클라이언트A는 개인키를 사용해서 공통키를 해독하고, 해독한 공통키를 사용해서 데이터를 복호화 한다. 

### ✏️ 25. DNS란 무엇인지 설명해주세요.

 Domain Name System의 약자로, 인터넷 상의 컴퓨터나 네트워크 장치들을 식별하는 데 사용되는 시스템입니다. 인터넷에서 컴퓨터를 식별하기 위해서 사용하는 IP 주소는 숫자의 나열이기 때문에 의미상 알기 어렵습니다. 따라서 IP 주소에 도메인이라는 이름을 붙여 알기 쉽게 표기하는데요, 이런 IP 주소와 도메인 명을 상호 변환하는 시스템을 DNS라고 합니다.

#### ✏️ 25-1. 도메인의 구조에 대해서 설명해주세요.
도메인은  'www.example.com'과 같이 점으로 구분된 문자열로 구성되어 있습니다.
이 문자 하나 하나를 "라벨" 이라 부릅니다. 그리고 오른쪽부터 순서대로 톱레벨 도메인, 2레벨 도메인, 3레벨 도메인이라 부르며 가장 왼쪽이 호스트명입니다. 라벨은 "루트"를 꼭지점으로 해서 톱레벨 도메인, 2레벨 도메인, 3레벨 도메인으로 나눠지는 트리형태의 계층 구조를 가지고있습니다. 오른쪽 부터 왼쪽으로 라벨을 따라가면 대상 서버까지 도달할 수 있습니다.

#### ✏️ 25-2. DNS 서버란 무엇인지 설명해주세요.

DNS 서버는 도메인과 IP 주소간의 매핑을 관리하고 제공해주는 역할을 하는 서버입니다. DNS 서버는 캐시 서버와 콘텐츠 서버로 크게 나뉠 수 있습니다. 캐시 서버는 LAN 안에 있는 클라이언트로부터 질의를 받아 인터넷으로 질의하는 DNS 서버입니다. 콘텐츠 서버는 외부의 컴퓨터로부터 자신이 관리하는 DNS 도메인에 관한 질의를 받는 DNS 서버입니다. 자기 도메인 안의 호스트명을 존 파일이라는 데이터베이스로 관리합니다. 클라이언트로부터 질의를 받은 캐시 서버는 받은 도메인명의 계층을 오른쪽부터 차례대로 질의하고 응답을 받아서 최종적으로 전체 도메인명에 대한 IP 주소를 알아내고 저장합니다. 