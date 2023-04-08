package com.deng.service.client;

import com.deng.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//声明为userservice服务的HTTP请求客户端   填写的就是服务名称  也就是对应以前的template
@FeignClient(value = "userservice", fallback = UserFallbackClient.class)
public interface UserClient {
    //这里面的内容  在请求处是请求uid 也就是在user-service中把他的controller方法丢过来
    //感觉就是代替了了template与负载均衡的管控
    @RequestMapping("/user/{uid}")
    User findUserById(@PathVariable("uid") int uid);//这是接口不要写实现

}
