package com.example.doantwo.service.implement;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.doantwo.entity.CategoryEntity;
import com.example.doantwo.entity.BookEntity;
import com.example.doantwo.modal.BookDto;
import com.example.doantwo.repository.BookReponsitory;
import com.example.doantwo.repository.CategoryReponsitory;
import com.example.doantwo.service.IBookService;
@Service
@Transactional
public class Bookservicer implements IBookService{
    @Autowired
    private BookReponsitory bookReponsitory;
    @Autowired
    private CategoryReponsitory categoryReponsitory;
  
    @Autowired 
    ModelMapper modelMapper;
    @Override
    public BookDto save(BookDto bookDto) {
        CategoryEntity categoryEntity=categoryReponsitory.findOneByName(bookDto.getCategory());
        BookEntity bookEntity =modelMapper.map(bookDto,BookEntity.class);
        bookEntity.setCategory(categoryEntity);
        bookEntity=bookReponsitory.save(bookEntity);
        
        return bookDto;
    }
    @Override
    public BookDto update(Long id,BookDto bookDto) {
       BookEntity oldbook= bookReponsitory.findById(id).get();
       CategoryEntity categoryEntity=categoryReponsitory.findOneByName(bookDto.getCategory());
       BookEntity bookEntity =modelMapper.map(oldbook,BookEntity.class);
       bookEntity.setCategory(categoryEntity);
       bookEntity=bookReponsitory.save(bookEntity);
        return bookDto;
    }
    @Override
    public BookDto delete(Long id) {
        bookReponsitory.deleteById(id);
        return null;
    }
    @Override
    public List<BookDto> getAll() {
        List<BookDto> employeeDtos=new ArrayList<BookDto>();
        bookReponsitory.findAll().forEach((employe)->{
         employeeDtos.add(modelMapper.map(employe,BookDto.class));
        });
        return employeeDtos;
        
    }
    @Override
    public Page<BookDto> getPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<BookEntity> page=bookReponsitory.findAll(pageable);

        return page.map(bookentity->modelMapper.map(bookentity,BookDto.class));
    }
    
    // @Override
    // public List<BookDto> getAll() {
    //     List<BookEntity> books = bookReponsitory.findAll();
    //     List<BookDto> bookDtos = books.stream()
    //             .map(book -> modelMapper.map(book, BookDto.class))
    //             .collect(Collectors.toList());
    //     return bookDtos;
    // }

    // public List<UserDto> getAllUsers() {
    //     List<User> users = userRepository.findAll();
    //     return users.stream()
    //         .map(user -> modelMapper.map(user, UserDto.class))
    //         .collect(Collectors.toList());
    // }
   
}
