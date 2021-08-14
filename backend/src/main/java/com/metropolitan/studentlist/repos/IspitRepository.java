package com.metropolitan.studentlist.repos;

import com.metropolitan.studentlist.models.Ispit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IspitRepository extends JpaRepository<Ispit, Long> {
}