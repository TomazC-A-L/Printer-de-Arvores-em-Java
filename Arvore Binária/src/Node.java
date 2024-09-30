public class Node {
    int valor;
    Node direita;
    Node esquerda;
    Node prox;

    public Node(int valor){
        this.valor = valor;
        this.direita = null;
        this.esquerda = null;
    }

    public int getValue() {
        return valor;
    }

    public void setValue(int valor) {
        this.valor = valor;
    }

    public Node getRight() {
        return direita;
    }

    public void setRight(Node direita) {
        this.direita = direita;
    }

    public Node getLeft() {
        return esquerda;
    }

    public void setLeft(Node esquerda) {
        this.esquerda = esquerda;
    }

    
}
