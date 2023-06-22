import java.util.NoSuchElementException;

public class MyStack <T>{


    public SNode<T> bottom;
    public SNode <T> top;
    int size;

    // is Empty method
    public boolean isEmpty(){
        return bottom ==null;
    }

    // push method

    public void push(T item){
        SNode<T> node = new SNode<>(item);
        if(isEmpty()){
            bottom = top = node;
        }else{
            top.next = node;
            top = node;
        }
        size++;
    }

    // T peak method

    public T peek(){
        return (T) top.value;
    }

    // pop method
    public T pop(){
        SNode peakNode;
        if (isEmpty()) throw  new NoSuchElementException(" No such element! ");
        // stack has one element
        if (top ==bottom){
            peakNode=top;
            top=bottom=null;
        }else{ // more than one element
            peakNode = top;
            SNode prev = bottom;
            while(prev.next!=top){
                prev=prev.next;
            }
            prev.next=null;
            top=prev;
        }
        size--;
        return (T) peakNode.value;
    }

}

/*

Stack is abstract datastructure -bussines logic



• Main stack operations
- void push(int data): Inserts data onto stack.
- int pop(): Removes and returns the last inserted element from the stack.

• Auxiliary stack operations
- Top(): Returns the last inserted element without removing it. (Peek())
- int Size(): Returns the number of elements stored in the stack.
- int IsEmpty(): Indicates any elements are stored in the stack or not.
- int IsFull(): Indicates the stack is full or not.

• Can be implemented using Arrays or Linked Lists (stack is an Abstract Data Type-ADT)
*
*
*
* */
