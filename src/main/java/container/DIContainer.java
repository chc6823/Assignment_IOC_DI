package container;

import annotation.Autowired;

import java.lang.reflect.Field;

// 의존성 주입을 관리할 컨테이너
public class DIContainer {
    public static void injectDependencies(Object target) throws IllegalAccessException {
        // 클래스의 필드를 순회하면서 @Autowired 어노테이션이 붙은 필드를 찾아 의존성 주입
        for (Field field : target.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Autowired.class)) {
                // 접근성을 변경하여 필드에 값을 주입
                field.setAccessible(true);
                // 필드의 타입으로 인스턴스를 생성하여 주입
                Object dependency = createInstance(field.getType());
                field.set(target, dependency);
            }
        }
    }

    private static Object createInstance(Class<?> type) {
        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Dependency injection failed for type: " + type.getName(), e);
        }
    }
}
