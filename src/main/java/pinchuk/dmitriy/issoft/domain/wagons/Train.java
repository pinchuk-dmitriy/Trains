package pinchuk.dmitriy.issoft.domain.wagons;

public class Train implements TrainList {

    private final int number;

    private Node<Wagon> head;
    private Node<Wagon> tail;

    private int size = 0;

    public Train(int number) {

        if(number == 0) {
            throw new IllegalArgumentException("Invalid number of train");
        }

        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Wagon getHead() {
        return head.wagon;
    }

    public Wagon getTail() {
        return tail.wagon;
    }

    public int getSize() {
        return size;
    }

    public boolean addFront(Wagon wagon) {

        canBeAdded(wagon);
        Node<Wagon> newNode = new Node<>(wagon);

        if (this.head == null) {

            this.head = newNode;
            this.tail = newNode;

        } else {

            newNode.next = this.head.next;
            newNode.prev = this.head;
            this.head.next.prev = newNode;
            this.head.next = newNode;

        }

        size++;
        return true;
    }

    public boolean add(Wagon wagon) {

        canBeAdded(wagon);
        Node<Wagon> newNode = new Node<>(wagon);
        if (tail == null) {

            head = newNode;

        } else {

            tail.next = newNode;
            newNode.prev = tail;

        }

        tail = newNode;
        size++;
        return true;
    }

    public boolean contains(Wagon wagon){

        if (wagon != null) {
            for(Node<Wagon> temp = head; temp != null; temp = temp.next){
                if(temp.wagon.equals(wagon)){
                    return true;
                }
            }
        }

        return false;
    }

    public String toString() {

        StringBuilder result = new StringBuilder("Train with number " + number + " {");

        for(Node<Wagon> temp = head; temp!=null; temp = temp.next){
            result.append(" ").append(temp.wagon);
        }

        result.append(" }");
        return result.toString();
    }

    public boolean remove(Wagon wagon) {

        Node<Wagon> current = head;
        while (current != null && current.wagon != wagon) {
            current = current.next;
        }

        if(current == null) {
            return false;
        }

        removeNode(current);
        return true;
    }

    private void removeNode(Node<Wagon> node) {

        if (node != null) {

            if (node.prev != null) {
                node.prev.next = node.next;
            } else {
                head = node.next;
            }

            if (node.next != null) {
                node.next.prev = node.prev;
            } else {
                tail = node.prev;
            }

            size--;
        }
    }

    public void clear() {

        for(Node<Wagon> temp = head; temp!=null;){
            temp.wagon = null;
            Node<Wagon> node = temp.next;
            temp.next = null;
            temp.prev = null;
            temp = node;
        }

        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean canBeAdded(Wagon wagon) {

        if (wagon == null) {
            throw new IllegalArgumentException("Wagon is null");
        }

        if(head == null && wagon.getWagonType() != WagonType.LOCOMOTIVE) {
            throw new IllegalArgumentException("First wagon of train must be locomotive");
        }

        if(head != null) {
            if (head.next == null) {
                return true;
            }
            else if(tail.wagon.getWagonType() != wagon.getWagonType()) {
                throw new IllegalArgumentException("All wagons of train must be of the same type");
            }
        }

        return true;
    }

    private static class Node<T> {

        Node<T> next;
        Node<T> prev;
        T wagon;

        public Node(T wagon) {
            this.wagon = wagon;
        }
    }
}




