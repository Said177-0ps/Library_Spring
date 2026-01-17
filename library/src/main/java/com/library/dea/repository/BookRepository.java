package com.library.dea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.library.dea.entity.Book;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(
            value = "SELECT * FROM books where LOWER(title) LIKE LOWER(CONCAT('%', :title, '%'))",
            nativeQuery = true
    )

    List<Book> findByTitle(String title);

@Query(
        value = "SELECT * FROM books where LOWER(author) LIKE LOWER(CONCAT('%', :author, '%'))",
        nativeQuery = true
)

List<Book> findByAuthor(String author);



@Query(
        value = "SELECT * FROM books where amount >= :minAmount",
        nativeQuery = true
)
List<Book> findByMinAmount(Integer minAmount);

    @Query(
            value = "SELECT * FROM books where amount >= :minPrice",
            nativeQuery = true
    )
    List<Book> findByMinPrice(Integer minPrice);
}
