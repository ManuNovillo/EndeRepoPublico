package ejercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField archivoTextField;
	private JTextField filtrarTextField;
	private GestorArchivos gestor = new GestorArchivos();
	private JTextArea textArea;
	private String textoOriginal;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					VentanaPrincipal frame = new VentanaPrincipal();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(701, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton abrirButton = new JButton("Abrir");
		abrirButton.setBounds(517, 21, 89, 23);
		abrirButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pulsadoAbrir();
			}
		});
		contentPane.add(abrirButton);
		
		archivoTextField = new JTextField();
		archivoTextField.setBounds(38, 22, 453, 20);
		archivoTextField.setColumns(10);
		archivoTextField.setEditable(false);
		contentPane.add(archivoTextField);
		
		filtrarTextField = new JTextField();
		filtrarTextField.setColumns(10);
		filtrarTextField.setBounds(38, 63, 209, 20);
		filtrarTextField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				filtrar();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				filtrar();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				filtrar();
			}
		});
		contentPane.add(filtrarTextField);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 110, 685, 397);
		textArea = new JTextArea();
		textArea.setSize(685, 397);
		textArea.setEditable(false);
		scrollPane.add(textArea);
		contentPane.add(scrollPane);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	protected void filtrar() {
		// TODO Auto-generated method stub
		if (gestor.getFile() == null) return;
		ArrayList<String> lineas = new ArrayList<String>();
		for (String linea : textoOriginal.split("\n")) {
			if (linea.toUpperCase().contains(filtrarTextField.getText().toUpperCase())) {
				lineas.add(linea);
			}
		}
		textArea.setText(null);
		for (String linea : lineas) {
			textArea.append(linea + "\n");
		}
	}

	protected void pulsadoAbrir() {
		// TODO Auto-generated method stub
		JFileChooser chooser = new JFileChooser(gestor.getFile());
		chooser.showOpenDialog(this);
		if (chooser.getSelectedFile() == null) return;
		gestor.setFile(chooser.getSelectedFile());
		setTitle(gestor.getFile().getName());
		archivoTextField.setText(gestor.getFile().getAbsolutePath());		
		ArrayList<String> lineas = gestor.getLineasTexto();
		textArea.setText(null);
		for (String linea : lineas) {
			textArea.append(linea + "\n");
		}
		textoOriginal = textArea.getText();
	}
}
