package Lab4_DiamantesEAreia;

public class Main {
    public static void main(String[] args) {
        String[] linhas = Utils.receberEntradas();

        for (String linha : linhas) {
            int diamantes = Utils.contarDiamantes(linha);
            System.out.println(diamantes);
        }
    }
}
