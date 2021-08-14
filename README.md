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

##### product
@Getter // get 함수를 일괄적으로 만들어줍니다.     
@NoArgsConstructor // 기본 생성자를 만들어줍니다.     
@Entity // DB 테이블 역할을 합니다.     
 // ID가 자동으로 생성 및 증가합니다.     
    @GeneratedValue(strategy = GenerationType.AUTO)     
    @Id     
    
// 반드시 값을 가지도록 합니다.    
    @Column(nullable = false)       

![image](https://user-images.githubusercontent.com/46198324/129441192-e32350e9-41da-4153-8e8c-2f2f9f91b777.png)

    
    
    
    
#### Mysql 연결하기
spring.datasource.url=jdbc:mysql://나의엔드포인트:3306/myselectshop     
spring.datasource.username=나의USERNAME     
spring.datasource.password=나의패스워드     
spring.jpa.hibernate.ddl-auto=update       

#### OpenJDK 설치
sudo apt-get update
sudo apt-get install openjdk-8-jdk
java -version //버전확인

#### 스프링 부트 작동
java -jar JAR파일명.jar

### 포트포워딩 & nohup 적용

sudo iptables -t nat -A PREROUTING -i eth0 -p tcp --dport 80 -j REDIRECT --to-port 8080      

##### 원격 접속을 종료하더라도 서버가 계속 돌아가게 하기
nohup java -jar JAR파일명.jar &
##### 서버 종료하기 - 강제종료
###### 아래 명령어로 미리 pid 값(프로세스 번호)을 본다
ps -ef | grep java

###### 아래 명령어로 특정 프로세스를 죽인다
kill -9 [pid값]
