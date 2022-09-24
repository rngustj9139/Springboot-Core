package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

//  private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); => 인터페이스, 구현체 둘다 의존하게됨
//  private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); => 인터페이스, 구현체 둘다 의존하게됨
//  private DiscountPolicy discountPolicy;  인터페이스만 의존하게됨, but 실행하면 오류남, Null에다가 . 찍고 함수실행하려면 NULLPOINTEREXCEPTION 발생, 아무것도 할당이 안되어있어서 discountPolicy는 NULL이다
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    @Autowired , @RequiredArgsConstructor가 대신함
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
