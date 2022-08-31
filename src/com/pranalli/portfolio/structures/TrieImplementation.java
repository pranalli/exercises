package com.pranalli.portfolio.structures;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>Trie Implementation for String Lookups</h1>
 * <p>
 *     This problem was defined as the need to implement a custom
 *     Trie in order to improve upon the runtime and functionality
 *     of string lookup.
 * </p>
 */
public class TrieImplementation {

    /**
     * The Node class is the actual Trie implementation in this case.
     * It provides basic functionality for adding strings as well as
     * determining if they are
     */
    public static class Node {
        private final Map<Character, Node> nodes = new HashMap<>();
        private int size = 0;

        public Node() { }

        public void add(String s) {
            add(s, 0);
        }

        private void add(String s, int index) {
            size++;
            if (index == s.length())
                return;

            char currChar = s.charAt(index);
            Node childNode = findChildNode(currChar);
            if (childNode == null) {
                childNode = new Node();
                setChildNode(currChar, childNode);
            }

            childNode.add(s, index + 1);
        }

        public int findCount(String s) {
            return findCount(s, 0);
        }

        private int findCount(String s, int index) {
            if (index == s.length()) {
                return size;
            }

            Node childNode = findChildNode(s.charAt(index));
            if (childNode == null) {
                return 0;
            }

            return childNode.findCount(s, index + 1);
        }

        public int getSize() {
            return size;
        }

        private Node findChildNode(char id) {
            return nodes.get(id);
        }

        private void setChildNode(char id, Node node) {
            nodes.put(id, node);
        }
    }

    public static void main(String[] args) {
        Node n = new Node();
        n.add("jodie");
        n.add("josh");
        n.add("joscelyn");
        n.add("jilly");

        System.out.println(n.findCount("ji"));
    }
}
