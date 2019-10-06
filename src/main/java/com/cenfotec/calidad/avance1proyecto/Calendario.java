package com.cenfotec.calidad.avance1proyecto;

public class Calendario {
    private final int ANIO_MAXIMO = 1582;
    private int[] diasPorMes = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public boolean esBisiesto(int anio) {
        return anio % 4 == 0 && anio % 100 != 0;
    }
    
    public boolean esFechaValida(int anio, int mes, int dia) {
        if (anio >= ANIO_MAXIMO) {
            if (mes > 0 && mes <= 12) {
                int numeroDeDias = mes == 2 && esBisiesto(anio) ? diasPorMes[mes - 1] + 1 : diasPorMes[mes - 1];
                if (dia > 0 && dia <= numeroDeDias) {
                    return true;
                }
            }
        }
        return false;
    }
}
