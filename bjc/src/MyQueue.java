import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
public class MyQueue {
    public static void main(String[] args)
    {
        Queue q = new LinkedList();
        q.offer("Banana");
        q.offer("Apple");
        q.offer("Orange");
        System.out.println(q);
        
        HashSet hs = new HashSet();
        hs.add("hi"); 
        hs.add("hi"); 
        hs.size(); 
        System.out.println(hs.size());
    }
}
