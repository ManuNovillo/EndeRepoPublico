package buscarTexto;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import blocDeNotas.GestorArchivos;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaPrincipalBuscarTexto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField rutaTextField;
	private JTextField filtrarTextField;
	private JTextArea textArea;
	private GestorArchivos gestor = new GestorArchivos(null);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					VentanaPrincipalBuscarTexto frame = new VentanaPrincipalBuscarTexto();
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
	public VentanaPrincipalBuscarTexto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Buscar Texto");
		setSize(506, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rutaTextField = new JTextField();
		rutaTextField.setBounds(26, 11, 322, 20);
		contentPane.add(rutaTextField);
		rutaTextField.setColumns(10);
		
		JButton abrirButton = new JButton("Abrir");
		abrirButton.setBounds(375, 10, 60, 23);
		abrirButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pulsadoAbrir();
			}
		});
		contentPane.add(abrirButton);
		
		filtrarTextField = new JTextField();
		filtrarTextField.setColumns(10);
		filtrarTextField.setBounds(26, 51, 277, 20);
		contentPane.add(filtrarTextField);
		
		JButton filtarButton = new JButton("Filtrar");
		filtarButton.setBounds(334, 50, 89, 23);
		filtarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pulsadoFiltrar();
			}
		});
		contentPane.add(filtarButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 89, 490, 258);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

	protected void pulsadoAbrir() {
		// TODO Auto-generated method stub
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(this);
		if(chooser.getSelectedFile() != null) {
			gestor.setArchivo(chooser.getSelectedFile());
			rutaTextField.setText(gestor.getArchivo().getAbsolutePath());
			ArrayList<String> lineas = gestor.getTexto();
			textArea.setText("");
			for (String linea : lineas) {
				textArea.append(linea);
			}
		}
	}

	protected void pulsadoFiltrar() {
		// TODO Auto-generated method stub
		if(filtrarTextField.getText().equals("")) return;
		String[] lineas = textArea.getText().split("\n");
	}
}
