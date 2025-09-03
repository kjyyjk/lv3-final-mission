package finalmission.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import finalmission.domain.NicknameReservation;
import finalmission.repository.NicknameReservationRepository;

public interface NicknameReservationJpaRepository extends JpaRepository<NicknameReservation, Long>,
        NicknameReservationRepository {
}
