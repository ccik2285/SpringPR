package first.spring.repository;

import first.spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);  //null처리하는 방법 중 하나
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
