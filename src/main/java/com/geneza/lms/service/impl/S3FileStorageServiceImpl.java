package com.geneza.lms.service.impl;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.geneza.lms.service.FileStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Service
public class S3FileStorageServiceImpl implements FileStorageService {

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    private AmazonS3 s3Client;

    public S3FileStorageServiceImpl() {
        // Will be initialized manually in uploadFile()
    }

    @Override
    public String uploadFile(MultipartFile multipartFile) throws Exception {
        initClient();

        String fileName = UUID.randomUUID() + "_" + multipartFile.getOriginalFilename();
        File file = convertMultiPartToFile(multipartFile);

        s3Client.putObject(new PutObjectRequest(bucketName, fileName, file));

        file.delete(); // Clean up local temp file

        return "https://" + bucketName + ".s3." + region + ".amazonaws.com/" + fileName;
    }

    private void initClient() {
        if (s3Client == null) {
            BasicAWSCredentials creds = new BasicAWSCredentials(accessKey, secretKey);
            s3Client = AmazonS3ClientBuilder.standard()
                    .withRegion(region)
                    .withCredentials(new AWSStaticCredentialsProvider(creds))
                    .build();
        }
    }

    private File convertMultiPartToFile(MultipartFile file) throws Exception {
        File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
