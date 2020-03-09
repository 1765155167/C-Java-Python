package 观察者;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Store implements ProductObservable {
    private List<ProductObserver> observers = new ArrayList<>();
    private Map<String, Product> products = new HashMap<>();

    @Override
    public void addObserver(ProductObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(ProductObserver observer) {
        this.observers.remove(observer);
    }

    public void addNewProduct(String name, double price) {
        Product p = new Product(name, price);
        products.put(p.getName(), p);
        ExecutorService es = Executors.newFixedThreadPool(4);//创建4个固定数量的线程池
        for (var observer : observers) {
            es.submit(() -> {
                observer.onPublished(p);
            });
        }
        es.shutdown();//等待执行完毕关闭线程池
//        observers.forEach(o -> o.onPublished(p));
    }

    public void setProductPrice(String name, double price) {
        Product p = products.get(name);
        p.setPrice(price);
        ExecutorService es = Executors.newFixedThreadPool(4);//创建4个固定数量的线程池
        for (var observer : observers) {
            es.submit(() -> {
                observer.onPriceChanged(p);
            });
        }
        es.shutdown();//等待执行完毕关闭线程池
//        observers.forEach(o -> o.onPriceChanged(p));
    }
}
