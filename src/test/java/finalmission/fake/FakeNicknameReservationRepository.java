package finalmission.fake;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.test.util.ReflectionTestUtils;

import finalmission.domain.Member;
import finalmission.domain.NicknameReservation;
import finalmission.repository.NicknameReservationRepository;

public class FakeNicknameReservationRepository implements NicknameReservationRepository {

    private long index = 0L;
    private List<NicknameReservation> reservations = new ArrayList<>();

    @Override
    public NicknameReservation save(NicknameReservation reservation) {
        ReflectionTestUtils.setField(reservation, "id", ++index);
        reservations.add(reservation);
        return reservation;
    }

    @Override
    public List<NicknameReservation> findAllByMember(Member member) {
        return reservations.stream()
                .filter(reservation -> reservation.getMember().getId() == member.getId())
                .toList();
    }

    @Override
    public List<NicknameReservation> findAll() {
        return List.copyOf(reservations);
    }

    @Override
    public Optional<NicknameReservation> findById(long reservationId) {
        return reservations.stream()
                .filter(reservation -> reservation.getId() == reservationId)
                .findAny();
    }

    @Override
    public void delete(NicknameReservation other) {
        reservations.removeIf(reservation -> reservation.getId() == other.getId());
    }
}
