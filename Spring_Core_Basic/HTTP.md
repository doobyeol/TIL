> 인터넷 네트워크

# 인터넷 통신

## 인터넷에서 컴퓨터 둘은 어떻게 통신을 하나?

### 클라이언트 < 인터넷 < 서버

인터넷 망을 통해 메세지를 전송하는데 해저 광테이블 ..인공위성 .. 등 수많은 중간 서버(노드)를 거쳐서 건너감
도대체 어떤 규칙으로 ? 수많은 복잡한 상황을 건너 목적지까지 잘 갈 수 있는 것인가? 이걸 이해하기 위해선 먼저 IP에 대한 이해가 필요하다.

# IP (인터넷 프로토콜)

IP주소를 통한 규칙
클라이언트가 주소를 부여받아야 한다. 
서버도 IP 주소가 있어야 한다.

### IP 패킷 정보란?

데이터를 전송하기 전에
출발지 IP, 목적지 IP를 적어야한다.

### 서버 패킷 전달

마찬가지로 출발지 IP, 목적지 IP가 있어야 한다.

## IP 프로토콜의 한계

- 비연결성
- 비신뢰성
- 프로그램 구분

## 대상이 서비스 불능일때 패킷 전송
클라이언트는 대상 서버가 패킷을 받을 수 있는 상태인지 모름

## 패킷 소실
서버를 거쳐서 전달이 되던 중 중간 서버에 문제가 생겼을때 클라이언트가 보낸 패킷이 유실됨

## 패킷 전달 순서 문제 발생
1. hello
2. world !
를 보냈는데 많은 중간 노드를 타다보면 
1. world !
2. hello 
이렇게 순서가 뒤바껴 전달될 수 있다.

위와 같은 문제들을 해결하기 위해선 TCP가 필요하다.

# TCP, UDP

## 인터넷 프로토콜 스택의 4계층
- 애플리케이션 계층 HTTP , FTP
- 전송 계층 TCP, UDP
- 인터넷 계층 IP
- 네트워크 인터페이스 계층

## 프로토콜 계층
1. 프로그램이 메시지 생성
2. socket 라이브러리를 통해 전달
3. TCP 정보 생성, 메시지 데이터 포함
4. IP 패킷 생성, TCP 데이터 포함
5. 랜카드 -> 인터넷 -> 서버 ...


## IP 패킷 정보
- 출발지 IP
- 목적지 IP
- 기타

IP 패킷 : 덩어리, 버킷 의 합성어

TCP 세그먼트
- 출발지 PORT
- 목적지 PORT
- 전송제어
- 순서
- 검증 정보
- 전송데이터

## TCP 특징
전송제어 프로토콜

- 연결지향
- 데이터 전달 보증
- 순서 보장
- 신뢰할 수 있는 프로토콜
- 현재는 대부분 TCP 사용

## TCP 3way handshake
1. SYN - connect 연결 과정
2. SYN + ACK
3. ACK
4. 데이터 전송

## 데이터 전달 보증
1. 클라이언트 : 데이터 전송
2. 서버 : 데이터 잘 받았음 ㅇㅇ

## 순서 보장
- 클라이언트 : 1,2,3 패킷 순서로 전송
- 서버 : 1,3,2 순서로 도착
- 서버 > 클라이언트 : 패킷2부터 다시 보내셈

## UDP 특징
사용자 데이터그램 프로토콜

- 하얀 도화지에 비유 . 기능이 거의 없음
- 연결지향 X
- 순서보장 X
- 데이터 전달 보증 X
- 단순하고 빠름
- PORT가 추가됨
- IP와 거의 같다. +PORT +체크섬 정도만 추가
- 애플리케이션에서 추가 작업 필요


# PORT
항구 

## 한번에 둘 이상 연결해야 하면?
클라이언트가 게임도 하고 화상통화도 하고 웹브라우저 요청도 하고 
이런 경우 클라이언트가 여러 서버와 통신해야 한다.
서버에서 날라온 패킷이 게임인지 화상통화인지 웹브라우저인지 보낼때도 마찬가지로 알수가 없지 않나. 그래서 TCP 패킷 안에 PORT가 있는 것 !


## TCP 패킷 정보
- 출발지 PORT 
- 목적지 PORT

* IP는 목적지 , 출발지 IP 패킷 정보를 담음

