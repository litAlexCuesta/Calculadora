package Calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Engine {
    // MARCO DE LA VENTANA
    private JFrame frame;
    
    // PANEL GENERAL QUE OCUPA TODA LA VENTANA
    private JPanel contentPanel;
    
    // PANEL NORTE QUE CONTIENE EL DISPLAY
    private JPanel displayPanel;
    
    // PANEL SUR QUE CONTIENE LOS BOTONES
    private JPanel buttonPanel;
    
    // DISPLAY
    private JTextField display;
    
    // BOTONES
    private JButton n0;
    private JButton n1;
    private JButton n2;
    private JButton n3;
    private JButton n4;
    private JButton n5;
    private JButton n6;
    private JButton n7;
    private JButton n8;
    private JButton n9;
    private JButton divide;
    private JButton multiply;
    private JButton subtract;
    private JButton add;
    private JButton equal;
    private JButton reset;
    
    // TIPOS DE BOTÓN
    private enum ButtonType { REGULAR, OPERATOR }
    
    // ALMACENAR TEMPORALMENTE CIERTOS VALORES
    private int num1, num2, result;
    private char operation;

    Engine() {
    	//CREAR EL JFRAME Y LOS BOTONES
    	frame = new JFrame("Calculadora");
    	frame.setLayout(new BorderLayout());
    	contentPanel = new JPanel();
    	contentPanel.setLayout(new BorderLayout());
    	displayPanel = new JPanel();
       	buttonPanel = new JPanel();
    	buttonPanel.setLayout(new GridLayout(4, 4));
    	
    	display = new JTextField(30);
    	
    	n0 = new JButton("0");
        n1 = new JButton("1");
        n2 = new JButton("2");
        n3 = new JButton("3");
        n4 = new JButton("4");
        n5 = new JButton("5");
        n6 = new JButton("6");
        n7 = new JButton("7");
        n8 = new JButton("8");
        n9 = new JButton("9");
        
        divide = new JButton("/");
        multiply = new JButton("*");
        subtract = new JButton("-");
        add = new JButton("+");
        equal = new JButton("=");
        reset = new JButton("R");
        num1 = 0;
        num2 = 0;
        result = 0;
        
        setSettings(); //AÑADE Y PONE LOS LAYOUTS. TAMBIEN LLAMA A SET_FEATURES_BUTTON
        
    } //CIERRE ENGINE()
    
    public void setSettings(){
    	//AÑADIR EL JTEXFIELD AL PANEL
        displayPanel.add(display, BorderLayout.CENTER);
        
        //AÑADIR LOS BOTONES AL PANEL
        
        buttonPanel.add(n7);
        buttonPanel.add(n8);
        buttonPanel.add(n9);
        buttonPanel.add(add);
        buttonPanel.add(n4);
        buttonPanel.add(n5);
        buttonPanel.add(n6);
        buttonPanel.add(subtract);
        buttonPanel.add(n1);
        buttonPanel.add(n2);
        buttonPanel.add(n3);
        buttonPanel.add(multiply);
        buttonPanel.add(n0);
        buttonPanel.add(reset);
        buttonPanel.add(equal);
        buttonPanel.add(divide);
        
        //AÑADIR AL CONTENTPANEL
        contentPanel.add(displayPanel, BorderLayout.NORTH);
        contentPanel.add(buttonPanel, BorderLayout.CENTER);
        
        //DAR VISIBILIDAD AL JFRAME
        frame.setLocation(100, 100);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(contentPanel);
        
        setFeaturesButton(n7, ButtonType.REGULAR);
        setFeaturesButton(n8, ButtonType.REGULAR);
        setFeaturesButton(n9, ButtonType.REGULAR);
        setFeaturesButton(add, ButtonType.OPERATOR);
        setFeaturesButton(n4, ButtonType.REGULAR);
        setFeaturesButton(n5, ButtonType.REGULAR);
        setFeaturesButton(n6, ButtonType.REGULAR);
        setFeaturesButton(subtract, ButtonType.OPERATOR);
        setFeaturesButton(n1, ButtonType.REGULAR);
        setFeaturesButton(n2, ButtonType.REGULAR);
        setFeaturesButton(n3, ButtonType.REGULAR);
        setFeaturesButton(multiply, ButtonType.OPERATOR);
        setFeaturesButton(n0, ButtonType.REGULAR);
        setFeaturesButton(reset, ButtonType.REGULAR);
        setFeaturesButton(equal, ButtonType.OPERATOR);
        setFeaturesButton(divide, ButtonType.OPERATOR);
    } //CIERRE SET_SETTINGS()
    
    public void setFeaturesButton(JButton _button, ButtonType _type) {
    	//SI ES TIPO REGULAR, EN GRIS. SI ES TIPO OPERATOR, EN MAGENTA
    	if (_type == ButtonType.REGULAR) {
            _button.setBackground(Color.LIGHT_GRAY);
        } else {
            _button.setBackground(Color.MAGENTA);
        }
    } //CIERRA SET_FEATURES_BUTTON
} //CIERRE DE LA CLASE
