package Main;

import Guis.GuiPlayers;
import Guis.GuiTeams;
import Model.Team;

import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {

        Team team = new Team();
        String[][] paises = team.cargarArchivo("teams.txt");
        String[][] chi = team.cargarArchivoPais("chi.txt");
        String[][] ger = team.cargarArchivoPais("ger.txt");
        String[][] cmr = team.cargarArchivoPais("cmr.txt");
        String[][] aus = team.cargarArchivoPais("aus.txt");

        SwingUtilities.invokeLater(() -> new GuiTeams(paises,aus,cmr, chi,ger));
    }
}