package com.deng.service.client;

import com.deng.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookFallbackClient implements  BookClient{
    @Override
    public Book findBookById(int bid) {
        return new Book();
    }
}
