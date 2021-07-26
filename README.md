## Java_Spring
  ###  Spring을 활용한 웹 개발


#### import
- Spring Web
- Mysql Driver
- H2 Database
- Spring Data JPA
- Lombok

#### 환경설정
Annotation Processors -> Enable annotation processing 활성화

http://localhost:8080/h2-console에 들어가서 요류 발생시 변경       
JDBC URL: jdbc:h2:mem:testdb

#### Spring Data JPA
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods

#### 네이버 오픈 API
https://developers.naver.com/products/intro/plan/     
https://developers.naver.com/docs/search/shopping/


##### timestamed    
@Getter // get 함수를 자동 생성     
@MappedSuperclass // 멤버 변수가 컬럼이 되도록 변경     
@EntityListeners(AuditingEntityListener.class) // 변경되었을 때 자동으로 기록     
  
##### main     
@EnableJpaAuditing // 시간 자동 변경이 가능하도록 합니다.
@SpringBootApplication // 스프링 부트임을 선언합니다.

  
