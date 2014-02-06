/**
 * @author Yeap Hooi Tong
 * @matric A0111736
 * @date 03/02/14
 * @desc Class to test the BinaryTree class
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestBinaryTree {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinaryTree<String> tree = BinaryTree.readBinaryTree1(br);
        System.out.println(tree.levelorderToString());
    }

}

