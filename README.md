# Gato:캣 
고양이 집사들이 소통할 수 있는 활동적인 커뮤니티를 만들기 위해서 기획하게 된 서비스입니다. 
사용자들끼리 자신의 지식을 공유하고 도움을 받을 수 있도록 블로그 형태로 포스팅을 하고 댓글을 통해 다른 사용들과 소통이 가능합니다. 
Spring Framework를 활용하여 Rest Api를 이용하여 CRUD 연산을 행하여 커뮤니티의 포스트 및 댓글, 로그인, 사용자 정보 수정 기능을 구현하였습니다.

###  프로젝트 목표 
- service layer 통해 의존적이지 않은 코드 작성 
- @Transactional 이용 로직 구현 
- JPA 기반으로 Hibernate 을 이용하여 객체자체 집중의 로직 개발  

기술 명세서 : 
 - 게시판 CRUD 비즈니스 로직 구현 
 - 회원 비즈니스 로직 구현 
 - Spring Security 
 - Kakao OAuth login : 토큰 기반 로그인 구현 
 - 

### 프로젝트 구조 

#### 개발 환경 
Java, Spring Boot, Gradle, MySQL, JPA, Hibernate

### 프로젝트 중점 사항 
- 비즈니스 코드 역할 분리하여 작성 
- REST API 
- OAuth 키카오 로그인 
- JPA 활용 
