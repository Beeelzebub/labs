public class Repair {
    public MyQueue<Gasbag> gasbagsQueue = new MyQueue<Gasbag>();;
    private MyStack repairedGasbags = new MyStack();;
    private MyStack noGasGasbags = new MyStack();;
    private MyStack brokenGasbags = new MyStack();;
    private MyStack donorsGasbags = new MyStack();;

    public void startProcess(){
        while (!gasbagsQueue.isEmpty()){
            distribution(gasbagsQueue.pull());
        }
    }

    public void distribution(Gasbag gasbag){
        if (gasbag.getGas() == 100 && gasbag.isServiceable()) {
            System.out.println("Gasbag number " + gasbag.getNumber() + " going to repairedGasbags stack");
            repairedGasbags.push(gasbag);
        }
        else if (gasbag.getGas() < 100 && gasbag.isServiceable()) {
            System.out.println("Gasbag number " + gasbag.getNumber() + " going to noGasGasbags stack");
            noGasGasbags.push(gasbag);
        }
        else if (gasbag.getGas() < 100 && gasbag.getGas() != 0 && !gasbag.isServiceable() && !noGasGasbags.isEmpty()) {
            refill(gasbag);
        }
        else if (gasbag.getGas() < 100 && gasbag.getGas() != 0 && !gasbag.isServiceable() && noGasGasbags.isEmpty()) {
            System.out.println("Gasbag number " + gasbag.getNumber() + " going to repairedGasbags stack");
            donorsGasbags.push(gasbag);
        }
        else brokenGasbags.push(gasbag);
        if (!noGasGasbags.isEmpty() && !donorsGasbags.isEmpty() && gasbagsQueue.isEmpty()) {
            Gasbag temp_gasbag;
            while (!noGasGasbags.isEmpty()) {
                temp_gasbag = (Gasbag) noGasGasbags.pull();
                System.out.println("Gasbag number " + temp_gasbag.getNumber() + " going to gasbagsQueue stack from noGasGasbags");
                gasbagsQueue.push(temp_gasbag);
            }
            while (!donorsGasbags.isEmpty()) {
                temp_gasbag = (Gasbag) donorsGasbags.pull();
                System.out.println("Gasbag number " + gasbag.getNumber() + " going to gasbagsQueue stack from donorsGasbags");
                gasbagsQueue.push(temp_gasbag);
            }
        }
    }

    public void refill(Gasbag gasbag){
        while(!noGasGasbags.isEmpty() && gasbag.getGas() != 0){
            Gasbag noGasGasbag = (Gasbag) noGasGasbags.pull();
            noGasGasbag.addGas(gasbag);
            if (noGasGasbag.getGas() == 100) repairedGasbags.push(noGasGasbag);
            else noGasGasbags.push(noGasGasbag);
            if (gasbag.getGas() == 0) brokenGasbags.push(gasbag);
            if (noGasGasbags.isEmpty() && gasbag.getGas() > 0) donorsGasbags.push(gasbag);
        }
    }

    public void resultOutput(){
        System.out.println("\nResult info:");
        if (!brokenGasbags.isEmpty()) brokenGasbagsOutput();
        if (!repairedGasbags.isEmpty()) repairedGasbagsOutput();
        if (!donorsGasbags.isEmpty()) donorsGasbagsOutput();
        if (!noGasGasbags.isEmpty()) noGasGasbagsOutput();
    }

    private void brokenGasbagsOutput(){
        Gasbag gasbag;
        System.out.println("Broken gasbags:");
        while (!brokenGasbags.isEmpty()){
            gasbag = (Gasbag) brokenGasbags.pull();
            System.out.println("Gasbag number " + gasbag.getNumber());
        }
        System.out.println("");
    }

    private void repairedGasbagsOutput(){
        Gasbag gasbag;
        System.out.println("Repaired gasbags:");
        while (!repairedGasbags.isEmpty()){
            gasbag = (Gasbag) repairedGasbags.pull();
            if (gasbag.isRefilled()) System.out.println("Gasbag number " + gasbag.getNumber() +  " has " + gasbag.getGas() + "% and was refilled" + gasbag.getRefillInfo());
            else System.out.println("Gasbag number " + gasbag.getNumber());
        }
        System.out.println("");
    }

    private void donorsGasbagsOutput(){
        Gasbag gasbag;
        System.out.println("Donors gasbags:");
        while (!donorsGasbags.isEmpty()){
            gasbag = (Gasbag) donorsGasbags.pull();
            System.out.println("Gasbag number " + gasbag.getNumber() + " has " + gasbag.getGas() + "%");
        }
        System.out.println("");
    }

    private  void noGasGasbagsOutput(){
        Gasbag gasbag;
        System.out.println("incomplete gasbags:");
        while (!noGasGasbags.isEmpty()){
            gasbag = (Gasbag) noGasGasbags.pull();
            if (gasbag.isRefilled()) System.out.println("Gasbag number " + gasbag.getNumber() + "has " + gasbag.getGas() + "and was refilled" + gasbag.getRefillInfo());
            else System.out.println("Gasbag number " + gasbag.getNumber());
        }
        System.out.println("");
    }
}