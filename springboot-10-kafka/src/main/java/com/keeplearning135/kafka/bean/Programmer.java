package com.keeplearning135.kafka.bean;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Programmer implements Serializable {

    private String name;

    private int age;

    private float salary;

    private Date birthday;
}

