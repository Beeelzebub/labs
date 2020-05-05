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
        if (gasbag.getGas() == 100 && gasbag.isServiceable()) repairedGasbags.push(gasbag);
        else if (gasbag.getGas() < 100 && gasbag.isServiceable()) noGasGasbags.push(gasbag);
        else if (gasbag.getGas() < 100 && gasbag.getGas() != 0 && !gasbag.isServiceable() && !noGasGasbags.isEmpty()){
            donorsGasbags.push(gasbag);
            refill();
        }
        else if (gasbag.getGas() < 100 && !gasbag.isServiceable() && noGasGasbags.isEmpty()) donorsGasbags.push(gasbag);
        else brokenGasbags.push(gasbag);
    }

    public void refill(){
        Gasbag gasbag = (Gasbag) donorsGasbags.pull();
        Gasbag noGasGasbag = (Gasbag) noGasGasbags.pull();
        if (noGasGasbag != null){
            noGasGasbag.addGas(gasbag);
            this.distribution(noGasGasbag);
            this.distribution(gasbag);
        }
    }

    public void resultOutput(){
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
    }

    private void repairedGasbagsOutput(){
        Gasbag gasbag;
        System.out.println("Repaired gasbags:");
        while (!repairedGasbags.isEmpty()){
            gasbag = (Gasbag) repairedGasbags.pull();
            if (gasbag.isRefilled()) System.out.println("Gasbag number " + gasbag.getNumber() + " was refilled" + gasbag.getRefillInfo());
            else System.out.println("Gasbag number " + gasbag.getNumber());
        }
    }

    private void donorsGasbagsOutput(){
        Gasbag gasbag;
        System.out.println("Donors gasbags:");
        while (!donorsGasbags.isEmpty()){
            gasbag = (Gasbag) donorsGasbags.pull();
            System.out.println("Gasbag number " + gasbag.getNumber() + "has" + gasbag.getGas());
        }
    }

    private  void noGasGasbagsOutput(){
        Gasbag gasbag;
        System.out.println("incomplete gasbags:");
        while (!noGasGasbags.isEmpty()){
            gasbag = (Gasbag) noGasGasbags.pull();
            System.out.println("Gasbag number " + gasbag.getNumber());
        }
    }



}