package com.cenfotec.calidad.avance1proyecto;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        Calendario calendario = new Calendario();
        
        System.out.println("1. Es bisiesto");
        System.out.println("2. Es fecha válida");
        System.out.println("3. Dia siguiente");
        System.out.println("4. Dia semana");
        System.out.println("Seleccione una opción: ");
        
        int opcion = in.nextInt();
        int anioInput, mesInput, diaInput;
        
        switch(opcion) {
            case 1:
                System.out.println("Ingrese el año: ");
                anioInput = in.nextInt();
                System.out.println(calendario.esBisiesto(anioInput));
                break;
            case 2:
                System.out.println("Ingrese el año: ");
                anioInput = in.nextInt();
                System.out.println("Ingrese el mes: ");
                mesInput = in.nextInt();
                System.out.println("Ingrese el día: ");
                diaInput = in.nextInt();
                System.out.println(calendario.esFechaValida(anioInput, mesInput, diaInput));
                break;
            case 3:
                System.out.println("Ingrese el año: ");
                anioInput = in.nextInt();
                System.out.println("Ingrese el mes: ");
                mesInput = in.nextInt();
                System.out.println("Ingrese el día: ");
                diaInput = in.nextInt();
                int[] resultado = calendario.diaSiguiente(anioInput, mesInput, diaInput);
                System.out.println(imprimirTripletaFecha(resultado));
                break;
            case 4:
                System.out.println("Ingrese el año: ");
                anioInput = in.nextInt();
                System.out.println("Ingrese el mes: ");
                mesInput = in.nextInt();
                System.out.println("Ingrese el día: ");
                diaInput = in.nextInt();
                System.out.println(calendario.diaSemana(anioInput, mesInput, diaInput));
                break;
            default:
                System.out.println("Opción inválida");
        }     
    } 
    
    public static String imprimirTripletaFecha(int[] fecha) {
        return "[" + fecha[0] + ", " + fecha[1] + ", " + fecha[2] + "]";
    }
    
}