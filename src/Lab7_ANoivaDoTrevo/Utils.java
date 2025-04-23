package Lab7_ANoivaDoTrevo;

import java.util.*;

public class Utils {
    public static void executar() {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();

        List<Depoimento> depoimentos = lerDepoimentos(sc, N, M);
        PriorityQueue<Depoimento> filaOrdenada = filtrarEOrdenar(depoimentos, M);
        imprimirDepoimentos(filaOrdenada);
        sc.close();
    }

    public static class Depoimento {
        int tempo;
        int ordemEntrada;
        String nome;

        public Depoimento(int tempo, int ordemEntrada, String nome) {
            this.tempo = tempo;
            this.ordemEntrada = ordemEntrada;
            this.nome = nome;
        }
    }

    public static List<Depoimento> lerDepoimentos(Scanner sc, int N, int M) {
        List<Depoimento> lista = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String linha = sc.nextLine();
            String[] partes = linha.split(" ");
            String hora = partes[0];
            String nome = partes[1];
            int minutosRelativos = converteHoraParaMinutosRelativos(hora);
            lista.add(new Depoimento(minutosRelativos, i, nome));
        }
        return lista;
    }

    public static PriorityQueue<Depoimento> filtrarEOrdenar(List<Depoimento> lista, int M) {
        PriorityQueue<Depoimento> fila = new PriorityQueue<>(new Comparator<Depoimento>() {
            public int compare(Depoimento d1, Depoimento d2) {
                if (d1.tempo != d2.tempo)
                    return Integer.compare(d1.tempo, d2.tempo);
                return Integer.compare(d1.ordemEntrada, d2.ordemEntrada);
            }
        });

        for (Depoimento d : lista) {
            if (estaDentroDoIntervalo(d.tempo, M)) {
                fila.add(d);
            }
        }

        return fila;
    }

    public static void imprimirDepoimentos(PriorityQueue<Depoimento> fila) {
        while (!fila.isEmpty()) {
            System.out.println(fila.poll().nome);
        }
    }

    public static int converteHoraParaMinutosRelativos(String hora) {
        String[] partes = hora.split(":");
        int h = Integer.parseInt(partes[0]);
        int m = Integer.parseInt(partes[1]);
        int total = h * 60 + m;
        if (h < 12) return total;
        return total - 1440;
    }

    public static boolean estaDentroDoIntervalo(int minutos, int intervalo) {
        return minutos >= -intervalo && minutos <= intervalo;
    }

}
