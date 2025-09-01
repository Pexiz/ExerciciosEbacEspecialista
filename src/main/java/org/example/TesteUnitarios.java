package org.example;

public class TesteUnitarios {
    
    int adicionar(int a, int b)
    {
      return a + b;
    }
    
    int subtrair(int a, int b) {
        if (a > b) {
            return a - b;
        }
        
        throw new ArithmeticException("Subtração negativa não permitida");

    }

    int multiplicar ( int a, int b)
    {
    return a * b;
    }
    
    int dividir(int a, int b) {
        if (b == 0 || a == 0) {
            throw new ArithmeticException("Divisão por zero não permitida");
        }
        return a / b;
    }

    // O codigo ja é altamente explicativo entao nesse caso nao é necesario documentar por ser coisas bem triviais é facil lembrar e fazer
}
