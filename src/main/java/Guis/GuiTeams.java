package Guis;

import Model.Pais;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GuiTeams extends VentanaBase {

	private JComboBox<Pais> comboBoxPais;
	private JButton botonPlayers;
	private JButton botonExit;

	private JLabel rankingLabel;

	private String[][] aus;
	private String[][] paises;
	private String[][] cmr;
	private String[][] chi;
	private String[][] ger;
	private String[] nombreColumnas = {"Numero", "Nombre","Posición"};

	public GuiTeams(String[][] paises, String[][] aus, String[][] cmr, String[][] chi, String[][] ger) {
		super("TEAMS", 500, 520);
		this.paises = paises;
		this.aus = aus;
		this.cmr = cmr;
		this.chi = chi;
		this.ger = ger;
		generarElementosVentana();
		setVisible(true);
	}
	public void generarElementosVentana() {
		generarComboBoxPais();
		generarLabel();
		generarBotonPlayer();

	}
	public void generarComboBoxPais(){
		super.generarJLabel("País:", 20, 250, 150, 20);
		comboBoxPais = super.generarLista(Pais.values(), 200, 250, 250, 20);
		comboBoxPais.setSelectedIndex(-1);
		comboBoxPais.addActionListener(this);
		this.add(comboBoxPais);
	}
	public void generarLabel(){
		super.generarJLabel("Ranking", 20, 300, 150, 20 );
		rankingLabel = super.generarJLabel("", 200, 300, 150, 20);
	}
	public void generarBotonPlayer(){
		botonPlayers = generarBoton("Players", 250, 100, 100, 30);
		this.add(botonPlayers);
		botonPlayers.addActionListener(this);

	}


	public void actionPerformed(ActionEvent event){
		if(event.getSource() == comboBoxPais){
			if(comboBoxPais.getSelectedItem() == Pais.Chile){
				int ranking = Integer.parseInt(paises[2][2]);
				rankingLabel.setText(String.valueOf(ranking));

			} else if (comboBoxPais.getSelectedItem() == Pais.Australia) {
				int ranking = Integer.parseInt(paises[0][2]);
				rankingLabel.setText(String.valueOf(ranking));

			} else if (comboBoxPais.getSelectedItem() == Pais.Cameroon) {
				int ranking = Integer.parseInt(paises[1][2]);
				rankingLabel.setText(String.valueOf(ranking));

			} else if (comboBoxPais.getSelectedItem() == Pais.Germany) {
				int ranking = Integer.parseInt(paises[3][2]);
				rankingLabel.setText(String.valueOf(ranking));
			}

		} else if (event.getSource() == botonPlayers) {
			Pais paisSeleccionado = (Pais) comboBoxPais.getSelectedItem();
			if (paisSeleccionado != null) {
				realizarAccionSegunPais(paisSeleccionado);
			}
		}
	}
	private void realizarAccionSegunPais(Pais pais) {
		switch (pais) {
			case Chile:
				VentanaTabla tabla = new VentanaTabla(chi, nombreColumnas,"Jugadores");
				break;
			case Cameroon:

				tabla = new VentanaTabla(cmr, nombreColumnas,"Jugadores");
				break;
			case Australia:
				tabla = new VentanaTabla(aus, nombreColumnas,"Jugadores");
				break;
			case Germany:
				tabla = new VentanaTabla(ger, nombreColumnas,"Jugadores");
				break;
			default:

				System.out.println("Acciones predeterminadas o mensaje de error");
		}
	}
}