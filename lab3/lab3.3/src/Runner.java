import by.vsu.mf.ai.ssd.strings.Job;
import by.vsu.mf.ai.ssd.strings.Manager;

import java.util.Set;

public class Runner {
    public static Manager manager = new Manager();

    public static void main(String[] argv){

        Transform transform = new Transform();
        manager.createWindow(transform);
    }

}
