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
9. OSI 7 layer와 각 계층에 대해 아는대로 설명해주세요. ⭐️⭐️⭐️⭐️
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

---

1. TCP와 UDP에 대해 설명하고, TCP와 UDP의 차이에 대해 설명해주세요
    
    ```markdown
    TCP와 UDP는 둘 다 전송 계층에서 데이터를 전송하기 위해 사용하는 프로토콜입니다.
    TCP는 연결형 서비스로 발신지와 수신지를 연결하여 패킷을 전송하는 가상회선 방식을 제공하고 높은 신뢰성을 보장하며 흐름제어 및 혼잡 제어 기능을 제공합니다.
    UDP는 비연결형 서비스로 각각의 패킷을 독립적으로 처리하는 데이터그램 방식을 제공하고 패킷에 순서 부여나 재조립 등의 기능을 처리하지 않습니다.
    TCP는 UDP에 비해 데이터의 전송에 대한 신뢰성이 높고 UDP는 TCP에 비해 데이터 전송 속도가 빠르다는 각각의 장점이 있습니다.
    따라서 TCP는 파일 전송과 같이 신뢰성 있는 전송을 필요로 할 때 사용하며, UDP는 스트리밍 서비스와 같이 연속성과 성능을 중요시하는 서비스에 사용됩니다.
    
    https://velog.io/@xoqja055/%EB%A9%B4%EC%A0%91-%EC%A4%80%EB%B9%84%EB%A5%BC-%ED%95%B4%EB%B3%B4%EC%9E%90-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC
    ```
    
2. TCP에서 데이터의 신뢰성을 보장하기 위한 방법은 어떤 것이 있는지 설명해주세요
    
    ```markdown
    TCP에서는 데이터 패킷에 순서 번호를 부여함으로써 데이터 패킷이 순서대로 도착할 수 있도록 합니다.
    순서 번호가 있기 때문에 패킷의 순서가 맞지 않는다면 패킷을 재조립할 수 있습니다.
    또한 데이터를 잘못 받았거나 못 받았을 경우엔 순서 번호에 따라 재전송하는 오류 제어 기능이 있습니다.
    
    1. 오류제어란 ?
    데이터가 유신되거나 잘못된 데이터가 수신되었을 경우 대처하는 방법입니다.
    TCP는 통신 중 오류가 발생하면 해당 데이터를 재전송하는 방식을 사용합니다.
    
    ack를 받고 다음 데이터를 보내는 방식인 stop and wait,
    연속으로 데이터를 전송하다 오류 발생 지점부터 재전송하는 방식인 go back N,
    오류가 발생한 데이터만 재전송하는 selective repeat 방식이 있습니다.
     
    
    2. 혼잡제어란 ?
    네트워크 혼잡에 대처하는 방법입니다.
    네트워크 내 패킷의 수가 과도하게 증가하는 현상을 혼잡이라고 합니다.
    AIMD - 처음에 패킷을 하나씩 보내고 문제가 발생하지 않으면 윈도우 크기를 1씩 증가하는 방법으로
    패킷 전송에 실패하거나 일정 시간을 넘으면 패킷 전송 속도를 벌반으로 줄입니다.
    
    SLOW START - AIMD와 같은 방식으로 패킷을 하나씩 보내고 윈도우 크기를 1씩 증가시키지만 전송속도를 지수함수꼴로 증가시켜 윈도우 크기를 빠르게 증가시킵니다.
    그리고 혼잡이 감지되면 윈도우 크기를 1로 줄입니다.
    
    FAST RETRANSMIT - 받은 데이터 중 연속되는 패킷의 마지막 순번 이후를 ACK 패킷에 실어 보냅니다. 
    
    FAST RECOVERY - 혼잡한 상태가 되면 윈도우 크기를 1이 아닌 반으로 줄이고, 선형 증가시킵니다.
    혼잡상황을 한번 겪은 이후로는 AIMD 방식으로 동작합니다.
    
    https://benlee73.tistory.com/186
    ```
    

