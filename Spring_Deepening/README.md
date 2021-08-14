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


