package examenArtifact;
import java.util.ArrayList;
import java.util.Random;

public class Examen {

	private static ArrayList<String> passwords;
	
	public static ArrayList<String>getPassword() {
		return passwords;
	}

	
	public static void iniciarLista() {
		passwords = new ArrayList<String>();
	}

	
	public static void rellenarLista() {
		for(int i=0; i<33; i++) {
			Random rand = new Random();
			int length = rand.nextInt(3, 10);

			String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" 
			+ "abcdefghijklmnopqrstuvxyz";

			StringBuilder sb = new StringBuilder(length);

			for (int j = 0; j < length; j++) {
				int index = (int) (alfabeto.length() * Math.random());
				sb.append(alfabeto.charAt(index));
			}
			passwords.add(sb.toString());
		}
	}

	
	public static boolean esImpar(int numero) {
		//Antes: return ((numero % 3 == 0));
		 return (numero % 2 != 0);
	}
	
	
	public static String palabraMasLarga() {
		String palabraLarga ="";
		for(String pass: passwords) {
			//Antes: if(palabraLarga.length() > pass.length()) {
			if(palabraLarga.length() < pass.length()) {
				palabraLarga = passwords.get(0);
			}
		}
		return palabraLarga;
		
	}
	
	
	public static double calcularValorPorcentaje(int porcentaje, int total) {
		if(porcentaje > 100) {
			throw new IllegalArgumentException("Porcentaje no debe ser mayor a 100");
		}
		return (double)porcentaje*total/100;
	}
}
