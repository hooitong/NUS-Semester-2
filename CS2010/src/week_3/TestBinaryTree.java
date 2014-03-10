package week_3; /**
 * @author Yeap Hooi Tong
 * @matric A0111736
 * @date 03/02/14
 * @desc Class to test the week_3.week_4.week_5.week_6.BinaryTree class
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

