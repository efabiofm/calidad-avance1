package com.cenfotec.calidad.avance1proyecto;

public class Avance1 {
    
    public static void main(String[] args) {
        Calendario calendario = new Calendario();
        System.out.println(calendario.esBisiesto(2000));
        System.out.println(calendario.esBisiesto(2019));
        System.out.println(calendario.esFechaValida(2019,2,29));
        System.out.println(calendario.esFechaValida(2020,2,29));
        System.out.println(calendario.diaSiguiente(2019,2,28));
        System.out.println(calendario.diaSiguiente(2020,2,28));
        System.out.println(calendario.diaSemana(2019,11,24));        
    } 
    
}
