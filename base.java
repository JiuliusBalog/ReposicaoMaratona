import java.util.Scanner;

public class base {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int ds = sc.nextInt();
        int ys = sc.nextInt();

        int dm = sc.nextInt();
        int ym = sc.nextInt();

        int t1 = ys - ds;
        int t2 = ym - dm;

        int tempo = 0;

        while (true) {

            boolean guarda1 = tempo >= t1 && (tempo - t1) % ys == 0;
            boolean guarda2 = tempo >= t2 && (tempo - t2) % ym == 0;

            if (guarda1 && guarda2) {
                System.out.println(tempo);
                break;
            }

            tempo++;
        }

        sc.close();
    }
}
