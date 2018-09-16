package com.BioskopPoyyy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BioskopPoyyy.model.Theatres;



@Repository
public interface TheatresRepository extends JpaRepository<Theatres, Long> {

	Theatres findById(Long id);


}
