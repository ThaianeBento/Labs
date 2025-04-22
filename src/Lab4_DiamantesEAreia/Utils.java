package Lab4_DiamantesEAreia;

import java.util.Stack;

public class Utils {
    public static String[] receberEntradas() {
        int n = 4;
        String[] entradas = new String[n];
        entradas[0] = ".<...< <..> >....>....> > >.";
        entradas[1] = "<<<<>>>>";
        entradas[2] = ">>><<<";
        entradas[3] = "<...>><<>...<";

        return entradas;
    }

    public static int contarDiamantes(String linha) {
        Stack<Character> pilha = new Stack<>();
        int contador = 0;

        for (char c : linha.toCharArray()) {
            if (c == '<') {
                pilha.push(c);
            } else if (c == '>') {
                if (!pilha.isEmpty()) {
                    pilha.pop();
                    contador++;
                }
            }
        }

        return contador;
    }

}
