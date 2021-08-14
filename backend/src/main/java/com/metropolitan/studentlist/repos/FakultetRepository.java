package com.metropolitan.studentlist.repos;

import com.metropolitan.studentlist.models.Fakultet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FakultetRepository extends JpaRepository<Fakultet, Long> {
}