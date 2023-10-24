package com.br.comunidadeArteCultura.service;

import com.br.comunidadeArteCultura.entity.Mentor;
import com.br.comunidadeArteCultura.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentorService {

    @Autowired
    private MentorRepository repository;

    public Mentor create(Mentor mentor) {
        return repository.save(mentor);
    }
}
