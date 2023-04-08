package com.deng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserBorrowDetail {
    //返回的借阅信息
    User user;//这里出现问题  返回信息中要有User Book的信息，但是这样是不可能的，因为应用都都不一样
    List<Book> bookList; //所以这里要把实体类单独提出来在一个公用的定义中
}
