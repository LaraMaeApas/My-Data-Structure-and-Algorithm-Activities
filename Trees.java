class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    void insert(int data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    void preorder() {
        preorderRec(root);
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void postorder() {
        postorderRec(root);
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    boolean search(int data) {
        return searchRec(root, data);
    }

    boolean searchRec(Node root, int data) {
        if (root == null)
            return false;
        if (root.data == data)
            return true;
        return data < root.data ? searchRec(root.left, data) : searchRec(root.right, data);
    }

    Node delete(int data) {
        return root = deleteRec(root, data);
    }

    Node deleteRec(Node root, int data) {
        if (root == null) return root;

        if (data < root.data)
            root.left = deleteRec(root.left, data);
        else if (data > root.data)
            root.right = deleteRec(root.right, data);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.print("Inorder traversal: ");
        tree.inorder();
        System.out.println();

        System.out.print("Preorder traversal: ");
        tree.preorder();
        System.out.println();

        System.out.print("Postorder traversal: ");
        tree.postorder();
        System.out.println();

        System.out.println("Search for 40: " + tree.search(40));
        System.out.println("Search for 90: " + tree.search(90));

        System.out.println("Deleting 20");
        tree.delete(20);
        System.out.print("Inorder traversal after deletion: ");
        tree.inordr();
        System.out.println();
    }
}
