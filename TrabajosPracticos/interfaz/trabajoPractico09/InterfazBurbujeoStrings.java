package trabajoPractico09;

public class InterfazBurbujeoStrings {

	public static void main(String[] args) {

		String nombres [] = {"Elo", "Milu", "Maxi", "Lari", "Orne", "Agus"};
		
		for(int i = 1; i < nombres.length; i++) {
			for(int j = 0; j < nombres.length - 1; j++) {
				if(nombres[j].compareTo(nombres[j+1]) > 0) {
					String auxiliar = nombres[j];
					nombres[j] = nombres[j+1];
					nombres[j+1] = auxiliar;
				}
			}
		}
		
		System.out.println("Nombres orneados alfabeticamente");
		for(int i = 0; i < nombres.length; i++) {
			System.out.println(nombres[i]);
		}

	}

}
