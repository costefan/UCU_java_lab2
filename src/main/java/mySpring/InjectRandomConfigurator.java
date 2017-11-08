package mySpring;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomConfigurator implements ObjectConfigurator {
    private Random random = new Random();
    @Override
    public <T> void configurate(T object, Field[] fields) throws IllegalAccessException {
        for (Field field : fields) {

            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                int randomIntValue = random.nextInt(max - min) + min;
                field.setAccessible(true);
                field.set(object, randomIntValue);

            }
        }
    }
}
