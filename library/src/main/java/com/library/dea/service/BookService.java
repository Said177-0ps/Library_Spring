package com.library.dea.service;

import com.library.dea.dto.BookDTO;
import com.library.dea.entity.Author;
import com.library.dea.entity.Book;
import com.library.dea.mapper.BookMapper;
import com.library.dea.repository.AuthorRepository;
import com.library.dea.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book add(Book book){
          return bookRepository.save(book);
    }

    public List<Book> showAll() {
        return bookRepository.findAll();
    }

    public List<Book> getAllByTitle( String title){
        return bookRepository.findByTitle(title);
    }

    public Page<Book> getBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }


    public List<Book> getAllByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }

    public List<Book> getAllByMinPrice(Integer minPrice){
        return bookRepository.findByMinAmount(minPrice);
    }

    public List<Book> getAllByMinAmount(Integer minAmount){
        return bookRepository.findByMinAmount(minAmount);
    }

    public List<Author> getAllByAuthors() {
        return authorRepository.findAll();
    }

    public Book showById(Integer id) {
      return bookRepository.findById(id)
              .orElseThrow(() -> new RuntimeException("There is no such A Book With the Following ID!" + id) );
    }

    public Author findAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found!"));
    }

    public Book update(Integer id,BookDTO updatedBook){
       Book existing = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("No book with following id!"));

                    existing.setTitle(updatedBook.getTitle());
//                    existing.setAuthor(updatedBook.getAuthor());
                    existing.setPrice(updatedBook.getPrice());
                    existing.setAmount(updatedBook.getAmount());
//                    existing.setBookAuthor(updatedBook.getBookAuthor());
                    return bookRepository.save(existing);
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    public Page<Book> findPaginated(int page,int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        return bookRepository.findAll(pageable);
    }

    public Page<Book> search(String keyword, int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        return bookRepository.findByTitleContainingIgnoreCase(keyword, pageable);
    }

    public void saveDto(BookDTO bookDTO) {
        Book entity = BookMapper.toEntity(bookDTO);

        Author author = authorRepository
                .findById(bookDTO.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author Not found"));
        entity.setAuthor(author);


        bookRepository.save(entity);
    }



}
