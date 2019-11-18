package com.cenfotec.calidad.avance1proyecto;

public class Calendario {

    private final int ANIO_MINIMO = 1582;
    private final int[] DIAS_POR_MES = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

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
                int numeroDeDias = mes == 2 && esBisiesto(anio) ? DIAS_POR_MES[mes - 1] + 1 : DIAS_POR_MES[mes - 1];
                if (dia > 0 && dia <= numeroDeDias) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[] diaSiguiente(int anio, int mes, int dia) {
        boolean esBisiesto = esBisiesto(anio);
        int diasDelMes = DIAS_POR_MES[mes - 1];
        int sigDia = dia, sigMes = mes, sigAnio = anio;

        if (mes == 2 && esBisiesto) {
            diasDelMes++;
        }

        if (dia < diasDelMes) {
            sigDia = dia + 1;
            sigMes = mes;
            sigAnio = anio;
        } else {
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
                } else {
                    siglo -= 400;
                }
            }
        }

        switch (siglo) {
            case 1700:
                valorSiglo = 4;
                break;
            case 1800:
                valorSiglo = 2;
                break;
            case 1900:
                valorSiglo = 0;
                break;
            case 2000:
                valorSiglo = 6;
                break;
            default:
                break;
        }

        resulKeyValue += valorSiglo + decadaAnio;
        resulKeyValue = (int) resulKeyValue % 7;
        diaSemana = resulKeyValue == 0 ? 6 : resulKeyValue - 1;

        return diaSemana;

    }
    
    public int[] fechaFutura(int[] fechaInicio, int diasFuturo) {
        boolean esFechaValida = esFechaValida(fechaInicio[0], fechaInicio[1], fechaInicio[2]);
        boolean esDiasFuturoValido = diasFuturo > 0;
        if (esFechaValida && esDiasFuturoValido) {
            int anioActual = fechaInicio[0];
            int mesActual = fechaInicio[1];
            int diaActual = fechaInicio[2];
            int contador = diasFuturo;
            while(contador > 0) {
                diaActual += 1;
                if (diaActual > DIAS_POR_MES[mesActual - 1]) {
                    if (mesActual != 2 || !esBisiesto(anioActual)) {
                        diaActual = 1;
                        mesActual += 1;
                        if (mesActual > DIAS_POR_MES.length) {
                            mesActual = 1;
                            anioActual += 1;
                        }
                    }
                }
                contador--;
            }
            return new int[] { anioActual, mesActual, diaActual };
        }
        throw new IllegalArgumentException();
    }
    
    public int[] fechaPasada(int[] fechaInicio, int diasPasado) {
        boolean esFechaValida = esFechaValida(fechaInicio[0], fechaInicio[1], fechaInicio[2]);
        boolean esDiasFuturoValido = diasPasado > 0;
        if (esFechaValida && esDiasFuturoValido) {
            int anioActual = fechaInicio[0];
            int mesActual = fechaInicio[1];
            int diaActual = fechaInicio[2];
            int contador = diasPasado;
            while(contador > 0) {
                diaActual -= 1;
                if (diaActual == 0) {
                    mesActual -= 1;
                    if (mesActual == 0) {
                        mesActual = DIAS_POR_MES.length;
                        anioActual -= 1;
                    }
                    diaActual = DIAS_POR_MES[mesActual - 1];
                    if (mesActual == 2 && esBisiesto(anioActual)) {
                        diaActual += 1;
                    }
                }
                contador--;
            }
            return new int[] { anioActual, mesActual, diaActual };
        }
        throw new IllegalArgumentException();
    }

}
