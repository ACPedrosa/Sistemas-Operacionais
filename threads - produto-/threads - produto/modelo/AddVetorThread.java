package modelo;

public class AddVetorThread implements Runnable{
    private double vetorA [];
    private double vetorB [];
    private double vetorR [];

    private int inicio;
    private int fim;
    private int tId;

    public AddVetorThread(double[] vetorA, double [] vetorB, double [] vetorR, int inicio, int fim, int tId){
        this.vetorA = vetorA;
        this.vetorB = vetorB;
        this.vetorR = vetorR;
        this.inicio = inicio;
        this.fim = fim;
        this.tId = tId;
    }

    @Override
    public void run(){ //contém o código que será executado paralelamente quando a thread for iniciada.
        for(int i = inicio; i <= fim; i++){
            vetorR[i] = vetorA[i] * vetorB[i];
        }
    }
}
