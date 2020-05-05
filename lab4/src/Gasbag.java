public class Gasbag {
    private int number;
    private int gas;
    private boolean serviceable;
    private boolean refilled;
    private StringBuilder refillInfo;

    public Gasbag(int number, int gas, boolean serviceable){
        this.number = number;
        this.gas = gas;
        this.serviceable = serviceable;
        this.refilled = false;
        this.refillInfo = new StringBuilder();
    }

    public void addGas(Gasbag gasbag){
        this.refilled = true;
        if (this.gas + gasbag.getGas() > 100){
            gasbag.subGas(this.gas + gasbag.getGas() - 100);
            setRefillInfo(gasbag.getNumber(), 100 - this.gas);
            this.gas = 100;
        }
        else if (this.gas + gasbag.getGas() <= 100){
            gasbag.subGas(gasbag.getGas());
            setRefillInfo(gasbag.getNumber(), 100 - this.gas);
            this.gas = 100;
        }
        else {
            setRefillInfo(gasbag.getNumber(), gasbag.getGas());
            this.gas += gasbag.getGas();
            gasbag.subGas(gasbag.getGas());
        }
    }

    private void setRefillInfo(int number, int gas){
        refillInfo.append("from gasbag number " + number + " by " + gas + "\n");
    }

    public boolean isRefilled(){
        return refilled;
    }

    public StringBuilder getRefillInfo() {
        return refillInfo;
    }

    public void subGas(int value){
        this.gas -= value;
    }

    public int getNumber() {
        return number;
    }

    public int getGas() {
        return gas;
    }

    public boolean isServiceable() {
        return serviceable;
    }
}
