/**
 * @author Yeap Hooi Tong
 * @matric A0111736
 * @date 03/02/14
 * @desc
 */

import java.util.Comparator;

public class NP implements Comparator<NP> {
    // an object describing the vertex label and its path
    public String label;
    public String path;

    public NP() {
    }

    public NP(String l, String p) {
        label = l;
        path = p;
    }

    public String toString() {
        return new String("(" + label + "," + path + ")");
    }

    public int compare(NP np1, NP np2) {
        return np1.path.length() - np2.path.length();
    }
}