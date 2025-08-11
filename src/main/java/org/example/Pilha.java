package org.example;

public class Pilha {
    private int[] elementos;
    private int topo;
    
    // Construtor
    public Pilha() {
        elementos = new int[10];
        topo = -1;
    }
    
    /**
     * Adiciona um elemento no topo da pilha
     * Complexidade:
     * Tempo: O(1) (amortizado se não tiver redimensionamento)
     * Espaço: O(n)
     */
    
    public void push(int valor) {
        if (topo == elementos.length - 1) {
            System.out.println("Pilha cheia!");
            return;
        }
        topo++;
        elementos[topo] = valor;
    }
    
    /**
     * Remove e retorna o elemento do topo da pilha
     * Complexidade:
     * Tempo: O(1)
     * Espaço: O(1) extra
     */
    
    public int pop() {
        if (topo == -1) {
            System.out.println("Pilha vazia!");
            return -1;
        }
        int valor = elementos[topo];
        topo--;
        return valor;
    }
    
    public int top() {
        if (topo == -1) {
            System.out.println("Pilha vazia!");
            return -1;
        }
        return elementos[topo];
    }
    
    public int size() {
        return topo + 1;
    }
    
    public boolean isEmpty()
    {
     if (topo == -1)
     {
         return true;
     }
     return false;
    }
}