## PORT - 같은 IP 내에서 프로세스 구분
- 게임 port : 8090 : 게임 서버 연결
- 화상통화 port : 21000 : 화상통화 통신
- 웹 브라우저 : 10010 : 웹 브라우저 요청


# DNS

## IP는 기억하기 어렵다.
200.200.200.2???


## IP는 변경될 수 있다.
과거 IP와 신규 IP가 다를 수 있고 그러면 클라이언트는 접속할 수 가 없음

## DNS
도메인 네임 시스템
- 전화번호부
- 도메인 명을 IP주소로 변환

## DNS 사용
1. 도메인명 : google.com
2. 응답 : 200.200.200.2
3. 접속 : 200.200.200.2

DNS 서버가 있으면 위 두개의 문제가 해결됨.




> URI와 웹 브라우저 요청 흐름

# URI
소스를 식별하기 위한 통합된 방법

## URI와 웹 브라우저 요청 흐름
- URI
- 웹 브라우저 요청 흐름

## URI?URL?URN?

URI는 로케이터, 이름 또는 둘다 추가로 분류될 수 있다.

URL은 scheme://authority/path/query/fragement

URN은 ResoureName

## URI
단어 뜻 
- Uniform : 리소스 식별하는 통일된 방식
- Resource: 자원, URI로 식별할 수 있는 모든 것. 제한 없음
- Identifier: 다른 항목과 구분하는데 필요한 정보

- URL : Uniform Resource Locator
- URN : Uniform Resource Name

## URL, URN
- URL : Locator : 리소스가 있는 위치를 지정
- URN : Name : 리소스에 이름을 부여
- 위치는 변할 수 있찌만 이름은 변하지 않는다.
- URN 이름만으로 실제 리소스를 찾을 수 있는 방법이 보편화 되지 않음
- 앞으로 URI == URL 같은 의미로 설명

## URL 전체 문법
- 프로토콜 https
- 호스트명 www.google.com
- 포트번호 8080
- 패스 /search
- 쿼리 파라미터 q=hello 


## URL scheme
스키마

- 주로 프로토콜 사용
- 어떤 방식으로 자원에 접근할 것인가 하는 약속 규칙 http, https, ftp 등
- http는 80포트, https는 443포트 주로 사용, 포트는 생략 가능
- https는 http에 강력한 보안이 적용된 것

## URL host
- 호스트명
- 도메인명 또는 IP주소를 직접 사용 가능

## URL port
- port
- 접속 포트
- 생략가능

## URL path
- 리소스 경로, 계층적 구조

## URL query
- key value 형태
- ?로 시작, &로 추가 가능
- query parameter, query string 등으로 불림, 웹서버에 제공하는 파라미터 문자형태

## URL fragment
- html 내부 북마크 등에 사용
- 서버에 전송하는 정보 아님

# 웹 브라우저 요청 흐름


## HTTP 요청 메시지
GET /search?q=hello HTTP/1.1
Host: www.google.com

## HTTP 메시지 전송
1. 웹 브라우저가 HTTP 메시지 생성
2. SOCKET 라이브러리를 통해 전달
- A:TCP/IP 연결 (IP, PORT)
- B: 데이터 전달
3. TCP/IP 패킷 생성, HTTP 메시지 포함

## HTTP 응답 메시지
- HTML 데이터가 들어있다.
- 웹 브라우저가 렌더링 한다.


> HTTP 기본

# 모든 것이 HTTP

HTTP 메시지에 모든 것을 전송

- HTML, TEXT
- image, 음성, 영상, 파일 ..
- JSON, XML
- 거의 모든 형태의 데이터 전송 가능
- 서버간에 데이터를 주고 받을 때도 대부분 HTTP 사용
- 지금은 HTTP 시대!


## HTTP 역사
- 0.9
- 0.1
**- 1.1 97년 : 가장 많이 사용, 우리에게 가장 중요한 버전**
- 2.0 2015년 : 성능개선
- 3.0 진행중 : 성능개선

## 기반 프로토콜

- TCP : HTTP/1.1 , HTTP/2
- UDP : HTTP/3
- 현재 HTTP/1.1 주로 사용
	- HTTP/2, HTTP/3도 점점 증가
    
## HTTP 특징

- 클라이언트 서버 구조
- 무상태 프로토콜, 비연결성
- HTTP 메시지
- 단숨함, 확장 가능


