package Lab2_ComputandoVetores;

import static Util.Utils.medirTempoExecucaoComRetorno;

public class Main {

    public static void main(String[] args) {
        caso1();
        caso2();
    }

    public static void caso1(){
       int [] vetor = Utils.geradorVetor(100);
       int max = 788, min = 580, k = 73;
        int resultado = medirTempoExecucaoComRetorno(() ->Utils.soma(vetor, min, max));
        int kEsimo = medirTempoExecucaoComRetorno(() -> Utils.kEsimoElemento(k, vetor));
        System.out.println(resultado + " "+ kEsimo);

    }

    public static void caso2(){
        int [] vetor = Utils.geradorVetor(100);
        int max = 788, min = 580, k = 73;
        int [] vetorOrdenado = medirTempoExecucaoComRetorno(() -> Utils.ordenador(vetor));
        int resultado = medirTempoExecucaoComRetorno(() ->Utils.somaOrdenada(vetorOrdenado, min, max));
        int kEsimo = medirTempoExecucaoComRetorno(() -> Utils.kEsimoOrdenado(k, vetorOrdenado));
        System.out.println(resultado + " "+ kEsimo);
    }
}
