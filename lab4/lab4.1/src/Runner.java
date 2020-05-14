public class Runner {
    public static void main(String[] argv){
        Repair repair = new Repair();
        repair.gasbagsQueue.push(new Gasbag(1, 99, true));
        repair.gasbagsQueue.push(new Gasbag(2, 1, false));
        repair.gasbagsQueue.push(new Gasbag(3, 1, false));
        repair.gasbagsQueue.push(new Gasbag(4, 11, false));
        repair.gasbagsQueue.push(new Gasbag(5, 99, true));
        repair.startProcess();
        repair.resultOutput();
    }
}
