package com.ken.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author Ken
 * @date 2022-01-24 11:54
 * @since v1.0
 */
@Data
public class School {


    private String schoolName;


    private Person person;


    public School(Person person){

        this.person = person;
        System.out.println("School 实例化: " + this.person);
    }
}
