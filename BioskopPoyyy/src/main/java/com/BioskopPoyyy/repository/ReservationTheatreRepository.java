package com.BioskopPoyyy.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BioskopPoyyy.model.Guest;
import com.BioskopPoyyy.model.Theatres;
import com.BioskopPoyyy.reservation.ReservationTheatre;


@Repository
public interface ReservationTheatreRepository extends JpaRepository<ReservationTheatre, Long> {

	List<ReservationTheatre> findByGuest(Guest guest);
	List<ReservationTheatre> findById(Long id);
	List<ReservationTheatre> findByTheatres(Theatres theatre);
	List<ReservationTheatre> findByTheatres_Id(long id);
	List<ReservationTheatre> findByTerminDo(Date termindo);
	List<ReservationTheatre> findByTerminOd(Date terminod);
	Long countByGuest(Guest guest);
}
