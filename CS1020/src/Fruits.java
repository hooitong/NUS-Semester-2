/**
 * User: Yeap Hooi Tong
 * Date: 3/11/13
 * Time: 11:50 AM
 */
import java.util.*;

public class Fruits implements Comparable<Fruits> {
    protected int _cost;
    protected String _name;

    public Fruits(int cost, String name){
        _cost = cost;
        _name = name;
    }

    public static void main(String[] args){
        Fruits[] storage = new Fruits[4];
        storage[0] = new Fruits(100, "Danana");
        storage[1] = new Fruits(200, "Apple");
        storage[2] = new Fruits(50, "Cake");
        storage[3] = new Fruits(30, "Kute");

        Arrays.sort(storage, Fruits.comp); /* quick sort O(N log N) */

        for(Fruits a : storage){
            System.out.println(a._cost + " " + a._name);
        }
    }

    public static Comparator<Fruits> comp = new Comparator<Fruits>() {
        @Override
        public int compare(Fruits o1, Fruits o2) {
            return o1._name.compareTo(o2._name);
        }
    };

    public int compareTo(Fruits f){
        return f._cost - _cost;
    }
}
