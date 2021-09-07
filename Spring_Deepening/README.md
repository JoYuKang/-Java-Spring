### 심화 

#### java <-> json 

bulid.gradle 

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'     
    implementation 'org.springframework.boot:spring-boot-starter-web'     
    compileOnly 'org.projectlombok:lombok'     
    runtimeOnly 'com.h2database:h2'     
    runtimeOnly 'mysql:mysql-connector-java'     
    annotationProcessor 'org.projectlombok:lombok'     
    testImplementation 'org.springframework.boot:spring-boot-starter-test'     
    implementation 'org.json:json:20210307'     
}



#### DI 사용
![image](https://user-images.githubusercontent.com/46198324/129450661-ef3191ab-5698-4343-aa39-25ffefe57c83.png)

#### Spring Reference Documentation
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods



#### 핵심기능과 부가기능
이렇게 구현시 하드코딩이 되고 각 기능별로 관리하기 힘듬
![image](https://user-images.githubusercontent.com/46198324/132268716-3df044c3-de78-439c-b3f7-3a42d84298d9.png)

#### 모듈화
모듈화 하여 필요한 부분에 가져다가 쓰면 훨씬 편리
![image](https://user-images.githubusercontent.com/46198324/132269538-413dbb08-0585-4db5-bb81-2d3a1a1cde0d.png)

#### SPRING AOP 활용

![image](https://user-images.githubusercontent.com/46198324/132269603-2e5936f2-1214-4cdf-a7da-9e8821bee6ed.png)

