package encrypted;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MatrizEncripted {

  private static final HashMap<Character, Integer> abc = new HashMap<>();
  private static final int[][] kays = new int[][]{
      {1, 2, 3},
      {0, 1, 4},
      {5, 6, 0}
  };

  static {
    fillHashMap();
  }

  private static void fillHashMap() {
    for (int i = 0; i < 26; i++) {
      abc.put((char) (i + 'a'), i + 1);
    }
    abc.put('_', 27);
  }

  public static void showMatriz(int[][] matriz) {
    for (int i = 0; i < matriz.length; i++) {
      for (int j = 0; j < matriz[i].length; j++) {
        System.out.print(matriz[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static String[][] toMatriz(String message) {
    List<String[]> groups = new ArrayList<>();
    int length = message.length();

    for (int i = 0; i < length; i += 3) {
      String[] triplet = new String[3];
      for (int j = 0; j < 3; j++) {
        if (i + j < length) {
          triplet[j] = String.valueOf(message.charAt(i + j));
        } else {
          triplet[j] = "_";
        }
      }
      groups.add(triplet);
    }

    return groups.toArray(new String[groups.size()][]);
  }

  public static int[][] matrizNumerica(String[][] matrizDeMessage) {
    int[][] matrizNumerica = new int[matrizDeMessage.length][3];
    for (int i = 0; i < matrizDeMessage.length; i++) {
      for (int j = 0; j < matrizDeMessage[i].length; j++) {
        matrizNumerica[i][j] = abc.get(matrizDeMessage[i][j].charAt(0));
      }
    }
    return matrizNumerica;
  }

  public static int[][] multiplicarMatrices(int[][] matrizA, int[][] matrizB) {
    int[][] resultado = new int[matrizA.length][matrizB[0].length];
    for (int i = 0; i < matrizA.length; i++) {
      for (int j = 0; j < matrizB[0].length; j++) {
        for (int k = 0; k < matrizB.length; k++) {
          resultado[i][j] += matrizA[i][k] * matrizB[k][j];
        }
        resultado[i][j] = resultado[i][j] % 27;
      }
    }
    return resultado;
  }

  public static String encriptacion(String mensaje) {
    String[][] vector = toMatriz(mensaje);
    int[][] matrizNumerica = matrizNumerica(vector);
    int[][] matrizEncriptada = multiplicarMatrices(matrizNumerica, kays);
    StringBuilder mensajeEncriptado = new StringBuilder();

    for (int[] fila : matrizEncriptada) {
      for (int valor : fila) {
        for (char letra : abc.keySet()) {
          if (abc.get(letra) == valor) {
            mensajeEncriptado.append(letra);
            break;
          }
        }
      }
    }

    return mensajeEncriptado.toString();
  }

}
