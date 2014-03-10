package week_5; /**
 * @author Yeap Hooi Tong
 * @matric A0111736M
 * @date 22/02/14
 * @desc Used to construct a expression tree given a fully parenthesized infix expression.
 * Also is able to evaluate a given expression tree.
 */

import java.util.Scanner;
import java.util.Stack;

/**
 * Class to test the Expression Tree construction
 */
public class TestExpressionTree {
    /**
     * This method constructs a expression tree given a fully parenthesized infix expression.
     *
     * @param expr the fully parenthesized infix expression
     * @return the expression tree object
     * @pre the input must be a fully parenthesized infix expression
     */
    public static BinaryTree<String> buildExpressionTree(String expr) {
        /* split the string into its individual string token */
        String[] exprArray = expr.split(" ");
        /* create a stack for construction of the expression tree */
        Stack<BinaryTree<String>> treeStack = new Stack<BinaryTree<String>>();

        /* for each token in the expression */
        for (String op : exprArray) {
            /* ignore all open brackets */
            if (op.equals("(")) continue;

            /* if open parenthesize found, construct expression tree with 3 sub-trees and push back into stack */
            else if (op.equals(")")) {
                BinaryTree<String> rightTree = treeStack.pop();
                BinaryTree<String> root = treeStack.pop();
                BinaryTree<String> leftTree = treeStack.pop();
                treeStack.push(new BinaryTree<String>(root.getData(), leftTree, rightTree));
            } else {
                /* else push operand or operator into stack */
                treeStack.push(new BinaryTree<String>(new Node<String>(op)));
            }
        }

        /* return the constructed expression tree */
        return (treeStack.pop());
    }

    /**
     * This method is used to evaluate the expression tree recursively.
     *
     * @param expressionTree The week_5.week_6.BinaryTree Object
     * @return int value of the expression tree
     */
    public static int evaluateExpressionTree(BinaryTree<String> expressionTree) {
        /* given a empty tree, return 0 */
        if (expressionTree == null) return 0;

        /* if its a operand (leaf), return the value */
        if (expressionTree.isLeaf()) return Integer.parseInt(expressionTree.getData());

        /* perform the calculation based on the operator in the root */
        switch (expressionTree.getData().charAt(0)) { /* for Java SE6 & Below as String is not acceptable in switch statement */
            case '+':
                return evaluateExpressionTree(expressionTree.getLeftSubtree()) + evaluateExpressionTree(expressionTree.getRightSubtree());
            case 'x':
                return evaluateExpressionTree(expressionTree.getLeftSubtree()) * evaluateExpressionTree(expressionTree.getRightSubtree());
            case '-':
                return evaluateExpressionTree(expressionTree.getLeftSubtree()) - evaluateExpressionTree(expressionTree.getRightSubtree());
            case '/':
                return evaluateExpressionTree(expressionTree.getLeftSubtree()) / evaluateExpressionTree(expressionTree.getRightSubtree());
            default:
                return 0;
        }
    }

    /* Test Driver */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        BinaryTree<String> expressionTree = buildExpressionTree(expr);
        String levelorderTraversal = expressionTree.levelorderToString();
        System.out.println("levelorder:" + levelorderTraversal);
        int val = evaluateExpressionTree(expressionTree);
        System.out.println("Evaluated value: " + val);
    }
}

