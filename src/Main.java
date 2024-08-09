import static encrypted.HillCipher.decrypt;
import static encrypted.HillCipher.encrypt;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    int[][] key = {
        {6, 24, 1},
        {13, 16, 10},
        {20, 17, 15}
    };


    //tengo que calcular bien la inversa,esta no funciona, la saque re mal xD
    int[][] keyDesencript = {{18,5,25},{21,18,10},{16,5,14}};

    System.out.println(key.length);
    String message = "Hola amiguitos como va";

    String encryptedMessage = encrypt(message, key);
    System.out.println("Texto cifrado: " + encryptedMessage);
    String keyTodes = "ZJXMQYEKQYCROQGNSNDAI";

    String descryp = decrypt(keyTodes,keyDesencript);
    System.out.println("Texto descifrado: "+ descryp);

  }

}