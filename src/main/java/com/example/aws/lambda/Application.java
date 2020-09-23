package com.example.aws.lambda;


import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.example.aws.lambda.bean.Student;
import com.example.aws.lambda.bean.Request;
import com.example.aws.lambda.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Application implements RequestHandler<Request, Object> {

    private final Logger logger = LoggerFactory.getLogger(Application.class);

    public Object handleRequest(Request inputRequest, Context context) throws ResourceNotFoundException {
        AmazonDynamoDB client = AmazonDynamoDBAsyncClientBuilder.defaultClient();
        DynamoDBMapper mapper = new DynamoDBMapper(client);
        Student student = null;
        if ("GET".equals(inputRequest.getHttpMethod())) {
            logger.info("!!!! Coming into the GET HTTP method call from API gateway !!!");
            student = mapper.load(Student.class, inputRequest.getId());
            if (null == student) {
                throw new ResourceNotFoundException("Resource not found with resource Id : " + inputRequest.getId());
            }
            logger.info("!!!! Coming into the POST HTTP method call from API gateway !!!");
        } else if ("POST".equals(inputRequest.getHttpMethod())) {
            logger.info("!!!! Coming into the POST HTTP method call from API gateway !!!");
            mapper.save(inputRequest.getStudent());
        }
        return student;
    }
}
