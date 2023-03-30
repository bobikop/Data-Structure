package session_6;

public class AlgoQuestion1LRUCache2 {
    public static void main(String[] args) {
        LRUCache2 lhm=new LRUCache2(3);
        lhm.put(1,1);
        lhm.put(2,2);
        lhm.put(3,3);
        System.out.println(lhm.get(1));
        lhm.put(4,4); // {cache= (4,4), (1,1) , (3,3)}
        lhm.entrySet().forEach(entry->{
            System.out.println("Key is: "+ entry.getKey() + "Value is:" + entry.getValue());
        });
        System.out.println();
    }
}