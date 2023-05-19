public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(50,
                new BinaryTree<>(17,
                    new BinaryTree<>(12,
                            new BinaryTree<>(9),
                            new BinaryTree<>(14)
                    ),
                        new BinaryTree<>(23,
                                new BinaryTree<>(19),
                                null
                        )
                ),
                new BinaryTree<>(72,
                        new BinaryTree<>(54,null,
                                new BinaryTree<>(67)
                        ),
                        new BinaryTree<>(76)
                )
        );
        int size = tree.getSize();
        // Preorder Traversal Test
        System.out.println("Preorder Traversal:");
        tree.preorderTraverse(new BinaryTree.Visitor<Integer>() {
            @Override
            public void visit(Integer data) {
                System.out.print(data + " ");
            }
        });
        System.out.println();

        // Postorder Traversal Test
        System.out.println("Postorder Traversal:");
        tree.postorderTraverse(new BinaryTree.Visitor<Integer>() {
            @Override
            public void visit(Integer data) {
                System.out.print(data + " ");
            }
        });
        System.out.println();

        // Inorder Traversal Test
        System.out.println("Inorder Traversal:");
        tree.inorderTraverse(new BinaryTree.Visitor<Integer>() {
            @Override
            public void visit(Integer data) {
                System.out.print(data + " ");
            }
        });
        System.out.println();

        // Inorder Iterator Test
        System.out.println("Inorder Iterator Test:");
        for (Integer element : tree) {
            System.out.print(element + " ");
        }
        System.out.println("\nthe size of the tree is: " + size);
    }
}