3. 3-way handshaking과 4-way handshaking에 대해 설명해주세요.
    
    ```markdown
    3-way handshake는 TCP 통신을 진행할 때 정확한 데이터 전송을 위해 네트워크 연결을 설정하는 과정입니다.
    클라이언트와 서버가 연결을 위해 요청과 응답을 3번 주고 받기에 3-way handshake라고 합니다.
    반면 4-way handshake는 데이터 전송이 모두 끝나고 연결을 해제하기 위해 네 번의 요청과 응답을 주고 받는 과정입니다.
    ```
    
4. 사용자가 URL을 입력한 후 화면이 출력되기까지의 과정을 설명해주세요
    
    ```markdown
    사용자가 URL을 입력하면 DNS 서버에 도메인 네임으로 서버의 진짜 주소를 찾습니다.
    IP 주소로 웹 서버에 TCP 3HAND-SHAKE로 연결을 수립하게 됩니다.
    클라이언트는 웹 서버로 HTTP 요청 메시지를 보내고 웹 서버는 HTTP 응답 메시지를 보냅니다.
    도착한 HTTP 응답 메시지는 웹 페이지 데이터로 변환되고, 웹 브라우저에 의해 출력됩니다.
    
    https://dev-coco.tistory.com/161
    https://medium.com/@2kunhee94/%EB%B8%8C%EB%9D%BC%EC%9A%B0%EC%A0%80%EC%9D%98-%EC%A3%BC%EC%86%8C%EC%B0%BD%EC%97%90-url%EC%9D%84-%EC%9E%85%EB%A0%A5%ED%95%98%EB%A9%B4-%EC%9D%BC%EC%96%B4%EB%82%98%EB%8A%94-%EC%9D%BC-97a0837b8bf8
    ```
    
5. HTTP 프로토콜에 대해 설명해주세요
    
    ```markdown
    서버와 클라이언트 간의 TCP/IP 통신 위에서 메시지를 교환하기 위해 사용되는 서버/클라이언트 모델을 따르는 프로토콜입니다.
    클라이언트가 HTTP를 통해 리소스를 요청하면 TCP/IP 프로토콜을 거쳐 서버측 HTTP까지 요청이 도달하는데
    이에 대한 응답을 다시 서버에서 HTTP로 보내면 TCP/IP 프로토콜을 통과해 클라이언트까지 응답이 도달하게 됩니다.
    HTTP는 이런 과정에서 서버에 연결하고 요청해 응답을 받으면 연결을 끊어버리기 때문에 접속 유지를 최소한으로 할 수 있어 많은 유저의 요청을 처리할 수 있습니다.
    하지만 연결을 끊어버리기에 클라이언트의 이전 상태를 알 수 없다는 단점이 있습니다.
    HTTP는 어떤 종류의 데이터든 전송할 수 있게 설계되어 있어 HTML 문서, 이미지, 동영상, 오디오, 텍스트 문서 등 여러 종류의 데이터를 전송할 수 있습니다.
    ```
    
6. HTTP와 HTTPS의 차이점에 대해서 설명해주세요.
    
    ```markdown
    HTTP와 HTTPS의 차이점은 보안 적용의 유무에 있습니다.
    HTTP는 암호화되지 않은 평문으로 데이터를 전송하기 때문에 데이터를 볼 수도 있고 도난, 변조 등의 보안 이슈가 발생할 수 있습니다.
    반면 HTTPS는 SSL 또는 TLS 프로토콜을 사용해 데이터를 암호화하고 인증하는 과정을 거칩니다.
    이를 통해 데이터의 기밀성과 무결성을 보장할 수 있다는 보안상 큰 장점을 가집니다.
    
    암호화 방식
    SSL 과 TLS 방식이 있습니다. 둘 다 암호화 프로토콜로 데이터 전송 시 보안을 제공합니다.
    하지만 TLS가 SSL보다 발전된 보안 기능과 강화된 암호화 방식을 제공한다는 점에서 차이가 있습니다.
    ```
    
