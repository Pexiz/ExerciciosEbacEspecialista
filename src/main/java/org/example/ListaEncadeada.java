package org.example;

public class ListaEncadeada {
    
    // Classe interna para representar o nó
    static class Node {
        int valor;
        Node proximo;
        
        Node(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }
    
    private Node inicio;
    private int tamanho;
    
    public ListaEncadeada() {
        inicio = null;
        tamanho = 0;
    }
    
    /**
     * Adiciona nó no fim da lista (push)
     * Complexidade:
     * Tempo: O(n) — percorre até o último nó
     * Espaço: O(1) extra
     */
    
    public void push(Node node) {
        if (inicio == null) {
            inicio = node;
        } else {
            Node atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = node;
        }
        tamanho++;
    }
    
    /**
     * Remove e retorna o nó do fim da lista (pop)
     * Complexidade:
     * Tempo: O(n) — precisa percorrer até o penúltimo nó
     * Espaço: O(1) extra
     */
    
    public Node pop() {
        if (inicio == null) {
            System.out.println("Lista vazia!");
            return null;
        }
        if (inicio.proximo == null) {
            Node temp = inicio;
            inicio = null;
            tamanho--;
            return temp;
        }
        Node atual = inicio;
        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }
        Node temp = atual.proximo;
        atual.proximo = null;
        tamanho--;
        return temp;
    }
    
    /**
     * Insere nó em índice específico
     * Complexidade:
     * Tempo: O(n)
     */
    public void insert(int index, Node node) {
        if (index < 0 || index > tamanho) {
            System.out.println("Índice inválido!");
            return;
        }
        if (index == 0) {
            node.proximo = inicio;
            inicio = node;
        } else {
            Node atual = inicio;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.proximo;
            }
            node.proximo = atual.proximo;
            atual.proximo = node;
        }
        tamanho++;
    }
    
    /**
     * Remove nó de índice específico
     * Complexidade:
     * Tempo: O(n)
     */
    public void remove(int index) {
        if (index < 0 || index >= tamanho) {
            System.out.println("Índice inválido!");
            return;
        }
        if (index == 0) {
            inicio = inicio.proximo;
        } else {
            Node atual = inicio;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.proximo;
            }
            atual.proximo = atual.proximo.proximo;
        }
        tamanho--;
    }
    
    /**
     * Retorna nó no índice especificado
     * Complexidade:
     * Tempo: O(n)
     */
    public Node elementAt(int index) {
        if (index < 0 || index >= tamanho) {
            System.out.println("Índice inválido!");
            return null;
        }
        Node atual = inicio;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }
        return atual;
    }
    
    /**
     * Retorna tamanho da lista
     * Complexidade:
     * Tempo: O(1)
     */
    public int size() {
        return tamanho;
    }
    
    /**
     * Imprime todos os elementos da lista
     * Complexidade:
     * Tempo: O(n)
     */
    public void printList() {
        Node atual = inicio;
        System.out.print("Lista: ");
        while (atual != null) {
            System.out.print(atual.valor + " -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        
        ListaEncadeada lista = new ListaEncadeada();
        
        // Adicionando no final
        lista.push(new ListaEncadeada.Node(10));
        lista.push(new ListaEncadeada.Node(20));
        lista.push(new ListaEncadeada.Node(30));
        lista.printList(); // 10 -> 20 -> 30 -> null
        
        // Inserindo no índice 1 (entre 10 e 20)
        lista.insert(1, new ListaEncadeada.Node(15));
        lista.printList(); // 10 -> 15 -> 20 -> 30 -> null
        
        // Inserindo no início (índice 0)
        lista.insert(0, new ListaEncadeada.Node(5));
        lista.printList(); // 5 -> 10 -> 15 -> 20 -> 30 -> null
        
        // Removendo do índice 2 (remove o 15)
        lista.remove(2);
        lista.printList(); // 5 -> 10 -> 20 -> 30 -> null
        
        // Pegando elemento no índice 1
        ListaEncadeada.Node elemento = lista.elementAt(1);
        System.out.println("Elemento no índice 1: " + elemento.valor); // 10
        
        // Removendo do final (pop)
        ListaEncadeada.Node removido = lista.pop();
        System.out.println("Removido do final: " + removido.valor); // 30
        lista.printList(); // 5 -> 10 -> 20 -> null
        
        // Mostrando tamanho
        System.out.println("Tamanho da lista: " + lista.size()); // 3
    }
}
