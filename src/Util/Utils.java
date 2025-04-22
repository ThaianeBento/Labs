package Util;

import java.util.function.Supplier;

public class Utils {
    public static <T> T medirTempoExecucaoComRetorno(Supplier<T> metodo) {
        long inicio = System.nanoTime();
        T resultado = metodo.get();
        long fim = System.nanoTime();
        long duracao = fim - inicio;

        System.out.println("Tempo de execução: " + duracao + " ns (" + (duracao / 1000000.0) + " ms)");
        return resultado;
    }
}
