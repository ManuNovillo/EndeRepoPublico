package dialogos;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Formulario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombreField;
	private JTextField edadField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Formulario frame = new Formulario();
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
	public Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(61, 43, 46, 14);
		contentPane.add(labelNombre);
		
		JLabel labelEdad = new JLabel("Edad");
		labelEdad.setBounds(61, 96, 46, 14);
		contentPane.add(labelEdad);
		
		nombreField = new JTextField();
		nombreField.setBounds(156, 40, 86, 20);
		contentPane.add(nombreField);
		nombreField.setColumns(10);
		
		edadField = new JTextField();
		edadField.setBounds(156, 93, 86, 20);
		contentPane.add(edadField);
		edadField.setColumns(10);
		
		JButton guardarBtn = new JButton("Guardar");
		guardarBtn.setBounds(153, 211, 89, 23);
		guardarBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				guardar();
			}
		});
		contentPane.add(guardarBtn);
	}
	
	private void guardar()  {
		try {
			if(nombreField.getText().isBlank()) JOptionPane.showMessageDialog(this,  "El nombre no puede estar vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if(edadField.getText().isBlank()) JOptionPane.showMessageDialog(this,  "Edad no puede estar vacía", "ERROR", JOptionPane.ERROR_MESSAGE);
			else JOptionPane.showMessageDialog(this,  "Datos guardados correctamente", "Correcto", JOptionPane.PLAIN_MESSAGE);
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
