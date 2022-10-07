package Hello.core.discount;

import Hello.core.member.Member;

public interface DiscountPolicy {

    /**
     * \
     * @param member
     * @param price
     * @return 할인 대상 금액 리턴
     */

    int discount(Member member , int price);
}
