package mySpring;

import java.lang.reflect.Field;

public interface ObjectConfigurator {
    public <T> void configurate(T object, Field[] fields) throws IllegalAccessException;
}
