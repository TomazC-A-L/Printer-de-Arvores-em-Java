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

    public void preOrdem(Node node) {
        if(node != null){
            System.out.println(node.valor+"\n");//raiz
            preOrdem(node.esquerda);//esquerda
            preOrdem(node.direita);//direita
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

    public Node encontrarElemento(Node atual, int valor) {
        if(atual == null) 
            return null;

        if(atual.valor < valor)
            if(atual.direita != null)
                if(atual.direita.valor == valor)
                    return atual;
        
        else 
            if(atual.esquerda != null)
                if(atual.esquerda.valor == valor)
                    return atual;

        if(atual.valor > valor)
            return encontrarElemento(atual.direita, valor);
        else
            return encontrarElemento(atual.direita, valor);
    }


    public boolean remover (int valor) {
        if (root == null)
            return false;
        
        else {
            Node nox; // celula q guarda o valor que estou buscanod
            Node pai; // celula q guarda o pai do nox

            if(root.valor == valor){
                pai = root;
                nox = root;
            } else {
                pai = encontrarElemento(root,valor);

                if(pai.valor < valor) //encontra o Node que tem o valor buscado e atribui ele a nox
                    nox = pai.direita;
                else
                    nox = pai.esquerda;
            }
            if(nox.direita == null && nox.esquerda == null){ /*caso 1*/

                  if(pai.valor < valor)
                    pai.direita = null;
                else 
                    pai.esquerda = null;
            } else { /*caso 3*/

                  if(nox.direita != null && nox.esquerda != null){

                    Node paiFarLeft = farLeft(nox, nox.direita);
                    Node replacer = paiFarLeft.esquerda; 

                    paiFarLeft.esquerda = null;

                    replacer.direita = nox.direita;
                    replacer.esquerda = nox.esquerda;

                    nox.esquerda = null;
                    nox.direita = null;

                    if(pai.valor < valor)
                        pai.direita = replacer;
                    else
                        pai.esquerda = replacer;

                } else { /*caso 2*/
                      if(nox.direita == null)
                        if(pai.valor < nox.valor)
                            pai.direita = nox.esquerda;
                        else
                            pai.esquerda = nox.esquerda;
                        nox.esquerda = null;

                    if(nox.esquerda == null)
                        if(pai.valor > nox.valor)
                            pai.esquerda = nox.direita;
                        else
                            pai.direita = nox.direita;
                        nox.direita = null;
                }
            }
        }
        return false;
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
        if (root == null)
            return 0;
        return 1 + Math.max(altura(root.esquerda), altura(root.direita));
    }

    //questao 5
    public void removerPares(Node root){
        if(root == null)
            return;
        
        if(root.valor % 2 == 0)
            remover(root.valor);
        else{
            return;
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
