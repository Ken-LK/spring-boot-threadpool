package com.ken;

import com.ken.service.AsyncService;
import com.ken.service.impl.CompletableFutureImpl;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
@RestController
@Slf4j
public class SpringBootThreadpoolApplication {

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private CompletableFutureImpl completableFutureImpl;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootThreadpoolApplication.class, args);
    }

    @GetMapping("async")
    public void async(){

        PropertyMapper propertyMap = PropertyMapper.get().alwaysApplyingWhenNonNull();

        School school = new School();
        school.setName("11");
        school.setAddress("北京");
        Anther anther = new Anther();
        propertyMap.from(school.getName()).asInt(Integer::parseInt).to(anther::setTitle);
        propertyMap.from(school.getAddress()).to(anther::setAdd);

        log.info(anther.toString());




        asyncService.executeAsync();
    }

    @GetMapping("getPersons")
    public void getPersons() throws ExecutionException, InterruptedException, TimeoutException {

        completableFutureImpl.getPersons();
    }


    @Data
    static class School{
        String name;
        String address;
    }

    @Data
    @ToString
    static class Anther{
        int title;
        String add;
    }
}
