package lab2_2;

public class ServerErrorHandler implements HttpHandler {
    @Override
    public void handle() throws InterruptedException {
        System.out.println("Handling Server error http status.");
        Thread.sleep(100);
    }
}
