package com.reimbursement;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {
//	
//	@Value("${aws.accesskey}")
//	private String accessKey;
//
//	@Value("${aws.secretkey}")
//	private String secretkey;
//
//	@Value("${aws.region}")
//	private String region;
//    @Bean
//    public AmazonS3 s3() {
//        AWSCredentials awsCredentials =
//                new BasicAWSCredentials("AKIARQIXRINTW2FN4QVY", "4/bqpPigXuikX4AprLWADHqr/bjxq0TToNX+0Rrz");
//        return AmazonS3ClientBuilder
//                .standard()
//                .withRegion("us-east-1")
//                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
//                .build();

    }




//Access Key ID:
//AKIARQIXRINTW2FN4QVY
//Secret Access Key:
//4/bqpPigXuikX4AprLWADHqr/bjxq0TToNX+0Rrz