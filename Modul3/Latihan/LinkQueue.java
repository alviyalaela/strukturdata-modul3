package Modul3.Latihan;

public class LinkQueue {
    public FirstLastList theList;
    public LinkQueue() {
        theList = new FirstLastList();
    }
    public boolean isEmpty () {
        return theList.isEmpty();
    }
    public void enqueue ( String j){
        theList.insertLast(j);
    }
    public String dequeue () {
        return theList.deleteFirst();
    }
    public void displayQueue () {
        System.out.println("Queue (Head--> Tail) : ");
        theList.displayList();
    }

}
