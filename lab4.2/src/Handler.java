import java.io.*;
import java.util.*;

public class Handler {
    private Scanner in = new Scanner(System.in);
    public ArrayList<Enrollee> enrolles;
    String csvFile;

    public Handler(String csvFile){
        this.csvFile = csvFile;
        enrolles = new ArrayList<Enrollee>();
        read();
    }

    public void getNames(){
        for (int i = 0; i < enrolles.size(); i++) System.out.println(i+1 + ") " + enrolles.get(i).getFirstName() +
                " " + enrolles.get(i).getSecondName());
    }

    public void add(){
        Enrollee enrollee = new Enrollee();
        System.out.print("Enter data:\nFirst name: ");
        enrollee.setFirstName(in.next());
        System.out.print("Second name: ");
        enrollee.setSecondName(in.next());
        System.out.print("Math scores: ");
        enrollee.setMathScores(in.nextInt());
        System.out.print("Physic scores: ");
        enrollee.setPhysicScores(in.nextInt());
        System.out.print("Language scores: ");
        enrollee.setLanguageScore(in.nextInt());
        System.out.print("Certificate: ");
        enrollee.setCertificate(in.nextInt());
        enrolles.add(enrollee);
        System.out.println("Data added");
        write();
        waiting();
    }

    public void enteredEnrollesOutput(){
        if (!enrolles.isEmpty()) {
            System.out.println("Entered enrolles:");
            for (int i = 0; i < enrolles.size(); i++){
                if (enrolles.get(i).isEntered())
                System.out.println(enrolles.get(i).getFirstName() + " " + enrolles.get(i).getSecondName());
            }
        } else System.out.println("No data :(");
        waiting();
    }

    public void exit(){
        write();
    }

    public void edit(int index, int field){
        switch (field){
            case 1:
                enrolles.get(index).setFirstName(in.next());
                break;
            case 2:
                enrolles.get(index).setSecondName(in.next());
                break;
            case 3:
                enrolles.get(index).setMathScores(in.nextInt());
                break;
            case 4:
                enrolles.get(index).setPhysicScores(in.nextInt());
                break;
            case 5:
                enrolles.get(index).setLanguageScore(in.nextInt());
                break;
            case 6:
                enrolles.get(index).setCertificate(in.nextInt());
                break;
            default: System.out.println("Incorrect input :(");
        }
        write();
        waiting();
    }

    public void delete(int index){
        if (!enrolles.isEmpty()) enrolles.remove(index);
        else System.out.println("No data :(");
        write();
        waiting();
    }

    public void view(){
        if (!enrolles.isEmpty()){
            Enrollee enrollee;
            for (int i = 0; i < enrolles.size(); i++){
                System.out.println("\nEnrollee " + i + ":");
                enrollee = enrolles.get(i);
                enrollee.allInfoOutput();
            }
        } else System.out.println("No data :(");
        waiting();
    }

    public void waiting(){
        System.out.println("\nPress to continue");
        try {
            System.in.read();
        } catch(Exception e) {}
    }

    public void admission(int places){
        if (!enrolles.isEmpty()) {
            for (int i = 0; i < enrolles.size(); i++) enrolles.get(i).refresh();
            enrolles.sort(Enrollee::compareTo);
            pass(places);
        } else System.out.println("No data :(");
    }

    public void pass(int places){
        for (int i = 0; i < places; i++){
                if (enrolles.get(i).getAverageScores() > enrolles.get(i + 1).getAverageScores())
                    enrolles.get(i).setEntered();
                else i = coincidencesCheck(i, places);
        }
    }

    public int coincidencesCheck(int index, int places){
        ArrayDeque<Integer> indexes = new ArrayDeque<Integer>();
        indexes.addFirst(index);
        for (int i = index + 1; i < enrolles.size(); i++){
            if (enrolles.get(indexes.peek()).getAverageScores() == enrolles.get(i).getAverageScores()){
                indexes.addFirst(i);
                index = i;
            } else {
                index = i;
                break;
            }
        }
        if (indexes.peek() < places){
            while (!indexes.isEmpty()){
                enrolles.get(indexes.poll()).setEntered();
            }
        } else {
            ArrayList<Enrollee> enrolleesTemp = new ArrayList<Enrollee>();
            while (!indexes.isEmpty()){
                enrolles.get(indexes.peek()).setCoincidencesFlag();
                enrolleesTemp.add(enrolles.get(indexes.poll()));
            }
            enrolleesTemp.sort(Enrollee::compareTo);
            if (!areEquals(enrolleesTemp)) {
                for (int i = 0; i < places; i++) {
                    enrolleesTemp.get(i).setEntered();
                }
            } else collision(enrolleesTemp);
        }
        return index;
    }

    private boolean areEquals (ArrayList<Enrollee> enrolleesTemp){
        for (int i = 0; i < enrolleesTemp.size() - 1; i++){
            if (enrolleesTemp.get(i).compareTo(enrolleesTemp.get(i + 1)) != 0) return false;
        }
        return true;
    }

    private void collision(ArrayList<Enrollee> enrolleesTemp){
        System.out.println("These enrollees have the same scores, but not enough space for everyone:");
        for (int i = 0; i < enrolleesTemp.size(); i++){
            System.out.println(enrolleesTemp.get(i).getFirstName() + " " + enrolleesTemp.get(i).getSecondName());
        }
        waiting();
    }

    public void read(){
        BufferedReader br = null;
        File file = new File(csvFile);
        String line = "";
        String cvsSplitBy = ";";
        if (file.isFile()){
                try {
                    br = new BufferedReader(new FileReader(csvFile));
                    while ((line = br.readLine()) != null) {
                        String[]fileInfo = line.split(cvsSplitBy);
                        Enrollee enrollee = new Enrollee();
                        enrollee.setFirstName(fileInfo[0]);
                        enrollee.setSecondName(fileInfo[1]);
                        enrollee.setMathScores(Integer.parseInt(fileInfo[2]));
                        enrollee.setPhysicScores(Integer.parseInt(fileInfo[3]));
                        enrollee.setLanguageScore(Integer.parseInt(fileInfo[4]));
                        enrollee.setCertificate(Integer.parseInt(fileInfo[5]));
                        enrolles.add(enrollee);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }

    public  void write(){
        File file = new File(csvFile);
        if (!file.isFile()){
            try {
                file.createNewFile();
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        try(FileWriter writer = new FileWriter(file, false))
        {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < enrolles.size(); i++){
                str.append(enrolles.get(i).toString());
            }
            writer.write(str.toString());
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
