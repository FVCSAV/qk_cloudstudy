package com.deng.service.impl;

import com.deng.entity.Book;
import com.deng.mapper.BookMapper;
import com.deng.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper mapper;
    @Override
    public Book getBookById(int bid) {
        return mapper.getBookById(bid);
    }
}
