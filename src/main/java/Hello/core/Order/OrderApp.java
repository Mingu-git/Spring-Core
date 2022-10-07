package Hello.core.Order;

import Hello.core.Appconfig;
import Hello.core.member.Grade;
import Hello.core.member.Member;
import Hello.core.member.MemberService;
import Hello.core.member.MemberServiceimpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

        //Appconfig appconfig = new Appconfig();

        //MemberService memberService = appconfig.memberService();
        //MemberService memberService = new MemberServiceimpl(memberRepository);

        //OrderService orderService = appconfig.orderService();
        //OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService",OrderService.class);


        Long membeId = 1L;
        Member member = new Member(membeId,"Minuk", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createorder(membeId, 20000, "itemA");

        System.out.println("order" + order);


    }
}
