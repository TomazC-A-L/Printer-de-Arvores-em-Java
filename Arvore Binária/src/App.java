public class App {
    public static void main(String[] args) throws Exception {
        
        Arvore arvore = new Arvore();
        arvore.inserir(new Node(30));
        arvore.inserir(new Node(10));
        arvore.inserir(new Node(20));
        arvore.inserir(new Node(40));
        arvore.inserir(new Node(15));
        arvore.inserir(new Node(8));
        arvore.inserir(new Node(60));
        arvore.inserir(new Node(12));
        arvore.inserir(new Node(35));


        Arte.printTree(arvore.root);
        System.out.println("Nodes: "+arvore.contarNodes(arvore.root));
        System.out.println("Nodes nao folhas: "+arvore.contarNaoFolhas(arvore.root));
        System.out.println("Nodes folhas: "+arvore.contarFolhas(arvore.root));
        System.out.println("Altura: "+arvore.altura(arvore.root));
        arvore.removerPares(arvore.root);
        //Arte.printTree(arvore.root);

    }
}
