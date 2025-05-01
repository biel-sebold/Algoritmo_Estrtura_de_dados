package Lista04;

public class NoListaDupla<T> {
    private Object info;
    private NoListaDupla<T> proximo;
    private NoListaDupla<T> anterior;

    public void setInfo(Object info) {
        this.info = info;
    }

    public Object getInfo() {
        return info;
    }

    public void setProximo(NoListaDupla<T> proximo) {
        this.proximo = proximo;
    }

    public NoListaDupla<T> getProximo() {
        return proximo;
    }

    public void setAnterior(NoListaDupla<T> anterior) {
        this.anterior = anterior;
    }

    public NoListaDupla<T> getAnterior() {
        return anterior;
    }
}
