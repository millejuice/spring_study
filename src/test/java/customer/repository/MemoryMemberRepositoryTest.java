package customer.repository;

import customer.domain.Member;
import customer.repo.MemberRepo;
import customer.repo.MemoryMemberRepo;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {
    MemberRepo repo = new MemoryMemberRepo();

    //run하면 실행되는것
    @Test
    public void save(){
        Member member = new Member();
        member.setName("juhyun");

        repo.save((Member) member);
         Member result = repo.findbyId(member.getId()).get(); /** save로 저장하면 setId로 저장한 값 getId로 받아온다
         findbuId가 optional이기 때문에 get으로 꺼내 옴 */
        System.out.println("result = " + (result == member ));
    }
}
