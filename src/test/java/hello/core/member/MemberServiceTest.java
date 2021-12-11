package hello.core.member;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by Imaspear on 2021-12-11
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
class MemberServiceTest {

    @Test
    void join(){
        //given
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        memberService.join(member);
//        Member member1 = memberService.findMember(1L);
        //then
        Assertions.assertThat(memberService.findMember(1L)).isEqualTo(member);
    }
}