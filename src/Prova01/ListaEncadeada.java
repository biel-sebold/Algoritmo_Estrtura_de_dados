package Prova01;

import Lista03.*;

public class ListaEncadeada<T> {

    private NoLista<T> primeiro;

    public ListaEncadeada() {
        primeiro = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(Object info) {
        NoLista<T> novo = new NoLista<>();
        novo.setInfo((Object[]) info);
        novo.setProximo(primeiro);
        this.primeiro = novo;
    }

    public boolean estaVazia() {
        if (getPrimeiro() == null){
            return true;
            
        } else {
            return false;
        }
    }

    public NoLista<T> buscar(Object info) {
        NoLista<T> p = primeiro;

        while (p != null) {
            if (p.getInfo().equals(info)) {
                return p;
            }
            p = p.getProximo();
        }

        return null;
    }

    public void retirar(Object info) {
        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;

        while (p != null && !p.getInfo().equals(info)) {
            anterior = p;
            p = p.getProximo();
        }

        if (p != null) {
            if (p == primeiro) {
                primeiro = p.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
            }
        }
    }

    public int obterComprimento() {
        int count = 0;
        NoLista<T> p = primeiro;

        while (p != null) {
            count++;
            p = p.getProximo();
        }

        return count;
    }

    public NoLista<T> obterNo(int idx) {
        if (idx < 0) {
            throw new IndexOutOfBoundsException();
        }

        NoLista<T> p = primeiro;
        int pos = 0;

        while (p != null && pos < idx) {
            p = p.getProximo();
            pos++;
        }

        if (p == null) {
            throw new IndexOutOfBoundsException();
        }

        return p;
    }

    public ListaEncadeada<T> criarSublista(int inicio, int fim) {
        if (inicio < 0 || fim < 0 || inicio > fim || fim >= obterComprimento()) {
            throw new IndexOutOfBoundsException("Índices inválidos");
        }

        ListaEncadeada<T> novaLista = new ListaEncadeada<>();
        NoLista<T> p = primeiro;
        int i = 0;

        while (p != null) {
            if (i >= inicio && i <= fim) {
                // Inserimos no início da nova lista para manter a ordem original invertida,
                // então depois faremos uma inversão.
                NoLista<T> novo = new NoLista<>();
                novo.setInfo(p.getInfo());
                novo.setProximo(novaLista.primeiro);
                novaLista.primeiro = novo;
            }
            i++;
            p = p.getProximo();
        }

        // Inverter a nova lista para manter a ordem original
        ListaEncadeada<T> ordenada = new ListaEncadeada<>();
        NoLista<T> atual = novaLista.primeiro;
        while (atual != null) {
            ordenada.inserir(atual.getInfo());
            atual = atual.getProximo();
        }

        return ordenada;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoLista<T> p = primeiro;

        while (p != null) {
            sb.append(p.getInfo());
            if (p.getProximo() != null) {
                sb.append(",");
            }
            p = p.getProximo();
        }

        return sb.toString();
    }
}
