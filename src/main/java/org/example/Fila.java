package org.example;

public class Fila {
    private int[] elementos;
    private int frente;
    private int tras;
    private int tamanho;
    
    public Fila(int capacidade) {
        elementos = new int[capacidade];
        frente = 0;
        tras = -1;
        tamanho = 0;
    }
    /**
     * Adiciona um elemento no final da fila (enqueue)
     * Complexidade:
     * Tempo: O(1)
     * Espaço: O(n)
     */
    
    public void enqueue(int valor) {
        if (tamanho == elementos.length) {
            System.out.println("Fila cheia!");
            return;
        }
        tras = (tras + 1) % elementos.length; // posição circular
        elementos[tras] = valor;
        tamanho++;
        System.out.println("Enfileirado: " + valor);
    }
    
    /**
     * Remove e retorna o elemento do início da fila (dequeue)
     * Complexidade:
     * Tempo: O(1)
     * Espaço: O(1) extra
     */
    public int dequeue() {
        if (tamanho == 0) {
            System.out.println("Fila vazia!");
            return -1;
        }
        int valor = elementos[frente];
        frente = (frente + 1) % elementos.length; // posição circular
        tamanho--;
        System.out.println("Removido: " + valor);
        return valor;
    }
    
    /**
     * Retorna o elemento do fim da fila
     * Complexidade:
     * Tempo: O(1)
     */
    public void rear ()
    {
        System.out.println("Fim da fila: " + elementos[tras]);
        
    }
    
    /**
     * Retorna o elemento do início da fila
     * Complexidade:
     * Tempo: O(1)
     */
    public void front ()
    {
        System.out.println("Início da fila: " + elementos[frente]);
        
    }
    
    public void mostrarFila() {
        System.out.print("Fila: ");
        for (int i = 0; i < tamanho; i++) {
            int index = (frente + i) % elementos.length;
            System.out.print(elementos[index] + " ");
        }
        System.out.println();
    }
    
    public boolean isEmpty() {
        return tamanho == 0;
    }
    
    public int size() {
        return tamanho;
    }
}
