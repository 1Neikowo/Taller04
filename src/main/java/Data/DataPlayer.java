package Data;

import Model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataPlayer {

	public boolean existeArchivo(String nombreArchivo) {
		//Se verifica si existe el archivo con el nombre "nombreArchivo"
		File file = new File(nombreArchivo);
		return file.exists();
	}
	public ArrayList<Player> obtenerPlayersArchivo(String nombreArchivo) {
		ArrayList<Player> players = new ArrayList<>();
		if (existeArchivo(nombreArchivo)){
			try {
				BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
				String linea = reader.readLine();
				while (linea != null){
					String[] datos = linea.split(",");
					Player player = new Player(Integer.parseInt(datos[0]), datos[1], datos[2]);
					players.add(player);
					linea = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return players;
	}

	public void editarPlayerArchivo(Player player) {
		// TODO - implement DataPlayer.editarPlayerArchivo
		throw new UnsupportedOperationException();
	}
	private ArrayList<String> leerArchivo(File archivo, String issn, boolean nuevoestado) throws IOException {
		ArrayList<String> lineas = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				lineas.add(actualizarEstado(linea, issn, nuevoestado));
			}
		}
		return lineas;
	}
	private String actualizarEstado(String linea, String issn, boolean nuevoestado) {
		String[] partes = linea.split(",");
		if ((partes[2]).equals(issn)) {
			return partes[0] + "," + partes[1] + "," + partes[2] + "," + partes[3] + ","+nuevoestado;
		} else {
			return linea;
		}
	}
	private void escribirArchivo(File archivo, ArrayList<String> lineas) throws IOException {
		try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
			for (String linea : lineas) {
				pw.println(linea);
			}
		}
	}
	public void obtenerPlayerArchivo(int numero, String nombre, Position position, String nombreArchivo) {
		try {
			File archivo = new File(nombreArchivo);
			List<String> lineas = new ArrayList<>();

			try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
				String linea;
				while ((linea = br.readLine()) != null) {
					String[] partes = linea.split(";");
					if ( Integer.parseInt(partes[0]) == numero) {
						lineas.set(0,String.valueOf(numero));
						lineas.set(1,String.valueOf(nombre));
						lineas.set(2,String.valueOf(position));
					} else {
						lineas.add(linea);
					}
				}
			}

			try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
				for (String linea : lineas) {
					pw.println(linea);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[][] cargarArchivoEquipos(String nombreArchivo){;

		int filas = 23;
		int columnas = 3;

		String[][] datos = new String[filas][columnas];

		try {
			File archivo = new File(nombreArchivo);
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);

			String linea;
			int fila = 0;

			while ((linea = br.readLine()) != null && fila < filas) {

				String[] columnasEnLinea = linea.split(";");


				for (int columna = 0; columna < columnasEnLinea.length && columna < columnas; columna++) {
					datos[fila][columna] = columnasEnLinea[columna];
				}

				fila++;
			}

			br.close();
			return datos;


		} catch (IOException e) {
			e.printStackTrace();
		}return null;
	}
	public String[][] cargarArchivoPais(String nombreArchivo){;

		int filas = 4;
		int columnas = 4;

		String[][] datos = new String[filas][columnas];

		try {
			File archivo = new File(nombreArchivo);
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);

			String linea;
			int fila = 0;

			while ((linea = br.readLine()) != null && fila < filas) {

				String[] columnasEnLinea = linea.split(";");


				for (int columna = 0; columna < columnasEnLinea.length && columna < columnas; columna++) {
					datos[fila][columna] = columnasEnLinea[columna];
				}

				fila++;
			}

			br.close();
			return datos;


		} catch (IOException e) {
			e.printStackTrace();
		}return null;
	}
}

