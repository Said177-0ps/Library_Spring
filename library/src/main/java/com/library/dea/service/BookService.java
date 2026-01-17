package com.library.dea.service;

import com.library.dea.entity.Book;
import com.library.dea.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    public List<Book> getAllByTitle(@PathVariable String title){
        return bookRepository.findByTitle(title);
    }

    public List<Book> getAllByAuthor(@PathVariable String author){
        return bookRepository.findByAuthor(author);
    }

    public List<Book> getAllByMinPrice(@PathVariable Integer minPrice){
        return bookRepository.findByMinAmount(minPrice);
    }

    public List<Book> getAllByMinAmount(@PathVariable Integer minAmount){
        return bookRepository.findByMinAmount(minAmount);
    }

    public Book showById(@PathVariable Integer id) {
      return bookRepository.findById(id)
              .orElseThrow(() -> new RuntimeException("There is no such A Book With the Following ID!" + id) );
    }

    public Book update(@PathVariable Integer id, @RequestBody Book updatedBook){
        return bookRepository.findById(id)
                .map(existing -> {
                    existing.setTitle(updatedBook.getTitle());
                    existing.setAuthor(updatedBook.getAuthor());
                    existing.setPrice(updatedBook.getPrice());
                    existing.setAmount(updatedBook.getAmount());
                    return bookRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("no such a book with the following id" + id));
    }

    public void deleteBook(@PathVariable Integer id) {
        bookRepository.deleteById(id);
    }

}
