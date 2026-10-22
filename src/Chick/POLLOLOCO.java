package Chick;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JButton;

public class POLLOLOCO {
	
	private JFrame frmElPolloLoco;
	 JLabel lblLogo; 
	 private JComboBox cmbPollos;
	 private JLabel lblTotal;
	 private JSpinner spnCantidad;
	 private JCheckBox chkFrijoles;
	 private JCheckBox chkPapas;
	 private JCheckBox chkArroz;
	 private JCheckBox chkFlan;
	 private JRadioButton radRefrescoChico;
	 private JRadioButton radAgua;
	 private JRadioButton radRefrescoGrande;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POLLOLOCO window = new POLLOLOCO();
					window.frmElPolloLoco.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
   
	public POLLOLOCO() {
		initialize();
	}
	
	public ImageIcon ajustarImagen(int ancho, int alto,String ruta) {
	    ImageIcon imageIcon = new ImageIcon(getClass().getResource(ruta));
	    Image image = imageIcon.getImage().getScaledInstance(ancho,alto,Image.SCALE_SMOOTH );    
	    ImageIcon icono = new ImageIcon(image);
	    return icono;
	   }
	   
	public void calcularTotal() {
		DecimalFormat df=new DecimalFormat ("0.00");
		double precio=0;
		double precios[]= {169,88,52,47,83,159,235};
		double total=0;
		double cantidad=Double.parseDouble(spnCantidad.getValue().toString());
		precio=precios[cmbPollos.getSelectedIndex()];
		if(chkFrijoles.isSelected())
		total+=22;
		if(chkPapas.isSelected())
		total+=25;
		if(chkArroz.isSelected())
		total+=22;
		if(chkFlan.isSelected())
		total+=25;
		
		if(radAgua.isSelected())
		total+=20;
		if(radRefrescoChico.isSelected())
		total+=30;
		if(radRefrescoGrande.isSelected())
		total+=40;
		total+=precio*cantidad;
		lblTotal.setText("TOTAL A PAGAR > $"+ df.format(total)+ " MXN");
	}

