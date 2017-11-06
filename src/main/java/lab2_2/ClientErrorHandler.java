package lab2_2;

public class ClientErrorHandler implements HttpHandler {
    @Override
    public void handle() throws InterruptedException {
        System.out.println("Handling client error http status.");
        Thread.sleep(100);
    }
}
