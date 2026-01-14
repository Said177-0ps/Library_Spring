package com.library.dea.controller;

import com.library.dea.entity.Book;
import com.library.dea.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
      return bookService.showAll();
  }

   @PostMapping("/add")
    public Book createBook(@RequestBody Book book) {
       return bookService.add(book);
   }

}
