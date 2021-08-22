package service;

import domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository repository;

    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    /**
     *  회원 가입
     * */
    public Long join(Member member){

        validateDuplicateMember(member);
        repository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        repository.findByName(member.getName())
                .ifPresent(m -> {
                     throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){
        return repository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return repository.findById(memberId);
    }

}
