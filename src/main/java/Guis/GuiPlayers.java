package Guis;

import Model.Player;
import Model.Team;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GuiPlayers extends VentanaBase {

	private JButton botonEditPlayer;
	private JButton botonBack;
	private String[][] players;

	public GuiPlayers(String[][] players) {
		super("TEAMS", 500, 520);
		this.players = players;
		generarElementosVentana();
	}
	public void generarElementosVentana() {
		generarBotonIngresar();
		generarTabla();
	}
	public void generarTabla() {
		String[] nombreColumnas = {"Numero", "Nombre","Posición"};
		VentanaTabla tabla = new VentanaTabla(players, nombreColumnas,"Jugadores");
	}
	public void generarBotonIngresar() {
		botonBack = generarBoton("Ingresar", 250, 100, 100, 30);
		this.add(botonBack);
		botonBack.addActionListener(this);
	}
	public void actionPerformed(ActionEvent event){

	}
}