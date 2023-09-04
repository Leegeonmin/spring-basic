package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService _memberService;
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        _memberService = appConfig.memberService();
    }
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
