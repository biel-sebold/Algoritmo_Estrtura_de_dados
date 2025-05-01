package Lista02;

import Lista02.ListaEstatica2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListaEstaticaTest2 {
    
   @Test
    void testInserir() {
        ListaEstatica2<Integer> lista = new ListaEstatica2<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals("5, 10, 15, 20", lista.toString());
    }

    @Test
    void testGetTamanho() {
        ListaEstatica2<Integer> lista = new ListaEstatica2<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(4, lista.getTamanho());
    }

    @Test
    void testBuscarElementoExistente() {
        ListaEstatica2<Integer> lista = new ListaEstatica2<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(2, lista.buscar(15));
    }

    @Test
    void testBuscarElementoInexistente() {
        ListaEstatica2<Integer> lista = new ListaEstatica2<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(-1, lista.buscar(30));
    }

    @Test
    void testRetirar() {
        ListaEstatica2<Integer> lista = new ListaEstatica2<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(10);
        assertEquals("5, 15, 20", lista.toString());
        assertEquals(3, lista.getTamanho());
    }

    @Test
    void testRedimensionamento() {
        ListaEstatica2<Integer> lista = new ListaEstatica2<>();
        for (int i = 1; i <= 15; i++) {
            lista.inserir(i);
        }
        assertEquals("1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15", lista.toString());
        assertEquals(15, lista.getTamanho());
    }

    @Test
    void testObterElemento() {
        ListaEstatica2<Integer> lista = new ListaEstatica2<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(20, lista.obterElemento(3));
    }

    @Test
    void testObterElementoExcecao() {
        ListaEstatica2<Integer> lista = new ListaEstatica2<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertThrows(IndexOutOfBoundsException.class, () -> lista.obterElemento(5));
    }

    @Test
    void testLiberar() {
        ListaEstatica2<Integer> lista = new ListaEstatica2<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.liberar();
        assertTrue(lista.estaVazia());
    }

    @Test
    void testEstaVazia() {
        ListaEstatica2<Integer> lista = new ListaEstatica2<>();
        assertTrue(lista.estaVazia());
    }

    @Test
    void testNaoEstaVazia() {
        ListaEstatica2<Integer> lista = new ListaEstatica2<>();
        lista.inserir(1);
        assertFalse(lista.estaVazia());
    }

    @Test
    void testInverter() {
        ListaEstatica2<Integer> lista = new ListaEstatica2<>();
        lista.inserir(50);
        lista.inserir(-15);
        lista.inserir(12);
        lista.inserir(28);
        lista.inserir(91);
        lista.inserir(198);
        lista.inserir(-55);
        
        lista.inverter();
        
        assertEquals("-55, 198, 91, 28, 12, -15, 50", lista.toString());
    }
    
}
