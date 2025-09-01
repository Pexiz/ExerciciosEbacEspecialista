package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonaciTest {
    
    @Test
    public void deveRetornarZeroQuandoNZero() {
        int resultado = Fibonaci.encontrarElemento(0);
        assertEquals(0, resultado);
    }
    
    @Test
    public void deveRetornarUmQuandoNUm() {
        int resultado = Fibonaci.encontrarElemento(1);
        assertEquals(1, resultado);
    }
    
    @Test
    public void deveCalcularFibonacciDeDois() {
        int resultado = Fibonaci.encontrarElemento(2);
        assertEquals(1, resultado);
    }
    
    @Test
    public void deveCalcularFibonacciDeTres() {
        int resultado = Fibonaci.encontrarElemento(3);
        assertEquals(2, resultado);
    }
    
    @Test
    public void deveCalcularFibonacciDeCinco() {
        int resultado = Fibonaci.encontrarElemento(5);
        assertEquals(5, resultado);
    }
    
    @Test
    public void deveCalcularFibonacciDeDez() {
        int resultado = Fibonaci.encontrarElemento(10);
        assertEquals(55, resultado);
    }
}
