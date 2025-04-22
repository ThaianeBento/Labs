package Lab1_MaiorPrefixoComum;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

public class Utils {
    private static Random rand = new Random();
    private static final char[] alfabeto = {'A','B','C','D'};

    public static String [] GeradorArrayStrings(int n){
    String [] strings = new String[n];
        String base = gerarStringBase();
        strings[0] = base;

    for (int i = 1; i < n; i++){
        strings[i] = gerarVariacoes(base);
    }
    return strings;
    }

    public static String gerarStringBase(){
        Random rand = new Random();
        int max = 10, min = 5;
        int tamanho = rand.nextInt((max - min) +1) + min;

        StringBuilder sb = new StringBuilder(tamanho);
        for (int i = 0; i < tamanho; i++) {
            char c = alfabeto[rand.nextInt(alfabeto.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public static String gerarVariacoes(String base){
        StringBuilder sb = new StringBuilder(base);
        int len = base.length();

        for (int i = 0; i < len; i++) {
            double prob = (double)(i + 1) / len;
            if (rand.nextDouble() < prob) {
                char novoChar;
                do {
                    novoChar = alfabeto[rand.nextInt(alfabeto.length)];
                } while (novoChar == base.charAt(i));
                sb.setCharAt(i, novoChar);
            }
        }

        return sb.toString();

    }

    public static String [] ordenar (String [] strings){
        Arrays.sort(strings);
        return strings;
    }

    public static int comparaTudo(String[] strings, String pivo){

            int prefComum = -1;
            boolean stop = false;

            for (int i = 0; i <= pivo.length(); i++) {
                if(stop)
                    return prefComum;
                for (String palavra : strings) {
                    if (i >= palavra.length()-1)
                        stop = true;

                    if (pivo.charAt(i) == palavra.charAt(i)) {
                        prefComum = i;
                    } else {
                        prefComum--;
                        return prefComum;
                    }
                }
            }
            return prefComum;
    }

    public static int comparaHeadTail(String [] strings, String pivot){
        String tail = strings[strings.length-1];
        int prefComum = -1;

        for (int i = 0; i < strings[0].length(); i++){

            if (pivot.charAt(i) == tail.charAt(i)){
                prefComum = i;
            }else{
                break;
            }
        }
        return prefComum;
    }

    public static String retorno(int verificacao, String pivo){
        if (verificacao == -1){
            return " ";
        }
        int verificacaoAtualizada = verificacao + 1;
        return pivo.substring(0, verificacaoAtualizada);
    }

    public static <T> T medirTempoExecucaoComRetorno(Supplier<T> metodo) {
        long inicio = System.nanoTime();
        T resultado = metodo.get();
        long fim = System.nanoTime();
        long duracao = fim - inicio;

        System.out.println("Tempo de execução: " + duracao + " ns (" + (duracao / 1000000.0) + " ms)");
        return resultado;
    }

}
