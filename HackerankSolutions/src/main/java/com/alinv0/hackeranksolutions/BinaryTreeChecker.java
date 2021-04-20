package com.alinv0.hackeranksolutions;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeChecker {

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    boolean checkBST(Node root) {
        Map<Integer, Integer> dataMap = new HashMap<>();
        boolean result = isOrderedAndCount(root, dataMap);

        return result;
    }

    private boolean isOrderedAndCount(Node root, Map<Integer, Integer> dataMap) {
        boolean result = false;

        if (root == null) {
            return true;
        }

        if (root.left != null) {
            result = root.left.data < root.data;
        }
        if (root.right != null) {
            result = result && root.right.data > root.data;
        }
        if (!result) {
            return false;
        }

        result = isOrderedAndCount(root.left, dataMap) && isOrderedAndCount(root.right, dataMap);

        if (result) {
            Integer count = dataMap.get(root.data);
            if (count == null) {
                count = 0;
            }
            dataMap.put(root.data, ++count);
            if (count > 1) {
                return false;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeChecker checker = new BinaryTreeChecker();
        Node root = new Node(4);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.right = new Node(8);
        root.right.left = new Node(5);
        root.right.right = new Node(10);

        System.out.println(checker.checkBST(root));
    }
}
