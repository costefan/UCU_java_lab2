package lab2_2;


public class Service {

    public static int getFirstDigit(int i) {
        while (Math.abs(i) >= 10 ) {
            i = i / 10;
        }
        return Math.abs(i);
    }

    public void handleHttp(int code) {

        int codeDigit = Service.getFirstDigit(code);

        HttpStatus status = HttpStatus.findByStartSymbol(codeDigit);
        HttpHandler handler = status.getHandler();
        try {
            handler.handle();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

}
