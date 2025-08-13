package org.example;

public class Fatorial {
    static int entrada = 3;
    
    public static int fatorial(int n) {
        if (n <= 1) return 1; // caso base
        return n * fatorial(n - 1); // recursão simples
    }
    
    
    
    public static void main(String[] args)
    {
        
        double saida = fatorial(entrada);
        System.out.println("Entrada " + entrada + " Saida " + saida);

    }
    
//    Maximo que consegui foi 20 o numero fica muito grande a nao ser que utilize BigInteger ai da pra ir mais porem demora


}
