package lab2_2;

public class InformationHandler implements HttpHandler {
    @Override
    public void handle() throws InterruptedException {
        System.out.println("Handling information http status.");
        Thread.sleep(100);
    }
}
