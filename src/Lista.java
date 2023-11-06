import java.util.Random;

public class Lista {
    private int[] lista;
    private int tamanho;

    private int passo =0;
    private int trocas =0;

    public Lista(int tamanho,int seed){
        this.lista = new int[tamanho];
        this.tamanho = tamanho;
        Random rd = new Random(seed);
        for(int i=0;i<tamanho;i++){
            lista[i]= rd.nextInt(9999);
        }
    }

    public int getPasso() {
        return passo;
    }

    public int getTrocas() {
        return trocas;
    }

    public void imprimir(){
        for (int i =0;i<tamanho;i++){
            System.out.printf("%7d",lista[i]);
        }
        System.out.println();
    }


    public boolean emOrdem(int[] lista){
        for(int i=0;i<tamanho-1;i++){
            if(lista[i]>lista[i+1]){
                return false;
            }
        }
        return true;
    }

    public void bubbleSort(){
        while(emOrdem(lista)==false){
            for(int i=0;i<tamanho-1;i++){
                if(lista[i]>lista[i+1]){
                    int temp = lista[i];
                    lista[i]=lista[i+1];
                    lista[i+1]=temp;
                    trocas++;
                }
                passo++;
            }
        }
    }

    public void shellSort(){
        for(int incremento = tamanho/2;incremento>0;incremento/=2){
            for (int i = incremento;i<tamanho;i++){
                passo++;
                int temp = lista[i];
                int j;
                for(j=i; j>=incremento && lista[j-incremento]>temp;j-=incremento){
                    lista[j] = lista[j-incremento];
                    trocas++;
                }
                lista[j] = temp;
            }
        }
    }
    public void quickSort(int inferior,int superior){

        if (inferior<superior){
            passo++;
            int indPivo = particao(inferior,superior);
            quickSort(inferior,indPivo-1);
            quickSort(indPivo+1,superior);
        }

    }
    private int particao(int inferior,int superior){
        int pivo = lista[superior];
        int i = inferior -1;
        for (int j = inferior;j<superior;j++){
            if (lista[j]<pivo){
                i++;
                int temp = lista[i];
                lista[i] = lista[j];
                lista[j] = temp;
                trocas++;
            }
            passo++;
        }
        int temp = lista[i+1];
        lista[i+1] = lista[superior];
        lista[superior] = temp;
        trocas++;
        return i+1;
    }

}
