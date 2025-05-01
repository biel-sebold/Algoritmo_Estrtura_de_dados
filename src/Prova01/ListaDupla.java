package Prova01;

import Lista04.*;

public class ListaDupla<T> {
    private NoListaDupla<T> primeiro;

    public ListaDupla() {
        primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(Object info) {
        NoListaDupla<T> novo = new NoListaDupla<>();
        novo.setInfo((Object[]) info);
        novo.setProximo(primeiro);
        if (primeiro != null) {
            primeiro.setAnterior(novo);
        }
        primeiro = novo;
    }

    public NoListaDupla<T> buscar(Object info) {
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            if (atual.getInfo().equals(info)) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void retirar(Object info) {
        NoListaDupla<T> atual = buscar(info);
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

    public ListaDupla<T> clonar() {
        ListaDupla<T> novaLista = new ListaDupla<>();
        NoListaDupla<T> atual = primeiro;

        // Percorre até o final para clonar na ordem correta
        NoListaDupla<T> ultimo = null;
        while (atual != null) {
            ultimo = atual;
            atual = atual.getProximo();
        }

        // Clona da cauda até a cabeça para manter a mesma ordem
        while (ultimo != null) {
            novaLista.inserir(ultimo.getInfo());
            ultimo = ultimo.getAnterior();
        }

        return novaLista;
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

        while (atual.getProximo() != null) {
            atual = atual.getProximo();
        }

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
