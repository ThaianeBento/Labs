package Lab3_JogoBeisebol;

import java.util.ArrayList;

public class Funcoes {
    private ArrayList<Integer> registro = new ArrayList<>();

    public int processarOperacoes(String[] funcoes) {
        for (String dado : funcoes) {
            encaminharFuncao(dado);
        }

        int soma = 0;
        for (int ponto : registro) {
            soma += ponto;
        }
        return soma;
    }

    public void encaminharFuncao(String dado){

            switch(dado){
                case "+":
                    somarUltimosDois();
                    break;
                case "D":
                    dobrarUltimo();
                    break;
                case "C":
                    removerUltimo();
                    break;
                default:
                    adicionarPontuacao(Integer.parseInt(dado));
            }



    }

    private void adicionarPontuacao(int valor) {
        registro.add(valor);
    }

    //Falta validação de um valor existente no registro
    private void removerUltimo() {
        registro.remove(registro.size() - 1);
    }

    //Falta validação de um valor existente no registro
    private void dobrarUltimo() {
        int ultimo = registro.get(registro.size() - 1);
        registro.add(2 * ultimo);
    }

    //Falta validação de dois valores existentes no registro
    private void somarUltimosDois() {
        int tamanho = registro.size();
        int soma = registro.get(tamanho - 1) + registro.get(tamanho - 2);
        registro.add(soma);
    }

}
