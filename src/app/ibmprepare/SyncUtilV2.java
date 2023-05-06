package app.ibmprepare;

/**
 * @author dimmy
 */
public class SyncUtilV2 {

    public synchronized void printA() {
        System.out.println("A");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printB() {
        System.out.println("B");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SyncUtilV2 syncUtil = new SyncUtilV2();
        new Thread(syncUtil::printB).start();
        new Thread(syncUtil::printA).start();
    }
}