7. HTTP 1.0과 1.1의 차이에 대해 설명하세요.
    
    ```markdown
    가장 큰 차이점은 연결의 지속성에 있습니다.
    HTTP 1.0에서는 데이터를 요청하고 수신할 때마다 새로운 TCP 세션을 맺어야 했지만
    1.1에서부터는 TCP 세션을 한 번만 맺으면 여러 개의 요청을 보내고 응답을 수신할 수 있습니다.
    이것은 파이프라이닝 기능의 차이라고 볼 수 있습니다.
    1.0은 파이프라이닝 기능을 지원하지 않기 때문에 1번 요청을 보내고 응답을 받아야 2번 요청을 보낼 수 있지만
    1.1에서는 파이프라이닝 기능을 통해 한 번에 여러 개의 요청을 보낼 수 있습니다.
    따라서 TCP 세션을 처리하는 비용을 줄이고 응답속도를 개선할 수 있게 되었습니다.
    
    이외에도 1.0은 하나의 IP 주소에 여러 개의 도메인을 운영할 수 없어 IP를 구분해서 준비해야 하기 때문에 서버의 개수를 늘려야했지만
    1.1은 가상 호스팅이 가능해져 하나의 IP 주소에 여러개의 도메인을 적용시킬 수 있다는 차이가 있습니다.
    
    마지막으로 1.1에서는 1.0부터 지원하는 www-authentication 헤더만이 아닌 클라이언트와 서버 사이에 프록시가 위차하는 경우
    프록시가 사용자의 인증을 요구할 수 있는 proxy-authentication과 proxy-authorizaion이 추가되었습니다.
    https://code-lab1.tistory.com/196
    ```
    
8. 쿠키(Cookie)와 세션(Session)의 차이점에 대해 설명해주세요
    
    ```markdown
    정보의 저장 위치에 따른 차이점이 있습니다.
    쿠키는 클라이언트 로컬에 저장하지만 세션은 서버에 저장합니다.
    따라서 쿠키는 서버의 자원을 전혀 사용하지 않지만 세션은 서버의 자원을 사용합니다.
    또한 쿠키는 변질되거나 request에서 스니핑 당할 우려가 있기에 보안에 취약하지만
    세션은 쿠키를 이용해 session-id만 저장하고 그것으로 구분하여 서버에서 처리하기 때문에 비교적 보안성이 높습니다.
    저장위치가 다르기 때문에 쿠키는 브라우저를 종료해도 정보가 유지되지만 세션은 브라우저를 종료하면 만료기간에 상관없이 삭제된다는 차이도 있습니다.
    
    https://velog.io/@whddlrs/%EB%AA%A8%EC%9D%98-%EB%A9%B4%EC%A0%91%EC%BF%A0%ED%82%A4%EC%99%80-%EC%84%B8%EC%85%98%EC%9D%98-%EC%B0%A8%EC%9D%B4
    ```
    
9. OSI 7 layer와 각 계층에 대해 아는대로 설명해주세요.
    
    ```markdown
    OSI 7계층은 네트워크 사이의 원활한 통신을 위해 필요한 것들을 계층별로 나눠놓은 개념 모델로서 국제표준입니다.
    응용, 표현, 세션, 전송, 네트워크, 데이터링크. 물리 계층으로 나뉩니다.
    응용 계층은 웹사이트 등 실제로 유저에게 제공하는 층으로 HTTP, SMTP, SSH, FTP가 대표적입니다.
    표현 계층은 데이터 표현에 대한 독립성을 제공하고 암호화하는 역할을 담당합니다. 파일 인코딩, 명령어 포장, 압축, 암호화 등의 작업이 표현 계층에서 일어납니다.
    세션 계층은 데이터가 통신하기 위한 논리적 연결을 담당하는데 데이터 교환과 에러 발생 시 복구를 관리합니다.
    전송 계층은 어플리케이션에서 받은 데이터를 전달하는 계층으로, TCP 방식이라면 세그먼트로, UDP라면 데이터그램으로 데이터를 쪼개어 전달합니다.
    네트워크 계층은 데이터를 목적지까지 안전하고 빠르게 전달하는 기능을 담당합니다. 라우터를 통해 이동 경로를 선택해 IP주소를 지정하고 패킷을 전달합니다. 이 때 라우팅, 흐름제어, 오류제어, 세그멘테이션 등을 수행합니다.
    데이터 링크 계층은 물리 계층으로 송수신되는 정보를 관리해 신뢰성있는 정보 전달을 담당합니다. 이 때 MAC 주소를 통해 통신합니다.
    물리 계층은 시스템 간 물리적 연결을하고, 전기 신호의 변환 및 제어를 담당합니다. 데이터를 전기 신호로 바꾸어 전송합니다. 따라서 0과 1의 값만이 가능한 bit단위로 전달합니다.
    
    https://mocha-blog.tistory.com/217
    ```
    
