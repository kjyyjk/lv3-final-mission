package finalmission.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import finalmission.domain.Member;
import finalmission.repository.MemberRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long>, MemberRepository {
}
