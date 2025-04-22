package Lab5_ListaDeNomes;

import java.util.*;

public class Utils {
    public static List<List<String>> gerarListasPorTamanho(List<String> nomes) {
        List<List<String>> grupos = new ArrayList<>();

        for (String nome : nomes) {
            boolean encontrado = false;

            for (List<String> grupo : grupos) {
                if (grupo.get(0).length() == nome.length()) {
                    grupo.add(nome);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                List<String> novoGrupo = new ArrayList<>();
                novoGrupo.add(nome);
                grupos.add(novoGrupo);
            }
        }

        grupos.sort(Comparator.comparingInt(g -> g.get(0).length()));

        List<List<String>> resultado = new ArrayList<>();
        boolean nomesRestantes = true;

        while (nomesRestantes) {
            nomesRestantes = false;
            List<String> linha = new ArrayList<>();

            for (List<String> grupo : grupos) {
                if (!grupo.isEmpty()) {
                    linha.add(grupo.remove(0));
                    nomesRestantes = true;
                }
            }

            if (!linha.isEmpty()) {
                resultado.add(linha);
            }
        }

        return resultado;
    }
}
