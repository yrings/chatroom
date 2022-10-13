package simple;

import java.util.ArrayList;
import java.util.Vector;

public class gorun {
    public static void main(String[] args) {
        //创建用户对象A
        Users u1 = new Users("小明",1);

        //创建用户对象B
        Users u2 = new Users("小蔡",0);

        //创建线程对象，开启线程
        Thread t1 = new Thread(u1);
        t1.start();

        Thread t2 = new Thread(u2);
        t2.start();

    }
}
//用户类，创建用户
class Users implements Runnable {
    private int userID; //标记A,B两个用户

    private String name;//用户名

    //设置有参构造
    public Users(String name, int userID) {
        this.name = name;
        this.userID = userID;
    }
    @Override
    public void run() {
        Print p = new Print();

        //设计两种模式，对应两个用户
         if(userID == 1) {
        while (Print.index != p.getVector().size() - 1) {
            try {
                System.out.println(this.name + ":" + p.printA());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
             }
            } else if(userID == 0) {
            while (Print.index != p.getVector().size() - 1) {
                try {
                   System.out.println(this.name + ":" + p.printB());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
         }
    }

}
//打印类，用等待唤醒机制用户依次交替获取存储在集合中的数据；
class Print {
    public static boolean flag = false;//定义一个标志判断线程状态


    private static Object obj = new Object();//创建锁对象

    public static int index = 0;//创建全局变量作为数据索引

    private ArrayList<String> v = new ArrayList<>();//存储要打印数据

    public Print() {
        //存储要打印的数据
        v.add("在吗");
        v.add("在的");
        v.add("你在干嘛");
        v.add("我在吃饭");
        v.add("哦哦");
        v.add("嗯嗯");
        v.add("吃的什么饭呀");
        v.add("蛋炒饭");
        v.add("加鸡蛋了吗");
        v.add("蛋炒饭你说呢");
        v.add("加了几个蛋");
        v.add("一个");
        v.add("为什么不加两个");
        v.add("不想");
        v.add("吃的是土鸡蛋吗");
        v.add("我不道啊");
    }

    public ArrayList<String> getVector() {
        return v;
    }

    //A模式先打印
    public String printA() throws InterruptedException {
        synchronized (obj) {
            Thread.sleep(1000);
            while (flag) {
                obj.wait();
            }

            obj.notify();
            Print.flag = true;

            //判断集合是否满了
            if (Print.index < v.size() - 1) {
                return v.get(Print.index++);
            } else {
                return v.get(Print.index);
            }
        }
    }

    //B模式后打印
    public String printB() throws InterruptedException {
        synchronized (obj) {
            Thread.sleep(1000);
            while (!flag) {
                obj.wait();
            }

            obj.notify();
            Print.flag = false;

            //判断集合是否满了
            if (Print.index < v.size() - 1) {
                return v.get(Print.index++);
            } else {
                return v.get(Print.index);
            }
        }

    }
}





