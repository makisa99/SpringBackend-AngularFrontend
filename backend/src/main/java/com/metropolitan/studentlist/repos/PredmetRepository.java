package com.metropolitan.studentlist.repos;

import com.metropolitan.studentlist.models.Predmet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PredmetRepository extends JpaRepository<Predmet, Long> {
}