import static encrypted.HillCipher.decrypt;
import static encrypted.HillCipher.encrypt;
import static encrypted.MatrizEncripted.encriptacion;

import encrypted.MatrizEncripted;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    String inputMessage = "holaeduardo";


    String mensajeEncriptado = encriptacion(inputMessage);
    System.out.println("Mensaje encriptado: " + mensajeEncriptado);


  }
};