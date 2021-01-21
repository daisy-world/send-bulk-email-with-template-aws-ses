package com.easy2excel.sendbulkemailwithtemplateawsses.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

@Configuration
public class AWSSESConfig {
	
	 @Value("${aws.ses.accessKey}")
	 private String accessKeyId;
	 
	 @Value("${aws.ses.secretKey}")
	 private String secretAccessKey;
	 
	 @Value("${aws.ses.region}")
	 private String region;
	 
	 
	 @Bean
	    public AmazonSimpleEmailService getAmazonSESCient() {
		 
	 final BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);
	 	 
	 AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
             .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
             .withRegion(region)
             .build();

         return client;
		 
	 }

}
