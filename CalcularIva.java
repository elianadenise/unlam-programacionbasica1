public class CalcularIva{
    public static void main(String args[]){
        //declaración
        float precioPantalon;
        int cantidadDePantalones;

        float resultadoSinIva = 0.0F;
        float resultadoConIva = 0.0F;
        float IVA = 1.21F;

        //entrada
        precioPantalon = 10000F;
        cantidadDePantalones = 5;

        //proceso
        resultadoSinIva = cantidadDePantalones*precioPantalon;
        resultadoConIva = resultadoSinIva*IVA;

        //salida
        System.out.println("El precio total de los pantalones sin IVA es de: $" + resultadoSinIva);
        System.out.println("El precio total de los pantalones con IVA es de: $" + resultadoConIva);


        //CONVERSIONES EXPLICITAS O CASTEO

        float iva = 0.0F; //Conversion explícita
        int alicuotaDeIva = 21;
        int baseImponible = 100;

        iva = (float)((double)alicuotaDeIva)/baseImponible; //Conversion explícita
        System.out.println(iva);

    }

}