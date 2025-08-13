package org.example;

public class FatorialBottomUp {
    public static long fatorial(int n) {
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado = resultado * i;
        }
        return resultado;
    }
    
    public static void main(String[] args) {
        int entrada = 10;
        System.out.println("Bottom-up: " + fatorial(entrada));
    }
    
    
}
