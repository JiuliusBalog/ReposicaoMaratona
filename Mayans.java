import java.util.Scanner;

public class Mayans {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      while (scanner.hasNextLine()) {
         String line = scanner.nextLine().trim();
         if (line.isEmpty()) continue;

         String[] digits = line.split(" ");

         // Condição de parada e caso especial do zero
         if (digits.length == 1 && digits[0].equals("*")) {
            System.out.println(0);
            break;
         }

         long totalDecimal = 0;
         int n = digits.length;

         // Agora processamos da esquerda para a direita:
         // O primeiro dígito (índice 0) tem a maior potência: 20^(n-1)
         // O último dígito (índice n-1) tem a menor potência: 20^0
         for (int i = 0; i < n; i++) {
            int valueOfDigit = calculateMayanValue(digits[i]);

            // Expoente decrescente: (n - 1 - i)
            int exponent = n - 1 - i;
            totalDecimal += valueOfDigit * Math.pow(20, exponent);
         }

         System.out.println(totalDecimal);

         // Se a linha terminar com o zero maia isolado, encerramos
         if (line.equals("*")) break;
      }

      scanner.close();
   }

   private static int calculateMayanValue(String symbol) {
      if (symbol.equals("*")) return 0;

      int value = 0;
      for (char c : symbol.toCharArray()) {
         if (c == '-') value += 5;
         else if (c == '.') value += 1;
      }
      return value;
   }
}