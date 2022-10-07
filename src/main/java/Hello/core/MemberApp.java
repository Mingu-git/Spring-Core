package Hello.core;

import Hello.core.member.Grade;
import Hello.core.member.Member;
import Hello.core.member.MemberService;
import Hello.core.member.MemberServiceimpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

public class MemberApp {


    public static void main(String[] args) {




        Member member =new Member(1L,"Minuk", Grade.VIP);

        //Appconfig appconfig = new Appconfig();
        //MemberService memberService = appconfig.memberService();
        // MemberService memberService = new MemberServiceimpl();

        //스프링을 활용한 DI컨테이너 구현
        //스프링 컨테이너에 빈 붙은 걸 다 넣어줌!!
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
        // 다음과 같이 빈에서 (이름 , 클래스) 로 찾아서 넣어주기
        MemberService memberService = applicationContext.getBean("memberService" , MemberService.class);



        memberService.join(member);
        Member findmember = memberService.findMember(1L);
    }
}
