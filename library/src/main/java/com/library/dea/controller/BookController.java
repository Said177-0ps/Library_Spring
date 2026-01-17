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

   @PutMapping("/update/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book book){
        return bookService.update(id, book);
   }

   @DeleteMapping("/delete/{id}")
    public void deleteBookById(@PathVariable Integer id){
        bookService.deleteBook(id);
   }

    @GetMapping("find/title/{title}")
    public List<Book> getAllBooksByTitle(@PathVariable String title){
        return bookService.getAllByTitle(title);
    }


    @GetMapping("find/author/{author}")
    public List<Book> getAllBooksByAuthor(@PathVariable String author){
        return bookService.getAllByAuthor(author);
   }

    @GetMapping("find/price/{minPrice}")
    public List<Book> getAllByMinPrice(@PathVariable Integer minPrice){
        return bookService.getAllByMinPrice(minPrice);
    }

    @GetMapping("find/amount/{minAmount}")
    public List<Book> getAllByMinAmount(@PathVariable Integer minAmount){
        return bookService.getAllByMinAmount(minAmount);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Integer id) {
        return bookService.showById(id);
    }
}
