package com.manoj.cryptography;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class AESUtils {


    public static void main(String[] args) {
        String secretKey = "123456";
        String inputText = "Hello World";
        String encryptedToken = encryptToken(secretKey, "Hello World");
        String outputText = decryptToken(secretKey, encryptedToken);
        System.out.println(inputText.equals(outputText));
    }

    public static String encryptToken(final String secret, final String data) {
        //Security.addProvider(new BouncyCastleProvider());
        try {
            Cipher cipher = Cipher.getInstance("AES");
            SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(secret.getBytes(), 16), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, originalKey);
            byte[] cipherText = cipher.doFinal(data.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(cipherText);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error occured while encrypting data", e);
        }

    }

    public static String decryptToken(final String secret,
                                      final String encryptedString) {
        //Security.addProvider(new BouncyCastleProvider());

        try {
            Cipher cipher = Cipher.getInstance("AES");
            // rebuild key using SecretKeySpec
            SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(secret.getBytes(), 16), "AES");
            cipher.init(Cipher.DECRYPT_MODE, originalKey);
            byte[] cipherText = cipher.doFinal(Base64.getDecoder().decode(encryptedString));
            return new String(cipherText);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error occured while decrypting data", e);
        }
    }
}
