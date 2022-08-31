package com.pranalli.portfolio.structures.btree;

import java.util.Objects;

interface INode<T extends Comparable<T>> {
    T data();
    INode<T> parent();
    INode<T> leftChild();
    INode<T> rightChild();

    /**
     * Default implementation for getHeight() which is useful across any type of
     * binary tree.
     *
     * @return The height from the bottom where 1 = bottom.  Null nodes are not counted.
     */
    default int getHeight() {
        boolean noChildren = Objects.isNull(leftChild()) && Objects.isNull(rightChild());
        if (noChildren) {
            return 1;
        }

        return (Objects.isNull(leftChild()) ? 0 : leftChild().getHeight()) +
               (Objects.isNull(rightChild()) ? 0 : rightChild().getHeight());
    }
}
