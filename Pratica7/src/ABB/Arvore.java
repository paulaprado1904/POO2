package ABB;

import ABB.No;

public class Arvore<T extends Comparable<T>> {
    private No<T> root;   //raiz

    public Arvore(){
        root= null;
    }

    public boolean vazia(No<T> t){
        return t == null;
    }

    public void insere(T valor){
        No<T> novo = new No<>();         // cria um novo No que será inserido na árvore
        ((No<T>) novo).info = valor;          // atribui o valor passado ao novo nó
        novo.dir = null;
        novo.esq = null;

        if (vazia(this.root)){      // verifica se a árvore é vazia, se sim, o novo nó é a raiz
            this.root = novo;
        }else{          // se não for a raiz
            No<T> atual = root;        // inicia o caminho da árvore. o primeiro nó é a raiz
            No<T> anterior;
            while (true){
                anterior = atual;       // anterior recebe atual, para que atual verifique o próximo valor
                if (valor.compareTo(atual.info) <= 0){       // verifica se o novo valor a ser inserido é menor que a raiz, para determinar o lado a ser percorrido
                    atual = atual.esq;          // atendeu o if, portando o novo nó é menor que a raiz e deve ir para a esquerda
                    if(atual == null){
                        anterior.esq = novo;    // verifica se chegou a uma folha vazia. onde será alocado o novo nó
                        return;
                    }  //fim da condição de ir para a esquerda
                }else {         // vai para a direita, quando 'valor' é maior que a raiz ou nó atual
                    atual = atual.dir;
                    if(atual == null){      // verifica até o nó da direita ser null para ocupar o esta folha
                        anterior.dir = novo;
                        return;
                    }
                }   // fim da condição de ir a direita
            }   // fim do laço while
        }   // fim do else não raiz
    }

    public boolean buscar(T valor) {
        if (vazia(this.root)) {
            System.out.print("A árvore está vazia");
            return false; // se árvore vazia
        }

        No<T> atual = root; // começa a buscar pela raiz
        while (atual != null) {
            int comparacao = valor.compareTo(atual.info);
            if (comparacao == 0) { // Encontrou o valor
                return true;
            } else if (comparacao < 0) { // O valor buscado é menor, busca à esquerda
                atual = atual.esq;
            } else { // O valor buscado é maior, busca à direita
                atual = atual.dir;
            }
        }
        return false; // Não encontrou o valor
    }

    public T remove(T valor) {
        if (root == null) {
            return null;
        }

        No<T> atual = root;
        No<T> pai = root;
        boolean filho_esq = true;

        // Buscando o valor
        while (atual.info.compareTo(valor) != 0) {
            pai = atual;
            if (valor.compareTo(atual.info) < 0) {
                atual = atual.esq;
                filho_esq = true;
            } else {
                atual = atual.dir;
                filho_esq = false;
            }
            if (atual == null) {
                return null;
            }
        }

        // Se passou do while, encontrou o valor
        T valorRemovido = atual.info;

        // Se o nó não possui filhos
        if (atual.esq == null && atual.dir == null) {
            if (atual == root) {
                root = null;
            } else if (filho_esq) {
                pai.esq = null;
            } else {
                pai.dir = null;
            }
        }

        // Se o nó possui apenas um filho à direita
        else if (atual.esq == null) {
            if (atual == root) {
                root = atual.dir;
            } else if (filho_esq) {
                pai.esq = atual.dir;
            } else {
                pai.dir = atual.dir;
            }
        }

        // Se o nó possui apenas um filho à esquerda
        else if (atual.dir == null) {
            if (atual == root) {
                root = atual.esq;
            } else if (filho_esq) {
                pai.esq = atual.esq;
            } else {
                pai.dir = atual.esq;
            }
        }

        // Se o nó possui dois filhos
        else {
            No<T> sucessor = no_sucessor(atual);
            if (atual == root) {
                root = sucessor;
            } else if (filho_esq) {
                pai.esq = sucessor;
            } else {
                pai.dir = sucessor;
            }
            sucessor.esq = atual.esq;
        }
        return valorRemovido;
    }

    public No<T> no_sucessor(No<T> apaga) {
        No<T> paidosucessor = apaga;
        No<T> sucessor = apaga;
        No<T> atual = apaga.dir;

        while (atual != null) {
            paidosucessor = sucessor;
            sucessor = atual;
            atual = atual.esq;
        }

        if (sucessor != apaga.dir) {
            paidosucessor.esq = sucessor.dir;
            sucessor.dir = apaga.dir;
        }
        return sucessor;
    }

}


