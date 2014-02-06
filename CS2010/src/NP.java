/**
 * @author Yeap Hooi Tong
 * @matric A0111736
 * @date 03/02/14
 * @desc Class that stores the path encoding information
 */

import java.util.Comparator;

public class NP implements Comparator<NP> {
    // an object describing the vertex label and its path
    private String label;
    private String path;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}