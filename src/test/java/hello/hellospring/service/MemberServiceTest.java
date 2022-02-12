package hello.hellospring.service;

import hello.hellospring.domain.Member;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;

    @Test
    void join() {
        //given
        Member newMember = new Member();
        newMember.setName("hello name");

        //when
        Long savedId = memberService.join(newMember);

        //then
        Member findMember = memberService.findOne(savedId).get();
        assertThat(findMember.getName()).isEqualTo(newMember.getName());
    }

    @Test
    void duplicatedJoin() {
        //given
        Member member1 = new Member();
        Member member2 = new Member();

        member1.setName("hello");
        member2.setName("hello");

        memberService.join(member1);

        //when
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(exception.getMessage()).isEqualTo("이미 존재하는 회원입니다");
//        try {
//            Long savedId1 = memberService.join(member1);
//            Long savedId2 = memberService.join(member2);
//            fail();
//        }catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
//        }


        //then
    }
    @Test
    void findMembers() {

    }
}