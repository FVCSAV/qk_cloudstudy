package com.deng.controller;

import com.deng.entity.UserBorrowDetail;
import com.deng.service.BorrowService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

@RestController
public class UserBorrowController {

    @Resource
    BorrowService service;

//    @HystrixCommand(fallbackMethod = "onError")    //使用@HystrixCommand来指定备选方案
    @RequestMapping("/borrow/{uid}")
    UserBorrowDetail findUserBorrows(@PathVariable("uid") int uid){
        return service.getUserBorrowDetailByUid(uid);
    }

    //备选方案，这里直接返回空列表了
    //注意参数和返回值要和上面的一致
//    UserBorrowDetail onError(int uid){
//        System.out.println("执行补救措施");
//        return new UserBorrowDetail(null, Collections.emptyList());
//    }
}
