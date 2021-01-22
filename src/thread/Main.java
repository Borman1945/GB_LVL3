package thread;

public class Main {
    public static void main(String[] args) {
        PrinterABC printerABC = new PrinterABC();
        new Thread(() -> printerABC.getA()).start();
        new Thread(() -> printerABC.getB()).start();
        new Thread(() -> printerABC.getC()).start();
    }
}
