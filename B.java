import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}

class BinaryTree {
    private TreeNode root;

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode curr, int data) {
        if (curr == null) {
            return new TreeNode(data);
        }

        if (data < curr.data) {
            curr.left = insertRec(curr.left, data);
        } else if (data > curr.data) {
            curr.right = insertRec(curr.right, data);
        }

        return curr;
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
        int num;
        while (true) {
            num = sc.nextInt();
            if (num == 0) {
                break;
            }
            tree.insert(num);
        }
        List<Integer> leaves = tree.findLeaves();
        Collections.sort(leaves);
        for (int leaf : leaves) {
            System.out.print(leaf + " ");
        }
    }
}
