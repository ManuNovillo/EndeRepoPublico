package clinica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class VentanaCreacionPaciente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombre;
	private JTextField textFieldDni;
	private JTextField textFieldCompania;
	private JLabel lblError;
	private JLabel lblCompania;
	private JLabel lblDni;
	private JLabel lblNombre;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public VentanaCreacionPaciente(JFrame padre, boolean modal) {
		super(padre, modal);
		setSize(450, 300);
		setLocationRelativeTo(padre);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(165, 11, 86, 20);
		contentPanel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(165, 62, 86, 20);
		contentPanel.add(textFieldDni);
		textFieldDni.setColumns(10);
		
		textFieldCompania = new JTextField();
		textFieldCompania.setBounds(165, 113, 86, 20);
		contentPanel.add(textFieldCompania);
		textFieldCompania.setColumns(10);
		
		lblCompania = new JLabel("Compañia");
		lblCompania.setBounds(78, 116, 77, 14);
		contentPanel.add(lblCompania);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(78, 65, 46, 14);
		contentPanel.add(lblDni);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(78, 14, 46, 14);
		contentPanel.add(lblNombre);
		
		lblError = new JLabel("Error en los datos");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(123, 181, 174, 14);
		lblError.setVisible(false);
		contentPanel.add(lblError);
		

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					crear();
					dispose();
				} catch (DatosIncorrectosException ex) {
					// TODO Auto-generated catch block
					lblError.setVisible(true);
				}
			}
		});
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cancel();
			}
		});
		buttonPane.add(cancelButton);
		
		setVisible(true);
	}
	
	private void cancel() {
		dispose();
	}
	
	private void crear() throws DatosIncorrectosException{
		if(textFieldNombre.getText().isBlank() || textFieldDni.getText().isBlank()) throw new DatosIncorrectosException();
		Paciente paciente;
		if(!textFieldCompania.getText().isBlank()) paciente = new Paciente(textFieldDni.getText(), textFieldNombre.getText(),  textFieldCompania.getText());
		else paciente = new Paciente(textFieldDni.getText(), textFieldNombre.getText());
		((VentanaPrincipal) getParent()).addPaciente(paciente);
	}
	
}
