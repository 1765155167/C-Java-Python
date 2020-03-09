package 观察者;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // observer:
        Admin a = new Admin();//管理员
        Customer c = new Customer();//消费者
        // store:
        Store store = new Store();//商品
        // register:注册
        store.addObserver(a);
        store.addObserver(c);
        // 注册匿名观察者:
        store.addObserver(new ProductObserver() {
            @Override
            public void onPublished(Product product) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("[Log] on product published: " + product);
            }

            @Override
            public void onPriceChanged(Product product) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("[Log] on product price changed: " + product);
            }
        });
        // operation:
        store.addNewProduct("Design Patterns", 35.6);//添加商品
        Thread.sleep(1000);
        store.addNewProduct("Effective Java", 50.8);
        Thread.sleep(1000);
        store.setProductPrice("Design Patterns", 31.9);//商品价格改变
        Thread.sleep(1000);
        store.removeObserver(a);
        store.addNewProduct("洗发露", 25);
    }
}
class Customer implements ProductObserver {

    @Override
    public void onPublished(Product product) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[Customer] on product published: " + product);
    }

    @Override
    public void onPriceChanged(Product product) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[Customer] on product price changed: " + product);
    }
}

class Admin implements ProductObserver {

    @Override
    public void onPublished(Product product) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[Admin] on product published: " + product);
    }

    @Override
    public void onPriceChanged(Product product) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[Admin] on product price changed: " + product);
    }
}