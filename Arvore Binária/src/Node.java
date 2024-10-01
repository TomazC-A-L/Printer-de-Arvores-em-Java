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
}