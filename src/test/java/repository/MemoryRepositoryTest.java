package repository;

import domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class MemoryRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("PTS");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member = new Member();
        member.setName("1");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("2");
        repository.save(member2);

        Member result = repository.findByName("1").get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findAll(){
        Member member = new Member();
        member.setName("Pts");
        repository.save(member);

        Member member2 = new Member();
        member.setName("YJM");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

}
