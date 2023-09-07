package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements  OrderService{

    private final MemberRepository _memberRepository;
    private final DiscountPolicy _discountPolicy;
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        _memberRepository = memberRepository;
        _discountPolicy = discountPolicy;
    } 

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = _memberRepository.findById(memberId);
        int discountPrice = _discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
