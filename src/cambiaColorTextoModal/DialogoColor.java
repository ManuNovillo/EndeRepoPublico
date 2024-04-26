package cambiaColorTextoModal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class DialogoColor extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public DialogoColor(JFrame padre, boolean modal) {
		super(padre, modal);
		setBounds(100, 100, 206, 295);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		JRadioButton rdbtnRojo = new JRadioButton("Rojo");
		buttonGroup.add(rdbtnRojo);
		rdbtnRojo.setBounds(47, 7, 109, 23);
		contentPanel.add(rdbtnRojo);
		JRadioButton rdbtnAzul = new JRadioButton("Azul");
		buttonGroup.add(rdbtnAzul);
		rdbtnAzul.setBounds(47, 46, 109, 23);
		contentPanel.add(rdbtnAzul);

		JRadioButton rdbtnVerde = new JRadioButton("Verde");
		buttonGroup.add(rdbtnVerde);
		rdbtnVerde.setBounds(47, 82, 109, 23);
		contentPanel.add(rdbtnVerde);

		JRadioButton rdbtnAmarillo = new JRadioButton("Amarillo");
		buttonGroup.add(rdbtnAmarillo);
		rdbtnAmarillo.setBounds(47, 123, 109, 23);
		contentPanel.add(rdbtnAmarillo);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = null;
				JRadioButton button = null;
				Enumeration<AbstractButton> en = buttonGroup.getElements();
				while(en.hasMoreElements()) {
					JRadioButton btn = (JRadioButton) en.nextElement();
					if(btn.isSelected()) button = btn;
				}
				/*
				 * if(rdbtnAmarillo.isSelected()) button = rdbtnAmarillo;
				 * if(rdbtnAzul.isSelected()) button = rdbtnAzul; if(rdbtnRojo.isSelected())
				 * button = rdbtnRojo; if(rdbtnVerde.isSelected()) button = rdbtnVerde;
				 */
				switch (button.getText()) {
				case "Rojo" -> color = Color.RED;
				case "Amarillo" -> color = Color.YELLOW;
				case "Verde" -> color = Color.GREEN;
				case "Azul" -> color = Color.BLUE;
				}
				((Ventana) getParent()).getLabel().setForeground(color);
				dispose();
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

	}
}
