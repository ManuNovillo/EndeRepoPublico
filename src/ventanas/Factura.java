package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Factura extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cantidadField;
	private JTextField totalField;
	private JTextField ivaField;
	private final ButtonGroup botonesIva = new ButtonGroup();
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Factura frame = new Factura();
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
	public Factura() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cantidadField = new JTextField();
		cantidadField.setHorizontalAlignment(SwingConstants.RIGHT);
		cantidadField.setBounds(115, 11, 86, 20);
		contentPane.add(cantidadField);
		cantidadField.setColumns(10);
		
		totalField = new JTextField();
		totalField.setEditable(false);
		totalField.setBounds(115, 213, 86, 20);
		contentPane.add(totalField);
		totalField.setColumns(10);
		
		ivaField = new JTextField();
		ivaField.setBounds(115, 155, 86, 20);
		contentPane.add(ivaField);
		ivaField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("IVA");
		lblNewLabel.setBounds(28, 158, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(28, 216, 46, 14);
		contentPane.add(lblTotal);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(28, 14, 46, 14);
		contentPane.add(lblCantidad);
		
		JButton calcularBtn = new JButton("Calcular");
		calcularBtn.setBounds(285, 212, 89, 23);
		contentPane.add(calcularBtn);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[]{"21", "4", "10"}));
		comboBox.setBounds(115, 75, 86, 22);
		contentPane.add(comboBox);
		
		calcularBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actualizar();
			}
		});
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				actualizar();
			}
		});
		
		cantidadField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				actualizar();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				actualizar();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				actualizar();
			}
		});
		
	}

	
	private int getIvaPulsado() {
		return Integer.parseInt((String) comboBox.getSelectedItem());
	}
	
	private void actualizar() {
		int iva = getIvaPulsado();
		double cantidad = 0;
		try { 
			cantidad = Double.parseDouble(cantidadField.getText());
			DecimalFormat formato = new DecimalFormat("#,##0.00€");
		    totalField.setText(String.valueOf(formato.format(cantidad + iva/100.0 * cantidad)));
			ivaField.setText((String.valueOf(formato.format(iva/100.0 * cantidad))));
		} catch (NumberFormatException ex) {
			totalField.setText("");
			ivaField.setText("");
		}
		
	
	}
}
