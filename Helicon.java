import java.util.Scanner;

public class Helicon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        // Inicializamos com um valor muito baixo ou o primeiro elemento
        long maxGlobal = Long.MIN_VALUE;

        // Testamos todos os possíveis saltos k
        // O enunciado diz 1 <= k <= n/2
        for (int k = 1; k <= n / 2; k++) {
            
            // Para cada salto k, existem 'k' possíveis pontos de início (0 até k-1)
            for (int inicio = 0; inicio < k; inicio++) {
                
                // Agora aplicamos o Algoritmo de Kadane para encontrar a 
                // maior soma de subsegmento dentro desta progressão.
                // Mas atenção: o enunciado implica que a rota pode ser a 
                // sequência inteira com salto k, ou parte dela.
                
                long somaAtual = 0;
                for (int j = inicio; j < n; j += k) {
                    somaAtual += a[j];
                    
                    // Se a soma atual for maior que o que já vimos, atualiza
                    if (somaAtual > maxGlobal) {
                        maxGlobal = somaAtual;
                    }
                    
                    // Se a soma ficar negativa, "resetamos" a busca a partir dali,
                    // pois um valor negativo atrapalharia o próximo elemento.
                    if (somaAtual < 0) {
                        somaAtual = 0;
                    }
                }
            }
        }
        
        // Caso especial: se n for pequeno ou se não entramos no loop de k,
        // verificamos os elementos individuais (caso k não se aplique)
        for (int i = 0; i < n; i++) {
            if (a[i] > maxGlobal) maxGlobal = a[i];
        }

        System.out.println(maxGlobal);
        sc.close();
    }
}
