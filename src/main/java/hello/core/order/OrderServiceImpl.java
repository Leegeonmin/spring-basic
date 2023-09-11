package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements  OrderService{

    //필드에 바로 의존성 주입
    // 필드 주입은 간결하지만 외부에서 변경 불가능, 테스트 힘듦
    //@Autowired
    private final MemberRepository _memberRepository;
//    @Autowired
    private final DiscountPolicy _discountPolicy;
    
    // 필드명을 매칭시켜주면 같은 타입이 Component로 스프링빈에 등록되어도 필드명으로 매칭시켜준다
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        _memberRepository = memberRepository;
        _discountPolicy = discountPolicy;
    }
    public MemberRepository getMemberRepository(){
        return this._memberRepository;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = _memberRepository.findById(memberId);
        int discountPrice = _discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
