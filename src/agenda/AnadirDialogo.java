package agenda;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clinica.DatosIncorrectosException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

public class AnadirDialogo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nombreTextField;
	private JTextField telefonoTextField;
	private JLabel errorLabel;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public AnadirDialogo(JFrame padre, boolean modal) {
		super(padre, modal);
		setSize(450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			nombreTextField = new JTextField();
			nombreTextField.setBounds(180, 31, 86, 20);
			contentPanel.add(nombreTextField);
			nombreTextField.setColumns(10);
		}
		
		telefonoTextField = new JTextField();
		telefonoTextField.setColumns(10);
		telefonoTextField.setBounds(180, 88, 86, 20);
		contentPanel.add(telefonoTextField);
		
		JLabel telefonoLabel = new JLabel("Teléfono:");
		telefonoLabel.setBounds(91, 91, 46, 14);
		contentPanel.add(telefonoLabel);
		{
			JLabel nombreLabel = new JLabel("Nombre:");
			nombreLabel.setBounds(91, 34, 46, 14);
			contentPanel.add(nombreLabel);
		}
		{
			errorLabel = new JLabel("Comprueba los datos");
			errorLabel.setForeground(Color.RED);
			errorLabel.setBounds(160, 203, 135, 14);
			errorLabel.setVisible(false);
			contentPanel.add(errorLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							pulsadoOk();
						} catch(DatosIncorrectosException ex) {
							errorLabel.setVisible(true);
						}
					}

				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(e -> pulsadoCancel());
				buttonPane.add(cancelButton);
			}
		}
		setTitle("Añadir contacto");
		setLocationRelativeTo(padre);
		setVisible(true);
	}
	
	private void pulsadoOk() throws DatosIncorrectosException {
		// TODO Auto-generated method stub
		if(nombreTextField.getText().isBlank()) throw new DatosIncorrectosException();
		Contacto contacto;
		if(telefonoTextField.getText().isBlank()) contacto = new Contacto(nombreTextField.getText());
		else {
			try {
				contacto = new Contacto(nombreTextField.getText(), Long.parseLong(telefonoTextField.getText()));
				VentanaPrincipal ventana = (VentanaPrincipal) getParent();
				ventana.addContacto(contacto);
				ventana.anadirRow(contacto.getNombre(), contacto.getTelefono());
				dispose();
			} catch(NumberFormatException ex) {
				throw new DatosIncorrectosException(ex);
			}
		}
	}
	
	private void pulsadoCancel() {
		dispose();
	}
}
