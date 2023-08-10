package customer.repository;

import customer.domain.Member;
import customer.repo.MemberRepo;
import customer.repo.MemoryMemberRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepo repo = new MemoryMemberRepo();

    //Test 끝나고 repo 지우기
    @AfterEach // Test 함수 한번 끝날때마다 실행되는 것
    public void afterEach(){
        repo.clearStore();
    }

    //run하면 실행되는것
    @Test
    public void save(){
        Member member = new Member();
        member.setName("juhyun");

        repo.save((Member) member);
         Member result = repo.findbyId(member.getId()).get(); /** save로 저장하면 setId로 저장한 값 getId로 받아온다
         findbuId가 optional이기 때문에 get으로 꺼내 옴 */
        System.out.println("result = " + (result == member ));
        Assertions.assertEquals(member, result); //비교하는 것
    }

    @Test
    public void findByName(){
        Member mem1 = new Member();
        mem1.setName("David");
        repo.save(mem1);

        Member mem2 = new Member();
        mem2.setName("JH");
        repo.save(mem2);

        Member result = repo.findByName("David").get();
    }
}
