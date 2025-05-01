package Lista04;

public class ListaDupla<T> {
    private NoListaDupla<T> primeiro;

    public ListaDupla() {
        primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoListaDupla<T> novo = new NoListaDupla<>();
        novo.setInfo(valor);
        novo.setProximo(primeiro);
        if (primeiro != null) {
            primeiro.setAnterior(novo);
        }
        primeiro = novo;
    }

    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            if (atual.getInfo().equals(valor)) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void retirar(T valor) {
        NoListaDupla<T> atual = buscar(valor);
        if (atual != null) {
            NoListaDupla<T> anterior = atual.getAnterior();
            NoListaDupla<T> proximo = atual.getProximo();

            if (anterior != null) {
                anterior.setProximo(proximo);
            } else {
                primeiro = proximo;
            }

            if (proximo != null) {
                proximo.setAnterior(anterior);
            }
        }
    }

    public void liberar() {
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            NoListaDupla<T> proximo = atual.getProximo();
            atual.setAnterior(null);
            atual.setProximo(null);
            atual = proximo;
        }
        primeiro = null;
    }

    public void exibirOrdemInversa() {
        NoListaDupla<T> atual = primeiro;
        if (atual == null) return;

        // Vai até o último
        while (atual.getProximo() != null) {
            atual = atual.getProximo();
        }

        // Exibe do último até o primeiro
        while (atual != null) {
            System.out.print(atual.getInfo() + " ");
            atual = atual.getAnterior();
        }
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            sb.append(atual.getInfo());
            if (atual.getProximo() != null) {
                sb.append(", ");
            }
            atual = atual.getProximo();
        }
        return sb.toString();
    }
}
