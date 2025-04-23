package Lab6_JogandoCartasFora;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Utils {
    public static List<Integer> simularDescartes(int n) {
        Queue<Integer> fila = new LinkedList<>();
        List<Integer> descartadas = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            fila.add(i);
        }

        while (fila.size() > 1) {
            descartadas.add(fila.poll());

            fila.add(fila.poll());
        }

        return descartadas;
    }

    public static int obterCartaRestante(int n) {
        Queue<Integer> fila = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            fila.add(i);
        }

        while (fila.size() > 1) {
            fila.poll();
            fila.add(fila.poll());
        }

        return fila.peek();
    }
}
