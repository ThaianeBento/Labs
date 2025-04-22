package Lab2_ComputandoVetores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Utils {
    public static int [] geradorVetor(int n){
        Random rand = new Random();
        int max = 1000, min = 0;
        int [] vetor = new int[n];

        for(int i = 0; i< n; i++){
            vetor[i] = min + rand.nextInt(max-min);
        }
        return vetor;
    }

    public static int [] ordenador (int [] vetor){
        Arrays.sort(vetor);
        return vetor;
    }

    public static int soma(int [] vetor, int min, int max){
        int soma = 0;
        for (int valor: vetor){
            if( valor > min && valor < max){
                soma += valor;
            }
        }
        return soma;
    }

    public static int somaOrdenada(int[] vetor, int min, int max) {
        int inicio = encontrarPrimeiroMaiorQue(vetor, min);
        int fim = encontrarPrimeiroMaiorOuIgual(vetor, max);

        int soma = 0;
        for (int i = inicio; i < fim; i++) {
            soma += vetor[i];
        }

        return soma;
    }

    public static int encontrarPrimeiroMaiorQue(int[] vetor, int min) {
        int esquerda = 0;
        int direita = vetor.length;

        while (esquerda < direita) {
            int meio = (esquerda + direita) / 2;
            if (vetor[meio] <= min) {
                esquerda = meio + 1;
            } else {
                direita = meio;
            }
        }
        return esquerda;
    }

    public static int encontrarPrimeiroMaiorOuIgual(int[] vetor, int max) {
        int esquerda = 0;
        int direita = vetor.length;

        while (esquerda < direita) {
            int meio = (esquerda + direita) / 2;
            if (vetor[meio] < max) {
                esquerda = meio + 1;
            } else {
                direita = meio;
            }
        }

        return esquerda;
    }

    public static int kEsimoElemento(int k, int [] vetor){
        ArrayList<Integer> menores = new ArrayList<>();

        for (int valor : vetor) {
            if (menores.size() < k) {
                menores.add(valor);
            } else {
                int maior = Collections.max(menores);
                if (valor < maior) {
                    menores.remove((Integer) maior);
                    menores.add(valor);
                }
            }
        }
        return Collections.max(menores);

    }

    public static int kEsimoOrdenado (int k, int [] vetor){
        int valor = vetor[k];
        return valor;
    }

}
