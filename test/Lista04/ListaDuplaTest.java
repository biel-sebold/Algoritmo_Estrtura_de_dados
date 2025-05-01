package Lista04;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListaDuplaTest {
    
    @Test
    void caso1_inclusaoEEncadeamento() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals("20, 15, 10, 5", lista.toString());

        StringBuilder inverso = new StringBuilder();
        NoListaDupla<Integer> atual = lista.getPrimeiro();
        while (atual.getProximo() != null) {
            atual = atual.getProximo();
        }
        while (atual != null) {
            inverso.append(atual.getInfo());
            if (atual.getAnterior() != null) {
                inverso.append(", ");
            }
            atual = atual.getAnterior();
        }
        assertEquals("5, 10, 15, 20", inverso.toString());
    }

    @Test
    void caso2_buscarInicio() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(20, lista.buscar(20).getInfo());
    }

    @Test
    void caso3_buscarMeio() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(10, lista.buscar(10).getInfo());
    }

    @Test
    void caso4_removerInicio() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(20);
        assertEquals("15, 10, 5", lista.toString());
    }

    @Test
    void caso5_removerMeio() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(10);
        assertEquals("20, 15, 5", lista.toString());
    }

    @Test
    void caso6_removerFim() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(5);
        assertEquals("20, 15, 10", lista.toString());
    }

    @Test
    void caso7_liberar() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.liberar();

        assertNull(lista.getPrimeiro());
    }
}
