

public class Main {
    public static void main(String[] args) {
        int tamanho = 5000;//50,500,1000,5000,10000
        int seed =81;//24,33,50,12,81
        Lista lista1 = new Lista(tamanho,seed);
        lista1.imprimir();
        long startB = System.nanoTime();
        lista1.bubbleSort();
        long endB = System.nanoTime();
        System.out.println("Tempo de Execução: "+(endB-startB)+" nanosegundos"+"\nNúmero de Trocas: "+lista1.getTrocas()+"\nNumero de Interações: "+lista1.getPasso());
        lista1.imprimir();
        System.out.println();

        Lista lista2 = new Lista(tamanho,seed);
        lista2.imprimir();
        long startS = System.nanoTime();
        lista2.shellSort();
        long endS = System.nanoTime();
        System.out.println("Tempo de Execução: "+(endS-startS)+" nanosegundos"+"\nNúmero de Trocas: "+lista2.getTrocas()+"\nNumero de Interações: "+lista2.getPasso());
        lista2.imprimir();
        System.out.println();

        Lista lista3 = new Lista(tamanho,seed);
        lista3.imprimir();
        long startQ = System.nanoTime();
        lista3.quickSort(0,tamanho-1);
        long endQ = System.nanoTime();
        System.out.println("Tempo de Execução: "+(endQ-startQ)+" nanosegundos"+"\nNúmero de Trocas: "+lista3.getTrocas()+"\nNumero de Interações: "+lista3.getPasso());
        lista3.imprimir();
    }
}

