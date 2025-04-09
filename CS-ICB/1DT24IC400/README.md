# 🔐 Java Encryption & Decryption Tool

This Java-based command-line tool allows users to encrypt and decrypt messages using three popular cryptographic algorithms: **AES**, **DES**, and **RSA**. It's a simple and interactive program useful for learning the basics of encryption techniques in Java.

## 🧠 Features

- ✅ Encrypt messages using AES, DES, or RSA
- ✅ Decrypt messages (Base64 encoded) using corresponding keys
- ✅ Interactive CLI menu for user-friendly experience
- 🔑 Temporarily stores keys in memory for decryption (session-based)

## 🛠 Technologies Used

- Java SE
- Java Cryptography Architecture (JCA)
- `javax.crypto`, `java.security`, `Base64`

## 📦 How to Run

1. **Clone this repo**
   ```bash
   git clone https://github.com/your-username/encryption-tool-java.git
   cd encryption-tool-java
   ```
2. **Compile the program**
   ```bash
   javac EncryptionTool.java
   ```
3. **Run the program**
   ```bash
   java EncryptionTool
   ```

## 📋 Example Usage
```bash
Choose an option:
1. Encrypt a message
2. Decrypt a message
3. Exit
Enter choice (1/2/3): 1

Enter text to encrypt: Hello World

Choose Encryption Method:
1. AES
2. DES
3. RSA
Enter choice (1/2/3): 1
Encrypted with AES: QW34lR93h4b...
```
