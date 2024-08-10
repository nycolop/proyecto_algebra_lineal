
import static encrypted.MatrizEncripted.desencriptar;
import static encrypted.MatrizEncripted.encriptacion;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Interfaz extends JFrame {

  public Interfaz() {
    setTitle("Proyecto algebra linear - Encriptar/Desencriptar");
    setSize(520, 550);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    add(panel);
    colocarComponentes(panel);
  }

  private void colocarComponentes(JPanel panel) {
    panel.setLayout(null);

    JLabel titulo = new JLabel("Proyecto Algebra lineal");
    JLabel subtitulo = new JLabel("Cifrado Hill con matrices");
    JTextArea creditos = new JTextArea("Hecho por: \nNicolas \nLuciano \nCarla \nMicaela");
    titulo.setBounds(100, 20, 300, 100);
    subtitulo.setBounds(100, 40, 300, 100);
    creditos.setBounds(100, 350, 200, 200);

    creditos.setBackground(new Color(238, 238, 238));
    titulo.setFont(new Font("Arial", Font.BOLD, 24));
    subtitulo.setFont(new Font("Arial", Font.BOLD, 24));
    creditos.setEditable(false);

    panel.add(titulo);
    panel.add(subtitulo);
    panel.add(creditos);



    JLabel label = new JLabel("Ingrese un texto:");
    label.setBounds(100, 75 + 50, 300, 25);
    panel.add(label);

    JTextField textoInput = new JTextField();
    textoInput.setBounds(100, 100 + 50, 300, 25);
    panel.add(textoInput);

    JLabel textoOutputPrefix = new JLabel("Salida: ");
    textoOutputPrefix.setBounds(100 , 100 + 50, 100, 100);
    textoOutputPrefix.setFont(new Font("Arial", Font.BOLD, 18));
    panel.add(textoOutputPrefix);

    JLabel textoOutput = new JLabel("");
    textoOutput.setBounds(170, 100 + 50, 100, 100);
    textoOutput.setFont(new Font("Arial", Font.BOLD, 18));
    panel.add(textoOutput);

    JButton botonEncriptar = new JButton("Encriptar");
    botonEncriptar.setBounds(100, 220+20, 300, 25);
    panel.add(botonEncriptar);

    JButton botonDesencriptar = new JButton("Desencriptar");
    botonDesencriptar.setBounds(100, 260+20, 300, 25);
    panel.add(botonDesencriptar);

    botonEncriptar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String inputMessage = textoInput.getText();
        String mensajeEncriptado = encriptacion(inputMessage);
        textoOutput.setText(mensajeEncriptado);
      }
    });

    botonDesencriptar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String inputMessage = textoInput.getText();
        String mensajeDesencriptado = desencriptar(inputMessage);
        textoOutput.setText(mensajeDesencriptado);
      }
    });
  }
}
