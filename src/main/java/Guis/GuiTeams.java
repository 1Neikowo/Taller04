package Guis;

import Model.Pais;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GuiTeams extends VentanaBase {

	private JComboBox comboBoxPais;
	private JButton botonPlayers;
	private JButton botonExit;
	public GuiTeams() {
		super("TEAMS", 500, 520);
		generarElementosVentana();
	}
	public void generarElementosVentana(){
		generarComboBoxPais();
		generarBotonPlayer();
		generarBotonExit();
		generarImagenGer();
		generarImagenAus();
	}
	public void generar
	public void generarComboBoxPais(){
		super.generarJLabel("Pais:", 20, 100, 150, 20);
		comboBoxPais = super.generarLista(Pais.values(), 200, 100, 250, 20);
		comboBoxPais.setSelectedIndex(-1);
		comboBoxPais.addActionListener(this);
		this.setVisible(true);
		this.add(comboBoxPais);
	}
	public void generarBotonPlayer(){
		botonPlayers = generarBoton("Player", 100, 430, 100, 30);
		this.setVisible(true);
		this.add(botonPlayers);
		botonPlayers.addActionListener(this);
	}
	public void generarImagenChile() {
		try {
			BufferedImage imagen = ImageIO.read(new File("../../../resources/images/chi.png"));
			JLabel labelImagen = new JLabel(new ImageIcon(imagen));
			labelImagen.setBounds(250, 50, imagen.getWidth(), imagen.getHeight());
			this.setVisible(true);
			this.add(labelImagen);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void generarImagenGer() {
		try {
			BufferedImage imagen = ImageIO.read(new File("resources/images/ger.png"));
			JLabel labelImagen = new JLabel(new ImageIcon(imagen));
			labelImagen.setBounds(250, 50, imagen.getWidth(), imagen.getHeight());
			this.add(labelImagen);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void generarImagenAus() {
		try {
			BufferedImage imagen = ImageIO.read(new File("src/main/resources/images/aus.png"));
			JLabel labelImagen = new JLabel(new ImageIcon(imagen));
			labelImagen.setBounds(250, 50, imagen.getWidth(), imagen.getHeight());
			this.add(labelImagen);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void generarImagenCmr() {
		try {
			BufferedImage imagen = ImageIO.read(new File("src/main/resources/images/cmr.png"));
			JLabel labelImagen = new JLabel(new ImageIcon(imagen));
			labelImagen.setBounds(250, 50, imagen.getWidth(), imagen.getHeight());
			this.add(labelImagen);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void generarBotonExit(){
		botonExit = generarBoton("Exit", 290, 430, 100, 30);
		this.add(botonExit);
		this.setVisible(true);
		botonExit.addActionListener(this);
	}
	public void actionPerformed(ActionEvent event){
		if (event.getSource() == comboBoxPais){
			if (comboBoxPais.getSelectedItem() == Pais.Chile){
				generarImagenChile();
			}
			if (comboBoxPais.getSelectedItem() == Pais.Germany){
				generarImagenGer();
			}
			if (comboBoxPais.getSelectedItem() == Pais.Australia){
				generarImagenAus();
			}
			if (comboBoxPais.getSelectedItem() == Pais.Cameroon){
				generarImagenCmr();
			}
		}
	}
}