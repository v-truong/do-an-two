package com.example.doantwo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.doantwo.modal.BookDto;


public interface IBookService {
 BookDto save(BookDto bookDto);
 BookDto delete(Long id);
 BookDto update(Long id,BookDto bookDto);
 List<BookDto> getAll();
 Page<BookDto> getPage(int pageNumber, int pageSize);
}
