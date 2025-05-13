package Lab8_Recontagem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeitorEntrada {
    public static List<String> lerVotos(){
        Scanner s = new Scanner(System.in);
        List<String> votos = new ArrayList<>();

        while(s.hasNextLine()){
            String linha = s.nextLine();

            if(linha.equals("***"))
                break;

            votos.add(linha);
        }
        return votos;
    }
}
