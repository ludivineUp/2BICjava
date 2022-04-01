package com.nfs.controllers;

import com.nfs.entities.Author;
import com.nfs.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepository repo;

    @RequestMapping(value = "", produces = "application/json")
    public List<Author> getAll(){
        return repo.findAll();
    }

    @RequestMapping(value = "/{id}", produces = "application/json")
    public Author get(@PathVariable(value="id") Integer id){
        return repo.getOne(id);
    }

    @PostMapping("/")
    public Author create(@RequestBody Author author){
        return repo.save(author);
    }

    @PutMapping("/")
    public Author update(@RequestBody Author author){
        return repo.save(author);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Author> delete(@PathVariable(value="id") Integer id){
        repo.deleteById(id);
        return ResponseEntity.ok().body(null);
    }
}
