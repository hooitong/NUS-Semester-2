package week_2.tutorial_2; /**
 * @author Yeap Hooi Tong
 * @matric A0111736M
 * @desc Test Driver Program for Tutorial 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestPostorderTraversal {
    public static void main(String[] args) throws IOException {
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        BinaryTree<String> bt = BinaryTree.readBinaryTree(bR);
        System.out.println(bt.postorderToString());
    }
}

/* When it is run, open in1.txt, use copy and paste and enter ctrl-d to simulate eof.
 * */