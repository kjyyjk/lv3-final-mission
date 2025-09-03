package finalmission.repository;

import java.util.Optional;

import finalmission.domain.Member;

public interface MemberRepository {

    Optional<Member> findMemberById(long id);
    Member save(Member member);
    Optional<Member> findByEmailAndPassword(String email, String password);
}
