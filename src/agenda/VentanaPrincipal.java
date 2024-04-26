package agenda;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.PopupMenuUI;
import javax.swing.plaf.basic.BasicPopupMenuUI;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
		
public class VentanaPrincipal extends JFrame { 
                           		  
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Agenda agenda;
	private JTable table;
	private JButton eliminarButton;
	private JButton anadirButton;
	                          	
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
		cargarAgenda();
		setTitle("Agenda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(487, 418);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		anadirButton = new JButton("Añadir");
		anadirButton.setBounds(62, 317, 89, 23);
		anadirButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pulsadoAnadir();
			}
		});
		contentPane.add(anadirButton);
		
		eliminarButton = new JButton("Eliminar");
		eliminarButton.setBounds(326, 317, 89, 23);
		eliminarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pulsadoEliminar();
			}

		
		});
		contentPane.add(eliminarButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 29, 353, 262);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setShowGrid(true);
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getButton() != MouseEvent.BUTTON3) return;
				if(table.getSelectedRow() == -1) return;
				System.out.println(table.getSelectedRow());
				int selectedRow = table.getSelectedRow();
				JPopupMenu pop = new JPopupMenu("hola");
				pop.setSize(500, 500);
				pop.setLocation(e.getXOnScreen(), e.getYOnScreen());
				pop.setInvoker(VentanaPrincipal.this);
				JMenuItem item = new JMenuItem("Eliminar");
				item.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						eliminarContacto(selectedRow);
					}

				});
				pop.add(item);
				pop.setVisible(true);
			}
		});
		scrollPane.setViewportView(table);
		cargarTabla();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				guardarAgenda();
			}
		});
	}

	private void guardarAgenda() {
		// TODO Auto-generated method stub
		try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(new File("src/agenda/agenda.obj")))) {
			stream.writeObject(agenda);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	private void cargarAgenda() {
		// TODO Auto-generated method stub
		/*agenda = new Agenda();
		agenda.add(new Contacto("Carla", 644218903L));
		agenda.add(new Contacto("Amín", 634258905L));
		agenda.add(new Contacto("Cerezo", 144218902L));
		agenda.add(new Contacto("Rumín", 904214803L));
		agenda.add(new Contacto("De Lucas", 664215787L));*/
		agenda = getAgenda();
	}
	
	private Agenda getAgenda() {
		// TODO Auto-generated method stub
		try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(new File("src/agenda/agenda.obj")))) {
			return (Agenda) stream.readObject();
		} catch (FileNotFoundException e) {
			return new Agenda();
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;

	}

	public void cargarTabla() {
		//Crear array para preparar los datos
		Object[][] datos = new Object[agenda.length()][2];
		//Obtener la lista de contactos
		ArrayList<Contacto> contactos = agenda.getListaDeContactos();
		for(int i = 0; i < datos.length; i++) {
			datos[i][0] = contactos.get(i).getNombre();
			datos[i][1] = contactos.get(i).getTelefono();
		}
		table.setModel(new DefaultTableModel(
				datos,
				new String[] {
					"Nombre", "N\u00FAmero"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
	}
	
	public void anadirRow(Object... row) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(row);
	}
	
	public void addContacto(Contacto contacto) {
		agenda.add(contacto);
	}
	
	private void pulsadoAnadir() {
		// TODO Auto-generated method stub
		AnadirDialogo dialogo = new AnadirDialogo(VentanaPrincipal.this, true);
	}
	
	private void pulsadoEliminar() {
		// TODO Auto-generated method stub
		agenda.delete(table.getSelectedRow());
		cargarTabla();
	}
	
	private void eliminarContacto(int row) {
		// TODO Auto-generated method stub
		agenda.delete(row);
		cargarTabla();
	}
}		
		