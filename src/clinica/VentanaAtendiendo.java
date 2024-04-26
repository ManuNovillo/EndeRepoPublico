package clinica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class VentanaAtendiendo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public VentanaAtendiendo(JFrame padre, boolean modal, Paciente paciente) {
		super(padre, modal);
		setSize(450, 300);
		setLocationRelativeTo(padre);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre: ".concat(paciente.getNombre()));
		lblNombre.setBounds(109, 11, 131, 14);
		contentPanel.add(lblNombre);
		
		JLabel lblDni = new JLabel("DNI: ".concat(paciente.getDni()));
		lblDni.setBounds(109, 58, 131, 14);
		contentPanel.add(lblDni);
		
		JLabel lblEmpresa = new JLabel("Compañia: ".concat(paciente.getCompañia()));
		lblEmpresa.setBounds(109, 101, 131, 14);
		contentPanel.add(lblEmpresa);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				aceptar();
			}
		});
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		
		setVisible(true);
	}

	private void aceptar() {
		dispose();
	}
}


