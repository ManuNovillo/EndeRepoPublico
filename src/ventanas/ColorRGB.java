package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ColorRGB extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel labelRed;
	private JLabel labelGreen;
	private JLabel labelBlue;
	private JSlider sliderRed;
	private JSlider sliderGreen;
	private JSlider sliderBlue;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ColorRGB frame = new ColorRGB();
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
	public ColorRGB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(149, 10, 127, 101);
		contentPane.add(panel);
		
		sliderRed = new JSlider();
		sliderRed.setMaximum(255); 
		sliderRed.setValue(0);
		sliderRed.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				labelRed.setText(String.valueOf(sliderRed.getValue()));
				panel.setBackground(new Color(sliderRed.getValue(), sliderGreen.getValue(), sliderBlue.getValue()));
			}
		});
		sliderRed.setBounds(112, 133, 200, 26);
		contentPane.add(sliderRed);
		
		sliderGreen = new JSlider();
		sliderGreen.setMaximum(255);
		sliderGreen.setValue(0);
		sliderGreen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				labelGreen.setText(String.valueOf(sliderGreen.getValue()));
				panel.setBackground(new Color(sliderRed.getValue(), sliderGreen.getValue(), sliderBlue.getValue()));
			}
		});
		sliderGreen.setBounds(112, 170, 200, 26);
		contentPane.add(sliderGreen);
		
		sliderBlue = new JSlider();
		sliderBlue.setMaximum(255);
		sliderBlue.setValue(0);
		sliderBlue.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				labelBlue.setText(String.valueOf(sliderBlue.getValue()));
				panel.setBackground(new Color(sliderRed.getValue(), sliderGreen.getValue(), sliderBlue.getValue()));
			}
		});
		sliderBlue.setBounds(112, 207, 200, 26);
		contentPane.add(sliderBlue);
		
		labelRed = new JLabel("0");
		labelRed.setBounds(351, 133, 46, 14);
		contentPane.add(labelRed);
		
		labelGreen = new JLabel("0");
		labelGreen.setBounds(351, 170, 46, 14);
		contentPane.add(labelGreen);
		
		labelBlue = new JLabel("0");
		labelBlue.setBounds(351, 207, 46, 14);
		contentPane.add(labelBlue);
		
		lblNewLabel = new JLabel("R");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(29, 133, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("G");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setBounds(29, 170, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("B");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(29, 207, 46, 14);
		contentPane.add(lblNewLabel_2);
	}
}
