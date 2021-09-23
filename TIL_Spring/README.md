## Java_Spring 개념 정리
  ###  @RequestParam @PathVariable 차이
  
  
  #### @RequestParam 개념
  -  url뒤에 붙는 파라미터의 값을 가져올 때 사용
  -  파라미터의 값과 이름을 함께 전달하는 방식
  ex) /requestparam?userid="userid의 value값"
  - RequestParam에 key값이 존재하지 않을 경우 -> "BadRequest 로 4**" error가 발생     
  해결방법 - "required=false"로 기본 값 설정
  
  #### @PathVariable 개념
  - Rest api에서 값을 호출할 때 주로 사용
  - PathVariable 의 경우 url에서 각 구분자에 들어오는 값을 처리해야 할 때 사용     
  ★중요★     
  WAS같은 경우 URL에 특수문자나 구분기호 " , , ` , . " 등을 사용하면 인식 불가
  JSON 형태로 HTTP BODY에 데이터를 넣어야한다.
  
 ### 실제로는 @RequestParam 또는 @PathVariable 하나만 사용하는 것이 아닌 복합적으로 사용
 
 
 ###  @Bean 과 @Component 차이

#### @Bean
- @Bean은 메소드 레벨에서 선언하며, 반환되는 객체(인스턴스)를 개발자가 수동으로 @Bean으로 등록
- 개발자가 컨트롤이 불가능한 외부 라이브러리들을 Bean으로 등록하고 싶은 경우에 사용
- 개발자가 생성한 클래스에 @Bean은 선언 불가능

#### @Component
- @Component는 클래스 레벨에서 선언함으로써 스프링이 런타임시에 컴포넌트스캔을 하여 자동으로 @Bean을 찾고(detect) 등록
- 개발자가 직접 컨트롤이 가능한 Class들의 경우엔 @Component를 사용
