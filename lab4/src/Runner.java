public class Runner {
    public static void main(String[] argv){
        Repair repair = new Repair();
        repair.gasbagsQueue.push(new Gasbag(1, 99, true));
        repair.gasbagsQueue.push(new Gasbag(2, 1, false));
        repair.startProcess();
        repair.resultOutput();
    }
}
