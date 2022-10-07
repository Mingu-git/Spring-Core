package Hello.core.MembersericeTest;

import Hello.core.Appconfig;
import Hello.core.member.Grade;
import Hello.core.member.Member;
import Hello.core.member.MemberService;
import Hello.core.member.MemberServiceimpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {


    MemberService memberService;

    @BeforeEach
    public void before(){
        Appconfig appconfig = new Appconfig();
        memberService = appconfig.memberService();
    }

    @Test
    void Join(){

        //given
        Member member = new Member(1L,"Minuk",Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        Member memberB = new Member(2L,"Minuk",Grade.VIP);
        //test

        Assertions.assertEquals(memberB,findMember);



    }



}
