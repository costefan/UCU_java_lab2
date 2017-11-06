package lab2_2;

public class SuccessHandler implements HttpHandler {
    @Override
    public void handle() throws InterruptedException {
        System.out.println("Handling success http status.");
        Thread.sleep(100);
    }
}