10. TCP/IP 프로토콜을 스택 4계층으로 설명해주세요.
    
    ```markdown
    TCP/IP 4계층은 각 계층이 애플리케이션, 전송, 인터넷, 링크 계층으로 나눠져 있습니다.
    애플리케이션 계층은 웹서비스, 이메일 등 서비스를 실질적으로 사람들에게 제공하는 층입니다.
    
    전송 계층은 애플리케이션과 인터넷 계층 사이의 데이터 전달의 중계 역할로 송신자와 수신자를 연결하는 통신 서비스를 제공하며 연결 지향 데이터 스트림 지원, 신뢰성, 흐름 제어를 제공합니다.
    가상회선 패킷 교환 방식으로 데이터를 전송하는 TCP 방식과 데이터그램 패킷 교환 방식을 사용하는 UDP방식이 있습니다.
    
    인터넷 계층은 장치로부터 받은 네트워크 패킷을 IP 주소로 지정된 목적지로 전송하기 위해 사용되는 계층입니다.
    패킷을 수신해야 할 상대의 주소를 지정하여 데이터를 전달하며 상대방이 패킷을 받았는지에 대해 보장하지 않습니다.
    
    링크 계층은 실질적으로 데이터를 전달하며 장치 간 신호를 주고받는 규칙을 정하는 계층입니다.
    https://blog.naver.com/jhc9639/222713398150
    ```
    
11. HTTP에서 사용되는 Method와 각 용도에 대해서 설명해주세요.
    
    ```markdown
    HTTP 메서드는 클라이언트와 서버 사이에 이루어지는 요청과 응답 데이터를 전송하는 방식입니다.
    HTTP 메서드의 주요 메서드에는 GET, POST, PUT, PATCH, DELETE가 있습니다.
    GET은 리소스를 조회하는 메서드로 캐싱이 가능하여 같은 데이터를 한 번 더 조회할 경우, 조회 속도가 빨라집니다.
    POST는 전달할 데이터의 처리와 생성을 요청하는 메서드입니다. 메시지 바디에 데이터를 담아 서버로 전달하는 방식입니다.
    PUT과 PATCH는 리소스를 수정하는 메서드입니다. 다만 PUT은 리소스가 있으면 덮어쓰고 없으면 새로 생성하는 지정한 데이터 전체를 수정하는 메서드이지만,
    PATCH는 리소스의 일부를 부분 변경하는 메서드라는 점에서 차이가 있습니다.
    주요 메서드 중 마지막으로 DELETE는 리소스를 제거하는 메서드입니다.
    
    이외에도 GET과 동일하지만 상태 줄과 헤더만 반환하는 HEAD, 대상 리소스에 대한 통신 가능 옵션을 설명하는 OPTIONS,
    대상 자원으로 식별되는 서버에 대한 터널을 설정하는 CONNECT, 대상 리소스에 대한 경로를 따라 메시지 루프백 테스트를 수행하는 TRACE가 있습니다.
    https://jhbljs92.tistory.com/entry/3-HTTP-Method
    ```
    
