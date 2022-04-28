/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.zip.GZIPOutputStream;

import static java.awt.event.MouseEvent.*;

public class Presentacion extends JFrame {
    //atributostodo lo grÃ¡ficos son privados
    private JButton miFoto, miHobby, misExpectativas;
    private JPanel panelBotones, panelDatos, panelMouse;
    private JLabel labelImage;
    private Escucha escucha;
    private JTextArea textoExpectativas;

    //metodos
    public Presentacion() {
        initGUI();
        //Configuracion base de la ventana
        this.setTitle("Mi PresentaciÃ³n");
        this.setSize(800, 900);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //Definir Container y Layout del JFrame
        //Crear objetos Escucha y Control
        escucha = new Escucha();
        //Configurar JComponents
      
        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "Un poco mas de mi­...",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Calibri",
                        Font.PLAIN, 20), Color.BLACK));

        this.add(panelDatos, BorderLayout.CENTER);

        miFoto = new JButton("Este soy yo");
        miFoto.addMouseListener(escucha);
        miHobby = new JButton("Este es mi hobbie");
        miHobby.addMouseListener(escucha);
        misExpectativas = new JButton("Creo que...");
        misExpectativas.addKeyListener(escucha);

        panelMouse = new JPanel();
        panelMouse.addMouseListener(escucha);
        panelMouse.addKeyListener(escucha);

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);

        this.add(panelBotones, BorderLayout.SOUTH);

        labelImage = new JLabel();
        textoExpectativas = new JTextArea(20, 50);

    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Presentacion miGUIPresentacion = new Presentacion();
            }
        });
    }

    private class Escucha implements ActionListener, MouseListener, KeyListener {
        private ImageIcon image;

        @Override
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(null,"Oprimiste un botÃ³n");
            panelDatos.removeAll();
            if (e.getSource() == miFoto) {
                image = new ImageIcon(getClass().getResource("/recursos/foto.jpg"));
                labelImage.setIcon(image);
                panelDatos.add(labelImage);
                Image cambioTamano = image.getImage();
                Image tamano = cambioTamano.getScaledInstance(500, 800, Image.SCALE_SMOOTH);
                ImageIcon fin = new ImageIcon(tamano);
                labelImage.setIcon(fin);
            } else {
                if (e.getSource() == miHobby) {
                    image = new ImageIcon(getClass().getResource("/recursos/videojuegos.jpg"));
                    labelImage.setIcon(image);
                    panelDatos.add(labelImage);
                } else {
                    textoExpectativas.setText("No sÃ© mucho de java,\nasÃ­ que en este curso espero aprender mucho del lenguaje.\n" +
                            "TambiÃ©n quiero aprender a hacer interfaces de usuario para aplicarlo en otros Ã¡mbitos de la programaciÃ³n ");
                    textoExpectativas.setBackground(null);
                    textoExpectativas.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 12));
                    panelDatos.add(textoExpectativas);
                }
            }
            revalidate();
            repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == miFoto && e.getClickCount()==1){
                panelDatos.removeAll();
                image = new ImageIcon(getClass().getResource("/recursos/foto.jpg"));
                labelImage.setIcon(image);
                panelDatos.add(labelImage);
                Image cambioTamano = image.getImage();
                Image tamano = cambioTamano.getScaledInstance(500, 800, Image.SCALE_SMOOTH);
                ImageIcon fin = new ImageIcon(tamano);
                labelImage.setIcon(fin);
            } else if (e.getSource() == miHobby && e.getClickCount()==2){
                panelDatos.removeAll();
                image = new ImageIcon(getClass().getResource("/recursos/videojuegos.jpg"));
                labelImage.setIcon(image);
                panelDatos.add(labelImage);
            }
            revalidate();
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == 'M' || e.getKeyChar() == 'm'){
                panelDatos.removeAll();
                textoExpectativas.setText("No sÃ© mucho de java,\nasÃ­ que en este curso espero aprender mucho del lenguaje.\n" +
                        "TambiÃ©n quiero aprender a hacer interfaces de usuario para aplicarlo en otros Ã¡mbitos de la programaciÃ³n ");
                textoExpectativas.setBackground(null);
                textoExpectativas.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 12));
                panelDatos.add(textoExpectativas);
            }
            revalidate();
            repaint();
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}

