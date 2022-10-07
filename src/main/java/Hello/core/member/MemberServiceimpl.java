package Hello.core.member;

public class MemberServiceimpl implements MemberService{

    private final MemberRepository memberRepository ;

    public MemberServiceimpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    // 이와같이 MemberRepository를 직접 설정해주는것이 아니라
    //다음과 같이 생성자 주입을 통해 구현해주자!

    @Override
    public void join(Member member) {

        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberID) {

        return memberRepository.findByID(memberID);

    }
}