12. GET과 POST의 차이를 설명하세요.
    
    ```markdown
    GET과 POST는 HTTP 메서드입니다.
    GET은 데이터를 요청할 때 주로 사용되며 URI로 지정한 데이터를 가져옵니다.
    URL에 데이터를 포함하고 있으며 ? 뒤에 이름과 값이 쌍으로 이어붙여져 전송됩니다.
    URL 길이에 제한이 있기 때문에 전송할 수 있는 데이터 양에는 제한이 있으며
    브라우저 히스토리에 저장되며 캐싱될 수 있기 때문에 민감한 데이터의 전송에는 GET이 적합하지 않습니다.
    
    반면 POST는 데이터가 요청 바디에 포함되어 있기 때문에 데이터의 길이 제한이 없어 GET보다 훨씬 큰 데이터를 전송할 수 있습니다.
    또한 브라우저 히스토리에 저장되지 않고 캐싱되지 않습니다.
    
    GET은 단순히 데이터를 조회하는 기능을 수행하기 때문에 안정성과 멱등성이 보장되는 반면
    POST는 데이터에 변경이 발생하기 때문에 안정성과 멱등성이 보장되지 않습니다.
    
    https://velog.io/@aacara/%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-%EB%A9%B4%EC%A0%91-2%EC%A3%BC%EC%B0%A8
    ```


13. REST(REST API)에 대해 설명하고 RESTful이란 무엇인지 설명해주세요.
    
    ```markdown
    - REST : 어떤 자원에 대해 CRUD 연산을 수행하기 위해 URI로 GET, POST 등의 방식을 사용하여 요청을 보내며, 요청을 위한 자원은 특정한 형태로 표현됩니다.
        - REST는 웹의 기존 기술과 HTTP를 그대로 활용하기 때문에 그 특성을 갖고있다.
        - Server-Client 구조
            - 자원이 있는 쪽이 Server, 자원을 요청하는 쪽이 Client
        - Stateless(무상태)
            - HTTP 프로토콜을 그대로 활용하기 때문에 무상태성을 갖는다.
            - Client의 context를 Server에 저장하지 않는다.
            - 따라서 이전 요청과 관계없이 Server는 각각의 요청을 별개의 것으로 인식, 처리한다
        - 캐시 처리
            - HTTP의 특징 중 하나인 캐싱 기능을 적용할 수 있다.
            - 대량의 요청을 처리할 수 있습니다.
        - 인터페이스 일관성
            - URI로 지정한 Resource에 대한 요청을 통일되고, 한정적으로 수행하는 아키텍처 스타일
            - 언어나 기술에 종속되지 않고, HTTP 표준에 따르는 모든 플랫폼에서 사용가능하다.
        - 계층 구조
            - Client는 REST API Server만 호출된다.
            - 다중 계층으로 구성될 수 있으며 보안, 로드밸런싱, 암호화 등의 계층을 추가하여 구조를 변경할 수 있다.
            - 네트워크 기반의 중간매체를 사용할 수 있다.(Proxy, Gateway)
        - 자체 표현
            - 요청 메시지만 보고도 쉽게 이해할 수 있는 자체 표현 구조로 되어있다.
        
    - REST API : REST의 특징을 기반으로 서비스 API를 구현한 것
        - 각 요청이 어떤 동작이나 정보를 위한 것인지를 그 요청의 모습 자체로 추론 가능하다.
        - URI는 정보의 자원을 표현해야 한다.
        - 자원에 대한 행위는 HTTP Method로 표현한다.(메소드는 URI에 포함하지 않는다.)
    
    - RESTful API : REST의 설계 규칙을 잘 지켜서 설계된 API
        - URI는 정보의 자원만 표현해야 하며, 자원의 행위는 HTTP 메서드에 명시
    ```
    

14. 공인(public) IP와 사설(private) IP의 차이에 대해 설명해주세요.
    
    ```markdown
    - 공인 IP는 인터넷에서 사용되며, 사설 IP는 로컬 네트워크에서 사용된다.
    - 공인 IP는 고유하며 인터넷 상에서 다른 장치에서 접근할 수 있지만, 사설 IP는 로컬 네트워크 내에서만 유효하며, 인터넷에서 직접 접근할 수 없다.
    - 공인 IP는 ISP를 통해 할당되지만, 사설 IP는 로컬 네트워크 관리에 의해 할당된다.
    - 따라서 공인 IP는 인터넷 상에서 장치를 식별하고 통신하는데 사용되며, 사설 IP는 로컬 네트워크에서 내부 통신에 사용된다.
    ```

    
