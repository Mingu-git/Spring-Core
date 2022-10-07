package Hello.core;

import Hello.core.Order.OrderService;
import Hello.core.Order.OrderServiceImpl;
import Hello.core.discount.DiscountPolicy;
import Hello.core.discount.DiscountPolicyImpl;
import Hello.core.discount.RateDiscountPolicy;
import Hello.core.member.MemberRepository;
import Hello.core.member.MemberService;
import Hello.core.member.MemberServiceimpl;
import Hello.core.member.MemoryMemberRepositroy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceimpl(memberRepositroy());
    }
    //멤버 서비스 사용시 멤버 리포지 토리 넣어주기

    //멤버서비스 생성 -> 멤버서비스(멤버리포지토리) 실행  -> 이때 appconfig로 와서 -> 메모리멤버 리포지토리 주입
    // -> 멤버서비스 입플리에서 넣어준 메모리멤버 리포티조리 실행

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepositroy() , discountPolicy());
    }


    //결론 멤버서비스는 메모리멤버리포지토리를 의존 x // 오더서비스는 메모리멤버리포지토리 , 할인정책을 의존하지 않음
    // DIP 완성

    /**
     * 메모리 , 할인정책또한 DIP를 구현해주면 역할에 따른 구현이 매우 잘보이게 된다
     * 대부분 인터페이스를 기본 생성자로 하여 return시 impl를 return해준다
     */
    @Bean
    public MemberRepository memberRepositroy(){
        return new MemoryMemberRepositroy();
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }


}
