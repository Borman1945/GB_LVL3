package thread;

public class PrinterABC {

    boolean isLockOne;
    boolean isNotLockTwo;
    boolean isLockThree = true;


    public synchronized void getA() {
        int i = 0;
        while(i < 5){
            try {
                if (isLockOne){
                    wait();
                } else {
                    System.out.print("A");
                    i++;
                    isLockOne = true;
                    isNotLockTwo = true;
                    notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void getB() {
        int i = 0;
        while(i < 5){
            try {
                if (!isNotLockTwo){
                    wait();
                } else {
                    System.out.print("B");
                    i++;
                    isNotLockTwo = false;
                    isLockThree = false;
                    notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void getC() {
        int i = 0;
        while(i < 5){
            try {
                if (isLockThree){
                    wait();
                } else {
                    System.out.print("C");
                    i++;
                    isLockThree = true;
                    isLockOne = false;
                    notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

}
