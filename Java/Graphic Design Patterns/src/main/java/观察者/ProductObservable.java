package 观察者;

public interface ProductObservable {
    void addObserver(ProductObserver observer);
    void removeObserver(ProductObserver observer);
}
