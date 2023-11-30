package Guis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaBase extends JFrame implements ActionListener {
	public VentanaBase(String nombre, int largoX, int largoY) {
		super(nombre);
		super.setVisible(true);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setSize(largoX, largoY);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		this.setLayout(null);
	}

	public JButton generarBoton(String text, int locationX, int locationY, int largoX, int largoY) {
			JButton boton = new JButton(text);
			boton.setBounds(locationX, locationY, largoX, largoY);
			boton.setFocusPainted(false);
			this.setVisible(true);
			return boton;
	}

	public JLabel generarJLabel(String texto, int posicionX, int posicionY, int largoX, int largoY) {
		JLabel label = new JLabel(texto);
		label.setBounds(posicionX, posicionY, largoX, largoY);
		this.add(label);
		return label;
	}

	public JComboBox generarLista(Object[] datosLista, int posicionX, int posicionY, int largoX, int largoY) {
		JComboBox lista = new JComboBox(datosLista);
		lista.setBounds(posicionX, posicionY, largoX, largoY);
		return lista;

	}
	public JTextField generarJTextField(int locationX, int locationY, int largoX, int largoY) {
		JTextField textField = new JTextField();
		textField.setBounds(locationX, locationY, largoX, largoY);
		return textField;
	}
	public void actionPerformed(ActionEvent e){
		throw new UnsupportedOperationException("Not supported yet.");
	}

}