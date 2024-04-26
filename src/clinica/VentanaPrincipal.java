package clinica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JRadioButton;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAtender;
	private JButton btnPaciente;
	private ListaDeEspera lista;
	private JLabel lblNoPacientes;
	private JLabel lblNumeroPacientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(688, 537);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAtender = new JButton("Atender");
		btnAtender.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(lblNoPacientes.isVisible()) hideNoPacientes();
				atender();
				actualizarPacientesEsperando();
			}
		});
		btnAtender.setBounds(287, 305, 107, 23);
		contentPane.add(btnAtender);
		
		btnPaciente = new JButton("Añadir paciente");
		btnPaciente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				crearPaciente();
				hideNoPacientes();
				actualizarPacientesEsperando();
			}

		});
		btnPaciente.setBounds(287, 180, 107, 23);
		contentPane.add(btnPaciente);
		
		JLabel lblNewLabel = new JLabel("CLÍNICA IES AZARQUIEL");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel.setBounds(24, 11, 210, 14);
		contentPane.add(lblNewLabel);
		
		lblNoPacientes = new JLabel("No hay pacientes");
		lblNoPacientes.setForeground(new Color(255, 0, 0));
		lblNoPacientes.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNoPacientes.setBounds(450, 309, 134, 14);
		lblNoPacientes.setVisible(false);
		contentPane.add(lblNoPacientes);
		
		JLabel lblPacientesEsperando = new JLabel("Pacientes esperando:");
		lblPacientesEsperando.setBounds(277, 414, 107, 42);
		contentPane.add(lblPacientesEsperando);
		
		
		lblNumeroPacientes = new JLabel("0");
		lblNumeroPacientes.setBounds(394, 414, 95, 42);
		contentPane.add(lblNumeroPacientes);
		
		lista = new ListaDeEspera();
		
	}
	
	private void actualizarPacientesEsperando() {
		// TODO Auto-generated method stub
		lblNumeroPacientes.setText(String.valueOf(lista.size()));
	}

	private void atender() {
		if(lista.isEmpty()) {
			lblNoPacientes.setVisible(true);
			return;
		}
		
		Paciente paciente = lista.atender();
		VentanaAtendiendo ventana = new VentanaAtendiendo(this, true, paciente);
	}
	
	private void crearPaciente() {
		VentanaCreacionPaciente ventana = new VentanaCreacionPaciente(this, true);
	}
	
	private void hideNoPacientes() {
		// TODO Auto-generated method stub
		lblNoPacientes.setVisible(false);
	}
	
	public void addPaciente(Paciente paciente) {
		lista.add(paciente);
	}
}