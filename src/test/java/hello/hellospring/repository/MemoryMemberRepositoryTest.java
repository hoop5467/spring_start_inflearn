package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        memoryMemberRepository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        memoryMemberRepository.save(member);

        Member result = memoryMemberRepository.findById(member.getId()).get();

        //System.out.println("result = " + (result == member));

        Assertions.assertEquals(result,member);

        assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memoryMemberRepository.save(member2);

        Member result = memoryMemberRepository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }
    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        memoryMemberRepository.save(member2);

        List<Member> result = memoryMemberRepository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }
}
