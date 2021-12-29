package ru.geekbrains.lessons.lesson6;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {
    private Node<E> root;
    private int size;


    @Override
    public boolean contains(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        return nodeAndParent.current != null;
    }

    private NodeAndParent doFind(E value) {
        Node<E> current = root;
        Node<E> parent = null;
        int level = 1;

        while ((current != null)) {
            if (current.getValue().equals(value)) {

                return new NodeAndParent(current, parent, level);
            }
            parent = current;
            if (current.isLeftChild(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
            level++;
        }
        return new NodeAndParent(null, parent, level);
    }

    @Override
    public boolean add(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        if (nodeAndParent.current != null) {
            System.out.println("Такое число :" + value + " в дереве уже имеется");
            return false;
        }
        if (nodeAndParent.getLevel() > 4) {
            System.out.println("Глубина дерева больше 4. В дерево не добавлено число : " + value);
            return false;
        }

        Node<E> parent = nodeAndParent.parent;
        Node<E> node = new Node<>(value);
        if (isEmpty()) {
            root = node;
        } else if (parent.isLeftChild(value)) {
            parent.setLeftChild(node);
        } else {
            parent.setRightChild(node);
        }
        size++;
        return true;
    }


    @Override
    public boolean remove(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        Node<E> removed = nodeAndParent.current;
        Node<E> parent = nodeAndParent.parent;

        if (removed == null) {
            return false;
        }
        if (removed.isLeaf()) {
            removeLeafNode(removed, parent);
        } else if (removed.hasOnlyOneChild()) {
            removedNodeWithOneChild(removed, parent);
        } else {
            removeNodeWithAllChild(removed, parent);
        }


        size--;
        return false;
    }

    private void removeNodeWithAllChild(Node<E> removed, Node<E> parent) {
        Node<E> successor = getSuccessor(removed);

        if (removed == root) {
            root = successor;
        } else if (parent.isLeftChild(removed.getValue())) {
            parent.setLeftChild(successor);
        } else parent.setRightChild(successor);
    }

    private Node<E> getSuccessor(Node<E> removed) {
        Node<E> successor = removed;
        Node<E> successorParent = null;
        Node<E> current = removed.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if (successor != removed.getRightChild() && successorParent != null) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removed.getRightChild());
        }
        successor.setLeftChild(removed.getLeftChild());
        return successor;
    }

    private void removedNodeWithOneChild(Node<E> removed, Node<E> parent) {
        Node<E> child = removed.getLeftChild() != null ? removed.getLeftChild() : removed.getRightChild();
        if (removed == root) {
            root = child;
        } else if (parent.isLeftChild(removed.getValue())) {
            parent.setLeftChild(child);
        } else parent.setRightChild(child);

    }

    private void removeLeafNode(Node<E> removed, Node<E> parent) {
        if (removed == root) {
            root = null;
        } else if (parent.isLeftChild(removed.getValue())) {
            parent.setLeftChild(null);
        } else parent.setRightChild(null);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        traverse(TraversMode.PRE_ORDER);
        traverse(Tree.TraversMode.IN_ORDER);
        //  traverse(TraversMode.POST_ORDER);
    }

    @Override
    public void traverse(TraversMode mode) {
        switch (mode) {
            case PRE_ORDER:
                preOrder(root);
                break;
            case IN_ORDER:
                inOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);

        }
        System.out.println(" ");
    }

    private void preOrder(Node<E> current) {
        if (current == null) return;
        System.out.print(current.getValue() + " ");
        preOrder(current.getLeftChild());
        preOrder(current.getRightChild());
    }

    private void inOrder(Node<E> current) {
        int level = 0;

        inOrder(current, level);
        System.out.println();
        System.out.println("Баланс : " +  isBalanced(current));
    }

    private void inOrder(Node<E> current, int level ) {
        level++;

        if (current == null) {
            return;
        }

        inOrder(current.getLeftChild(), level );

        System.out.printf("level  %s : %s  , " , level ,current.getValue());
        inOrder(current.getRightChild(), level );
    }

    public static boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private static int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    private void postOrder(Node<E> current) {
        if (current == null) return;

        postOrder(current.getLeftChild());
        postOrder(current.getRightChild());
        System.out.print(current.getValue() + " ");
    }

    private class NodeAndParent {
        private Node<E> current;
        private Node<E> parent;
        private int level;

        public NodeAndParent(Node<E> current, Node<E> parent, int level) {
            this.current = current;
            this.parent = parent;
            this.level = level;
        }

        public int getLevel() {
            return level;
        }

    }


}
