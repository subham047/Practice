package com.subham.Practice.Utilities;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EncryptDecryptData {
    public static void main(String[] args) throws IOException {
//        readWriteTextFiles();


        String stringValue = "10243.41";

        // Convert string to double
        double doubleValue = Double.parseDouble(stringValue);

        // Round the double value
        long longValue = Math.round(doubleValue);

        System.out.println("Converted long value: " + longValue);
    }

    public static void readWriteTextFiles() throws IOException {

        String file = "/home/subham.s@reward360.local/Downloads/mobileNumbers.txt";
        FileWriter myWriter = new FileWriter("/home/subham.s@reward360.local/Downloads/DecryptedMobile.txt");

        String str = new String(
                Files.readAllBytes(Paths.get(file)));
        String[] spl = str.split("\n");
        for (String a : spl) {
            String num = decrypt(a);
            System.out.println("Encrypted string = " + a + " Decrypted String = " + decrypt(num));
            myWriter.write(num);
            myWriter.write(System.getProperty("line.separator"));
        }
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
    }

    public static String decrypt(String encrypted) {
        System.out.println("decrypt");
        String encryptionstatus = "0";
//        String key = "EDZY7346YK5P9Z28"; // 128 bit key - Prod key
        String key = "Bar12345Bar12345"; // 128 bit key - UAT key
        String initVector = ""; // 16 bytes IV
        try {
            encryptionstatus = "1";
//            key=System.getProperty("ENCRYPTION_KEY");
            initVector = "RandomInitVector";

        } catch (Exception e) {
            return encrypted;
        }
        if (encryptionstatus != null && encryptionstatus.length() > 0) {
            if (encryptionstatus.equals("1")) {
                if (encrypted != null) {
                    try {
                        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
                        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

                        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

                        try {
                            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
                            return new String(original);
                        } catch (Exception e) {
                            return new String(encrypted);
                        }
                    } catch (Exception ex) {
                    }
                }
            }
        }

        return encrypted;
    }

    public static String encrypt(String value) {
        if (value != null && value.length() > 0) {
            //String key = "Bar12345Bar12345"; // 128 bit key
            String key = System.getProperty("ENCRYPTION_KEY");

            String initVector = "RandomInitVector"; // 16 bytes IV
            try {
                IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
                SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

                byte[] encrypted = cipher.doFinal(value.getBytes());

                return Base64.encodeBase64String(encrypted);
            } catch (Exception ex) {
                return value;
            }
        }

        return value;
    }
}
