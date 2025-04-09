import javax.crypto.*;
import java.security.*;
import java.util.Base64;
import java.util.Scanner;

public class EncryptionTool {
 static SecretKey aesKey;
 static SecretKey desKey;
 static KeyPair rsaKeyPair;

 public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);
  boolean running = true;

  while (running) {
   System.out.println("\nChoose an option:");
   System.out.println("1. Encrypt a message");
   System.out.println("2. Decrypt a message");
   System.out.println("3. Exit");
   System.out.print("Enter choice (1/2/3): ");
   int mainChoice = scanner.nextInt();
   scanner.nextLine();

   switch (mainChoice) {
    case 1:
     System.out.print("Enter text to encrypt: ");
     String inputText = scanner.nextLine();
     System.out.println("\nChoose Encryption Method:");
     System.out.println("1. AES");
     System.out.println("2. DES");
     System.out.println("3. RSA");
     System.out.print("Enter choice (1/2/3): ");
     int encChoice = scanner.nextInt();
     scanner.nextLine();
     try {
      switch (encChoice) {
       case 1:
        String aesEncrypted = encryptAES(inputText);
        System.out.println("Encrypted with AES: " + aesEncrypted);
        break;
       case 2:
        String desEncrypted = encryptDES(inputText);
        System.out.println("Encrypted with DES: " + desEncrypted);
        break;
       case 3:
        String rsaEncrypted = encryptRSA(inputText);
        System.out.println("Encrypted with RSA: " + rsaEncrypted);
        break;
       default:
        System.out.println("Invalid choice.");
      }
     } catch (Exception e) {
      e.printStackTrace();
     }
     break;

    case 2:
     System.out.print("Enter text to decrypt (Base64): ");
     String encryptedText = scanner.nextLine();
     System.out.println("\nChoose Decryption Method:");
     System.out.println("1. AES");
     System.out.println("2. DES");
     System.out.println("3. RSA");
     System.out.print("Enter choice (1/2/3): ");
     int decChoice = scanner.nextInt();
     scanner.nextLine();
     try {
      switch (decChoice) {
       case 1:
        if (aesKey == null) {
         System.out.println("No AES key available. Encrypt first.");
        } else {
         System.out.println("Decrypted with AES: " + decryptAES(encryptedText));
        }
        break;
       case 2:
        if (desKey == null) {
         System.out.println("No DES key available. Encrypt first.");
        } else {
         System.out.println("Decrypted with DES: " + decryptDES(encryptedText));
        }
        break;
       case 3:
        if (rsaKeyPair == null) {
         System.out.println("No RSA key available. Encrypt first.");
        } else {
         System.out.println("Decrypted with RSA: " + decryptRSA(encryptedText));
        }
        break;
       default:
        System.out.println("Invalid choice.");
      }
     } catch (Exception e) {
      e.printStackTrace();
     }
     break;

    case 3:
     running = false;
     break;

    default:
     System.out.println("Invalid option.");
   }
  }

  System.out.println("Thank you for using the Encryption Tool!");
  System.out.println("TARS");
 }

 public static String encryptAES(String text) throws Exception {
  KeyGenerator keyGen = KeyGenerator.getInstance("AES");
  keyGen.init(128);
  aesKey = keyGen.generateKey();

  Cipher cipher = Cipher.getInstance("AES");
  cipher.init(Cipher.ENCRYPT_MODE, aesKey);
  byte[] encrypted = cipher.doFinal(text.getBytes());

  return Base64.getEncoder().encodeToString(encrypted);
 }

 public static String decryptAES(String encryptedText) throws Exception {
  Cipher cipher = Cipher.getInstance("AES");
  cipher.init(Cipher.DECRYPT_MODE, aesKey);
  byte[] decoded = Base64.getDecoder().decode(encryptedText);
  byte[] decrypted = cipher.doFinal(decoded);
  return new String(decrypted);
 }

 public static String encryptDES(String text) throws Exception {
  KeyGenerator keyGen = KeyGenerator.getInstance("DES");
  keyGen.init(56);
  desKey = keyGen.generateKey();

  Cipher cipher = Cipher.getInstance("DES");
  cipher.init(Cipher.ENCRYPT_MODE, desKey);
  byte[] encrypted = cipher.doFinal(text.getBytes());

  return Base64.getEncoder().encodeToString(encrypted);
 }

 public static String decryptDES(String encryptedText) throws Exception {
  Cipher cipher = Cipher.getInstance("DES");
  cipher.init(Cipher.DECRYPT_MODE, desKey);
  byte[] decoded = Base64.getDecoder().decode(encryptedText);
  byte[] decrypted = cipher.doFinal(decoded);
  return new String(decrypted);
 }

 public static String encryptRSA(String text) throws Exception {
  KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
  keyGen.initialize(2048);
  rsaKeyPair = keyGen.generateKeyPair();
  PublicKey publicKey = rsaKeyPair.getPublic();

  Cipher cipher = Cipher.getInstance("RSA");
  cipher.init(Cipher.ENCRYPT_MODE, publicKey);
  byte[] encrypted = cipher.doFinal(text.getBytes());

  return Base64.getEncoder().encodeToString(encrypted);
 }

 public static String decryptRSA(String encryptedText) throws Exception {
  PrivateKey privateKey = rsaKeyPair.getPrivate();

  Cipher cipher = Cipher.getInstance("RSA");
  cipher.init(Cipher.DECRYPT_MODE, privateKey);
  byte[] decoded = Base64.getDecoder().decode(encryptedText);
  byte[] decrypted = cipher.doFinal(decoded);
  return new String(decrypted);
 }
}
