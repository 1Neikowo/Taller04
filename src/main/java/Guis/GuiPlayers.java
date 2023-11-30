package Guis;

import Model.Position;
import Model.Team;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GuiPlayers extends VentanaBase {

	private JButton botonBack;
	private JButton botonAceptar;
	private String[][] players;
	private JComboBox comboBoxJugador;
	private JTextField textFieldNombre;
	private JComboBox comboBoxNumero;
	private JButton botonSave;

	public GuiPlayers(String[][] players) {
		super("TEAMS", 500, 520);
		this.players = players;
		generarElementosVentana();
	}
	public void generarElementosVentana() {
		generarBotonIngresar();
		generarComboBoxJugador();
		generarComboBoxNumero();
		generarBotonBack();
	}
	public void generarComboBoxJugador() {
		String textoNombre = "Posición: ";
		super.generarJLabel(textoNombre, 20, 100, 100, 20);
		comboBoxJugador = super.generarLista(Position.values(), 200,100, 100, 20);
		this.add(comboBoxJugador);
	}
	public void generarComboBoxNumero() {
		Integer[] nums = generarLista();
		String textoNombre = "Número: ";
		super.generarJLabel(textoNombre, 20, 150, 100, 20);
		comboBoxNumero = super.generarLista(nums, 200,150, 100, 20);
		this.add(comboBoxNumero);
	}
	public void generarBotonIngresar() {
		botonAceptar = generarBoton("Ingresar", 250, 300, 100, 30);
		this.add(botonAceptar);
		botonAceptar.addActionListener(this);
	}
	public void generarBotonBack() {
		botonBack = generarBoton("Volver", 150, 300, 100, 30);
		this.add(botonBack);
		botonBack.addActionListener(this);
	}
	public void actionPerformed(ActionEvent event){
		if (event.getSource() == botonBack){
			Team team = new Team();
			String[][] paises = team.cargarArchivo("teams.txt");
			String[][] chi = team.cargarArchivoPais("chi.txt");
			String[][] ger = team.cargarArchivoPais("ger.txt");
			String[][] cmr = team.cargarArchivoPais("cmr.txt");
			String[][] aus = team.cargarArchivoPais("aus.txt");

			SwingUtilities.invokeLater(() -> new GuiTeams(paises,aus,cmr, chi,ger));
			this.dispose();
		}
	}
	public Integer[] generarLista() {
		Integer[] nums = new Integer[23];
		for (int i = 0; i <nums.length; i++) {
			nums[i] = i+1;
		}
		return nums;
	}
}