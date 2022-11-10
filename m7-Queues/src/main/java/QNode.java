public class QNode<T> {

     T value;
   QNode<T> next;

    public QNode(QNode<T> next) {
        this.next = next;
    }

    public QNode(T value) {
        this.value = value;
    }
}
