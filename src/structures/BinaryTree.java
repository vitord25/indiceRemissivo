package structures;

public class BinaryTree {
    private static class Node {

        public Word word;
        public Node left;
        public Node right;

        public Node(Word word) {
            this.word = word;
            this.left = null;
            this.right = null;
        }
    }

    public Node root;
    public int nElements;

    public BinaryTree() {
        this.root = null;
        this.nElements = 0;
    }

    public int size() {
        return this.nElements;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void printInWidth() {

        DynamicQueue<Node> queue = new DynamicQueue<Node>();

        queue.enfileira(this.root);
        while (!queue.estaVazia()) {

            Node now = queue.desenfileira();

            System.out.print(now.word + " ");

            if (now.left != null) {
                queue.enfileira(now.left);
            }

            if (now.right != null) {
                queue.enfileira(now.right);
            }
        }

        System.out.println();

    }

    public void printPreOrdem() {
        this.preOrdem(this.root);
        System.out.println();
    }

    public void printPosOrdem() {
        this.posOrdem(this.root);
        System.out.println();
    }

    public void printEmOrdem() {
        this.emOrdem(this.root);
        System.out.println();
    }

    public StringBuilder wordValueInOrder(){
        StringBuilder s = new StringBuilder();
        this.inOrderStringBuilder(this.root, s);
        s.append("\n");
        return s;
    }

    public StringBuilder wordValueOccurencesInOrder(){
        StringBuilder s = new StringBuilder();
        this.inOrderValueOccurences(this.root, s);
        return s;
    }

    public void inOrderValueOccurences(Node node, StringBuilder s){
        if(node == null ){
            return;
        }

        this.inOrderValueOccurences(node.left, s);
        s.append(node.word.getWord());
        s.append(" ");
        s.append(node.word.getOccurrences().toString());
        s.append("\n");
        this.inOrderValueOccurences(node.right, s);
    }

    public void inOrderStringBuilder(Node node, StringBuilder s){
        if(node ==null)
            return;

        this.inOrderStringBuilder(node.left, s);
        s.append(node.word.getWord());
        s.append(" ");
        this.inOrderStringBuilder(node.right, s);
    }

    public void preOrdem(Node node) {

        if (node == null)
            return;

        System.out.print(node.word + " ");
        this.preOrdem(node.left);
        this.preOrdem(node.right);
    }

    public void posOrdem(Node node) {

        if (node == null)
            return;

        this.posOrdem(node.left);
        this.posOrdem(node.right);
        System.out.print(node.word + " ");
    }

    public void emOrdem(Node node) {

        if (node == null)
            return;

        this.emOrdem(node.left);
        System.out.print(node.word + " ");
        this.emOrdem(node.right);
    }

    public void insert(Word element) {
        this.root = insertRec(element, this.root);
    }

    private Node insertRec(Word element, Node node) {
        
        if (node == null) {
            this.nElements++;
            return new Node(element);
        }

        int compare = element.getWord().compareTo(node.word.getWord()); //uso do compareTo

        if (compare < 0) {
            node.left = insertRec(element, node.left);
        }

        else if (compare > 0) { // vai pra direita
            node.right = insertRec(element, node.right);
        }

        else {
            return node;
        }

        return node;
    }

    private Node biggestElement(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private Node smallestElement(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void remove(String text) {
        this.root = removeRec(text, this.root);
    }

    private Node removeRec(String text, Node node) {

        if (node == null)
            return null;

        int compare = text.compareTo(node.word.getWord());

        if (compare < 0) {
            node.left = removeRec(text, node.left);
        }

        else if (compare > 0) {
            node.right = removeRec(text, node.right);
        }

        else {

            if (node.left == null) {
                this.nElements--;
                return node.right;
            }

            if (node.right == null) {
                this.nElements--;
                return node.left;
            }

            Node other = smallestElement(node.right);
            node.word = other.word;
            node.right = removeRec(other.word.getWord(), node.right);
        }

        return node;
    }

    public Word busca(String texto) {
        Node node = buscaRec(texto, this.root);

        if(node == null) return null;

        return node.word;
    }

    private Node buscaRec(String texto, Node node) {

        if (node == null)
            return null;

        int cmp = texto.compareTo(node.word.getWord());

        if (cmp < 0)
            return buscaRec(texto, node.left);

        else if (cmp > 0)
            return buscaRec(texto, node.right);

        else
            return node;
    }

    private int altura(Node node) {

        if (node == null) {
            return -1;
        }

        int alturaEsquerda = this.altura(node.left) + 1;
        int alturaDireita = this.altura(node.right) + 1;

        int altura = alturaEsquerda > alturaDireita ? alturaEsquerda : alturaDireita;

        return altura;

    }

    public int altura() {
        return this.altura(this.root);
    }
}
