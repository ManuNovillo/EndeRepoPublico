package ventanas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class CambiaColorTexto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CambiaColorTexto frame = new CambiaColorTexto();
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
	public CambiaColorTexto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextPane();
		textField.setFont(new Font("Tahoma", Font.BOLD, 17));
		textField.setText("PRUEBA QUE TAL");
		textField.setBounds(31, 184, 337, 42);
		contentPane.add(textField);
		
		JButton btnAzul = new JButton("Azul");
		btnAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setForeground(Color.BLUE);
			}
		});
		btnAzul.setBounds(44, 96, 89, 23);
		contentPane.add(btnAzul);
		JButton btnRojo = new JButton("Rojo");
		btnRojo.setBounds(172, 96, 89, 23);
		btnRojo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textField.setForeground(Color.RED);
			}
		});
		contentPane.add(btnRojo);
		
		JButton btnVerde = new JButton("Verde");
		btnVerde.setBounds(296, 96, 89, 23);
		btnVerde.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textField.setForeground(Color.GREEN);
			}
		});
		contentPane.add(btnVerde);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				System.out.println("a");
				textField.setText(String.valueOf(slider.getValue()));
			}
		});
		/*slider.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				System.out.println("a");
				textField.setText(String.valueOf(slider.getValue()));
			}
		});*/
		slider.setBounds(80, 41, 200, 26);
		contentPane.add(slider);
		
		
	}
}
