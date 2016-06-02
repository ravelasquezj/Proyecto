package Mundo;

public class Casilla {

	public final static String muro = "./utilidades/imagenes/muro.png";

	public final static String piso = "./utilidades/imagenes/piso.png";

	public final static String llaveRoja = "./utilidades/imagenes/llaveRoja.png";

	public final static String llaveAzul = "./utilidades/imagenes/llaveAzul.png";

	public final static String llaveAmarilla = "./utilidades/imagenes/llaveAmarilla.png";

	public final static String puertaRoja = "./utilidades/imagenes/puertaRoja.png";

	public final static String puertaAzul = "./utilidades/imagenes/puertaAzul.png";

	public final static String puertaAmarilla = "./utilidades/imagenes/puertaAmarilla.png";

	public final static String puertaSalida = "./utilidades/imagenes/puertaSalida.png";

	public final static String diabloRojo = "./utilidades/imagenes/diabloRojo.png";

	public final static String diabloAzul = "./utilidades/imagenes/diabloAzul.png";

	public final static String diabloAmarillo = "./utilidades/imagenes/diabloAmarillo.png";

	public final static String armaRoja = "./utilidades/imagenes/espadaRoja.png";

	public final static String armaAzul = "./utilidades/imagenes/espadaAzul.png";

	public final static String armaAmarilla = "./utilidades/imagenes/espadaAmarilla.png";

	public final static String heroe = "./utilidades/imagenes/heroe.png";

	private String casilla;

	private int cooX;

	private int cooY;

	// -------------------------------------------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------------------------------------------

	/**
	 * Construye una nueva casilla con una imagen, una fila y una columna.
	 * 
	 * pCasilla: Ruta de la imagen de la casilla. pFila: Número que indica la
	 * coordenada en x de la matriz. pColumna: Número que indica la coordenada
	 * en y de la matriz.
	 */
	public Casilla(String pCasilla, int pFila, int pColumna) {
		casilla = pCasilla;
		cooX = pFila;
		cooY = pColumna;
	}

	public String setImagenCasilla() {
		return casilla;
	}

	public int setFila() {
		return cooX;
	}

	public int setColumna() {
		return cooY;
	}

	public boolean esPiso() {
		boolean esPiso = false;
		if (casilla.equals(piso)) {
			esPiso = true;
		}
		return esPiso;
	}

	public boolean esDiablo() {
		boolean esDiablo = false;
		if (casilla.equals(diabloAmarillo) || casilla.equals(diabloAzul) || casilla.equals(diabloRojo)) {
			esDiablo = true;
		}
		return esDiablo;
	}

	public void cambiarImagen(String pNuevaImagen) {
		casilla = pNuevaImagen;
	}

	public boolean permiteAccion() {
		boolean permitir = true;
		if (casilla.equals(piso) || casilla.equals(muro)) {
			permitir = false;
		}
		return permitir;
	}

	public boolean sePuedeGuardar() {
		boolean sePuede = false;
		if (casilla.equals(llaveAmarilla) || casilla.equals(llaveAzul) || casilla.equals(llaveRoja)
				|| casilla.equals(armaAmarilla) || casilla.equals(armaAzul) || casilla.equals(armaRoja)) {
			sePuede = true;
		}
		return sePuede;
	}

	public boolean esPuertaNormal() {
		boolean esPuertaNormal = false;
		if (casilla.equals(puertaAmarilla) || casilla.equals(puertaAzul) || casilla.equals(puertaRoja)) {
			esPuertaNormal = true;
		}
		return esPuertaNormal;
	}
}
