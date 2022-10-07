package Hello.core.MembersericeTest.Order;

import Hello.core.Appconfig;
import Hello.core.Order.Order;
import Hello.core.Order.OrderService;
import Hello.core.Order.OrderServiceImpl;
import Hello.core.member.Grade;
import Hello.core.member.Member;
import Hello.core.member.MemberService;
import Hello.core.member.MemberServiceimpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;

public class OrderServiceTest {

    //MemberService memberService = new MemberServiceimpl(memberRepository);

    //OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public  void befoe(){
        Appconfig appconfig = new Appconfig();
        memberService = appconfig.memberService();
        orderService = appconfig.orderService();
    }


    @Test
    void creteaOrder(){
        Member member = new Member(1L,  "Minuk", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createorder(member.getId(),10000,"itemA");
        Assertions.assertEquals(order.getDiscountPrice(),1000);

    }


}
