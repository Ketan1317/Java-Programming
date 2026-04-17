public class Pair {
    int V;
    int weight;
    
    public Pair(int V,int weight){
        this.V = V;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + V + ", " + weight + ")";
    }
}
