package lab2_2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Service myHandleService = new Service();
        int countOfCodesToHandle = random.nextInt(10);
        for (int i = 0; i < countOfCodesToHandle; i++) {
            // getting random code from 100 to 599
            int randomCode = random.nextInt(499) + 100;
            myHandleService.handleHttp(randomCode);
        }
    }
}
