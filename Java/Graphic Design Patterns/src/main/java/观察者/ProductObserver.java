package 观察者;

public interface ProductObserver {
    void onPublished(Product product);//通知增加商品
    void onPriceChanged(Product product);//通知价格改变
}
