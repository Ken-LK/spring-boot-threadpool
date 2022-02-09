package com.ken.config;

import com.ken.pojo.Person;
import com.ken.pojo.School;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author Ken
 * @date 2022-01-24 11:51
 * @since v1.0
 */
@Configuration
public class TestConfiguration {


    @Bean
    public School school() {
        return new School(person());
    }

    @Bean
    public Person person() {
        return Person.builder().build();
    }


}
