package Lista05;

public class PilhaVetor<T> {
    
    private Object info[];
    private int limite;
    private int tamanho;
    
    public PilhaVetor(int limite) {
        this.limite = limite;
        this.info = (T[]) new Object[limite];
        this.tamanho = 0;
        
    }
    
    public void push(Object info){
        if (tamanho == limite) {
            throw new PilhaCheiaException();
        }
        info[tamanho++] = info;
    }
        
    }
    
    public Object pop(){
        
    }
    
    public Object peek(){
        
    }
    
    public boolean estaVazia(){
        
    }
    
    public void liberar(){
        
    }
    
    public String toString(){
        
    }
    
    public void concatenar(PilhaVetor<T> p){
        
    }
    
