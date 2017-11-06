package lab2_2;

public class RedirectionHandler implements HttpHandler {
    @Override
    public void handle() throws InterruptedException {
        System.out.println("Handling redirect http status.");
        Thread.sleep(100);
    }
}
