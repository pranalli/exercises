package com.pranalli.portfolio.structures.btree;

import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class BinaryTree<T extends Comparable<T>> implements ITree<T> {
    private Node<T> root;

    @Override
    public ITree<T> insert(T t) {
        if (isNull(root)) {
            root = new Node<>(t, null);
            return this;
        }

        return insert(root, t);
    }

    private ITree<T> insert(Node<T> n, T t) {
        if (t.compareTo(n.data()) < 0) {
            if (isNull(n.leftChild())) {
                n.setLeftChild(new Node<>(t, n));
            } else {
                insert(n.leftChild(), t);
            }
        }
        if (t.compareTo(n.data()) > 0) {
            if (isNull(n.rightChild())) {
                n.setRightChild(new Node<>(t, n));
            } else {
                insert(n.rightChild(), t);
            }
        }

        return this;
    }

    @Override
    public void delete(T t) {
        Node<T> n = findNode(root, t);
        if (isNull(n)) {
            return;
        }

        if (t.compareTo(n.parent().data()) < 0) {
            if (n.hasRight()) {
                rotateLeft(n);
            }
            else {
                n.parent().setLeftChild(n.leftChild());
            }
        }

        if (t.compareTo(n.parent().data()) > 0) {
            if (n.hasLeft()) {
                rotateRight(n);
            }
            else {
                n.parent().setRightChild(n.rightChild());
            }
        }
    }

    private Node<T> rotateRight(Node<T> n) {
        Node<T> leftChild = n.leftChild();
        Node<T> rightChild = n.rightChild();
        return n;
    }

    private Node<T> rotateLeft(Node<T> n) {
        Node<T> rightChild = n.rightChild();
        Node<T> centerChild = rightChild.leftChild();
        if (n.hasLeft() && rightChild.hasLeft()) {
            Node<T> maxLeftOfDelete = getMax(n.leftChild());
            maxLeftOfDelete.setRightChild(centerChild);
            rightChild.setLeftChild(null);
        }

        n.parent().setLeftChild(rightChild);

//        Node<T> leftChild = n.leftChild();
//        Node<T> centerChild = rightChild.leftChild();

        return n;
    }

    private Node<T> findNode(Node<T> n, T t) {
        if (isNull(n)) {
            return null;
        }

        if (t.compareTo(n.data()) < 0) {
            return findNode(n.leftChild(), t);
        }

        if (t.compareTo(n.data()) > 0) {
            return findNode(n.rightChild(), t);
        }

        return n;
    }

    @Override
    public void traverse() {
        traverse(root);
    }

    private void traverse(Node<T> n) {
        if (nonNull(n.leftChild())) {
            traverse(n.leftChild());
        }

        System.out.println(n.data());

        if (nonNull(n.rightChild())) {
            traverse(n.rightChild());
        }
    }

    @Override
    public T getMax() {
        return getMax(root).data();
    }

    private Node<T> getMax(Node<T> n) {
        if (nonNull(n.rightChild())) {
            return getMax(n.rightChild());
        }

        return n;
    }
    @Override
    public T getMin() {
        return getMin(root);
    }

    public T getMin(Node<T> n) {
        if (nonNull(n.leftChild())) {
            return getMin(n.leftChild());
        }

        return n.data();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public static void main(String[] args) {
        Integer[] input = new Integer[] { -1, 0, -2, -3, 1, 2, 4, -4, 3, -5, 5 };
        BinaryTree<Integer> btree = new BinaryTree<>();
        for (Integer i : input) {
            btree.insert(i);
        }

        btree.traverse();
        System.out.printf("Max: %d\n", btree.getMax());
        System.out.printf("Min: %d", btree.getMin());
    }
}
