package org.example;

public class HashMap10 {
    
        private static final int CAPACIDADE = 10;
        
        private final int[] estados = new int[CAPACIDADE];
        private final int[] chaves  = new int[CAPACIDADE];
        private final int[] valores = new int[CAPACIDADE];
        private int tamanho = 0;
        
        private int hash(int key) {
            int h = key % CAPACIDADE;
            return (h < 0) ? h + CAPACIDADE : h;
        }
        
        /**
         * put(key, value) → adiciona ou atualiza o par chave/valor
         * Colisão: linear probing
         * Se a chave já existe, atualiza o valor.
         * Se a tabela estiver cheia, lança IllegalStateException.
         */
        
        public void put(int key, int value) {
            if (tamanho == CAPACIDADE) {
                throw new IllegalStateException("Mapa cheio (capacidade fixa = 10).");
            }
            
            int idx = hash(key);
            int primeiroApagado = -1;
            
            // procura posição: ou mesma chave (para atualizar) ou slot livre/apagado
            for (int i = 0; i < CAPACIDADE; i++) {
                int p = (idx + i) % CAPACIDADE;
                
                if (estados[p] == 1) { // ocupado
                    if (chaves[p] == key) {
                        // chave já existe → atualiza
                        valores[p] = value;
                        return;
                    }
                    // senão, continua sondando
                } else if (estados[p] == 2) { // apagado (túmulo)
                    if (primeiroApagado == -1) primeiroApagado = p;
                } else { // estados[p] == 0 (vazio)
                    // podemos inserir aqui
                    if (primeiroApagado != -1) p = primeiroApagado; // reutiliza túmulo
                    estados[p] = 1;
                    chaves[p] = key;
                    valores[p] = value;
                    tamanho++;
                    return;
                }
            }
            
            // se chegou aqui, tenta reutilizar um apagado (caso todos fossem ocupados/apagados)
            if (primeiroApagado != -1) {
                estados[primeiroApagado] = 1;
                chaves[primeiroApagado] = key;
                valores[primeiroApagado] = value;
                tamanho++;
                return;
            }
            
            // tabela realmente cheia (ou muito fragmentada)
            throw new IllegalStateException("Mapa cheio (sem slot disponível).");
        }
        
        /**
         * delete(key) → remove a chave e retorna o valor associado.
         * Se não encontrar, retorna -1.
         */
        public int delete(int key) {
            int idx = hash(key);
            
            for (int i = 0; i < CAPACIDADE; i++) {
                int p = (idx + i) % CAPACIDADE;
                
                if (estados[p] == 0) {
                    // encontramos um slot vazio antes de achar a chave → não existe
                    return -1;
                }
                if (estados[p] == 1 && chaves[p] == key) {
                    // achou
                    int val = valores[p];
                    estados[p] = 2; // marca como apagado (túmulo)
                    tamanho--;
                    return val;
                }
                // se estados[p] == 2 (apagado), continua sondando
            }
            return -1;
        }
        
        
    public int get(int key) {
        int idx = hash(key);
        
        for (int i = 0; i < CAPACIDADE; i++) {
            int p = (idx + i) % CAPACIDADE;
            
            if (estados[p] == 0) return -1; // chave não encontrada
            if (estados[p] == 1 && chaves[p] == key) {
                return valores[p];
            }
        }
        return -1; // não achou
    }
    
    // Novo: remove todos os elementos
    public void clear() {
        for (int i = 0; i < CAPACIDADE; i++) {
            estados[i] = 0;
            chaves[i] = 0;
            valores[i] = 0;
        }
        tamanho = 0;
    }
    
    public int size() { return tamanho; }
    
    public void debugPrint() {
        System.out.println("idx\testado\tchave\tvalor");
        for (int i = 0; i < CAPACIDADE; i++) {
            System.out.printf("%d\t%d\t%d\t%d%n", i, estados[i], chaves[i], valores[i]);
        }
        System.out.println("tamanho=" + tamanho);
    }
    
    public static void main(String[] args) {
        HashMap10 m = new HashMap10();
        m.put(1, 100);
        m.put(11, 1100); // colisão com 1 (mesmo hash)
        m.put(2, 200);
        m.put(12, 1200); // colisão com 2
        
        m.debugPrint();
        
        System.out.println("delete(11) = " + m.delete(11)); // 1100
        System.out.println("delete(99) = " + m.delete(99)); // -1 (não existe)
        
        m.put(21, 2100); // deve reutilizar túmulo do 11
        m.debugPrint();
    }
    }
    