package structures;

public class Word {
    private String word;
    private LinkedList occurrences;

    public Word(String word){
        this.word = word;
        this.occurrences = new LinkedList();
    }

    public String getWord(){
        return this.word;
    }

    public void addOccurrence(int line) {
        occurrences.insertFinal(line);
    }

    public LinkedList getOccurrences() {
        return this.occurrences;
    }

    @Override
    public String toString() {
        return this.word;
    }
}
