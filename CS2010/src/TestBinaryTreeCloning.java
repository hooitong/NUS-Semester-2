/**
 * @author Yeap Hooi Tong
 * @matric A0111736M
 * @date 02/03/14
 * @desc Used to construct a expression tree given a fully parenthesized infix expression.
 * Also able to deep clone a expression tree
 */

import java.util.Scanner;
import java.util.Stack;

/**
 * Class to test the ExpressionTree construction
 */
public class TestBinaryTreeCloning {
    public static BinaryTree<String> buildExpressionTree(String expr) {
        BinaryTree<String> subt, rightTree, leftTree, opTree;
        Stack<BinaryTree<String>> st = new Stack<BinaryTree<String>>();
        Scanner scan = new Scanner(expr);
        String data;
        while (scan.hasNext()) {
            data = scan.next();
            if (data.equals("(")) continue;
            if (data.equals(")")) {
                rightTree = st.pop();
                opTree = st.pop();
                data = opTree.getData();
                leftTree = st.pop();
                subt = new BinaryTree<String>(data, leftTree, rightTree);
                st.push(subt);
            } else {
                subt = new BinaryTree<String>(data, null, null);
                st.push(subt);
            }
        }
        return st.pop();
    }

    /**
     * This method is used to deep clone an given BinaryTree
     *
     * @param expressionTree the BinaryTree object to be cloned
     * @return Reference to the cloned BinaryTree object
     */
    public static BinaryTree<String> cloneBinaryTree(BinaryTree<String> expressionTree) {
        /* base case when the tree is empty */
        if (expressionTree == null) {
            return null;
        }

        /* base case when the tree is a leaf */
        if (expressionTree.isLeaf()) {
            return new BinaryTree<String>(new Node<String>(expressionTree.getRoot().getData()));
        }

        /* recursive call to clone the given expression tree */
        return new BinaryTree<String>(expressionTree.getRoot().getData(), cloneBinaryTree(expressionTree.getLeftSubtree()), cloneBinaryTree(expressionTree.getRightSubtree()));
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        BinaryTree<String> expressionTree = buildExpressionTree(expr);
        String levelorderTravesal = expressionTree.levelorderToString();
        System.out.println("levelorder:" + levelorderTravesal);
        BinaryTree<String> cloneTree = cloneBinaryTree(expressionTree);
        expressionTree.getRoot().setData("1000");
        // System.out.println("levelorder:" + expressionTree.levelorderToString());
        levelorderTravesal = cloneTree.levelorderToString();
        System.out.println("levelorder of cloneTree:" + levelorderTravesal);
    }
}

