package com.people.controller;

import com.people.entity.People;
import com.people.service.PeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Controller
@RequiredArgsConstructor
public class PeopleController {


    private final PeopleService peopleService;


    @PostMapping
    public ResponseEntity<People> save(@RequestBody People people){
        return ResponseEntity.status(CREATED).body(peopleService.save(people));
    }

    @GetMapping("/{id}")
    public ResponseEntity<People> findById(@PathVariable String id){
        return ResponseEntity.ok().body(peopleService.getById(id));
    }
    @GetMapping("/{firstName}/{lastName}")
    public ResponseEntity<List<People>> findByName(@PathVariable String firstName, String lastName){
        return ResponseEntity.ok().body(peopleService.findByName(firstName, lastName));
    }

    @PutMapping
    public ResponseEntity<People> update(@RequestBody People people){
        return ResponseEntity.accepted().body(peopleService.update(people));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        return ResponseEntity.ok().body(peopleService.delete(id));
    }

    @GetMapping
    public ResponseEntity<List<People>> getAll(){
        return ResponseEntity.ok().body(peopleService.getAll());
    }


}
