import java.util.Scanner;

public class triangulo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double angulo = sc.nextDouble();

            if (a == 0 && b == 0 && angulo == 0)
                break;

            double rad = Math.toRadians(angulo);

            double area = (a * b * Math.sin(rad)) / 2.0;

            System.out.printf("%.4f\n", area);
        }

        sc.close();
    }
}
