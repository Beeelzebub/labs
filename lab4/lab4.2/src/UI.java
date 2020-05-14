import java.util.Scanner;

public class UI {
    private int choose;
    private Handler handler = new Handler();
    Scanner in = new Scanner(System.in);

    public void startProcess(){
        handler.read("enrolles.csv");
        menu();
        while(true){
            choose = in.nextInt();
            switch (choose){
                case 1:
                    handler.view();
                    menu();
                    break;
                case 2:
                    handler.add();
                    menu();
                    break;
                case 3:
                    editChoose();
                    menu();
                    break;
                case 4:
                    deleteChoose();
                    menu();
                    break;
                case 5:
                    admissionChoose();
                    menu();
                    break;
                case 0:
                    handler.exit();
                    return;
                default: System.out.println("Incorrect input :(");
            }
        }
    }

    public void menu(){
        System.out.println("\nMenu:\n1.View\n2.Add\n3.Edit\n4.Delete\n5.Admission\n0.Exit");
    }

    public void deleteChoose(){
        System.out.println("Enter the number of enrollee to delete:");
        handler.getNames();
        int index = in.nextInt();
        if (!handler.enrolles.isEmpty()) {
            if (index > 0 && index <= handler.enrolles.size()) {
                handler.delete(index - 1);
            } else System.out.println("Incorrect input :(");
        } else System.out.println("No data to delete :(");
    }

    public void editChoose(){
        if (!handler.enrolles.isEmpty()) {
            System.out.println("Enter the number of enrollee to change:");
            handler.getNames();
            int index = in.nextInt();
            System.out.println("Enter the field to change:\n1.First name\n2.Second name\n3.Math sores" +
                    "\n4.Physic scores\n5.Language scores\n6.Certificate");
            int field = in.nextInt();
            if (index > 0 && index < handler.enrolles.size() && field > 0 && field < 7){
                System.out.println("Enter new data:");
                handler.edit(index - 1, field);
            } else System.out.println("Incorrect input :(");
        } else System.out.println("No data to change :(");
    }

    public void admissionChoose(){
        System.out.println("Enter the number of places");
        int places = in.nextInt();
        if (places > handler.enrolles.size()) places = handler.enrolles.size();
        handler.admission(places);
        handler.enteredEnrollesOutput();
    }
}
