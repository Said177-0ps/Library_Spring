package com.library.dea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.library.dea.entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
