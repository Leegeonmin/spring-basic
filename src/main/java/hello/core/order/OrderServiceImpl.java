package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements  OrderService{

    //필드에 바로 의존성 주입
    // 필드 주입은 간결하지만 외부에서 변경 불가능, 테스트 힘듦
    //@Autowired
    private MemberRepository _memberRepository;
    //@Autowired
    private DiscountPolicy _discountPolicy;
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("member Repository = " + memberRepository);
        System.out.println("DiscountPolicy = " + discountPolicy);
        _memberRepository = memberRepository;
        _discountPolicy = discountPolicy;
    }
    // 수정자를 통한 의존성 주입
    // 수정자가 있으면 @Autowired 기본 생성자가 필요없다
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository){this._memberRepository=memberRepository;}
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy){this._discountPolicy=discountPolicy;}
//    public MemberRepository getMemberRepository(){
//        return this._memberRepository;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = _memberRepository.findById(memberId);
        int discountPrice = _discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
