package Lab3_JogoBeisebol;

public class Main {
    public static void main(String[] args) {
        String anotacoes = "C";
        String [] funcoes = anotacoes.split(" ");

        Funcoes jogo = new Funcoes();
        int resultado = jogo.processarOperacoes(funcoes);
        System.out.println("Resultado final: " + resultado);
    }
}
