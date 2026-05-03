import java.util.Scanner;
import java.util.Locale;

public class Agricultor {
    public static void main(String[] args) {
        // Usamos Locale.US para garantir que o Scanner entenda o ponto decimal
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        // Lê a quantidade de casos de teste
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                double temperatura = scanner.nextDouble();
                double umidade = scanner.nextDouble();
                int previsaoChuva = scanner.nextInt();

                // Lógica da Árvore de Decisão:

                // Regra 1: Se tem previsão de chuva (P = 1) -> NÃO REGAR
                if (previsaoChuva == 1) {
                    System.out.println("NAO REGAR");
                }
                else {
                    // Regra 2: Se NÃO tem previsão de chuva (P = 0)

                    // Sub-regra 2.1: Calor extremo (> 30) e solo seco (< 50)
                    if (temperatura > 30.0 && umidade < 50.0) {
                        System.out.println("REGAR");
                    }
                    // Sub-regra 2.2: Todas as outras condições
                    else {
                        System.out.println("NAO REGAR");
                    }
                }
            }
        }
        scanner.close();
    }
}