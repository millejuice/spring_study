package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //controller는 항상 어노테이션 해줘야 한다
public class HelloController {
    @GetMapping("hello") //hello라는 말 있으면 mapping 해준다
    //web route에 hello라는것 있다는거 인식하면 내장 톰캣서버가 스프링에 던진다
    //스프링은 해당하는 모델을 가지고 return에 해당하는곳으로 가서 렌더링 한다
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc") //url에 hello-mvs라는게 있으면 이 controller라는거 인식
    public String helloMVC(@RequestParam("name") String name, Model model){  //외부에서 파라미터를 받는 방식
        //url에 hello-mvc?name=원하는 이름 으로 검색해야 에러가 안나온다
    //위에는 hello!!라는 attributeValue값을 가져왔는데 이번에는 외부에서 받아오는것 model에 담으면 렌더링할 때 사용
    model.addAttribute("name",name); //파라미터로 넘어온 name을 넘겨받는것
    //http://localhost:8080/hello-mvc?name=juhyun 이렇게 입력했다가 치면 name값이 바뀌고, model로 값 넘어간다
    //hello-template으로 넘어가면 ${name}에 model안에 있던 name이 들어감


    return "hello-template"; //static폴더 templates 폴더 안에 새로 파일 만들어서 파라미터 web꾸미기
    }

    @GetMapping("hello-string")
    @ResponseBody //http의 response body부분에 return값 직접 넣겠다는 뜻
    public String helloString(@RequestParam("name") String name){
        return "hello "+name;
    }

    @GetMapping("hello-api")
    @ResponseBody //json반환이 기본
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name); //private인 name 접근할 수 있게 set으로 설정
        return hello;
    }
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
