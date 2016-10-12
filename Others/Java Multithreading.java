public class Solution implements Runnable{
    private Thread t;
    private String name;

    public Solution(String name) {
        t = new Thread(this, name);
        this.name = name;
    }

    public void run() {
        int i = 0;
        while(true) {
            System.out.println(name + ":" + i++);
            try {
                Thread.sleep(500);
            } catch(InterruptedException e) {
                System.out.println("!!!");
            }
        }
    }

    public void start() {
        t.start();
    }
}