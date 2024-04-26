package cambiaColorTextoModal;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel labelPrueba;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Ventana frame = new Ventana();
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
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelPrueba = new JLabel("TEXTO PRUEBA");
		labelPrueba.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelPrueba.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrueba.setBounds(129, 11, 190, 108);
		contentPane.add(labelPrueba);
		
		JButton btnCambiarColor = new JButton("Cambia color");
		btnCambiarColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogoColor color = new DialogoColor(Ventana.this, true);
				color.setLocationRelativeTo(Ventana.this);
				color.setVisible(true);
			}
		});
		btnCambiarColor.setBounds(156, 197, 132, 23);
		contentPane.add(btnCambiarColor);
		
	}
	
	public JLabel getLabel() {
		return labelPrueba;
	}
}