	private void initialize() {
		frmElPolloLoco = new JFrame();
		frmElPolloLoco.setIconImage(Toolkit.getDefaultToolkit().getImage(POLLOLOCO.class.getResource("PolloLoco-removebg-preview.png")));
		frmElPolloLoco.setTitle("EL POLLO LOCO");
		frmElPolloLoco.setBounds(100, 100, 619, 644);
		frmElPolloLoco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmElPolloLoco.setLocationRelativeTo(null);
		frmElPolloLoco.getContentPane().setLayout(null);
		
		 lblLogo = new JLabel("");
		lblLogo.setBounds(25, 31, 181, 189);
		lblLogo.setIcon(ajustarImagen(lblLogo.getWidth(),lblLogo.getHeight(),"PolloLoco-removebg-preview.png"));
		frmElPolloLoco.getContentPane().add(lblLogo);
		
		JLabel Pollo = new JLabel("POLLO");
		Pollo.setForeground(new Color(255, 128, 64));
		Pollo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Pollo.setBounds(216, 31, 74, 14);
		frmElPolloLoco.getContentPane().add(Pollo);
		
		cmbPollos = new JComboBox();
		cmbPollos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularTotal();
			}
		});
		cmbPollos.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmbPollos.setModel(new DefaultComboBoxModel(new String[] {"1 POLLO", "1/2 POLLO", "1/4 PECHUGA Y ALA", "1/4 PIERNA Y MUSLO", "5 PIEZAS", "10 PIEZAS", "15 PIEZAS"}));
		cmbPollos.setBounds(212, 57, 124, 22);
		frmElPolloLoco.getContentPane().add(cmbPollos);
		
		JLabel lblCantidad = new JLabel("CANTIDAD");
		lblCantidad.setForeground(new Color(255, 128, 64));
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidad.setBounds(216, 93, 99, 14);
		frmElPolloLoco.getContentPane().add(lblCantidad);
		
		spnCantidad = new JSpinner();
		spnCantidad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				calcularTotal();
			}
		});
		spnCantidad.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spnCantidad.setBounds(216, 118, 120, 20);
		frmElPolloLoco.getContentPane().add(spnCantidad);
		
		JLabel lblAdicionales = new JLabel("ADICIONALES");
		lblAdicionales.setForeground(new Color(255, 128, 64));
		lblAdicionales.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdicionales.setBounds(216, 159, 130, 14);
		frmElPolloLoco.getContentPane().add(lblAdicionales);
		
		JLabel lblBebidas = new JLabel("BEBIDAS");
		lblBebidas.setForeground(new Color(255, 128, 64));
		lblBebidas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBebidas.setBounds(216, 326, 99, 14);
		frmElPolloLoco.getContentPane().add(lblBebidas);
		
		chkFrijoles = new JCheckBox("Frijoles Charros");
		chkFrijoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularTotal();
			}
		});
		chkFrijoles.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkFrijoles.setBounds(212, 184, 134, 23);
		frmElPolloLoco.getContentPane().add(chkFrijoles);
		
		chkPapas = new JCheckBox("Papas a la Francesa");
		chkPapas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularTotal();
			}
		});
		chkPapas.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkPapas.setBounds(212, 215, 152, 23);
		frmElPolloLoco.getContentPane().add(chkPapas);
		
		chkArroz = new JCheckBox("Arroz");
		chkArroz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularTotal();
			}
		});
		chkArroz.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkArroz.setBounds(212, 252, 124, 23);
		frmElPolloLoco.getContentPane().add(chkArroz);
		
		chkFlan = new JCheckBox("Flan Napolitano");
		chkFlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularTotal();
			}
		});
		chkFlan.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkFlan.setBounds(212, 288, 124, 23);
		frmElPolloLoco.getContentPane().add(chkFlan);
		
		radRefrescoChico = new JRadioButton("Refreco Chico");
		radRefrescoChico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularTotal();
			}
		});
		radRefrescoChico.setFont(new Font("Tahoma", Font.BOLD, 11));
		radRefrescoChico.setBounds(206, 355, 140, 23);
		frmElPolloLoco.getContentPane().add(radRefrescoChico);
		
		radAgua = new JRadioButton("Agua");
		radAgua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularTotal();
			}
		});
		radAgua.setFont(new Font("Tahoma", Font.BOLD, 11));
		radAgua.setBounds(206, 394, 140, 23);
		frmElPolloLoco.getContentPane().add(radAgua);
		
		radRefrescoGrande = new JRadioButton("Refresco Grande");
		radRefrescoGrande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularTotal();
			}
		});
		radRefrescoGrande.setFont(new Font("Tahoma", Font.BOLD, 11));
		radRefrescoGrande.setBounds(206, 431, 140, 23);
		frmElPolloLoco.getContentPane().add(radRefrescoGrande);
		ButtonGroup grupo= new ButtonGroup();
		grupo.add(radAgua);
		grupo.add(radRefrescoChico);
		grupo.add(radRefrescoGrande);
		
		lblTotal = new JLabel("Total a pagar");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotal.setBounds(205, 483, 298, 22);
		frmElPolloLoco.getContentPane().add(lblTotal);
		
		
		JLabel lblLogoPOll = new JLabel("");
		lblLogoPOll.setBounds(383, 45, 120, 93);
		lblLogoPOll.setIcon(ajustarImagen(lblLogoPOll.getWidth(),lblLogoPOll.getHeight(),"/Chick/polloasado.png"));
		frmElPolloLoco.getContentPane().add(lblLogoPOll);
		
		JLabel lblLogoAdicionales = new JLabel("");
		lblLogoAdicionales.setBounds(383, 157, 124, 101);
		lblLogoAdicionales.setIcon(ajustarImagen(lblLogoAdicionales.getWidth(),lblLogoAdicionales.getHeight(),"/Chick/adicionales.png"));
		frmElPolloLoco.getContentPane().add(lblLogoAdicionales);
		
		JLabel lblLogoBebidas = new JLabel("");
		lblLogoBebidas.setBounds(383, 330, 120, 101);
		lblLogoBebidas.setIcon(ajustarImagen(lblLogoBebidas.getWidth(),lblLogoBebidas.getHeight(),"/Chick/bebida.png"));
		frmElPolloLoco.getContentPane().add(lblLogoBebidas);
		
		JButton btnNewButton = new JButton("( BORRAR )");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cmbPollos.setSelectedIndex(0);
				spnCantidad.setValue(1);
				chkFrijoles.setSelected(false);
				chkPapas.setSelected(false);
				chkArroz.setSelected(false);
				chkFlan.setSelected(false);
				grupo.clearSelection();
				lblTotal.setText("TOTAL A PAGAR > $169.00 MXN");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBounds(201, 533, 152, 23);
		frmElPolloLoco.getContentPane().add(btnNewButton);
		calcularTotal();
	}
}
