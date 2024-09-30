public class Arvore {
    Node root;
    int quantNodes = 0;
    int quantNaoFolhas = 0;
    int quantFolhas = 0;

    public Arvore(){
        root = null;
    }

    public void inserir(Node node){
        root = inserirNovo(node, root);
    }

    public void emOrdem(Node node) {
        if (node == null)
            return;

        Pilha pilha = new Pilha();
        Node aux = node;

        while (aux != null || !pilha.vazia()){

            while(aux != null){
                pilha.empilhar(aux);
                aux = aux.esquerda;
            }
            aux = pilha.desempilhar();
            System.out.print(aux.valor + " ");

            aux = aux.direita;
        }
    }

    public void preOrdem(Node node) {
        if (node == null)
            return;

        Pilha pilha = new Pilha(); 
        Node aux = node;

        while (aux != null || !pilha.vazia()){

            while(aux != null){
                pilha.empilhar(aux);
                System.out.print(aux.valor + " ");
                aux = aux.esquerda;
            }
            aux = pilha.desempilhar();
            aux = aux.direita;
        }
    }

    public void posOrdem(Node node) {
        if (node == null) {
            return;
        }

        Pilha pilha1 = new Pilha();
        Pilha pilha2 = new Pilha();

        pilha1.empilhar(node);

        while (!pilha1.vazia()) {
            Node aux = pilha1.desempilhar();
            pilha2.empilhar(aux);
            if (aux.esquerda != null) 
                pilha1.empilhar(aux.esquerda);
            

            if (aux.direita != null) 
                pilha1.empilhar(aux.direita);
        }

        while (!pilha2.vazia()) {
            Node aux = pilha2.desempilhar();
            System.out.print(aux.valor + " ");
        }
    }

    private Node inserirNovo(Node node, Node current){
        if(current == null)
            return node;

        if (current.valor > node.valor)
            current.esquerda = inserirNovo(node, current.esquerda);

        else
            current.direita = inserirNovo(node, current.direita);

        return current;
    }

    public Node encontrarElemento(Node current, int value){
        if(current == null) return null; 
        if(value > current.getValue()){
             if(current.getRight() != null){
                  if(current.getRight().getValue() == value){
                       return current;
                  }
             }
        }
        else{
             if(current.getLeft() != null){
                  if(current.getLeft().getValue() == value){
                       return current;
                  }
             }
        }
        if(current.getValue() > value){
             return encontrarElemento(current.getLeft(),value);
        }
        if(current.getValue() < value){
             return encontrarElemento(current.getRight(), value);
        }
        return null;
   }


    public boolean remover(int value) {
        if (root == null) {
            return false; // A árvore está vazia
        }
    
        // Caso em que a raiz é o nó a ser removido
        if (root.getValue() == value) {
            // Se a raiz não tem filhos, simplesmente a remove
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
            } else if (root.getLeft() == null) { // Se não tem filho esquerdo
                root = root.getRight();
            } else if (root.getRight() == null) { // Se não tem filho direito
                root = root.getLeft();
            } else { // Caso com dois filhos
                Node noDadRightLeft = farLeft(root,root.getRight());
                Node substite = noDadRightLeft.getRight();
                substite.setLeft(root.getLeft());
                noDadRightLeft.setLeft(null);
                root = substite; // Substitui a raiz pela substituta
            }
            return true; // A raiz foi removida
        }
    
        // Para outros casos, procure o pai do nó a ser removido
        Node dad = encontrarElemento(root, value);
        if (dad == null) {
            return false; // O valor não foi encontrado
        }
    
        Node noX = (dad.getValue() < value) ? dad.getRight() : dad.getLeft();
    
        // Caso 1: nó sem filhos
        if (noX.getRight() == null && noX.getLeft() == null) {
            if (dad.getValue() < value) {
                dad.setRight(null);
            } else {
                dad.setLeft(null);
            }
            return true;
        }
    
        // Caso 2: um filho
        if (noX.getRight() == null) {
            if (dad.getValue() < value) {
                dad.setRight(noX.getLeft());
            } else {
                dad.setLeft(noX.getLeft());
            }
        } else if (noX.getLeft() == null) {
            if (dad.getValue() < value) {
                dad.setRight(noX.getRight());
            } else {
                dad.setLeft(noX.getRight());
            }
        }
    
        // Caso 3: dois filhos
        if (noX.getRight() != null && noX.getLeft() != null) {
            Node noDadRightLeft = farLeft(noX,noX.getRight());
            Node substite = noDadRightLeft.getLeft();
            noDadRightLeft.setLeft(substite.getRight());
            substite.setRight(noX.getRight());
            substite.setLeft(noX.getLeft());
            noX.setRight(null);
            noX.setLeft(null);
            if (dad.getValue() < value){
                dad.setRight(substite);
            }
            else{
                dad.setLeft(substite);
            }
        }
        return true;
    }

    private Node farLeft (Node pai, Node filho){
        if(filho.esquerda == null)
            return pai;
        
        return farLeft(filho, filho.esquerda);
    }

    public Node pesquisarNode(Node root, int valor){
        if(root == null)
            return null;
        
        if (root.valor < valor)
            return pesquisarNode(root.direita, valor);
        if (root.valor > valor)
            return pesquisarNode(root.esquerda, valor);
        else 
            return root;
    }

    public Node pesquisar(int valor){
        return pesquisarNode(this.root, valor);
    }

    //questao 1
    public int contarNodes(Node root){
        if(root != null){
            quantNodes++;
            contarNodes(root.esquerda);
            contarNodes(root.direita);
        }
        return quantNodes;
    }

    //questao 2
    public int contarNaoFolhas(Node root){
        if(root != null){
            if(root.direita != null || root.esquerda != null){
                quantNaoFolhas++;
                contarNaoFolhas(root.esquerda);
                contarNaoFolhas(root.direita);
            }
        }
        return quantNaoFolhas;
    }

    //questao 3
    public int contarFolhas(Node root){
        if(root != null){
            if(root.direita == null && root.esquerda == null)
                quantFolhas++;
            contarFolhas(root.esquerda);
            contarFolhas(root.direita);
        }
        return quantFolhas;
    }

    //questao 4
    public int altura(Node root) {
        if(this.root == null)
            return 0;
            
        if (root == null)
            return -1;

        return Math.max(altura(root.esquerda),altura(root.direita)) + 1;
    }

    //questao 5
    public void removerPares(Node root){
        if(root != null){
            removerPares(root.esquerda);
            removerPares(root.direita);
            if(root.valor % 2 == 0){
                remover(root.valor);
            }
        } 
    }
    //questao 6
    public void espelhar(Node root){
        if(root != null){
            Node aux = root.direita;
            root.direita = root.esquerda;
            root.esquerda = aux;
        }
    }
}
