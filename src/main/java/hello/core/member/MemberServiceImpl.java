package hello.core.member;

public class MemberServiceImpl implements  MemberService{
    // 구현체와 추상화 모두 의존하고 있음. DIP 위반
    private final MemberRepository _memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        _memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return _memberRepository.findById(memberId);
    }
}
