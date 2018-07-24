package com.test.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.itextpdf.text.pdf.codec.Base64;

public class EncryptionDecryptionService {

	static byte[] expBytes = Base64.decode("AQAB");
	static byte[] modBytes = Base64.decode("pIvqQsmHqz7LCb/fEM3bevrgwic/2PSjjjf54yw8CkgUUgpJwXrl6+Gf4Tvv3yDHdFYqnB08p4lBNUZIF8zCnIhmeZfArFAaDE96OZrMYiL5CPJDSXScxjbb1JJVeP7jYyznBxzTFiotUaak0Hn5xuWRcmXKaMegwv7xRxEwxSc=");
	static byte[] dBytes = Base64.decode("b0IvttL/ifmeXcw/ruQSiHgD6yOQ10irImmU7FcnjagpHUPZlRpdRn47lZbqXUuTsYTlsMNQFNQIpFYOPxFzcD86EcpSB1hT3PA3NWrA6SvcXciAjdXNKT/5uk7n4ijpx0yf2cDdwzEjsycklRHbrXD9JyVjbCXY6Wt641HsRYE=");
	static BigInteger modules = new BigInteger(1, modBytes);
	static BigInteger exponent = new BigInteger(1, expBytes);
	static BigInteger d = new BigInteger(1, dBytes);
	

	public  static String encrpt(String plainText) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException
	{
		if(plainText==null)
		{
			plainText="";
		}
		KeyFactory factory = KeyFactory.getInstance("RSA");
		Cipher cipher = Cipher.getInstance("RSA");
		RSAPublicKeySpec pubSpec = new RSAPublicKeySpec(modules, exponent);
		PublicKey pubKey = factory.generatePublic(pubSpec);
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		byte[] encrypted = cipher.doFinal(plainText.getBytes("UTF-8"));
		//System.out.println("encrypted: "+ConvertByteArrayToHexString(encrypted));
		return ConvertByteArrayToHexString(encrypted); 
	}

	public static String decrypt(String encrypted) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException
	{
		byte[] byteencrptedarray=hexStringToByteArray(encrypted.toCharArray());
		KeyFactory factory = KeyFactory.getInstance("RSA");
		Cipher cipher = Cipher.getInstance("RSA");
		RSAPrivateKeySpec privSpec = new RSAPrivateKeySpec(modules, d);
		PrivateKey privKey = factory.generatePrivate(privSpec);
		cipher.init(Cipher.DECRYPT_MODE, privKey);
		byteencrptedarray = cipher.doFinal(byteencrptedarray);
		String decrptedText=new String(byteencrptedarray,"UTF-8");
		//System.out.println("Decrypted: "+decrptedText);
		return  decrptedText;
	}

	public static  String ConvertByteArrayToHexString(byte[] tempArray)
	{
		
		int v=0;

		StringBuffer sb = new StringBuffer(tempArray.length * 2);

		for (int i = 0; i < tempArray.length; i++)
		{
			v = tempArray[i] & 0xff;

			if (v < 16) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));

		}
		String temp=sb.toString();

		return temp;
	}
	public static  byte[] hexStringToByteArray(char[] data)
	{
		 byte[] out =null;
		try
		{
		  int len = data.length;

	        if ((len & 0x01) != 0) {
	            throw new Exception("Odd number of characters.");
	        }

	        out = new byte[len >> 1];

	        // two characters form the hex value.
	        for (int i = 0, j = 0; j < len; i++) {
	            int f = toDigit(data[j], j) << 4;
	            j++;
	            f = f | toDigit(data[j], j);
	            j++;
	            out[i] = (byte) (f & 0xFF);
	        }
		}
		catch(Exception ex)
		{ex.printStackTrace();}

	        return out;
	}
	protected static int toDigit(char ch, int index) 
	{
		 int digit=0;
		try
		{
		           digit = Character.digit(ch, 16);
		           if (digit == -1) {
		                throw new Exception("Illegal hexadecimal charcter " + ch + " at index " + index);
		          }
		}
		catch(Exception ex)
		{ex.printStackTrace();}
		return digit;
	 }

  public static void main(String args[]) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
	  EncryptionDecryptionService ed = new EncryptionDecryptionService();
	  System.out.println("Encrypt Text :: java :: "+ed.encrpt("123456789"));
	  System.out.println("Decrypt :: "+ed.decrypt("2dc9df9dcb6148e7648b705d4d39acf271c965781c17dd205f614320108a560ad7f926e29d9aeb013b34d3d63abe69be5f15e63a04e5607ca28869811e41c5a1a2a025a5e1eaabdca1087f8af6a5795745ed52f1dc31c0ecc2f9a803b939c770b987a95eb6374e026aa66c472a27fb6fc80faf8ec84c72dd17943e9b6fd9be97"));
	  
	  
  }

}