15. 라우팅 알고리즘에 대해서 설명해주세요
    
    ```markdown
    - 네트워크 내에서 데이터 패킷이 송신지에서 목적지까지 최적의 경로를 찾아 전송되도록 도와주는 알고리즘
        - 정적 라우팅 : 수동으로 라우터에 경로를 설정
        - 동적 라우팅 : 네트워크 상황의 변화에 따라 자동으로 최적의 경로를 찾아주는 방식
            - 거리 벡터 라우팅 : 각 라우터가 인접한 라우터에게 자신으로부터 각 목적지까지의 거리 벡터를 주기적으로 전송(벨만포트 기반)
            - 링크 상태 라우팅 : 네트워크 내 모든 라우터가 자신과 인접한 라우터 사이의 링크 상태 정보를 교환하여 네트워크 전체의 지도 구성(다익스트라 기반)
            - 경로 벡터 라우팅 : 각 라우터는 경로 정보와 함께 목적지까지의 경로를 전파(인터넷과 같은 큰 규모)
    ```

    
16. 라우터와 스위치의 차이에 대해 설명해주세요. ⭐️
    
    ```markdown
    - 스위치
        - 네트워크 내의 장치와의 연결 및 데이터 패킷 전송 장치
        - MAC 주소를 사용하여 패킷 전송
        - 네트워크 내 효율적인 데이터 통신 가능하게 하며, 충돌 도메인 분리로 네트워크 성능 향상
    - 라우터
        - 서로 다른 네트워크 간의 데이터 패킷 전송 장치(인터넷 정보 교환)
        - 데이터 패킷이 목적지까지 도달할 수 있도록 최적의 경로 선정
        - IP 주소를 사용하여 패킷 라우팅, 네트워크 간 경계 역할로 네트워크 간 데이터 전송 담당
    
    - 차이점
        - 라우터는 네트워크 계층에서 작동하며, IP 주소를 사용하여 라우팅 수행하지만 스위치는 데이터 링크 계층에서 작동하며, MAC 주소를 사용하여 데이터 전송
        - 라우터는 네트워크 간의 연결과 데이터 라우팅을 담당, 스위치는 네트워크 내의 장치를 사이의 데이터 전송 담당
    
    ```
    
17. 세션 기반 인증과 토큰 기반 인증의 차이에 대해 설명하고, 어느 경우에 적합한지 설명해주세요. ⭐️⭐️
    
    ```markdown
    - 세션 기반 인증
        - 사용자의 인증 정보가 세션 저장소에 저장되는 방식
        - 상태를 유지하는 방식으로 사용자의 상태 추적
    - 토큰 기반 인증
        - 인증 정보를 사용자가 직접 갖고 있는 방식
        - 인증 정보가 토큰의 형태로 브라우저의 로컬 스토리지나 쿠키에 저장
        - 상태를 유지하지 않기에 서버는 사용자의 상태를 저장하지 않으며, 각 요청이 독립적 처리
    
    - 차이점
        - 세션의 경우 Cookie 헤더에 세션 ID만 실어 보내면 되기 때문에 트래픽을 적게 사용하지만 토큰 인증 방식은 인증 정보나 시간 등의 정보가 담겨 있어 더 많은 네트워크 트래픽을 사용
        - 세션은 모든 인증 정보를 서버에서 관리하기 때문에 세션 ID를 해킹 당해도 서버측에서 해당 세션을 무효 처리하면 되지만 토큰은 사용자가 모든 인증 정보를 가지고 있기 때문에 해킹당하면 해당 토큰이 만료되기 전까지 피해를 당할 수 밖에 없다.
        - 세션 기반 인증 방식은 서버가 하나일 경우에는 문제되지 않지만 서버가 확장되어 여러개가 된다면 세션 불일치의 문제를 겪을 수 있다. 하지만 토큰 기반 인증은 토큰을 서버에 따로 저장하지 않고 클라이언트가 저장하는 방식이기에 HTTP의 비상태성을 그대로 활용해 높은 확장성을 가질 수 있다.
        - 세션 인증 방식은 세션 데이터의 양이 많아지면 서버의 부담이 증가하지만 토큰 인증 방식은 서버의 부담이 증가하지 않는다.
    
    - 사용
        - 세션 기반 인증 : 소규모 애플리케이션, 서버 자원이 충분한 경우, 내부 네트워크나 폐쇄적 환경
        - 토큰 기반 인증 : 대규모 및 분산 시스템, 모바일 및 싱글페이지 애플리케이션, 마이크로서비스 아키텍처, API 보안, 크로스 도메인 인증 요구
    ```
    
