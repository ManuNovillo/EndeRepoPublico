package blocDeNotas;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaBlocDeNotas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GestorArchivos gestor = new GestorArchivos(null);
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					VentanaBlocDeNotas frame = new VentanaBlocDeNotas();
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
	public VentanaBlocDeNotas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JMenuBar menuBar = new JMenuBar();
		scrollPane.setColumnHeaderView(menuBar);
		
		JMenu archivoMenu = new JMenu("Archivo");
		menuBar.add(archivoMenu);
		
		JMenuItem abrirItem = new JMenuItem("Abrir");
		abrirItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsadoAbrir();
			}
		});
		abrirItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		archivoMenu.add(abrirItem);
		
		JMenuItem guardarItem = new JMenuItem("Guardar");
		guardarItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		guardarItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pulsadoGuardar();
			}
		});
		archivoMenu.add(guardarItem);
		
		JMenuItem guardarComoItem = new JMenuItem("Guardar como");
		guardarComoItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pulsadoGuardarComo();
			}
		});
		archivoMenu.add(guardarComoItem);
		
		JMenu edicionMenu = new JMenu("Edición");
		menuBar.add(edicionMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Ver");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_3 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_3);
		setLocationRelativeTo(null);
	}

	protected void pulsadoGuardar() {
		// TODO Auto-generated method stub
		if (gestor.getArchivo() == null) {
			pulsadoGuardarComo();
		} else {
			gestor.guardarTexto(textArea.getText());
		}
	}

	protected void pulsadoGuardarComo() {
		// TODO Auto-generated method stub
		JFileChooser chooser = new JFileChooser();
		chooser.showSaveDialog(this);
		if(chooser.getSelectedFile() != null) {
			gestor.setArchivo(chooser.getSelectedFile());
			gestor.guardarTexto(textArea.getText());
		}
	}

	protected void pulsadoAbrir() {
		// TODO Auto-generated method stub
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(this);
		if (chooser.getSelectedFile() != null) {
			gestor.setArchivo(chooser.getSelectedFile());
			ArrayList<String> lineas = gestor.getTexto();
			textArea.setText("");
			for(String string : lineas) {
				textArea.append(string + "\n");
			}
			setTitle(chooser.getSelectedFile().getName());
		}
	}

}
