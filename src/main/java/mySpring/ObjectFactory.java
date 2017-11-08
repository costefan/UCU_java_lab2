package mySpring;

import lab2_1.MailGenerator;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private List<ObjectConfigurator> objectConfigurators = new ArrayList<>();


    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    public ObjectFactory addConfigurators() {
        Reflections scanner = new Reflections("mySpring");
        Set<Class<? extends ObjectConfigurator>> classes = scanner.getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> clazz: classes) {
            if (!Modifier.isAbstract(clazz.getModifiers())) {
                this.objectConfigurators.add(clazz.newInstance());
            }

        }
        return ourInstance;
    }

    private ObjectFactory() {
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type.isInterface()) {
           type =  config.getImpl(type);
        }
        T o = type.newInstance();

        if (!objectConfigurators.isEmpty())
            this.configureObject(o, type);

        return o;
    }

    @SneakyThrows
    public <T> void configureObject(T object, Class<T> type) {
        Field[] fields = type.getDeclaredFields();
        for (ObjectConfigurator conf: this.objectConfigurators) {
            conf.configurate(object, fields);
        }
    }
}
