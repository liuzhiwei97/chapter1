package cn.zhiwei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Created by Administrator on 2018/4/6.
 */
@Service//加上这个表示被spring容器管理了
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    //该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法，
    // 熔断方法直接返回了一个字符串，字符串为”hi,”+name+”,sorry,error!”，
    //@HystrixCommand
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }
}