# 클라이언트 서버 구조


- Request Response 구조
- 클라이언트는 서버에 요청을 보내고, 응답을 대기
- 서버가 요청에 대한 결과를 만들어서 응답



# Stateful, Stateless

## 무상태 프로토콜
- 서버가 클라이언트의 상태를 보존 X

## 상태 유지 - stateful
- 클라이언트의 상태를 보존
- 항상 같은 서버가 유지되어야 한다.

## 무상태 - stateless
- 클라이언트의 상태를 보존 X
- 아무 서버나 호출해도 된다.
- 중간에 서버가 동작할 수 없어도 중계서버가 다른 서버로 던져줄 수 있다.
- 스케알 아웃 : 수평 확장에 유리하다.
- 실무 한계 :
	- 모든 것을 무상태로 설계할 수 있는 경우도 있고 없는 경우도 있다.
    - 무상태
    	예) 로그인이 필요없는 단순한 서비스 소개 화면
    - 상태 유지
    	예 ) 로그인
    - 로그인한 사용자의 경우 로그인 했다는 상태를 서버에 유지
    - 일반적으로 브라우저 쿠키와 서버 세션등을 사용해서 상태 유지
    - 상태 유지는 최소한만 사용

## 상태유지, 무상태 차이
- 상태유지 : 중간에 다른 서버로 바뀌면 안된다. (중간에 다른 서버로 바뀔때 상태정보를 다른 서버에게 미리 알려주어야 한다.)
- 무상태 : 중간에 다른 서버로 바뀌어도 된다.
	- 갑자기 클라이언트 요청이 증가해도 서버를 대거 투입할 수 있다.
- 무상태는 응답 서버를 쉽게 바꿀 수 있다. > 무한한 서버 증설 가능


# 비연결성
- HTTP는 기본이 연결을 유지하지 않는 모델
- 일반적으로 초 단위 이하의 빠른 속도로 응답
- 1시간 동안 수천명이 서비스를 사용해도 실제 서버에서 동시에 처리하는 요청은 수십개 이하로 매우 작음
	- 예) 웹 브라우저에서 계속 연속해서 검색버튼을 누르지는 않는다.
- 서버 자원을 매우 효율적으로 사용할 수 있음

## 연결을 유지하는 모델
- HTTP 지속 연결 

## 연결을 유지하지 않는 모델
- 자원을 주고 받을때에만 연결하고 서버 연결 유지 x , 최소한의 자원 사용으로 서버를 운영

## 비연결성 한계와 극복
- TCP/IP 연결을 새로 맺어야함 - 3way handshake 시간 추가
- 웹 브라우저로 사이트를 요청하면 HTML 뿐만 아니라 자바스크립트, css , 추가 이미지등 수많은 자원이 함께 다운로드 
- 지금은 HTTP 지속 연결로 문제 해결
- HTTP/2, HTTP/3에서 더 많은 최적화

## 스테이스리스를 기억하자
서버 개발자들이 어려워하는 업무

- 정말 같은 시간에 딱 맞추어 발생하는 대용량 트래픽
- 예) 선착순 이벤트, 명절 KTX, 수강신청 


# HTTP 메시지

## 요청메시지
### 메서드
- GET, POST , PUT, DELETE ...
- 서버가 수행해야할 동작 지정

### 요청대상
- 절대경로="/"로 시작하는 경로

### HTTP 버전

## 응답 메시지
- HTTP 버전
- HTTP 상태 코드 : 요청 성공, 실패를 나타냄
	- 200 : 성공
    - 400 : 클라이언트 요청 오류
    - 500 : 서버 내부 오류
    
    
## HTTP 헤더

### 용도
- HTTP 전송에 필요한 모든 부가정보
- 메시지 body의 내용, 크기, 압축, 인증, 요청 클라이언트 브라우저의 정보, 서버 애플리케이션 정보, 캐시 관리 정보 ...
- 표준 헤더가 너무 많음
- 필요시 임의의 헤더 추가 가능

## HTTP 메시지 바디
- 실제 전송할 데이터
- HTML 문서, 이미지, JSON 등 ..

## 단순함 확장 가능
- HTTP는 단순하다. 스펙도 읽어볼만..
- HTTP 메시지도 매우 단순
- 크게 성공하는 표준 기술은 단순하지만 확장 가능한 기술


