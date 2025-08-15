package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class backtracking {
    
        public static List<List<Integer>> combinarN(List<Integer> S, int n) {
            List<List<Integer>> resultado = new ArrayList<>();
            if (n < 0 || n > S.size()) return resultado; // sem combinações possíveis
            backtrack(S, n, 0, new ArrayList<>(), resultado);
            return resultado;
        }
        
        private static void backtrack(List<Integer> S, int n, int inicio,
                                      List<Integer> atual, List<List<Integer>> res) {
            
            // Se atingiu n elementos, adiciona uma cópia ao resultado
            if (atual.size() == n) {
                res.add(new ArrayList<>(atual));
                return;
            }
            
            // se faltam k elementos e restam menos do que isso, pare
            int faltam = n - atual.size();
            for (int i = inicio; i <= S.size() - faltam; i++) {
                atual.add(S.get(i));               // escolhe
                backtrack(S, n, i + 1, atual, res); // avança
                atual.remove(atual.size() - 1);    // desfaz (backtrack)
            }
        }
        
        public static void main(String[] args) {
            System.out.println(combinarN(Arrays.asList(1,2,3), 2));   // [ [1,2], [1,3], [2,3] ]
            System.out.println(combinarN(Arrays.asList(1,2,3,4), 1)); // [ [1], [2], [3], [4] ]
        }
    }
    

