package com.dayshare.utils.s3;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Service
public class S3ServicesImpl implements S3Services {
    private Logger logger = LoggerFactory.getLogger(S3Services.class);

    @Autowired
    private AmazonS3 s3Client;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Override
    public String uploadProfileImage(String keyName, String base64Image) {

        try {
            byte[] bI = org.apache.commons.codec.binary.Base64.decodeBase64((base64Image.substring(base64Image.indexOf(",")+1)).getBytes());

            InputStream fis = new ByteArrayInputStream(bI);

            ObjectMetadata metadata = new ObjectMetadata();
            AccessControlList acl = new AccessControlList();
            metadata.setContentLength(bI.length);
            metadata.setContentType("image/png");
            metadata.setContentEncoding("base64");
            metadata.setCacheControl("public");
            acl.grantPermission(GroupGrantee.AllUsers, Permission.Read);
            s3Client.putObject(new PutObjectRequest(bucketName, keyName, fis, metadata).withAccessControlList(acl));
            logger.info("====================== Upload File - Done! ======================");
            return "No Problems";
        } catch (AmazonServiceException ase) {
            logger.info("Caught an AmazonServiceException from PUT requests, rejected reasons:");
            logger.info("Error Message:    " + ase.getMessage());
            logger.info("HTTP Status Code: " + ase.getStatusCode());
            logger.info("AWS Error Code:   " + ase.getErrorCode());
            logger.info("Error Type:       " + ase.getErrorType());
            logger.info("Request ID:       " + ase.getRequestId());
            return ase.getMessage();
        } catch (AmazonClientException ace) {
            logger.info("Caught an AmazonClientException: ");
            logger.info("Error Message: " + ace.getMessage());
            return ace.getMessage();
        }
    }
}
