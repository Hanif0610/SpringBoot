package com.spring.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;

//비밀번호를 데이터베이스에서 그대로 보여지는 것이 아닌, SHA코드로 바꿔서 넣는 것
@Service
public class UserPasswordHashClass {
    public String getSHA256(String plainText) {
        String shaString = "";
        try {
            MessageDigest sh = MessageDigest.getInstance("SHA-256");
            sh.update(plainText.getBytes());
            byte byteData[] = sh.digest();
            StringBuffer stringBuffer = new StringBuffer();
            int byteSize = byteData.length;
            for(int i = 0; i < byteSize; i++) {
                stringBuffer.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            shaString = stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            shaString = null;
        }
        return shaString;
    }
}
