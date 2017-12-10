package com.dayshare.utils;

import com.amazonaws.auth.BasicAWSCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

public class AwsCreds {
    @Value("${aws.access_key_id}")
    private String awsId;

    @Value("${aws.secret_access_key}")
    private String awsKey;

    @Value("${aws.region}")
    private String region;

    public AwsCreds(BasicAWSCredentials awsCreds) {
        this.awsCreds = awsCreds;
    }

    private BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsId, awsKey);

    public BasicAWSCredentials getAwsCreds() {
        return awsCreds;
    }

    public void setAwsCreds(BasicAWSCredentials awsCreds) {
        this.awsCreds = awsCreds;
    }
}
