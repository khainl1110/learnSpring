//package com.example.demo.web;
//
//import com.example.demo.domain.Book;
//import com.example.demo.persistence.InMemoryBookRepository;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("books")
//public class BookController1 {
//    private final InMemoryBookRepository bookService;
//
//    public BookController1(InMemoryBookRepository inMemoryBookRepository) {
//        this.bookService = inMemoryBookRepository;
//    }
//
//    @GetMapping
//    public Iterable<Book> get() {
//        return bookService.findAll();
//    }
//
//    @GetMapping("{isbn}")
//    public Book getByIsbn(@PathVariable String isbn) {
//        return bookService.findByIsbn(isbn).get();
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Book post(@RequestBody Book book) {
//        return bookService.save(book);
//    }
//
//    @DeleteMapping("{isbn}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable String isbn) {
//        bookService.deleteByIsbn(isbn);
//    }
//
//    @PutMapping("{isbn}")
//    public Book put(@PathVariable String isbn, @RequestBody Book book) {
//        return bookService.save(book);
//    }
//}
