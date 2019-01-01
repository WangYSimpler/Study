package com.simple.study.thread;

/**
 * Created by Administrator on 2019/1/1.
 */


class MyTicket implements  Runnable{

    private int ticket  = 20;

    public synchronized  boolean saleTickets(){
        if (0 <= ticket ){
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() +" 卖票， 票还有 ticket= " + ticket -- );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("票已经卖完");
            return false;
        }
        return true;

    }
    @Override
    public void run() {
        while(this.saleTickets()){};
    }
}
public class TicketThread {

  public static void main(String[] args){
      MyTicket myTicketThread = new MyTicket();
      new Thread(myTicketThread, "窗口1").start();
      new Thread(myTicketThread, "窗口2").start();
      new Thread(myTicketThread, "窗口3").start();
      new Thread(myTicketThread, "窗口4").start();
    }
}
