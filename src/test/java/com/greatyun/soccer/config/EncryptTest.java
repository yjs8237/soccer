package com.greatyun.soccer.config;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.Size;

@SpringBootTest
@Slf4j
public class EncryptTest {

    @Test
    public void encryptTest() {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        standardPBEStringEncryptor.setAlgorithm("PBEWithMD5AndDES");
        standardPBEStringEncryptor.setPassword("greatyun");

        String enc = standardPBEStringEncryptor.encrypt("root");
        log.info("root : " + enc);

        String password = standardPBEStringEncryptor.encrypt("Jsyun0415!");
        log.info("password : " + password);
    }
}
