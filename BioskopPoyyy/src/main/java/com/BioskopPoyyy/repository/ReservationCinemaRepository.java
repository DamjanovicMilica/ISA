package com.BioskopPoyyy.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.BioskopPoyyy.model.Cinema;
import com.BioskopPoyyy.model.Guest;
import com.BioskopPoyyy.reservation.ReservationCinema;


@Repository
public interface ReservationCinemaRepository extends JpaRepository<ReservationCinema, Long> {

	List<ReservationCinema> findByGuest(Guest guest);
	List<ReservationCinema> findById(Long id);
	List<ReservationCinema> findByCinema(Cinema cinema);
	List<ReservationCinema> findByCinema_Id(long id);
	List<ReservationCinema> findByTerminDo(Date termindo);
	List<ReservationCinema> findByTerminOd(Date terminod);
	Long countByGuest(Guest guest);
}
