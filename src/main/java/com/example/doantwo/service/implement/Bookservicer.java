package com.example.doantwo.service.implement;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
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
    public Page<BookDto> getUsers(Pageable pageable) {
        Page<BookEntity> users = bookReponsitory.findAll(pageable);
        List<BookDto> userDtos = users.stream()
            .map(user -> modelMapper.map(user, BookDto.class))
            .collect(Collectors.toList());
       return new PageImpl<>(userDtos,pageable,userDtos.size());
    }

   
}
