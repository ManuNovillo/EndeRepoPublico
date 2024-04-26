package calculadora;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnCambiarSigno;
	private JButton btn0;
	private JButton btnPunto;
	private JButton btn3;
	private JButton btn2;
	private JButton btn1;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btnBorrar;
	private JButton btnMultiplicar;
	private JButton btnSumar;
	private JButton btnIgual;
	private JButton btnRestar;
	private JButton btnDividir;
	private double valor1;
	private double valor2;
	private double resultado;
	private String signo;
	boolean debeResetear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Calculadora frame = new Calculadora();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculadora() {
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnCambiarSigno = new JButton("+/-");
		btnCambiarSigno.setBounds(61, 363, 74, 63);
		contentPane.add(btnCambiarSigno);

		btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn0.setBounds(166, 363, 74, 63);
		contentPane.add(btn0);

		btnPunto = new JButton(".");
		btnPunto.setBounds(271, 363, 74, 63);
		contentPane.add(btnPunto);

		btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn3.setBounds(271, 274, 74, 63);
		contentPane.add(btn3);

		btn2 = new JButton("2");
		btn2.setBounds(166, 274, 74, 63);
		contentPane.add(btn2);

		btn1 = new JButton("1");
		btn1.setBounds(61, 274, 74, 63);
		contentPane.add(btn1);

		btn4 = new JButton("4");
		btn4.setBounds(61, 190, 74, 63);
		contentPane.add(btn4);

		btn5 = new JButton("5");
		btn5.setBounds(166, 190, 74, 63);
		contentPane.add(btn5);

		btn6 = new JButton("6");
		btn6.setBounds(271, 190, 74, 63);
		contentPane.add(btn6);

		btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn7.setBounds(61, 108, 74, 63);
		contentPane.add(btn7);

		btn8 = new JButton("8");
		btn8.setBounds(166, 108, 74, 63);
		contentPane.add(btn8);

		btn9 = new JButton("9");
		btn9.setBounds(271, 108, 74, 63);
		contentPane.add(btn9);

		btnBorrar = new JButton("CE");
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrar.setForeground(new Color(255, 128, 64));
		btnBorrar.setBounds(378, 108, 178, 63);
		contentPane.add(btnBorrar);

		btnMultiplicar = new JButton("x");
		btnMultiplicar.setBounds(378, 190, 74, 63);
		contentPane.add(btnMultiplicar);

		btnSumar = new JButton("+");
		btnSumar.setBounds(378, 274, 74, 63);
		contentPane.add(btnSumar);

		btnIgual = new JButton("=");
		btnIgual.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIgual.setBounds(378, 363, 178, 63);
		contentPane.add(btnIgual);

		btnRestar = new JButton("-");
		btnRestar.setBounds(482, 274, 74, 63);
		contentPane.add(btnRestar);

		btnDividir = new JButton("/");
		btnDividir.setBounds(482, 190, 74, 63);
		contentPane.add(btnDividir);

		textField = new JTextField("0");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 34));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setEditable(false);
		textField.setBounds(61, 21, 495, 47);
		contentPane.add(textField);
		textField.setColumns(10);

		btn0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textField.getText().equals("0")) return;
				textField.setText(textField.getText() + ((JButton) e.getSource()).getText());
			}
		});

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textField.getText().equals("0")) textField.setText("");
				textField.setText(textField.getText() + ((JButton) e.getSource()).getText());
			}
		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textField.getText().equals("0")) textField.setText("");
				textField.setText(textField.getText() + ((JButton) e.getSource()).getText());
			}
		});

		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textField.getText().equals("0")) textField.setText("");
				textField.setText(textField.getText() + ((JButton) e.getSource()).getText());
			}
		});

		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textField.getText().equals("0")) textField.setText("");
				textField.setText(textField.getText() + ((JButton) e.getSource()).getText());
			}
		});

		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textField.getText().equals("0")) textField.setText("");
				textField.setText(textField.getText() + ((JButton) e.getSource()).getText());
			}
		});

		btn6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textField.getText().equals("0")) textField.setText("");
				textField.setText(textField.getText() + ((JButton) e.getSource()).getText());
			}
		});

		btn7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textField.getText().equals("0")) textField.setText("");
				textField.setText(textField.getText() + ((JButton) e.getSource()).getText());
			}
		});

		btn8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textField.getText().equals("0")) textField.setText("");
				textField.setText(textField.getText() + ((JButton) e.getSource()).getText());
			}
		});

		btn9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textField.getText().equals("0")) textField.setText("");
				textField.setText(textField.getText() + ((JButton) e.getSource()).getText());
			}
		});

		btnPunto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textField.setText(textField.getText() + ((JButton) e.getSource()).getText());
			}
		});

		btnSumar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				valor1 = Double.parseDouble(textField.getText());
				signo = ((JButton) e.getSource()).getText();
				textField.setText("0");
			}
		});

		btnRestar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				valor1 = Double.parseDouble(textField.getText());
				signo = ((JButton) e.getSource()).getText();
				textField.setText("0");
			}
		});

		btnMultiplicar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				valor1 = Double.parseDouble(textField.getText());
				signo = ((JButton) e.getSource()).getText();
				textField.setText("0");
			}
		});

		btnDividir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				valor1 = Double.parseDouble(textField.getText());
				signo = ((JButton) e.getSource()).getText();
				textField.setText("0");
			}
		});
		
		btnIgual.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				valor2 = Double.parseDouble(textField.getText());
				calcular();
				textField.setText(String.valueOf(resultado));
			}
		});
	}

	private void calcular() {
		switch (signo) {
		case "+" -> resultado = valor1 + valor2;
		case "-" -> resultado = valor1 - valor2;
		case "x" -> resultado = valor1 * valor2;
		case "/" -> resultado = valor1 / valor2;
		}
	}

}