package ut.ee382v.parallelalorithms;

/**
 * Created by dinhvan5481 on 6/30/17.
 */
public class ClassDemo {
    public int id;
    public String name;

    public ClassDemo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Class " + id + ": " + name;
    }
}
