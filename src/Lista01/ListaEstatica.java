package Lista01;

public class ListaEstatica {

    //a) ListaEstatica(): construtor da classe. Deve criar um vetor para guardar os dados e estabelecer que a lista está vazia;

    private int[] info;
    private int tamanho;

    public ListaEstatica(){
        info = new int[10];
    }

    public int getTamanho() {
        return tamanho;
    }
    

    /*
     * b) redimensionar(): este método deverá aumentar a capacidade de armazenamento da lista, criando um novo
        vetor com capacidade de armazenamento expandida em 10 novas posições e copiar os dados do vetor original
        para o novo vetor criado. Por fim, o método redimensionar() deverá assumir que o novo vetor info é o vetor
        recentemente criado;
     */

    public void redimensionar(){
        int[] aux = new int[info.length+10];
        
        for (int i = 0; i < this.getTamanho(); i++) {
            aux[i] = this.info[i];

        }

        this.info = aux;
    }


    /*
     * c) inserir(int): Deve inserir o número fornecido como argumento no vetor encapsulado pela lista. Caso o vetor
        encapsulado info não tenha mais posições livres, deve invocar o método privado redimensionar(), para
        expandir a capacidade de armazenamento da lista;
     */

    public void inserir(int valor){
        if (this.getTamanho() == info.length) {
            this.redimensionar();
            
        }

        /*
         * j) getTamanho(): método getter da variável tamanho;
         */

        info[this.getTamanho()] = valor;
        this.tamanho++;

    }


    /*
     * d) exibir(): Deve exibir o conteúdo armazenado na lista, apresentando na tela o valor do primeiro número até * o último número armazenado, nesta ordem;
     */

     public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print(info[i] + " ");
        }
        System.out.println();
    }


    /*
     * e) buscar(int): Deve procurar se há um número igual ao fornecido como argumento. Caso seja encontrado, este
        método deverá retornar a posição do número no vetor (índice no vetor). Se não for localizado, deverá retornar -1;
     */

     public int buscar(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i] == valor) {
                return i;
            }
        }
        return -1;
    }


    /*
     * f) retirar(int): Deve retirar da lista o dado fornecido como argumento, deslocando todos os elementos das
        posições seguintes, uma posição para esquerda;
     */

     public void retirar(int valor) {
        int pos = buscar(valor);
        if (pos != -1) {
            for (int i = pos; i < tamanho - 1; i++) {
                info[i] = info[i + 1];
            }
            tamanho--;
        }
    }


    /*
     * g) liberar(): Deverá limpar a estrutura de dados de forma que o vetor info seja redimensionado novamente para
        que tenha capacidade de armazenar apenas 10 elementos;
     */

     public void liberar(){
        info = new int[10];
        tamanho = 0;
     }


     /*
      * h) obterElemento(int): este método deverá retornar o número armazenado na posição fornecida como
        argumento. Caso o valor do parâmetro corresponda a uma posição inexistente ou não ocupada, este método
        deverá lançar a exceção IndexOutOfBoundsException.
      */

      public int obterElemento(int posicao){
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição Inválida: " + posicao);
            
        }
        return info[posicao];

      }


      /*
       * i) estaVazia(): este método deverá retornar true se a lista não possuir nenhum dado armazenado e false se a
            lista estiver armazenando algum dado; 
       */

      public boolean estaVazia(){
        if (this.getTamanho() == 0) {
            return true;      
        }
        
        return false;
        
      }


      /*
       * k) toString(): deve retornar os valores armazenados na lista, desde o primeiro até o último, separando-os * por vírgula
       */

       public String toString() {
           
        String string = "";
           for (int i = 0; i < info.length; i++) {
               string += info[i] + ",";
           }
           
           return string;
        /*   
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            sb.append(info[i]);
            if (i < tamanho - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }   */
      }
}       