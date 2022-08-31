package com.pranalli.portfolio.structures.btree;

public interface ITree<T extends Comparable<T>> {
    ITree<T> insert(T t);
    void delete(T t);
    void traverse();
    T getMax();
    T getMin();
    boolean isEmpty();
}
