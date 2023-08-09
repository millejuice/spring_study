package customer.repo;
import customer.domain.Member;
import java.util.*;

public class MemoryMemberRepo implements MemberRepo {

    /** save기능에서 저장할 값 보관하는 변수 */
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findbyId(Long id) {
        /** store에서 꺼내 씀*/
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        /** 람다식 검색한 이름이 등록되어 있으면 이름 반환 */
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //member 반환 됨
    }
}