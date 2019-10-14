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

    }
    
    public void testDiaSiguiente() {
        Calendario cal = new Calendario();
        assertArrayEquals(new int[]{2020, 1, 1}, cal.diaSiguiente(2019, 12, 31));
        assertArrayEquals(new int[]{2019, 3, 1}, cal.diaSiguiente(2019, 2, 28));
        assertArrayEquals(new int[]{2020, 2, 29}, cal.diaSiguiente(2020, 2, 28));
        assertArrayEquals(new int[]{2020, 3, 1}, cal.diaSiguiente(2020, 2, 29));
        assertArrayEquals(new int[]{2020, 2, 1}, cal.diaSiguiente(2020, 1, 31));
        assertArrayEquals(new int[]{2020, 5, 1}, cal.diaSiguiente(2020, 4, 30));
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
    }
}
