import java.util.Scanner;

public class suprimentos {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int saldo = 0;
        int menorSaldo = 0;

        for (int i = 0; i < n; i++) {

            int valor = sc.nextInt();

            saldo += valor;

            if (saldo < menorSaldo) {
                menorSaldo = saldo;
            }
        }

        System.out.println(Math.abs(menorSaldo));

        sc.close();
    }
}
