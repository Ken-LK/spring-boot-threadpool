package com.ken.service.impl;

import com.ken.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Ken
 * @date 2022-02-07 15:10
 * @since v1.0
 */
@Service
public class CompletableFutureImpl {


    @Autowired
    Executor asyncServiceExecutor;


    public List<Person> getPersons() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<List<Person>> future = CompletableFuture.supplyAsync(() -> {

            List<Person> persons = new ArrayList<>();
            Person person1 = Person.builder().name("张三").age(11).build();
            Person person2 = Person.builder().name("李四").age(12).build();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            persons.add(person1);
            persons.add(person2);

            System.out.println("---添加用户结束----");
            return persons;
        }, asyncServiceExecutor);

        System.out.println(">>>>>"+future.isDone());
        List<Person> people = future.get();
        System.out.println("===线程结束===");

        return people;


    }

}
