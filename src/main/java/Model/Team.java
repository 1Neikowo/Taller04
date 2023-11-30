package Model;

import Data.DataPlayer;

import javax.swing.*;
import java.util.ArrayList;

public class Team {

	private String nombre;
	private int ranking;
	private String icon;
	private ArrayList<Player> players;
	private DataPlayer gestor;
	public Team(){
		players = new ArrayList<Player>();
		gestor = new DataPlayer();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRanking() {
		return this.ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * 
	 * @param player
	 */
	public void editarPlayer(Player player) {
		gestor.editarPlayerArchivo(player);
	}

	public ArrayList<Player> mostrarPlayers(String nombreArchivo) {
		return gestor.obtenerPlayersArchivo(nombreArchivo);
	}


	public String[][] cargarArchivo(String nombreArchivo) {
		return gestor.cargarArchivoPais(nombreArchivo);
	}
	public String[][] cargarArchivoPais(String nombreArchivo){
		return gestor.cargarArchivoEquipos(nombreArchivo);
	}
}