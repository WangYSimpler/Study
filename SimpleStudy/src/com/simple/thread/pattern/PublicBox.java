package com.simple.thread.pattern;

/**
 * Created by Administrator on 2019/1/1.
 */
public class PublicBox {

    private int products = 0;

    public synchronized void increace() {
        while (products == 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        products++;
        System.out.println(Thread.currentThread().getName()+" : 生成苹果成功!,数量 =" +products);
        notify();
    }

    public synchronized void decreace() {
        while (products == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products--;
        System.out.println(Thread.currentThread().getName()+" : 消费苹果成功!,数量 =" +products);

        notify();
    }

    public static void main(String[] args) {

        PublicBox box = new PublicBox();

        ConsumerModule con = new ConsumerModule(box);
        ProducerModule pro = new ProducerModule(box);

        new Thread(con, "消费者").start();
        new Thread(con, "消费者2").start();
        new Thread(con, "消费者3").start();
        new Thread(pro, "生产者").start();
    }
}

class ProducerModule implements Runnable {
    private PublicBox box;

    public ProducerModule(PublicBox box) {
        this.box = box;
    }

    @Override
    public void run() {

        for (int i = 0; i < 50; i++) {
            try {
                System.out.println("pro  i:" + i);
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }

            box.increace();
        }

    }
}

class ConsumerModule implements Runnable {
    private PublicBox box;

    public ConsumerModule(PublicBox box) {
        this.box = box;
    }

    @Override
    public void run() {

        for (int i = 0; i < 50; i++) {
            try {
                System.out.println("Con: i " + i);
                Thread.sleep(100);                // 这里设置跟上面30不同是为了 盒子中的苹果能够增加，不会生产一个马上被消费
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }

            box.decreace();
        }
    }
}
