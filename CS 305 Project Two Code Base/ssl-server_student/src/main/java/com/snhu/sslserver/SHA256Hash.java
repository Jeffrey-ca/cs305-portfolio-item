package com.snhu.sslserver;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Hash {
    public static String hash(String data) {
        try {
            // Create a SHA-256 message digest object
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Convert the data string to bytes
            byte[] dataBytes = data.getBytes();

            // Calculate the hash value
            byte[] hashBytes = digest.digest(dataBytes);

            // Convert the hash value to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // This should never happen, since SHA-256 is a built-in algorithm
            throw new RuntimeException(e);
        }
    }
}
