/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cenfotec.calidad.avance1proyecto;

import static org.junit.jupiter.api.Assertions.*;

public class CalendarioTest {
    
    @org.junit.jupiter.api.Test
    public void testEsBisiesto() {
        Calendario cal = new Calendario();
        assertEquals(true, cal.esBisiesto(2020));
        assertEquals(false, cal.esBisiesto(2019));
    }
    
    public void testEsFechaValida() {
        Calendario cal = new Calendario();
        assertEquals(true, cal.esFechaValida(2019, 10, 13));
        assertEquals(false, cal.esFechaValida(1581, 1, 1));
        assertEquals(false, cal.esFechaValida(2019, 2, 29));
        assertEquals(true, cal.esFechaValida(2020, 2, 29));
        assertEquals(false, cal.esFechaValida(2019, 1, 32));
        assertEquals(false, cal.esFechaValida(2019, 13, 1));
    }
    
    public void testDiaSiguiente() {
        Calendario cal = new Calendario();
        assertEquals("2020 2 29", cal.diaSiguiente(2020, 2, 28));
        assertEquals("2020 3 1", cal.diaSiguiente(2020, 2, 29));
        assertEquals("2019 1 1", cal.diaSiguiente(2018, 12, 31));
    }
    
    public void testDiaSemana() {
        Calendario cal = new Calendario();
        assertEquals(0, cal.diaSemana(2019, 11, 24));
        assertEquals(6, cal.diaSemana(2020, 2, 29));
        assertEquals(5, cal.diaSemana(2019, 3, 1));
    }
}
