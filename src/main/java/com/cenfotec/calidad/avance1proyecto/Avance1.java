package com.cenfotec.calidad.avance1proyecto;

public class Avance1 {
    
    public static void main(String[] args) {
        Calendario calendario = new Calendario();
        System.out.println(calendario.diaSiguiente(2001,12,31));
        System.out.println(calendario.diaSiguiente(2020,2,28));
        System.out.println(calendario.diaSiguiente(2020,2,29));
        System.out.println(calendario.diaSiguiente(1978,11,30));
        System.out.println(calendario.diaSiguiente(2020,10,31));
    } 
    
}
