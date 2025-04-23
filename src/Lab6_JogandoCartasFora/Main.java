package Lab6_JogandoCartasFora;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            List<Integer> descartadas = Utils.simularDescartes(n);
            int restante = Utils.obterCartaRestante(n);

            System.out.print("Discarte:");
            if (!descartadas.isEmpty()) {
                System.out.print(" " + descartadas.get(0));
                for (int i = 1; i < descartadas.size(); i++) {
                    System.out.print(", " + descartadas.get(i));
                }
            }
            System.out.println();
            System.out.println("Restante: " + restante);
        }

        sc.close();
    }
}
