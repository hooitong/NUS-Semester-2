package week_3; /**
 * @author Yeap Hooi Tong
 * @matric A0111736
 * @date 03/02/14
 * @desc Class for a binary tree that stores type E objects.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree<E> implements Serializable {

    // Data Field
    /**
     * The root of the binary tree
     */
    protected Node<E> root;

    /**
     * Construct an empty week_3.week_4.BinaryTree
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Construct a week_3.week_4.BinaryTree with a specified root.
     * Should only be used by subclasses.
     *
     * @param root The node that is the root of the tree.
     */
    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    /**
     * Constructs a new binary tree with data in its root,leftTree
     * as its left subtree and rightTree as its right subtree.
     */
    public BinaryTree(E data, BinaryTree<E> leftTree,
                      BinaryTree<E> rightTree) {
        root = new Node<E>(data);
        if (leftTree != null) {
            root.setLeft(leftTree.root);
        } else {
            root.setLeft(null);
        }
        if (rightTree != null) {
            root.setRight(rightTree.root);
        } else {
            root.setRight(null);
        }
    }

    /**
     * Reads path encoding from the user and construct a binary tree
     *
     * @param bR BufferReader object
     * @return week_3.week_4.BinaryTree object
     * @throws java.io.IOException
     */
    public static BinaryTree<String> readBinaryTree1(BufferedReader bR)
            throws IOException {
        Scanner scan = new Scanner(bR);
        BinaryTree<String> bTree = null;

        /* take in all of user's input and read accordingly */
        while (scan.hasNext()) {
            String token = scan.next();
            if (token.equals("()")) break; /* end of node input indicated */
            if (bTree == null) {
                bTree = new BinaryTree<String>(new Node<String>("-1"));
            }

            /* get the parameters from the path encoding and store into the week_3.NP object */
            NP pathInfo = new NP(token.substring(token.indexOf('(') + 1, token.indexOf(',')), token.substring(token.indexOf(',') + 1, token.indexOf(')')));
            /* this is to ensure that if the user did not specify a value in one of the nodes, its default to -1 which is incomplete */
            if (pathInfo.getLabel().equals("")) pathInfo.setLabel("-1");

            /* call recursive method to add node to the tree according to the path encoding */
            addNode(bTree.root, pathInfo.getLabel(), pathInfo.getPath());
        }

        /* if no new node is created, create a empty binary tree */
        if (bTree == null) {
            bTree = new BinaryTree<String>();
        }

        /* return the created binary tree object */
        return bTree;
    }

    /**
     * Recursive method to add the nodes based on the given path
     *
     * @param root  a node object pointer
     * @param value the value that is to be added
     * @param path  the traversal path it needs to take
     */
    private static void addNode(Node<String> root, String value, String path) {
        /* base case when the path passed in is empty */
        /* replace the value at root */
        if (path.equals("")) {
            root.setData(value);
            return;
        }

        /* perform the traversal based on the path string, starting from the left index */
        if (path.charAt(0) == 'L') {
            if (root.getLeft() == null) {
                root.setLeft(new Node<String>("-1"));
            }
            addNode(root.getLeft(), value, path.substring(1));
        } else if (path.charAt(0) == 'R') {
            if (root.getRight() == null) {
                root.setRight(new Node<String>("-1"));
            }
            addNode(root.getRight(), value, path.substring(1));
        }
    }

    /**
     * Return the left subtree.
     *
     * @return The left subtree or null if either the root or
     * the left subtree is null
     */
    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.getLeft() != null) {
            return new BinaryTree<E>(root.getLeft());
        } else {
            return null;
        }
    }

    /**
     * Return the right sub-tree
     *
     * @return the right sub-tree or
     * null if either the root or the
     * right subtree is null.
     */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.getRight() != null) {
            return new BinaryTree<E>(root.getRight());
        } else {
            return null;
        }
    }

    /**
     * Return the data field of the root
     *
     * @return the data field of the root
     * or null if the root is null
     */
    public E getData() {
        if (root != null) {
            return root.getData();
        } else {
            return null;
        }
    }

    /**
     * Determine whether this tree is a leaf.
     *
     * @return true if the root has no children
     */
    public boolean isLeaf() {
        return (root == null || (root.getLeft() == null && root.getRight() == null));
    }

    public int height() {
        return height(root);
    }

    public int height(Node<E> r) {
        if (r == null) return 0;
        return 1 + Math.max(height(r.getLeft()), height(r.getRight()));
    }

    public int size() {
        return size(root);
    }

    public int size(Node<E> r) {
        if (r == null) return 0;
        return 1 + size(r.getLeft()) + size(r.getRight());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }

    /**
     * Perform a preorder traversal.
     *
     * @param node  The local root
     * @param depth The depth
     * @param sb    The string buffer to save the output
     */
    private void preOrderTraverse(Node<E> node, int depth,
                                  StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.getLeft(), depth + 1, sb);
            preOrderTraverse(node.getRight(), depth + 1, sb);
        }
    }

    /**
     * Method to return the preorder traversal of the binary tree
     * as a sequence of strings each separated by a space.
     *
     * @return A preorder traversal as a string
     */
    public String preorderToString() {
        StringBuilder stb = new StringBuilder();
        preorderToString(stb, root);
        return stb.toString();
    }

    private void preorderToString(StringBuilder stb, Node<E> root) {
        stb.append(root);
        if (root.getLeft() != null) {
            stb.append(" ");
            preorderToString(stb, root.getLeft());
        }
        if (root.getRight() != null) {
            stb.append(" ");
            preorderToString(stb, root.getRight());
        }
    }

    /**
     * Method to return the postorder traversal of the binary tree
     * as a sequence of strings each separated by a space.
     *
     * @return A postorder traversal as a string
     */
    public String postorderToString() {
        StringBuilder stb = new StringBuilder();
        postorderToString(stb, root);
        return stb.toString();
    }

    private void postorderToString(StringBuilder stb, Node<E> root) {
        if (root.getLeft() != null) {
            postorderToString(stb, root.getLeft());
            stb.append(" ");
        }
        if (root.getRight() != null) {
            postorderToString(stb, root.getRight());
            stb.append(" ");
        }
        stb.append(root);
    }

    /**
     * A method to display the inorder traversal of a binary tree
     * placeing a left parenthesis before each subtree and a right
     * parenthesis after each subtree. For example the expression
     * tree shown in Figure 6.12 would be represented as
     * (((x) + (y)) * ((a) / (b))).
     *
     * @return An inorder string representation of the tree
     */
    public String inorderToString() {
        StringBuilder stb = new StringBuilder();
        inorderToString(stb, root);
        return stb.toString();
    }

    private void inorderToString(StringBuilder stb, Node<E> root) {
        if (root.getLeft() != null) {
            stb.append("(");
            inorderToString(stb, root.getLeft());
            stb.append(") ");
        }
        stb.append(root);
        if (root.getRight() != null) {
            stb.append(" (");
            inorderToString(stb, root.getRight());
            stb.append(")");
        }
    }

    public String levelorderToString() {
        StringBuilder stb = new StringBuilder();
        stb.append("levelorder: ");

        return levelorderToString(stb, root) ? stb.toString() : "not complete\n" + stb.toString();
    }

    private boolean levelorderToString(StringBuilder stb, Node<E> root) {
        /* boolean flag to signify whether the tree is complete */
        boolean isComplete = true;
        if (root == null) {
            stb.append("An empty tree");
            return isComplete;
        }

        Queue<Node<E>> q = new LinkedList<Node<E>>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node<E> curr = q.poll();
            if (curr.toString().equals("-1")) isComplete = false;
            stb.append(curr);
            stb.append(" ");
            if (curr.getLeft() != null) {
                q.offer(curr.getLeft());
            }
            if (curr.getRight() != null) {
                q.offer(curr.getRight());
            }
        }

        return isComplete;
    }
}