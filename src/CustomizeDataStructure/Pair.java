package CustomizeDataStructure;

public class Pair<F extends Object, S extends Object> {
    private F first;
    private S second;

    public Pair() {
    }

    public F first() {
        return first;
    }

    public S second(){
        return second;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public void setSecond(S second) {
        this.second = second;
    }
}
