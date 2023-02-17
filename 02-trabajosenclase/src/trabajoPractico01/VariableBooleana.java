package trabajoPractico01;

//Estudiante Eliana Navarro
//Actividad 
//Desarrollar una clase de prueba donde los datos de entrada
//son las dos notas de un alumno y la salida es la condicion del alumno
//La condicion del alumno es Promocionado si ambas notas son mayores o iguales a 7.
//Aprobado si es mayor o igual a 4.
//Desaprobado, si alguna de las notas es menos a 4.

public class VariableBooleana{
  public static void main(String args[]){
      
      int nota1 = 6;
      int nota2 = 3;
      
      boolean promocionado = (nota1 >= 7 && nota2 >=7);
      //boolean aprobado = (nota1 >= 4 && nota2 >= 4);
      boolean aprobado = !promocionado && (nota1 >= 4 && nota2 >= 4);
      boolean desaprobado = (nota1 < 4 || nota2 <4);
      
      System.out.println("Promociona: " + promocionado);
      System.out.println("Aprobado: " + aprobado);
      System.out.println("Desaprueba: " + desaprobado);
      
  }
}
