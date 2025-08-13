package org.example;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FatorialTopDown {
    static Map<Integer, BigInteger> armazenamento = new HashMap<>();
    
    public static BigInteger fatorial(int n) {
        if (n <= 1) return BigInteger.ONE;
        BigInteger resultado = BigInteger.valueOf(n).multiply(fatorial(n - 1));
        armazenamento.put(n, resultado);
        return resultado;
    }
    
    public static void main(String[] args) {
        int entrada = 100;
        System.out.println("Top-down: " + fatorial(entrada));
    }
    
//    Utilizando como base o BIGINTEGER e em key and value eu consigo sim passar de 100, utilizando o Key And Value Eu armazeno seus valores entao fica armazenamento 5, 120 porem nao é ajuda mas resolvi testar
}
