package Lab1_MaiorPrefixoComum;

import static Lab1_MaiorPrefixoComum.Utils.*;
import static Util.Utils.medirTempoExecucaoComRetorno;

public class Main {
    public static void main(String[] args) {
        caso1();
        caso2();
    }

    public static void caso1() {
        String[] strings = Utils.GeradorArrayStrings(5);
        String pivot = strings[0];

        int resultado = medirTempoExecucaoComRetorno(() -> comparaTudo(strings,pivot));
        System.out.println(Utils.retorno(resultado,pivot));
    }

    public static void caso2(){
        String[] strings = Utils.GeradorArrayStrings(5);
        Utils.ordenar(strings);

        String pivot = strings[0];
        String tail = strings[strings.length-1];
        int prefComum = -1;

        prefComum = medirTempoExecucaoComRetorno(() ->comparaHeadTail(strings, pivot));
        System.out.println(Utils.retorno(prefComum, pivot));
    }

}