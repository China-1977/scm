package work.onss.scm.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member,String> {

    Optional<Member> findByPhone(String s);
}
