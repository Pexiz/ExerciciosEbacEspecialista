package org.example;
import java.util.Arrays;
public class guloso {
    
        /**
         * Retorna as quantidades de cada moeda usadas, alinhadas ao array de moedas (ordenado decrescente).
         * Ex.: quantia=18, moedas={5,2,1} -> retorna {3,1,1} (3x5, 1x2, 1x1).
         */
        
        public static int[] troco(int quantia, int[] moedas) {
            // copia e ordena em ordem decrescente
            int[] moedasOrdenadas = Arrays.copyOf(moedas, moedas.length);
            Arrays.sort(moedasOrdenadas);
            for (int i = 0; i < moedasOrdenadas.length / 2; i++) { // inverte para decrescente
                int tmp = moedasOrdenadas[i];
                moedasOrdenadas[i] = moedasOrdenadas[moedasOrdenadas.length - 1 - i];
                moedasOrdenadas[moedasOrdenadas.length - 1 - i] = tmp;
            }
            
            int[] usados = new int[moedasOrdenadas.length];
            int restante = quantia;
            
            for (int i = 0; i < moedasOrdenadas.length; i++) {
                if (moedasOrdenadas[i] <= 0) continue;
                usados[i] = restante / moedasOrdenadas[i];      // pega o máximo dessa moeda
                restante = restante % moedasOrdenadas[i];       // atualiza o restante
            }
            
            if (restante != 0) {
                throw new IllegalStateException("Não foi possível formar a quantia com as moedas fornecidas.");
            }
            
            // Opcional: imprimir resumo
            System.out.printf("Quantia %d em moedas %s:%n", quantia, Arrays.toString(moedasOrdenadas));
            int totalMoedas = 0;
            for (int i = 0; i < moedasOrdenadas.length; i++) {
                if (usados[i] > 0) {
                    System.out.printf("  %dx de %d%n", usados[i], moedasOrdenadas[i]);
                    totalMoedas += usados[i];
                }
            }
            System.out.println("Total de moedas: " + totalMoedas);
            
            return usados; // alinhado a moedasOrdenadas (ordem decrescente)
        }
        
        // Exemplo de uso
        public static void main(String[] args) {
            int quantia = 18;
            int[] moedas = {5, 2, 1};
            troco(quantia, moedas);  // Saída: 3x5, 1x2, 1x1 (total 5 moedas)
        }
    }
    
