package Modul3.Latihan;

public class Main{
    public static void main(String[] args) {
        LinkQueue queue = new LinkQueue();

        queue.enqueue("Java");
        queue.enqueue("DotNet");
        queue.displayQueue();

        queue.enqueue("PHP");
        queue.enqueue("HTML");
        queue.displayQueue();

        queue.dequeue();
        queue.displayQueue();
    }
}
