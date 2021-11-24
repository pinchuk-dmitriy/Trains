package pinchuk.dmitriy.issoft.domain.wagons;

public interface TrainList {

    boolean add(Wagon wagon);
    boolean addFront(Wagon wagon);
    boolean contains(Wagon wagon);
    boolean isEmpty();
    boolean remove(Wagon wagon);
    void clear();
    String toString();

}
