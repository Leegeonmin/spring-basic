package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService _memberService = new MemberServiceImpl();
    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        _memberService.join(member);
        Member findMember = _memberService.findMember(1L);
        //then
        Assertions.assertThat(findMember).isEqualTo(member);
    }
}
