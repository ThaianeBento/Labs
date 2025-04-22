package Lab5_ListaDeNomes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String> nomes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nomes.add(sc.nextLine());
        }

        List<List<String>> listasOrdenadas = Utils.gerarListasPorTamanho(nomes);

        for (List<String> linha : listasOrdenadas) {
            System.out.println(String.join(", ", linha));
        }

        sc.close();
    }
}
