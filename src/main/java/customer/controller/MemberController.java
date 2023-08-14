package customer.controller;

import customer.domain.Member;
import customer.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
/** controller는 유저에게 입력 받는 것, service는 비즈니스 로직 만들고, repository에 값 저장하는게 패턴*/
public class MemberController {
    private final MemberService memberService;

    @Autowired
    /** autowired는 memberController가 생성될 때 스프링 빈에 저장된 memberService객체 자동으로 넣어준다 => Dependency injection*/
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}
