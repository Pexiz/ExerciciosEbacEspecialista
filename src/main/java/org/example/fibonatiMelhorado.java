package org.example;

import java.util.HashMap;
import java.util.Map;

public class fibonatiMelhorado {
    
    static Map<Integer, Long> memo = new HashMap<>();
    
    public static long fib(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        long resultado = fib(n - 1) + fib(n - 2);
        memo.put(n, resultado);
        return resultado;
    }
    
    public static void main(String[] args) {
        System.out.println(fib(100));
    }
    
    // Pq melhorado? pq ele vai SALVANDO os numeros que ja foi utilizado         if (memo.containsKey(n)) return memo.get(n); ele olha ja utilizamos o N? se sim qual valor, note se que nao utilizei BIGINTEGER
}

