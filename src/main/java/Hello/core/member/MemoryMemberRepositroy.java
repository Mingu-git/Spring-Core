package Hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepositroy implements MemberRepository {

    private static Map<Long,Member> store = new HashMap<>();


    @Override
    public void save(Member member) {
        store.put(member.getId(),member);

    }

    @Override
    public Member findByID(Long memberid) {

        return store.get(memberid);
    }
}
