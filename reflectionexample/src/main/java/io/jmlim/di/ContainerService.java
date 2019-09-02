package io.jmlim.di;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

    public static <T> T getObject(Class<T> classType) {
        T instance = createInstance(classType);
        Arrays.stream(classType.getDeclaredFields()).forEach(f -> {
            //필드에 어노테이션 Inject 가 붙어있는게 있는지 확인
            Inject annotation = f.getAnnotation(Inject.class);
            if (annotation != null) {
                // book repository
                Object fieldInstance = createInstance(f.getType());
                // public 접근 지시자가 아닌게 많으므로
                f.setAccessible(true);
                try {
                    f.set(instance, fieldInstance);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return instance;
    }

    private static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor(null).newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException();
        }
    }
}
