package customer.service;

import customer.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService = new MemberService();

    @Test ///test case는 given - when -then으로 나눠서 하면 편하다
    void join() {
        //given - 주어졌을 때
        Member member = new Member();
        member.setName("juhyun");
        //when - 어떤 상황에서
        Long saveId = memberService.join(member);
        //then - 어떤 결과가 나온다
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class , ()->memberService.join(member2));
        //member2 join하면 IAE발생해서 e에 저장
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원");
        //then

    }

    @Test
    void findOne() {
    }
}