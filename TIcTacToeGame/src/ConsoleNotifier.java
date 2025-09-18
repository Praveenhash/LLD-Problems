public class ConsoleNotifier implements IObserver{
    @Override
    public void update(String message) {
        System.out.println("[Notification] " + message);
    }
}
