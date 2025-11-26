package structures;

public class HashTable {

    private BinaryTree[] table;
    private final int size = 26; // A-Z

    public HashTable() {
        table = new BinaryTree[size];
        for (int i = 0; i < size; i++) {
            table[i] = new BinaryTree(); // initialize each bucket
        }
    }

    private int hashFunction(String word) {
        char c = Character.toLowerCase(word.charAt(0));
        return c - 'a';  // 'a' = 0 ... 'z' = 25
    }


    public void insert(String word, int line) {
        int index = hashFunction(word);

        Word existentWord = this.search(word);
        if(existentWord == null){
            Word w = new Word(word);
            w.addOccurrence(line);

            table[index].insert(w); //BST
        }else{
            existentWord.addOccurrence(line);
        }

    }

    public Word search(String word) {
        int index = hashFunction(word);
        return table[index].busca(word);
    }

    public void remove(String word) {
        int index = hashFunction(word);
        table[index].remove(word);
    }

    // print em ordem alfabética
    public void print() {
        for (int i = 0; i < size; i++) {
//            System.out.println("\n--- Words starting with '" + (char)('A' + i) + "' ---");
            table[i].printEmOrdem();

        }
    }

    public String inOrder(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
//            System.out.println("\n--- Words starting with '" + (char)('A' + i) + "' ---");
            builder.append(table[i].wordValueInOrder());
        }

        return builder.toString().replaceAll("(?m)^\\s*$\\n?", "");
    }
}

