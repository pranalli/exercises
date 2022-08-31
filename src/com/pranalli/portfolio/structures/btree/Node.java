package com.pranalli.portfolio.structures.btree;

import java.util.Objects;

class Node<T extends Comparable<T>> implements INode<T> {
    private T data;
    private Node<T> parent;
    private Node<T> leftChild;
    private Node<T> rightChild;
    private int height = 0;

    public Node(T t, Node<T> parent) {
        this.data = t;
        this.parent = parent;
    }

    @Override
    public T data() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public Node<T> parent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    @Override
    public Node<T> leftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    @Override
    public Node<T> rightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public boolean hasLeft() {
        return Objects.nonNull(leftChild);
    }

    public boolean hasRight() {
        return Objects.nonNull(rightChild);
    }
}
