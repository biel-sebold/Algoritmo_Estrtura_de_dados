package Lista03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ListaEncadeadaTest {

    @Test
    public void teste01_listaVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        assertTrue(lista.estaVazia());
    }

    @Test
    public void teste02_listaNaoVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        assertFalse(lista.estaVazia());
    }

    @Test
    public void teste03_insercaoSimples() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        NoLista<Integer> primeiro = lista.getPrimeiro();
        assertNotNull(primeiro);
        assertEquals(5, primeiro.getInfo());
        assertNull(primeiro.getProximo());
    }

    @Test
    public void teste04_insercaoMultipla() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);

        NoLista<Integer> p = lista.getPrimeiro();
        assertEquals(15, p.getInfo());
        p = p.getProximo();
        assertEquals(10, p.getInfo());
        p = p.getProximo();
        assertEquals(5, p.getInfo());
        assertNull(p.getProximo());
    }

    @Test
    public void teste05_buscaPrimeiraPosicao() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> resultado = lista.buscar(20);
        assertNotNull(resultado);
        assertEquals(20, resultado.getInfo());
    }

    @Test
    public void teste06_buscaMeio() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> resultado = lista.buscar(15);
        assertNotNull(resultado);
        assertEquals(15, resultado.getInfo());
    }

    @Test
    public void teste07_buscaInexistente() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertNull(lista.buscar(50));
    }

    @Test
    public void teste08_remocaoPrimeiroElemento() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(20);
        assertEquals(3, lista.obterComprimento());
        assertNull(lista.buscar(20));
    }

    @Test
    public void teste09_remocaoMeio() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(15);
        assertEquals(3, lista.obterComprimento());
        assertNull(lista.buscar(15));
    }

    @Test
    public void teste10_obterNoPos0() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(20, lista.obterNo(0).getInfo());
    }

    @Test
    public void teste11_obterNoUltimaPosicao() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(5, lista.obterNo(3).getInfo());
    }

    @Test
    public void teste12_obterNoPosicaoInvalida() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertThrows(IndexOutOfBoundsException.class, () -> lista.obterNo(10));
    }

    @Test
    public void teste13_comprimentoListaVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        assertEquals(0, lista.obterComprimento());
    }

    @Test
    public void teste14_comprimentoListaNaoVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(4, lista.obterComprimento());
    }
}
