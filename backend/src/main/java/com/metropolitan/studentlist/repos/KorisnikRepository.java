package com.metropolitan.studentlist.repos;

import com.metropolitan.studentlist.models.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    Boolean existsByImeAndLozinka(String ime, String lozinka);

}