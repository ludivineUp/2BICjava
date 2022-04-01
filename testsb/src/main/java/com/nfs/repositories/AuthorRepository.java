package com.nfs.repositories;

import com.nfs.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository  extends JpaRepository<Author, Integer> {

    public Author getAuthorByFirstname(String firstname);
}
