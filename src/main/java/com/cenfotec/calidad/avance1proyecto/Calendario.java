package com.cenfotec.calidad.avance1proyecto;

public class Calendario {

    private final int ANIO_MINIMO = 1582;
    private int[] diasPorMes = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public boolean esBisiesto(int anio) {
        //Un año bisiesto en el calendario gregoriano debe:
        //ser divisible entre 4 sin decimales
        //Si el año es divisible entre 100 también debe ser divisble entre 400 sin decimales
        return anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0);
    }

    public boolean esFechaValida(int anio, int mes, int dia) {
        //fechas válidas en el calendario gregoriano deben cumplir con el número de meses, 
        // días y años bisiestos correctos
        if (anio >= ANIO_MINIMO) {
            if (mes > 0 && mes <= 12) {
                int numeroDeDias = mes == 2 && esBisiesto(anio) ? diasPorMes[mes - 1] + 1 : diasPorMes[mes - 1];
                if (dia > 0 && dia <= numeroDeDias) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[] diaSiguiente(int anio, int mes, int dia) {
        boolean esBisiesto = esBisiesto(anio);
        int diasDelMes = diasPorMes[mes - 1];
        int sigDia = dia, sigMes = mes, sigAnio = anio;

        if (mes == 2 && esBisiesto) {
            diasDelMes++;
        }

        if (dia < diasDelMes) {
            sigDia = dia + 1;
            sigMes = mes;
            sigAnio = anio;
        } else if (dia == diasDelMes) {
            sigDia = 1;

            if (mes == 12) {
                sigMes = 1;
                sigAnio = anio + 1;
            } else {
                sigMes = mes + 1;
                sigAnio = anio;
            }

        }
        
        //retorno en formato tupla
        return new int[] {sigAnio, sigMes, sigDia};
    }

    public int diaSemana(int anio, int mes, int dia) {
        //el cálculo del dia de la semana se hace utilizando el método Key Value
        //los valores de meses y siglos están definidos por Key value
        int[] valoresMeses = {1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};
        boolean esBisiesto = esBisiesto(anio);
        int valorSiglo = 0;
        int diaSemana;

        int resulKeyValue = ((int) (anio % 100) / 4) + (dia + valoresMeses[mes - 1]);

        if (mes == 1 && esBisiesto || mes == 2 && esBisiesto) {
            resulKeyValue -= 1;
        }

        int siglo = Integer.parseInt(Integer.toString(anio).substring(0, 2) + "00");
        int decadaAnio = Integer.parseInt(Integer.toString(anio).substring(2, 4));

        //el calendario gregoriano se repite cada 400 años por eso es necesario
        //sumar o restar hasta encontrar un valor en este rango
        if (siglo < 1700 || siglo > 2099) {
            while (siglo < 1700 || siglo > 2099) {
                if (siglo < 1700) {
                    siglo += 400;
                } else if (siglo > 2099) {
                    siglo -= 400;
                }
            }
        }

        switch (siglo) {
            case 1700:
                valorSiglo = 4;
            case 1800:
                valorSiglo = 2;
            case 1900:
                valorSiglo = 0;
            case 2000:
                valorSiglo = 6;
        }

        resulKeyValue += valorSiglo + decadaAnio;
        resulKeyValue = (int) resulKeyValue % 7;
        diaSemana = resulKeyValue == 0 ? 6 : resulKeyValue - 1;

        return diaSemana;

    }

}
