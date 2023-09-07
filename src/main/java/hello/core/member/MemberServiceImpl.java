package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements  MemberService{
    // 구현체와 추상화 모두 의존하고 있음. DIP 위반
    private final MemberRepository _memberRepository;
    @Autowired // ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        _memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        _memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return _memberRepository.findById(memberId);
    }
}
