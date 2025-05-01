package Lista03;

public class ListaEncadeada<T> {
    
    private NoLista<T> primeiro;
    
    public ListaEncadeada(){
        primeiro = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }
    
    public void inserir(Object info){
        NoLista novo = new NoLista();
        novo.setInfo((Object[]) info);
        novo.setProximo(primeiro)   ;
        this.primeiro = novo;
        
    }
    
    public boolean estaVazia(){
        
        if (getPrimeiro() == null){
            return true;
            
        } else {
            return false;
        }
                
    }
    
    public NoLista<T> buscar(Object info){
        
        NoLista p = primeiro;
        
        while (p != null){
            if (p.getInfo().equals(info)) {
                return p;
            }
            p = p.getProximo();
        }
        
        return null; 
        
    }
    
    public void retirar(Object info){
        
        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;
        
        do {            
            anterior = p;
            p = p.getProximo();
        } while (p!=null && !p.getInfo().equals(info));
        
        if (p!=null) {
            if (p == primeiro){
                primeiro = p.getProximo();
            }
            
        } else{
            anterior.setProximo(p.getProximo());
        }
    }
    
    public int obterComprimento(){
        int count = 0;
        NoLista<T> p = primeiro;
        
        while (p != null) {
            count++;
            p = p.getProximo();
        }
        return count;
        
    }
    
    public NoLista<T> obterNo(int idx){
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

    
    public String toString() {
        
        String string = "";
    NoLista<T> p = primeiro;

    while (p != null) {
        string += p.getInfo();
        if (p.getProximo() != null) {
            string += ",";
        }
        p = p.getProximo();
    }

    return string;
    
        /*StringBuilder sb = new StringBuilder();
        NoLista<T> p = primeiro;

        while (p != null) {
            sb.append(p.getInfo());
            if (p.getProximo() != null) {
                sb.append(", ");
            }
            p = p.getProximo();
        }
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody */
    }
    
    
    public static void main(String[] args) {
        
    } 
    
}
