import container.DIContainer;
import controller.MyController;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        // 의존성 주입을 받을 객체
        MyController controller = new MyController();

        // 의존성 주입
        DIContainer.injectDependencies(controller);

        // 의존성이 주입된 객체 사용
        controller.getData("Main Data 1234");

    }
}
