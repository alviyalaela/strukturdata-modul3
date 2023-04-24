package Modul3;

import java.util.Scanner;

public class Kegiatan1 {

    public static void main(String[] args) {
        String input;
        Scanner in = new Scanner(System.in);

        System.out.print("Masukkan String: ");
        input = in.nextLine();

        String reversedStr = reverseString(input);

        System.out.println("String yang diinput: " + input);
        System.out.println("String yang terbalik: " + reversedStr);
    }

    public static String reverseString(String input) {
        int length = input.length();
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < length; i++) {
            char ch = input.charAt(i);
            stack.push(ch);
        }

        StringBuilder reversedStr = new StringBuilder();
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            reversedStr.append(ch);
        }

        return reversedStr.toString();
    }

    static class Stack<T> {
        private Node<T> top;

        private static class Node<T> {
            private T data;
            private Node<T> next;

            public Node(T data) {
                this.data = data;
                this.next = null;
            }
        }

        public void push(T data) {
            Node<T> newNode = new Node<T>(data);

            if (top == null) {
                top = newNode;
            } else {
                newNode.next = top;
                top = newNode;
            }
        }

        public T pop() {
            if (top == null) {
                throw new IllegalStateException("Stack is empty");
            }

            T data = top.data;
            top = top.next;

            return data;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }
}


