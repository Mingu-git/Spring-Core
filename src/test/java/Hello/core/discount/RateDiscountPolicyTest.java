package Hello.core.discount;

import Hello.core.member.Grade;
import Hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    void vip_o(){
        //gi
        Member member = new Member(1L,"Min", Grade.BASIC);

        //wh
        int discount = rateDiscountPolicy.discount(member,10000);

        //test


        assertEquals(discount, 1000);
    }



}