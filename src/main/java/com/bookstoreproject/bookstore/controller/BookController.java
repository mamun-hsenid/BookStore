package com.bookstoreproject.bookstore.controller;


import com.bookstoreproject.bookstore.entity.Book;
import com.bookstoreproject.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;


    @GetMapping("/book-list")
    public String showBookListPage(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }
    @GetMapping("/addbook")
    public String addUserForm(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        return "addBookForm";
    }

    @PostMapping("/add")
    public String createUser(@ModelAttribute("book") Book book) {
        System.out.println("add book"+book);
        try{
            bookService.createBook(book);
            return "redirect:/book/book-list";
        }catch(Exception e){
            return "redirect:/book/book-list";
        }
    }

    @GetMapping("/update")
    public String updateUserForm(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        System.out.println("inside update : "+book);
        return "updateBookForm";
    }

    @PostMapping("/update/bookname")
    public String updateBookName(@ModelAttribute("book") Book book) {
        System.out.println("update book"+book);
        try{
            bookService.updateBookNameById(book, book.getBookId());
            return "redirect:/book/book-list";
        }catch(Exception e){
            return "redirect:/book/book-list";
        }
    }

    @PostMapping("/update/authorname")
    public String updateAuthorName(@ModelAttribute("book") Book book) {
        System.out.println("update book"+book);
        try{
            bookService.updateBookAuthorById(book, book.getBookId());
            return "redirect:/book/book-list";
        }catch(Exception e){
            return "redirect:/book/book-list";
        }
    }

    @GetMapping("/delete/{bookId}")
    public String deleteUser(@PathVariable("bookId") int bookId){
        System.out.println("");
        System.out.println("delete book"+bookId);
        try{
            bookService.deleteBookById(bookId);
            return "redirect:/book/book-list";
        }catch(Exception e){
            return "redirect:/book/book-list";
        }
    }















//    @GetMapping("/")
//    public List<Book> getBooks() {
//        return bookService.getAllBooks();
//    }
//
//    @PostMapping
//    public int addBook(@RequestBody Book book) {
//        return bookService.createBook(book);
//    }
//    @PutMapping("/update-name/{id}")
//    public ResponseEntity<Object> updateBookName(@RequestBody Book book, @PathVariable("id") Integer id){
//        System.out.println("Book from controller"+book);
//        System.out.println("id "+id);
//        try{
//            bookService.updateBookNameById(book,id);
//            return ResponseEntity.status(HttpStatus.OK).build();
//        }catch(Exception e){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//    @PutMapping("/update-author/{id}")
//    public ResponseEntity<Object> updateBookAuthor(@RequestBody Book book, @PathVariable("id") Integer id){
//        System.out.println("Book from controller "+book);
//        System.out.println("id "+id);
//        try{
//            bookService.updateBookAuthorById(book,id);
//            return ResponseEntity.status(HttpStatus.OK).build();
//        }catch(Exception e){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> deleteBook(@PathVariable("id") Integer id) {
//        System.out.println("delete user" + id);
//        try {
//            bookService.deleteBookById(id);
//            return ResponseEntity.status(HttpStatus.OK).build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//    @GetMapping("/{name}")
//    public List<AuthorBook> getAuthorBooks(@PathVariable("name") String name) {
//        return bookService.getBookAuthor(name);
//    }

}
