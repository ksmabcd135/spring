package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository repository;


//    @BeforeEach
//    public void beforeEach() {
//        repository = new MemoryMemberRepository();
//        memberService = new MemberService(repository);
//    }

//    @AfterEach
//    public void afterEach() {
//        repository.clearStore();
//    }


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

    }
    @Test
    void findMembers() {

    }
}
