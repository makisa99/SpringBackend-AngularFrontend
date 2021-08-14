package com.metropolitan.studentlist.services;

import com.metropolitan.studentlist.payload.request.LoginDto;
import com.metropolitan.studentlist.repos.KorisnikRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private KorisnikRepository korisnikRepository;

    public AuthService(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    public boolean login(LoginDto loginDto) {
        return korisnikRepository.existsByImeAndLozinka(loginDto.getIme(), loginDto.getLozinka());
    }

}