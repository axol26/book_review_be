package com.book.BooksReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "https://bookreview-t1vn.onrender.com")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{bookId}")
    public Book getBookByBookId(@PathVariable String bookId) {
        return bookRepository.findByBookId(bookId);
    }

    @PutMapping("/{bookId}")
    public Book updateBookByBookId(@PathVariable String bookId, @RequestBody Book book) {
        Book existingBook = bookRepository.findByBookId(bookId);
        if (existingBook != null) {
            book.setId(existingBook.getId());
            return bookRepository.save(book);
        }
        return null;
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable String bookId) {
        Book existingBook = bookRepository.findByBookId(bookId);
        if (existingBook != null) {
            bookRepository.delete(existingBook);
        }
    }
}