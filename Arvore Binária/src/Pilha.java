public class Pilha {
    private Node topo;

    public Pilha( ) {
        this.topo = null;
    }
        
    public boolean vazia( ){
        return (topo == null);
    }

    public void empilhar(Node node){
        node.prox = topo;
        topo = node;
    }

    public Node desempilhar(){
        if(vazia( )){
            System.out.println("\nErr: Nao ha' itens na pilha");
            return null;
        } else {
            Node aux = topo; //aponta pra 1a célula válida
            topo = topo.prox;
            aux.prox = null;
            return aux;
        }
    }
}
