package work.onss.scm.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


public interface MemberRepository extends JpaRepository<Member,String> {
}
