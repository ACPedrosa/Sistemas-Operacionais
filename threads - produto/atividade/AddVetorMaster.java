package atividade;

import modelo.AddVetorThread;

public class AddVetorMaster {
    private double vetorA [];
    private double vetorB [];
    private double vetorR [];

    private int numThreads;
    private int tamanho;
    
    private Thread v_threads []; 

    public AddVetorMaster(double vetorA [], double vetorB[], int numThreads){
        this.vetorA = vetorA;
        this.vetorB = vetorB;
        this.numThreads = numThreads;
        this.tamanho = vetorA.length;
    }

    public void calcVetores(){
        int fatia = (int) Math.floor(tamanho/numThreads);
        int extra = tamanho%numThreads;
        int inicio, fim;

        v_threads = new Thread[numThreads];
        vetorR = new double[tamanho];

        for(int i = 0; i < numThreads; i++){
            inicio = calcInicio(i, extra, fatia);
            fim = calcFim(i, extra, fatia, inicio);
            
            v_threads[i] = new Thread(new AddVetorThread(vetorA, vetorB, vetorR, inicio, fim, i));
            v_threads[i].start();
        }
    }

    public double [] getVetorR(){
        // Esperar todas as threads finalizarem
        joinThreads();
        return vetorR;
    }

    private void joinThreads(){ //estudar como o join funciona, avaliação preguiçosa na CPU: pesquisar
        try {
            for(int i = 0; i < numThreads; i++) { //um join bloqueia uma thread até que ela seja completa.
                v_threads[i].join(); // Espera que uma thread seja executada por completo
            }
        } catch(InterruptedException e) {
            e.printStackTrace(); //caso não seja realizado, imprime o rastreamento da pilha quando há um erro
        }
    }

    private int calcInicio(int i, int extra, int fatia){
        return (i < extra) ? i * (fatia + 1) : extra * (fatia+1) + (i - extra) * fatia;
    }

    private int calcFim(int i, int extra, int fatia, int t_inicio){
        return (i < extra) ? t_inicio + fatia : t_inicio + fatia - 1;
    }


}
