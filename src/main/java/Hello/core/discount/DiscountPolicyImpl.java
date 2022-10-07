package Hello.core.discount;

import Hello.core.member.Grade;
import Hello.core.member.Member;

public class DiscountPolicyImpl implements DiscountPolicy{

    private int discountfixamount = 1000;

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP){
            return discountfixamount;
        }
        else {
            return 0;
        }
    }
}
