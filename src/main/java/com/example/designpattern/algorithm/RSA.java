package com.example.designpattern.algorithm;

import javax.crypto.Cipher;
import java.io.*;
import java.security.*;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class RSA {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyPair keyPair;
//        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        try{
            // create public and private key
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();


            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyPair.getPublic().getEncoded());
            String base64EncodedPublicKey = Base64.getEncoder().encodeToString(keySpec.getEncoded());

            PKCS8EncodedKeySpec keySpecPrivate = new PKCS8EncodedKeySpec(keyPair.getPrivate().getEncoded());
            String base64EncodedPrivateKey = Base64.getEncoder().encodeToString(keySpecPrivate.getEncoded());
            System.out.println(base64EncodedPublicKey);
            System.out.println(base64EncodedPrivateKey);


            System.out.println(generateRsaPublicKeyString(2048));
            System.out.println(generateRsaPrivateKeyString(2048));
            keyPair = keyRSAPair(2048);
            String encrypt = encrypt("hello",keyPair.getPublic());
            System.out.println("Encrypted : " + encrypt);
            System.out.println("Decrypted : " + decrypt(encrypt,keyPair.getPrivate()));

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateRsaPublicKeyString(int keySize) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyPair keyPair = keyRSAPair(keySize);
        PublicKey publicKey = keyPair.getPublic();
        byte[] encodedPublicKey = publicKey.getEncoded();

        // Convert the encoded key to Base64 string
        String base64EncodedPublicKey = Base64.getEncoder().encodeToString(encodedPublicKey);

        // Format the Base64 string with header and footer
        StringBuilder sb = new StringBuilder();
        sb.append("-----BEGIN PUBLIC KEY-----\n");
        sb.append(base64EncodedPublicKey);
        sb.append("\n-----END PUBLIC KEY-----\n");

        return sb.toString();
    }

    public static String generateRsaPrivateKeyString(int keySize) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyPair keyPair = keyRSAPair(keySize);
        PrivateKey privateKey = keyPair.getPrivate();
        byte[] encodedPrivateKey = privateKey.getEncoded();

        String base64EncodedPrivateKey = Base64.getEncoder().encodeToString(encodedPrivateKey);

        StringBuilder sb = new StringBuilder();
        sb.append("-----BEGIN PRIVATE KEY-----\n");
        sb.append(base64EncodedPrivateKey);
        sb.append("\n-----END PRIVATE KEY-----\n");
        return sb.toString();
    }

    public static KeyPair keyRSAPair(int keySize) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keySize);
        return keyPairGenerator.generateKeyPair();
    }

    public static String encrypt(String message, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey, new SecureRandom());
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedMessage, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        return new String(decryptedBytes);
    }

    public String getPublicKey() throws IOException {
        File publicKeyFile = new File("src/main/resources/public.key");
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(publicKeyFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("-----BEGIN PUBLIC KEY-----")) {
                    sb.append(line.substring(17)); // Skip the header
                } else if (line.startsWith("-----END PUBLIC KEY-----")) {
                    sb.append(line.substring(0, line.length() - 17)); // Skip the footer
                    break;
                } else {
                    sb.append(line);
                }
            }
        }
        return sb.toString();
    }
}
