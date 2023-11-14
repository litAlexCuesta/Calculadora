package Calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Clase Calculadora que contiene una calculadora basica con + - * y /
 * @author alex
 *
 */
public class Engine implements ActionListener {
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
	private enum ButtonType {
		REGULAR, OPERATOR
	}

	// ALMACENAR TEMPORALMENTE CIERTOS VALORES
	private int num1, num2, result;
	private char operation;
	
	/**
	 * Constructor que inicializa la calculadora e implementa la interfaz grafica
	 */
	Engine() {
		// CREAR EL JFRAME Y LOS BOTONES
		frame = new JFrame("Calculadora");
		contentPanel = new JPanel();
		displayPanel = new JPanel();
		buttonPanel = new JPanel();

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

		setSettings(); // AÑADE Y PONE LOS LAYOUTS. TAMBIEN LLAMA A SET_FEATURES_BUTTON
		addActionEvent();

	} // CIERRE ENGINE()

	public void setSettings() {
		frame.setLayout(new BorderLayout());
		contentPanel.setLayout(new BorderLayout());
		buttonPanel.setLayout(new GridLayout(4, 4));

		// AÑADIR EL JTEXFIELD AL PANEL
		displayPanel.add(display, BorderLayout.CENTER);

		// AÑADIR LOS BOTONES AL PANEL

		buttonPanel.add(n7); // SE AÑADE A BUTTONPANEL
		n7.setFocusable(false); // QUITA EL CUADRADO QUE SE MARCA AL CLICAR
		buttonPanel.add(n8);
		n8.setFocusable(false);
		buttonPanel.add(n9);
		n9.setFocusable(false);
		buttonPanel.add(add);
		add.setFocusable(false);
		buttonPanel.add(n4);
		n4.setFocusable(false);
		buttonPanel.add(n5);
		n5.setFocusable(false);
		buttonPanel.add(n6);
		n6.setFocusable(false);
		buttonPanel.add(subtract);
		subtract.setFocusable(false);
		buttonPanel.add(n1);
		n1.setFocusable(false);
		buttonPanel.add(n2);
		n2.setFocusable(false);
		buttonPanel.add(n3);
		n3.setFocusable(false);
		buttonPanel.add(multiply);
		multiply.setFocusable(false);
		buttonPanel.add(n0);
		n0.setFocusable(false);
		buttonPanel.add(reset);
		reset.setFocusable(false);
		buttonPanel.add(equal);
		equal.setFocusable(false);
		buttonPanel.add(divide);
		divide.setFocusable(false);

		// AÑADIR AL CONTENTPANEL
		contentPanel.add(displayPanel, BorderLayout.NORTH);
		contentPanel.add(buttonPanel, BorderLayout.CENTER);

		// DAR VISIBILIDAD AL JFRAME
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
	} // CIERRE SET_SETTINGS()

	public void setFeaturesButton(JButton _button, ButtonType _type) {
		// SI ES TIPO REGULAR, EN GRIS. SI ES TIPO OPERATOR, EN MAGENTA
		if (_type == ButtonType.REGULAR) {
			_button.setBackground(Color.LIGHT_GRAY);
			_button.setFont(new Font("Fuente", Font.ITALIC, 20));
		} else {
			_button.setBackground(Color.MAGENTA);
		}
	} // CIERRA SET_FEATURES_BUTTON

	public void addActionEvent() {
		n7.addActionListener(this);
		n8.addActionListener(this);
		n9.addActionListener(this);
		add.addActionListener(this);
		n4.addActionListener(this);
		n5.addActionListener(this);
		n6.addActionListener(this);
		subtract.addActionListener(this);
		n1.addActionListener(this);
		n2.addActionListener(this);
		n3.addActionListener(this);
		multiply.addActionListener(this);
		n0.addActionListener(this);
		reset.addActionListener(this);
		equal.addActionListener(this);
		divide.addActionListener(this);
	} // CIERRA ADD_ACTION_EVENT()

	public void operation() {

	} // CIERRA OPERATION

	@Override
	public void actionPerformed(ActionEvent e) {

		String operacion = null;
		String[] partes = null;

		Object source = e.getSource();
		String input_text = e.getActionCommand();

		switch (input_text) {

		case "=":
			operacion = display.getText();

			// EXPRESION REGULAR
			String patron = "([-+]?(?:\\d+\\.?\\d*|\\.\\d+))([-+*/])([-+]?(?:\\d+\\.?\\d*|\\.\\d+))";
			Pattern pattern = Pattern.compile(patron);
			Matcher matcher = pattern.matcher(operacion);

			if (matcher.matches()) {

				num1 = Integer.parseInt(matcher.group(1));
				operation = matcher.group(2).charAt(0);
				num2 = Integer.parseInt(matcher.group(3));

				switch (operation) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					if (num2 != 0) {
						result = num1 / num2;
					} else {
						display.setText("Syntax error");
					}
					break;
				default:
					display.setText("Syntax error");
				}
				
				display.setText("" + result);
			} else {
				display.setText("Syntax error");
			}

			break;
		}

		if (input_text.equals("R")) {
			num1 = 0;
			num2 = 0;
			result = 0;
			operation = ' ';
			display.setText("");
		} else if (input_text.equals("=")) {

		} else {
			display.setText(display.getText() + input_text);
		}

	}

} // CIERRE DE LA CLASE
