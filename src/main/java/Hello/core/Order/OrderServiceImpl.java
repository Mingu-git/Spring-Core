package Hello.core.Order;

import Hello.core.discount.DiscountPolicy;
import Hello.core.member.Member;
import Hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {


    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createorder(Long memberId, int itemprice, String itemName) {
        Member member = memberRepository.findByID(memberId);
        int discountPrice = discountPolicy.discount(member , itemprice);

        return new Order(memberId , itemName , itemprice , discountPrice);
    }
}
