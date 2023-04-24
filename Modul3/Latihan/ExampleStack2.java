package Modul3.Latihan;

public class ExampleStack2 {
    public static class Stack {
        private int maxSize;
        private String[] stackArray;
        private int top;

        public Stack (int a){
            maxSize = 5;
            stackArray = new String[maxSize];
            top = -1;
        }
        public void push(String  j){
            stackArray[++top] = j;
        }
        public String pop(){
            return stackArray[top--];
        }
        public String peek(){
            return stackArray[top];
        }
        public boolean isEmpty(){
            return (top == -1);
        }
        public boolean isFull(){
            return (top == maxSize -1);
        }
    }

    public static void main(String[] args) {
        Stack stacks = new Stack(10);
        stacks.push("Aku");
        stacks.push("Anak");
        stacks.push("Indonesia");

        while (!stacks.isEmpty()){
            String value = stacks.pop();
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println("");
    }
}
