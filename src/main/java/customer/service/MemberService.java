package customer.service;
//service 파일은 비즈니스적으로 메소드, 변수들 만들기

import customer.domain.Member;
import customer.repo.MemberRepo;
import customer.repo.MemoryMemberRepo;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepo memberRepository = new MemoryMemberRepo();

    //회원가입
    public Long join(Member member){
        //같은 이름의 회원은 못한다
        //원래 null값일 경우 구분해야 하는데 optional로 감싸서 ifPresent 사용할 수 있다
        //보잡하니까 method로 따로 빼준다 ctrl + t 에서 extract method 선택
        //Optional<Member> result = memberRepository.findByName(member.getName());
        //        result.ifPresent(member1 -> {  //null이 아니라 이미 있으면 멤버에 대해 출력
        //            throw new IllegalStateException("이미 존재하는 회원");
        //        }); 이거를 21번 줄처럼 바꾸기
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(member1 -> {  //null이 아니라 이미 있으면 멤버에 대해 출력
            throw new IllegalStateException("이미 존재하는 회원");
        });
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findbyId(memberId);
    }
}
