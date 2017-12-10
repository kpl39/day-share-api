package com.dayshare.utils.email;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SesConfiguration {
    @Value("${aws.ses.iam_username}")
    private String iamUsername;

    @Value("${aws.ses.smtp_username}")
    private String smtpUsername;

    @Value("${aws.access_key_id}")
    private String accessId;

    @Value("${aws.secret_access_key}")
    private String secretKey;

    @Value("${aws.ses.password}")
    private String password;

    @Value("${aws.ses.region}")
    private String region;

    @Bean
    public AmazonSimpleEmailService sesClient() {
        AWSCredentialsProvider provider;
        AWSCredentials awsCreds = new BasicAWSCredentials(accessId, secretKey);
        provider = new AWSStaticCredentialsProvider(awsCreds);


        AmazonSimpleEmailService sesClient = AmazonSimpleEmailServiceClientBuilder.standard()
                .withRegion(region)
                .withCredentials(provider)
                .build();

        return sesClient;
    }

}
