package com.library.dea.service;

import com.library.dea.entity.Book;
import com.library.dea.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book add(Book book){
          return bookRepository.save(book);
    }

    public List<Book> showAll() {
        return bookRepository.findAll();
    }

    public Book showById(@PathVariable Integer id) {
      return bookRepository.findById(id)
              .orElseThrow(() -> new RuntimeException("There is no such A Book With the Following ID!" + id) );
    }

    public void deleteBook(@PathVariable Integer id) {
        bookRepository.deleteById(id);
    }

}
