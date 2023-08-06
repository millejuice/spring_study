package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //controller는 항상 어노테이션 해줘야 한다
public class HelloController {
    @GetMapping("hello") //hello라는 말 있으면 mapping 해준다
    //web route에 hello라는것 있다는거 인식하면 내장 톰캣서버가 스프링에 던진다
    //스프링은 해당하는 모델을 가지고 return에 해당하는곳으로 가서 렌더링 한다
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }
}
