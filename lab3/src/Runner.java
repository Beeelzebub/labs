import by.vsu.mf.ai.ssd.strings.Job;
import by.vsu.mf.ai.ssd.strings.Manager;

public class Runner {
    public static Manager manager = new Manager();
    public static void main(String[] argv){
        Transform transform = new Transform();
        transform.setStr("Hi there! Welcome to the first task!");
        transform.firtstTask("W","t", "k");
        transform.setStr("My first phone number is 11-25-82 and second is 22-54-43");
        transform.secondTask();
        manager.createWindow(transform);
    }

}
