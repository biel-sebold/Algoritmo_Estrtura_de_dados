package Lista02;

public class ListaEstatica2<T> {
    private Object[] info;  // Armazena os elementos
    private int tamanho;    // Quantidade de elementos na lista

    public ListaEstatica2() {
        info = new Object[10];  // Inicializa com tamanho 10
        tamanho = 0;
    }

    private void redimensionar() {
        Object[] aux = new Object[info.length + 10];
        for (int i = 0; i < tamanho; i++) {
            aux[i] = info[i];
        }
        info = aux;
    }

    public void inserir(T valor) {
        if (tamanho == info.length) {
            redimensionar();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print(info[i] + " ");
        }
        System.out.println();
    }

    public int buscar(T valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(T valor) {
        int posicao = buscar(valor);
        if (posicao != -1) {
            for (int i = posicao; i < tamanho - 1; i++) {
                info[i] = info[i + 1];
            }
            info[tamanho - 1] = null;
            tamanho--;
        }
    }

    public void liberar() {
        info = new Object[10];
        tamanho = 0;
    }

    public T obterElemento(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida: " + posicao);
        }
        return (T) info[posicao];
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            sb.append(info[i]);
            if (i < tamanho - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    // Implementação do método inverter() sem criar novos arrays
    public void inverter() {
        for (int i = 0; i < tamanho / 2; i++) { //só precisa trocar a primeira metade com a segunda metade — o restante é automaticamente ajustado.
            int j = tamanho - 1 - i; //índice oposto a i no array. (primeiro -> último)
            Object temp = info[i]; //Guarda o valor da posição i numa variável temporária temp
            info[i] = info[j]; //Coloca o valor da posição j na posição i.
            info[j] = temp; //valor original de i (guardado em temp) é colocado na posição j.
        }
    }

    public static void main(String[] args) {
        ListaEstatica2<Integer> lista = new ListaEstatica2<>();
        lista.inserir(50);
        lista.inserir(-15);
        lista.inserir(12);
        lista.inserir(28);
        lista.inserir(91);
        lista.inserir(198);
        lista.inserir(-55);

        System.out.println("Lista original: " + lista);
        lista.inverter();
        System.out.println("Lista invertida: " + lista);
    }
}
