package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TesteUnitariosTest {
    
    int numeroA = 10;
    int numeroB = 20;
    TesteUnitarios teste = new TesteUnitarios();
    
    @Test
    public void testAdicionar() {

        
       int resultado = teste.adicionar(numeroA,numeroB);
       assertEquals(resultado,30);
    
    }
    @Test
      public void deveLancarExcecaoQuandoSubtracaoForNegativa() {
            ArithmeticException ex = assertThrows(
                    ArithmeticException.class,
                    () -> teste.subtrair(numeroA, numeroB)
            );
            assertEquals("Subtração negativa não permitida", ex.getMessage());
        }
        
        @Test
        public void deveFuncionarNormalmenteSubtração()
        {
            int resultado = teste.subtrair(numeroB,numeroA);
            assertEquals(resultado,10);
            
        }
        @Test
    public void testMultiplicar() {
        int resultado = teste.multiplicar(numeroA,numeroB);
        assertEquals(resultado,200);
        
    }
    @Test
    public void DividirComValor0() {
        ArithmeticException ex = assertThrows(
                ArithmeticException.class,() -> teste.dividir(0,numeroB)
        );
        assertEquals("Divisão por zero não permitida", ex.getMessage());
        
    }
    
    @Test
    public void DividirComValorCorreto() {
    int resultado = teste.dividir(20,2);
    
        assertEquals(resultado, 10);
        
    }
    
 

}