package com.deng.service.impl;

import com.deng.entity.Book;
import com.deng.entity.Borrow;
import com.deng.entity.User;
import com.deng.entity.UserBorrowDetail;
import com.deng.mapper.BorrowMapper;
import com.deng.service.BorrowService;
import com.deng.service.client.BookClient;
import com.deng.service.client.UserClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService{

    @Resource
    BorrowMapper mapper;

//    @Resource
//    RestTemplate template;
    @Resource
    BookClient bookClient;

    @Resource
    UserClient userClient;

    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        System.out.println("执行正常方法");
        List<Borrow> borrow = mapper.getBorrowsByUid(uid);
        //那么问题来了，现在拿到借阅关联信息了，怎么调用其他服务获取信息呢？
        //RestTemplate支持多种方式的远程调用
//        RestTemplate template = new RestTemplate();
        //这里通过调用getForObject来请求其他服务，并将结果自动进行封装
        //获取User信息
        //修改前
//        User user = template.getForObject("http://localhost:8701/user/"+uid, User.class);
        User user = userClient.findUserById(uid);
        //获取每一本书的详细信息
        List<Book> bookList = borrow
                .stream()
                .map(b -> bookClient.findBookById(b.getBid()))
                //由于书有多个所以用map去转换
                .collect(Collectors.toList());
        return new UserBorrowDetail(user, bookList);
    }
}