18. CORS에 대해 설명해주세요.
    
    ```markdown
    - 교차 출처 리소스 공유
        - 웹 애플리케이션에서 다른 출처의 리소스를 안전하게 접근할 수 있도록 해주는 표준 기술
        - CORS 에러 : URL에서 도메인만이 아닌 프로토콜과 포트 중 하나라도 다를 때의 에러
        - CORS 설정 : 실제 요청을 보내기 전 사전 요청을 통해 실제 요청이 안전한지 확인 후, 사전 요청에 대한 응답으로 CORS 관련 헤더를 포함시킨다. 이 요청과 응답이 성공하면 실제 요청을 보내고 CORS 헤더를 응답에 포함시켜 요청을 허용한다.
    ```
    
19. 유니캐스트, 브로드캐스트, 멀티캐스트, 애니캐스트에 대해 설명해주세요.
    
    ```markdown
    - 유니캐스트
    		- 송신자와 수신자 간에만 데이터를 전송하는 1:1 통신 방식
    		- MAC 주소를 사용하여 데이터 전송, 네트워크 상 다른 PC들의 CPU 성능을 저하시키지 않는다.
    		
    - 브로드캐스트
    		- 네트워크에 연결된 모든 시스템에 데이터를 전송하는 1:all 통신 방식
    		- 모든 시스템에 프레임을 전송하므로 트래픽 증가와 성능 저하를 일으킴
    
    - 멀티캐스트
    		- 특정 그룹의 시스템에만 데이터 전송하는 1:N 통신 방식
    		- UDP 방식, 라우터의 지원
    		
    - 애니캐스트
    		- 가장 가까운 또는 가장 효율적인 호스트에 데이터 전송
    		- 애니캐스트 주소 사용, 가장 가까운 DNS 서버나 게이트웨이를 찾는데 사용
    ```
    
20. JWT 토큰에 대해 설명해주세요. ⭐️
    
    ```markdown
    - 인터넷 표준 인증 방식 중 하나, 필요한 정보를 JSON 객체에 담아 비밀키로 서명한 것
    - 인증과 권한 부여에 사용되며 HTTP 무상태성을 보완하기 위해 로그인 시 JWT 토큰을 발급받아 API 호출 시 헤더에 저장하여 전송
    - 구성
    		- Header : 토큰의 유형 및 서명을 위한 알고리즘 정보
    		- Payload : 사용자의 정보, 토큰의 발행자, 유효 기간 등의 정보
    		- Signature : 헤더와 페이러드를 합친 후 주어진 알고리즘으로 서명한 부분
    - 장점
    		- 자가 수용적 : 필요한 모든 정보를 자체적으로 가지고 있어 별도의 저장소 불필요
    		- 확장성 : 서버의 리소스를 사용하지 않기 때문에 확장성이 높다.
    		- 보안성 : 디지털 서명이 되어 있어 정보의 위변조 방지
    - 단점
    		- 토큰의 크기가 커질수록 트래픽에 영향
    		- 토큰은 발급되면 만료 기간 변경이 불가능하므로 토큰 만료 처리 구현
    ```
    
