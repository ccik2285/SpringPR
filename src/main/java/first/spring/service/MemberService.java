package first.spring.service;

import first.spring.domain.Member;
import first.spring.repository.MemberRepository;
import first.spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
public class MemberService {

    private final MemberRepository memberRepository;



    public MemberService(MemberRepository memberRepository){ //di 방식 너는 MemberRepository가 필요하구나 해서 컨테이너에서 di를 주입해줌
        this.memberRepository = memberRepository;
    }

    /*
    * 회원가입
    */


    public Long join(Member member){
        //같은 이름이 있는 중복 회원 안됨
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m ->{
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }
    
    /*
    * 전체 회원 조회
    */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
