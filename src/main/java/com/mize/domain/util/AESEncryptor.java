package com.mize.domain.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class AESEncryptor {
    //shared secret test
    static byte[] keyBytes = new byte[] { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07,
                                        0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f};
    static String sPadding = "ISO10126Padding";
    
    public static String encryptedKey(String key) {
    	try {
			return encrypt(keyBytes, sPadding, key.getBytes()) ;
		} catch (Exception e) {
		}
    	return null;
    }
    
    public static String decryptedKey(String key) {
    	try {
			return decrypt(keyBytes, sPadding, key) ;
		} catch (Exception e) {
		}
    	 return null;   	
    }
    
    public static String decrypt(byte[] keyBytes, String sPadding, String data) throws Exception {
        Cipher cipher = getAESECBDecryptor(keyBytes, sPadding); 
        return decrypt(cipher, data);
    }
    
    public static String encrypt(byte[] keyBytes, String sPadding, byte[] messageBytes) throws Exception {
        Cipher cipher = getAESECBEncryptor(keyBytes, sPadding); 
        return encrypt(cipher, messageBytes);
    }
    
    public static Cipher getAESECBEncryptor(byte[] keyBytes, String padding) throws Exception{
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher;
    }
    
    public static Cipher getAESECBDecryptor(byte[] keyBytes, String padding) throws Exception{
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher;
    }
    
    public static String encrypt(Cipher cipher, byte[] dataBytes) throws Exception{

    	byte[] encVal = cipher.doFinal(dataBytes);
    	String encryptedValue = new BASE64Encoder().encode(encVal);
    	return encryptedValue;
    }

    public static String decrypt(Cipher cipher, String data) throws Exception{
    	byte[] decordedValue = new BASE64Decoder().decodeBuffer(data);
    	byte[] decValue = cipher.doFinal(decordedValue);
    	String decryptedValue = new String(decValue);
    	return decryptedValue;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String original = "qwer1234$";
		System.out.println("Original " + original);
		String encrypted =  AESEncryptor.encryptedKey(original);
		System.out.println("encrypted  " + encrypted);
		String original1 =  AESEncryptor.decryptedKey(encrypted);
		System.out.println("Decrypted " + original1);
		
	}

}