21. Connection timeout 과 Read timeout의 차이에 대해 설명해주세요. ⭐️⭐️
    
    ```markdown
    - Connection timeout
    		- 쿨라이언트가 서버에 연결을 시도할 때 설정된 시간 내에 연결이 성공적으로 이루어지지 않을 경우 발생
    		- 네트워크 지연, 서버 다운, 방화벽 문제 등으로 연결 설정이 지연될 때 발생
    		- 클라이언트의 OUTBOUND, 서버 측의 INBOUND 방화벽을 확인
    - Read timeout
    		- 클라이언트와 서버간의 연결이 성공적으로 이루어진 후, 데이터를 주고받는 과정에서 설정된 시간 내에 데이터 교환이 완료되지 않을 경우 발생
    		- 서버가 요청을 처리하는데 시간이 너무 오래 걸리거나 네트워크 지연 등으로 인해 발생 가능
    
    - 차이점
    		- 연결 설정과 데이터 교환의 단계에서 발생
    		- Connection Timeout은 연결을 설정하는 초기 단계에서 발생하는 반면, Read Timeout은 연결 후 데이터를 주고받는 과정에서 발생		
    ```
    
22. IOCP에 대해 설명해주세요.
    
    ```markdown
    - Input Output Completion Port의 약자로 입출력 완료 포트
    - 사용할 쓰레드를 미리 만들어 놓고 socket에서의 input 또는 output이 완료되었을 때 잠들어있는 thread를 깨워 처리하는 방식
    - 입출력이 완료된 작업들이 들어가는 큐로 쓰레드들은 이 큐에서 작업을 꺼내 수행
    - 작업 대기 중인 쓰레드들이 들어있으며 IO가 완료되면 이 큐에서 쓰레드를 하나 꺼내 사용
    - 현재 작업 수행 중인 쓰레드들이 들어가는 큐
    - 어떤 원인으로 인해 일시정지된 쓰레드들이 들어가는 큐
    ```
    
23. POOLING은 무엇인지 설명해주세요.
    
    ```markdown
    - 자원을 효율적으로 관리하고 데이터 처리 과정을 최적화하는데 사용되는 기술
    - 메모리 내에 자원을 사전에 모아두고, 필요할 때 즉시 사용할 수 있도록 하는 기술로 메모리 할당과 해제 과정을 줄여 성능을 향상시킨다.
    - 시스템 자원 : 파일 핸들과 같은 시스템 자원을 효율적으로 관리
    - 내부 자원 : 객체와 같은 내부 자원의 관리에도 사용
    ```
    
24. 대칭키, 비대칭키 암호화 방식에 대해 설명해주세요.
    
    ```markdown
    - 대칭키 암호화
    		- 암호화와 복호화에 같은 키를 사용하는 방식
    		- 비대칭키 암호화에 비해 처리 속도가 빠르고 대량의 Data 암호화에 유리
    		- 키를 안전하게 교환하고 관리하는 것이 중요
    - 비대칭키 암호화
    		- 암호화와 복호화에 서로 다른 키를 사용하는 방식
    		- 공개키로 암호화된 데이터는 해당 공개키와 쌍을 이루는 개인키로만 복호화할 수 있어 보안성이 높음
    		- 키 교환의 필요성이 없어 대칭키 방식에 비해 키 관리가 수월
    		- 키의 길이가 일고 연산속도가 느림
    ```
    
25. DNS란 무엇인지 설명해주세요.
    
    ```markdown
    - 우리가 보는 주소 즉, 도메인 이름을 컴퓨터가 이해할 수  있는 IP 주소로 변환
    - Local DNS 서버에 해당 도메인 주소를 조회한 뒤 해당 도메인 주소를 알고 있다면 ip 주소를 반환, 없다면 Root DNS 서버로 넘긴다.
    - Root DNS 서버에도 해당 도메인이 없을 수 있다. 그렇다면 top-level 도메인으로 넘겨 해당 도메인을 찾는다.
    - pc에는 DNS Cache 안에 자주 사용하는 Domain Name 주소를 저장하는 기능이 있다.
    ```