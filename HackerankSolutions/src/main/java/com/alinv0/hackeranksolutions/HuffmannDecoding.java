package com.alinv0.hackeranksolutions;

public class HuffmannDecoding {
    static class Node {
        Node left;
        Node right;
        int frequency;
        char data;

        public Node(Node left, Node right, int frequency, char data) {
            this.left = left;
            this.right = right;
            this.frequency = frequency;
            this.data = data;
        }

        public Node(int frequency, char data) {
            this.frequency = frequency;
            this.data = data;
        }
    }
    public static void decode(String s, Node root) {
        Node temp = root;
        StringBuilder decoded = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '0') {
                temp = temp.left;
            } else if(s.charAt(i) == '1') {
                temp = temp.right;
            }

            if(temp.data != 0) {
                decoded.append(temp.data);
                temp = root;
            }
        }

        System.out.println(decoded.toString());
    }


    public static void main(String[] args) {
        Node root = new Node(
            new Node(
                    new Node(
                            null,
                            null,
                            1,
                            'B'
                    ),
                    new Node(
                            null,
                            null,
                            1,
                            'C'
                    ),
                    2,
                    (char)0
            ),
            new Node(
                    null,
                    null,
                    3,
                    'A'
            ),
            5,
                (char)0
        );
        decode("1001011", root);
    }
}
