
import static encrypted.MatrizEncripted.desencriptar;
import static encrypted.MatrizEncripted.encriptacion;

public class Main {

  public static void main(String[] args) {

    String inputMessage = "pileta";
    System.out.println("El mensaje es:" + inputMessage);

    String mensajeEncriptado = encriptacion(inputMessage);
    System.out.println("Mensaje encriptado: " + mensajeEncriptado);

    String mensajeDesencriptado = desencriptar(mensajeEncriptado);
    System.out.println("Mensaje desencriptado: " + mensajeDesencriptado);



  }
};