package org.example;

public class Fibonaci {
    
    public static int encontrarElemento(int n) {
        System.out.println("→ entrando F(" + n + ")");
        int res;
        if (n <= 1) {
            res = n;
        } else {
            int a = encontrarElemento(n - 1);
            int b = encontrarElemento(n - 2);
            res = a + b;
            System.out.println("  somando F(" + (n-1) + ")=" + a + " + F(" + (n-2) + ")=" + b + " -> F(" + n + ")=" + res);
        }
        System.out.println("← saindo  F(" + n + ") = " + res);
        return res;
    }
    
    public static void main(String[] args)
    {
        int n = 5;
        System.out.println("Elemento " + n + ":" + encontrarElemento(n));
    }
    
    
}
