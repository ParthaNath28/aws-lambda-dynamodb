package com.example.aws.lambda.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Request {
    private Student student;
    private String httpMethod;
    private int id;
}
