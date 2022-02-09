package com.ken.pojo;

import lombok.*;

/**
 * @author Ken
 * @date 2022-01-24 11:52
 * @since v1.0
 */
@Data
@Builder
public class Person {

    private String name;

    private Integer age;
//
//    public Person() {
//        System.out.println("Person 实例化: " + this);
//    }


}
