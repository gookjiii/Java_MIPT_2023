import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}

class BinaryTree {
    TreeNode root;

    public TreeNode insert(TreeNode node, int data) {
        if (node == null) {
            return new TreeNode(data);
        }

        if (data < node.data) {
            node.left = insert(node.left,data);
        } else if (data > node.data) {
            node.right = insert(node.right,data);
        }
        
        return node;
    }

    public List<Integer> findLeaves() {
        List<Integer> leaves = new ArrayList<>();
        findLeavesRec(root, leaves);
        return leaves;
    }

    private void findLeavesRec(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            leaves.add(node.data);
        }

        findLeavesRec(node.left, leaves);
        findLeavesRec(node.right, leaves);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        
        readInput(tree, sc);
        
        List<Integer> leaves = tree.findLeaves();
        printOutput(leaves);
    }
    
    private static void readInput(BinaryTree tree, Scanner sc) {
        int num;
        while (true) {
            num = sc.nextInt();
            if (num == 0) {
                break;
            }
            tree.root = tree.insert(tree.root, num);
        }
    }

    private static void printOutput(List<Integer> leaves) {
        Collections.sort(leaves);
        for (int leaf : leaves) {
            System.out.print(leaf + " ");
        }
    }
}