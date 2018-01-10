package com.example.demo.java8.predicate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Created by chunmei on 1/10/2018.
 */
//来自于lombok
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

    private Integer id;
    private Integer age;
    private String gender;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return this.id.toString()+" - "+this.age.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
