package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//처음에 spring initializer 다운받고 에러 나오는데 우측 상단
// settings --> Build, Execution, Deployment --> Build Tools --> Gradle -> project gradle jvm 20 선택
//gradle refresh 해주면 해결
//run하면 Tomcat initialized with port(s): 8080 (http) 뜨는데 local:8080 쳐서 에러페이지 나오면 성공


@SpringBootApplication
public class HellospringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellospringApplication.class, args);
	}

}
