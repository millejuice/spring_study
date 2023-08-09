package customer.repo;

import customer.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepo {
    Member save(Member member); //회원 저장하면 저장된 회원 반환
    Optional<Member> findbyId(Long id);  /** optional : 값 없을 때 null 반환*/
    Optional<Member> findByName(String name);
    List<Member> findAll(); //저장된 모든 정보반환
}
