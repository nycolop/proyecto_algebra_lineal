package encrypted;

import java.util.Arrays;

public class HillCipher {

  public static String encrypt(String message, int[][] key) {
    int dimensionDeClaveFilas = key.length;
    message = message.toUpperCase()
        .replaceAll("\\s+", "");

    int relleno = dimensionDeClaveFilas - (message.length() %  dimensionDeClaveFilas);
    if (relleno < dimensionDeClaveFilas) {
      char padChar = 'X';
      message += String.valueOf(padChar).repeat(relleno);
    }

    int[] messageVector = new int[message.length()];
    for (int i = 0; i < message.length(); i++) {
      messageVector[i] = message.charAt(i) - 'A';
    }

    StringBuilder encryptedMessage = new StringBuilder();
    for (int i = 0; i < messageVector.length; i += dimensionDeClaveFilas) {
      int[] blockVector = Arrays.copyOfRange(messageVector, i, i + dimensionDeClaveFilas);
      int[] encryptedBlock = multiplyMatrixVector(key, blockVector);
      for (int value : encryptedBlock) {
        encryptedMessage.append((char) (value + 'A'));
      }
    }

    return encryptedMessage.toString();
  }

  public static String decrypt(String encryptedMessage, int[][] key) {
    int dimensionDeClaveFilas = key.length;
    int[][] inverseKey = key; // Obtener la matriz inversa


    int[] encryptedVector = new int[encryptedMessage.length()];
    for (int i = 0; i < encryptedMessage.length(); i++) {
      encryptedVector[i] = encryptedMessage.charAt(i) - 'A';
    }

    StringBuilder decryptedMessage = new StringBuilder();
    for (int i = 0; i < encryptedVector.length; i += dimensionDeClaveFilas) {
      int[] blockVector = Arrays.copyOfRange(encryptedVector, i, i + dimensionDeClaveFilas);
      int[] decryptedBlock = multiplyMatrixVector(inverseKey, blockVector);
      for (int value : decryptedBlock) {
        decryptedMessage.append((char) (value + 'A'));
      }
    }

    return decryptedMessage.toString().toLowerCase();
  }


  public static int[] multiplyMatrixVector(int[][] matrix, int[] vector) {
    int[] result = new int[vector.length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < vector.length; j++) {
        result[i] += matrix[i][j] * vector[j];
      }
      result[i] %= 26;
    }
    return result;
  }

  public static int[][] invertMatrix(int[][] matrix) {
      //deberia usar un algoritmo para calcular la inversa, voy a verlo mañana 
    return new int[matrix.length][matrix.length];
  }


}
