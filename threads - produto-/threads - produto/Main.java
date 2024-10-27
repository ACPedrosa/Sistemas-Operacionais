import java.util.Random;

import atividade.AddVetorMaster;

public class Main{
    private static final int TAMANHO = 400000000; // space
    private static final int NTHREADS = 2;

    private static void preencherVetor(double vetor []){
        Random random = new Random();
        for(int i = 0; i < TAMANHO; i++){
            vetor[i] = random.nextDouble()*10;
        }
    }

    private static void imprimirVetor(double vetorR []){
        System.out.print("[ " + vetorR[0] );
        for(int i = 1; i < TAMANHO -1 ; i++){
            System.out.print(" | " + vetorR[i]);
        }
        System.out.println(" | " + vetorR[TAMANHO - 1] + "]");
    }


    public static void main(String[] args) {
        //criar vetores
        double vetorA[] = new double[TAMANHO];
        double vetorB[] = new double[TAMANHO];

        //preencher vetores
        preencherVetor(vetorA);
        preencherVetor(vetorB);

        //instanciar o master
        AddVetorMaster master = new AddVetorMaster(vetorA, vetorB, NTHREADS);

        //executar o master e retorna o tempo de execução
        long startTime = System.nanoTime();
        master.calcVetores();
        long endTime = System.nanoTime();

        long duration = endTime - startTime;

        System.out.println("Tempo de execução em nanosegundos: " + duration);

        //pegar imprimir resultado
        //imprimirVetor(master.getVetorR());
    }
}

