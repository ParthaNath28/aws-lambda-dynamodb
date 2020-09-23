package com.example.aws.lambda.bean;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@DynamoDBTable(tableName = "T_Student_Details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @DynamoDBHashKey
    private int id;
    @DynamoDBAttribute
    private String name;
}
