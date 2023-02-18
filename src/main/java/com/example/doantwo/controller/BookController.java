package com.example.doantwo.controller;

import java.util.List;

import javax.websocket.server.PathParam;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.doantwo.entity.BookEntity;
import com.example.doantwo.modal.BookDto;
import com.example.doantwo.repository.BookReponsitory;
import com.example.doantwo.service.IBookService;
import com.google.common.base.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path ="/book")
@CrossOrigin
public class BookController {
    @Autowired
    IBookService bookService;
    @Autowired
    BookReponsitory bookReponsitory;

    // @GetMapping(path = "/new")
    // public void getDate(BookDto bookDto,@RequestParam("p") Optional<Long> p)
      // @PostMapping(path = " ouput")
      // public BookOutput showNew(@RequestParam("page") int page,@RequestParam("limit") int limit){
      //   BookOutput reslult = new BookOutput();
      //   reslult.setPage(page);
      //   return null;
      // }
    @PostMapping(path ="/add")
    public BookDto postBook(@RequestBody BookDto entity) {
    
        return bookService.save(entity);
    }
    @PutMapping(path = "/update/{id}")
    public BookDto updateBook(@RequestBody BookDto entity,@PathVariable("id") long id){
        entity.setId(id);
        return bookService.update(id, entity);
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteBook(@RequestBody long id){
        bookService.delete(id);
    } 
    @GetMapping(path = "show")
    public List<BookDto> getAll(){
    
      // try {
        return bookService.getAll();
    // } catch (Exception e) {
    //     e.printStackTrace();
    //     return null;
    // }
  }
  @GetMapping(value="showpage")
  public Page<BookDto> getMethodName( @RequestParam(defaultValue = "0") int page,
  @RequestParam(defaultValue = "1") int size) {
      return bookService.getPage(page,size) ;
  }
  
}
