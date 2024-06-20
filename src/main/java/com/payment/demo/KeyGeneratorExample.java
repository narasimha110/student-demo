package com.payment.demo;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class KeyGeneratorExample {
	 public static void main(String[] args) {
	        try {
	            // Generate a secret key using AES algorithm
	            SecretKey secretKey = generateSecretKey();

	            // Convert the secret key to a Base64-encoded string for storage or distribution
	            String encodedKey = encodeSecretKey(secretKey);

	            System.out.println("Generated Secret Key: " + encodedKey);
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	    }

	    private static SecretKey generateSecretKey() throws NoSuchAlgorithmException {
	        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
	        keyGenerator.init(256); // Choose the key size, such as 128, 192, or 256 bits
	        return keyGenerator.generateKey();
	    }

	    private static String encodeSecretKey(SecretKey secretKey) {
	        byte[] encodedKey = secretKey.getEncoded();
	        return Base64.getEncoder().encodeToString(encodedKey);
	    }

}
