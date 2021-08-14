package com.metropolitan.studentlist.repos;

import com.metropolitan.studentlist.models.Rola;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolaRepository extends JpaRepository<Rola, Integer> {

    Optional<Rola> findByNaziv(String naziv);

}