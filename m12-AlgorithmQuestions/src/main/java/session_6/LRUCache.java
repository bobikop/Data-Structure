package session_6;

import java.util.HashMap;

public class LRUCache {

    public class DNode{
        int key;
        int value;
        DNode prev;
        DNode next;

        public DNode() {
        }

        public DNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, DNode>  cacheMap=new HashMap<>();
    int size;
    int capacity;
    DNode head;
    DNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size=0;
        this.head=new DNode();
        this.tail=new DNode();
        head.next=tail;
        tail.prev=head;
    }
    public void addNode(DNode node){
        node.prev=head;
        node.next=head.next;

        head.next.prev=node;
        head.next=node;
    }

    public void removeNode(DNode node){
        DNode prev=node.prev;
        DNode next=node.next;

        prev.next=next;
        next.prev=prev;
    }

  public void moveToHead(DNode node){
        removeNode(node);
        addNode(node);
  }
   private DNode popTail(){
        DNode popped=tail.prev;
        removeNode(popped);
        return popped;
   }

     public int get(int key){
        DNode node= cacheMap.get(key);
        if (node==null) return -1;
        moveToHead(node);
        return node.value;
     }
     public void put(int key, int value){
         DNode node= cacheMap.get(key);
         if(node==null) {
             DNode newNode=new DNode(key, value);
             cacheMap.put(key, newNode);
             addNode(newNode);
             size++;
                if(size>capacity) {
                    DNode tail=popTail();
                    cacheMap.remove(tail.key);
                    size--;
                }
         }else {
             node.value = value;
             moveToHead(node);
         }
     }


}