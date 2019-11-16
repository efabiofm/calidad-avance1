package com.cenfotec.calidad.avance1proyecto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    public void testFechaFutura() {
        Calendario cal = new Calendario();
        assertThrows(IllegalArgumentException.class, () -> cal.fechaFutura(new int[]{2019,2,28}, 0));
        assertThrows(IllegalArgumentException.class, () -> cal.fechaFutura(new int[]{2019,13,32}, 1));
        assertArrayEquals(new int[]{2019, 3, 1}, cal.fechaFutura(new int[]{2019, 2, 28}, 1));
        assertArrayEquals(new int[]{2020, 2, 29}, cal.fechaFutura(new int[]{2020, 2, 28}, 1));
        assertArrayEquals(new int[]{2019, 12, 31}, cal.fechaFutura(new int[]{2019, 12, 30}, 1));
        assertArrayEquals(new int[]{2020, 1, 1}, cal.fechaFutura(new int[]{2019, 12, 31}, 1));
    }
    
    public void testFechaPasada() {
        Calendario cal = new Calendario();
        assertThrows(IllegalArgumentException.class, () -> cal.fechaPasada(new int[]{2019,2,28}, 0));
        assertThrows(IllegalArgumentException.class, () -> cal.fechaPasada(new int[]{2019,13,32}, 1));
        assertArrayEquals(new int[]{2019, 2, 28}, cal.fechaPasada(new int[]{2019, 3, 1}, 1));
        assertArrayEquals(new int[]{2020, 2, 29}, cal.fechaPasada(new int[]{2020, 3, 1}, 1));
        assertArrayEquals(new int[]{2019, 12, 30}, cal.fechaPasada(new int[]{2019, 12, 31}, 1));
        assertArrayEquals(new int[]{2019, 12, 31}, cal.fechaPasada(new int[]{2020, 1, 1}, 1));
    }
}
