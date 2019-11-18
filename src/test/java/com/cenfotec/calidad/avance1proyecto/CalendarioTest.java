package com.cenfotec.calidad.avance1proyecto;

import static org.junit.jupiter.api.Assertions.*;

public class CalendarioTest {
    
    @org.junit.jupiter.api.Test
    public void testEsBisiesto() {
        Calendario cal = new Calendario();
        assertEquals(false, cal.esBisiesto(2019));
        assertEquals(true, cal.esBisiesto(2020));
        assertEquals(false, cal.esBisiesto(2021));
        assertEquals(true, cal.esBisiesto(2024));
        assertEquals(false, cal.esBisiesto(1800));
        assertEquals(true, cal.esBisiesto(1600));
        assertEquals(false, cal.esBisiesto(1700));
        assertEquals(false, cal.esBisiesto(1900));
        assertEquals(true, cal.esBisiesto(2000));
        assertEquals(true, cal.esBisiesto(2400));
    }
    
    public void testEsFechaValida() {
        Calendario cal = new Calendario();
        assertEquals(false, cal.esFechaValida(1581, 1, 1));
        assertEquals(true, cal.esFechaValida(1582, 1, 1));
        assertEquals(true, cal.esFechaValida(1583, 1, 1));
        assertEquals(false, cal.esFechaValida(2019, 2, 29));
        assertEquals(true, cal.esFechaValida(2020, 2, 29));
        // Tests adicionales para cubrir los branches no visitados
        assertEquals(false, cal.esFechaValida(2020, 0, 1));
        assertEquals(false, cal.esFechaValida(2020, 13, 1));
        assertEquals(false, cal.esFechaValida(2020, 1, 0));
        assertEquals(false, cal.esFechaValida(2020, 1, 32));
        assertEquals(true, cal.esFechaValida(2020, 1, 31));
    }
    
    public void testDiaSiguiente() {
        Calendario cal = new Calendario();
        assertArrayEquals(new int[]{2020, 1, 1}, cal.diaSiguiente(2019, 12, 31));
        assertArrayEquals(new int[]{2019, 3, 1}, cal.diaSiguiente(2019, 2, 28));
        assertArrayEquals(new int[]{2020, 2, 29}, cal.diaSiguiente(2020, 2, 28));
        assertArrayEquals(new int[]{2020, 3, 1}, cal.diaSiguiente(2020, 2, 29));
        assertArrayEquals(new int[]{2020, 2, 1}, cal.diaSiguiente(2020, 1, 31));
        assertArrayEquals(new int[]{2020, 5, 1}, cal.diaSiguiente(2020, 4, 30));
        // Tests adicionales para cubrir los branches no visitados
        assertArrayEquals(new int[]{2020, 1, 3}, cal.diaSiguiente(2020, 1, 2));
    }
    
    public void testDiaSemana() {
        Calendario cal = new Calendario();
        assertEquals(0, cal.diaSemana(2020, 2, 23));
        assertEquals(1, cal.diaSemana(2020, 2, 24));
        assertEquals(2, cal.diaSemana(2020, 2, 25));
        assertEquals(3, cal.diaSemana(2020, 2, 26));
        assertEquals(4, cal.diaSemana(2020, 2, 27));
        assertEquals(5, cal.diaSemana(2020, 2, 28));
        assertEquals(6, cal.diaSemana(2020, 2, 29));
        // Tests adicionales para cubrir los branches no visitados
        assertEquals(3, cal.diaSemana(2020, 1, 1));
        assertEquals(4, cal.diaSemana(1699, 1, 1));
        assertEquals(5, cal.diaSemana(2100, 1, 1));
        assertEquals(5, cal.diaSemana(1700, 1, 1));
        assertEquals(3, cal.diaSemana(1800, 1, 1));
        assertEquals(1, cal.diaSemana(1900, 1, 1));
        assertEquals(5, cal.diaSemana(2019, 2, 1));
        assertEquals(3, cal.diaSemana(3000, 1, 1));
    }
    
    public void testDiasEntreFechas() {
        Calendario cal = new Calendario();
        int[] fecha1 = {2019, 2, 28};
        int[] fecha2 = {2019, 2, 2};
        int[] fecha3 = {2019, 3, 1};
        int[] fecha4 = {2020, 3, 1};
        int[] fecha5 = {2020, 2, 28};
        int[] fecha6 = {2095, 3, 1};
        int[] fecha7 = {2020, 1, 2};
        int[] fecha8 = {2021, 2, 3};
        assertEquals(0, cal.diasEntreFechas(fecha1, fecha1));
        assertEquals(1, cal.diasEntreFechas(fecha1, fecha3));
        assertEquals(2, cal.diasEntreFechas(fecha5, fecha4));
        assertEquals(2, cal.diasEntreFechas(fecha4, fecha5));
        assertEquals(27395, cal.diasEntreFechas(fecha5, fecha6));
        assertEquals(27395, cal.diasEntreFechas(fecha6, fecha5));
        assertEquals(398, cal.diasEntreFechas(fecha7, fecha8));
        assertEquals(398, cal.diasEntreFechas(fecha8, fecha7));
        assertEquals(26, cal.diasEntreFechas(fecha1, fecha2));
        assertEquals(26, cal.diasEntreFechas(fecha2, fecha1));
    }
}
