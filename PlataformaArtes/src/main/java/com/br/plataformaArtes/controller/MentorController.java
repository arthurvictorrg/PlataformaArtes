package com.br.comunidadeArteCultura.controller;

import com.br.comunidadeArteCultura.entity.Mentor;
import com.br.comunidadeArteCultura.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    MentorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Mentor> create(@RequestBody Mentor mentor) {
        Mentor mentorCreated = service.create(mentor);

        return ResponseEntity.status(201).body(mentorCreated);
    }
}
