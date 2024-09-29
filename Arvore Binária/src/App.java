public class App {
    public static void main(String[] args) throws Exception {
        
        Arvore arvore = new Arvore();
        arvore.inserir(new Node(16));
        arvore.inserir(new Node(18));
        arvore.inserir(new Node(17));
        arvore.inserir(new Node(4));
        arvore.inserir(new Node(3));
        arvore.inserir(new Node(10));
        arvore.inserir(new Node(11));
        arvore.inserir(new Node(7));
        arvore.inserir(new Node(6));
        arvore.inserir(new Node(8));
        arvore.inserir(new Node(9));


        Arte.printTree(arvore.root);
        System.out.println("Nodes: "+arvore.contarNodes(arvore.root));
        System.out.println("Nodes nao folhas: "+arvore.contarNaoFolhas(arvore.root));
        System.out.println("Nodes folhas: "+arvore.contarFolhas(arvore.root));
        System.out.println("Altura: "+arvore.altura(arvore.root));
        arvore.posOrdem2(arvore.root);
        System.out.println();
        arvore.posOrdem(arvore.root);
        //arvore.removerPares(arvore.root);


    }
}
