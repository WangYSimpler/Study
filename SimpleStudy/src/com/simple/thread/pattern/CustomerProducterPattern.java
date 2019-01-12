package com.simple.thread.pattern;

/**
 * Created by Administrator on 2019/1/1.
 */

//产品缓存
class ProductsCache {
    private int index = 0;
    private int[] dataArray = new int[10];

    //生产过程
    public synchronized void produceProducts(int product) {
        //仓库满了，等待消费
        while (index >= this.dataArray.length) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        super.notifyAll();
        try {
            Thread.sleep(20);
            dataArray[index] = product;
            System.out.println(Thread.currentThread().getName() + " ：生产产品= " + product);
            index++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
    * 消费产品
    * */
    public synchronized void CustumeProduct() {
        //空间空了，需要生产
        while (0 == this.index) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        super.notifyAll();
        try {
            Thread.sleep(5);
            this.index--;
            System.out.println(Thread.currentThread().getName() + " : 消费产品=" + dataArray[index]);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}

/*
* 生产者
* */
class Producer implements Runnable {
    ProductsCache productsCache = null;

    Producer(ProductsCache productsCache) {
        this.productsCache = productsCache;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            productsCache.produceProducts(i);
        }
    }
}

class Customer implements Runnable {
    ProductsCache productsCache = null;

    Customer(ProductsCache productsCache) {
        this.productsCache = productsCache;
    }

    @Override
    public void run() {
        productsCache.CustumeProduct();
    }
}


public class CustomerProducterPattern {

    public static void main(String[] args) {

        ProductsCache productsCache = new ProductsCache();
        Producer producer = new Producer(productsCache);
        Customer customer = new Customer(productsCache);
        new Thread(producer, "生产者 1").start();
       // new Thread(producer, "生产者 2").start();
      //  new Thread(customer, "消费者 1").start();
        new Thread(customer, "消费者 2").start();
        new Thread(customer, "消费者 3").start();
        // Thread(producer, "生产者一"
    }

}
