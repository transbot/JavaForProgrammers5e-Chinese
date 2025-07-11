// 图11.11: CryptographyDemo.java
// 使用AES加密和解密消息，并
// 使用RSA来加密和解密AES密钥
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;

public class CryptographyDemo {
   public static void main(String[] args) {
      var scanner = new Scanner(System.in);

      System.out.println("请输入要加密的文本:");
      String plaintext = scanner.nextLine();

      System.out.println(
         "\n请输入密钥种子(用于重现):");
      String seedString = scanner.nextLine();

      try { // 加密/解密可能抛出异常
         // 从seedString生成可重现的AES密钥
         SecretKey secretKey = generateKey(seedString);
         System.out.printf("%n生成的密钥:%n%s%n", 
            Base64.getEncoder().encodeToString(secretKey.getEncoded()));

         // AES加密明文
         String ciphertext = encrypt(plaintext, secretKey);
         System.out.printf("%n加密后的结果:%n%s%n", ciphertext);

         // 生成RSA密钥对——通常由消息接收方完成
         var keyPairGenerator = KeyPairGenerator.getInstance("RSA");
         keyPairGenerator.initialize(2048); // 设置密钥大小为2048位
         KeyPair rsaKeyPair = keyPairGenerator.generateKeyPair();

         // 获取RSA公钥和私钥——接收方将公钥
         // 发送给需要安全通信的任何人
         PublicKey publicKey = rsaKeyPair.getPublic();
         PrivateKey privateKey = rsaKeyPair.getPrivate();

         // 使用RSA公钥加密AES密钥；
         // 此密钥将与加密消息一起发送给接收方
         String encryptedAESKey = 
            encryptRSA(secretKey.getEncoded(), publicKey);
         System.out.printf(
            "%nRSA加密的AES密钥:%n%s%n", encryptedAESKey);

         // 接收方使用RSA私钥解密AES密钥
         SecretKey decryptedSecretKey = 
            decryptRSA(encryptedAESKey, privateKey);
         System.out.printf("%n解密后的AES密钥:%n%s%n", 
            Base64.getEncoder().encodeToString(
               decryptedSecretKey.getEncoded()));

         // AES解密文本
         System.out.printf("%n解密后的结果:%n%s%n", 
            decrypt(ciphertext, decryptedSecretKey));
      }
      catch (Exception ex) { 
         System.out.printf("""
            加密/解密过程中发生异常:
            %s%n
            """, ex);
      }
   }

   // 生成并返回SecretKey。注意：这里考虑到可重现性，
   // 为SecureRandom设置了固定的种子，以便解密本章的加密文本。
   // 在生产代码中，绝对不要这样做！
   public static SecretKey generateKey(String seed) throws Exception {
      // 获取安全的随机数生成器
      var random = SecureRandom.getInstance("SHA1PRNG");
      random.setSeed(seed.getBytes()); // 为了演示可重现性

      // 获取AES密钥生成器
      var keyGen = KeyGenerator.getInstance("AES");
      keyGen.init(256, random); // 设置为256位密钥
      return keyGen.generateKey(); // 生成并返回新的SecretKey
   }

   // 使用AES加密字符串
   public static String encrypt(
      String plaintext, SecretKey secretKey) throws Exception {

      var cipher = Cipher.getInstance("AES"); // 获取Cipher对象
      cipher.init(Cipher.ENCRYPT_MODE, secretKey); // 配置为加密模式

      // 加密明文的字节数组表示
      byte[] encrypted = cipher.doFinal(plaintext.getBytes());

      // 将加密结果Base64编码为密文字符串并返回 
      return Base64.getEncoder().encodeToString(encrypted);
   }

   // 解密AES加密的字符串
   public static String decrypt(
      String ciphertext, SecretKey secretKey) throws Exception {

      var cipher = Cipher.getInstance("AES"); // 获取Cipher对象
      cipher.init(Cipher.DECRYPT_MODE, secretKey); // 配置为解密模式

      // 将密文Base64解码为字节数组  
      byte[] ciphertextBytes = Base64.getDecoder().decode(ciphertext);

      // 从密文字节数组创建明文字符串并返回
      return new String(cipher.doFinal(ciphertextBytes));
   }
  
   // 使用RSA公钥加密数据——此方法的结果
   // 将发送给AES加密消息的接收方
   public static String encryptRSA(byte[] data, PublicKey publicKey) 
      throws Exception {

      var cipher = Cipher.getInstance("RSA"); // 创建RSA Cipher对象
      
      // 使用接收方的公钥初始化加密模式
      cipher.init(Cipher.ENCRYPT_MODE, publicKey);
      
      // 使用RSA公钥加密数据(AES密钥)
      byte[] encryptedData = cipher.doFinal(data);
      
      // 将加密的AES密钥进行Base64编码 
      return Base64.getEncoder().encodeToString(encryptedData);
   }

   // 使用RSA私钥解密数据并返回SecretKey
   public static SecretKey decryptRSA(
      String encryptedData, PrivateKey privateKey) throws Exception {

      var cipher = Cipher.getInstance("RSA"); // 创建RSA Cipher对象
      
      // 使用接收方的私钥初始化解密模式
      cipher.init(Cipher.DECRYPT_MODE, privateKey);
      
      // 从Base64格式解码加密的AES密钥并进行解密
      byte[] decryptedData = 
         cipher.doFinal(Base64.getDecoder().decode(encryptedData));
      
      // 将解密的字节数组转换回AES SecretKey对象 
      return new SecretKeySpec(
         decryptedData, 0, decryptedData.length, "AES");
   }
}

/*
 **************************************************************************
 * (C) Copyright 1992-2025 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 **************************************************************************
*/
