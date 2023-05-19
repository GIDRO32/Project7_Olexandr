import java.util.Iterator;
import java.util.Stack;

public class BinaryTree<T> implements Iterable<T> {
    private Node<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(T rootData) {
        this.root = new Node<>(rootData);
    }

    public BinaryTree(T rootData, BinaryTree<T> left, BinaryTree<T> right) {
        this.root = new Node<>(rootData);
        if (left != null) {
            this.root.left = left.root;
        }
        if (right != null) {
            this.root.right = right.root;
        }
    }

    public void inorderTraverse(Visitor<T> visitor) {
        inorderTraverse(root, visitor);
    }

    private void inorderTraverse(Node<T> node, Visitor<T> visitor) {
        if (node != null) {
            inorderTraverse(node.left, visitor);
            visitor.visit(node.data);
            inorderTraverse(node.right, visitor);
        }
    }

    public void postorderTraverse(Visitor<T> visitor) {
        postorderTraverse(root, visitor);
    }

    private void postorderTraverse(Node<T> node, Visitor<T> visitor) {
        if (node != null) {
            postorderTraverse(node.left, visitor);
            postorderTraverse(node.right, visitor);
            visitor.visit(node.data);
        }
    }

    public void preorderTraverse(Visitor<T> visitor) {
        preorderTraverse(root, visitor);
    }

    private void preorderTraverse(Node<T> node, Visitor<T> visitor) {
        if (node != null) {
            visitor.visit(node.data);
            preorderTraverse(node.left, visitor);
            preorderTraverse(node.right, visitor);
        }
    }

    public int getSize() {
        return getSizeOfNode(root);
    }

    private int getSizeOfNode(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSizeOfNode(node.left) + getSizeOfNode(node.right);
    }

    @Override
    public Iterator<T> iterator() {
        return new InorderIterator();
    }

    private class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public interface Visitor<T> {
        void visit(T data);
    }

    private class InorderIterator implements Iterator<T> {
        private Stack<Node<T>> stack;

        public InorderIterator() {
            stack = new Stack<>();
            pushLeftNodes(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            Node<T> current = stack.pop();
            pushLeftNodes(current.right);
            return current.data;
        }

        private void pushLeftNodes(Node<T> node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
}