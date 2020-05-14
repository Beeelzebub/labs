import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Enrollee implements Comparable<Enrollee> {
    private String firstName;
    private String secondName;
    private int mathScores;
    private int physicScores;
    private int languageScore;
    private int certificate;
    private boolean entered;
    private boolean coincidencesFlag;

    public Enrollee(){
        this.entered = false;
    }

    public Enrollee(String firstName, String secondName, int mathScores, int physicScores, int languageScore, int certificate){
        this.firstName = firstName;
        this.secondName = secondName;
        this.mathScores = mathScores;
        this.physicScores = physicScores;
        this.languageScore = languageScore;
        this.certificate = certificate;
        this.entered = false;
    }

    public void allInfoOutput(){
        System.out.println("\nFirst name: " + this.firstName +
                "\nSecond name: " + this.secondName +
                "\nMath scores: " + this.mathScores +
                "\nPhysic scores: " + this.physicScores +
                "\nLanguage scores: " + this.languageScore +
                "\nCertificate: " + this.certificate);
    }

    public int compareTo(Enrollee o) {
        if (!coincidencesFlag) return o.getAverageScores() - this.getAverageScores();
        else {
            if (this.getMathScores() != o.getMathScores()) return this.getMathScores() - o.getMathScores();
            else if (this.getPhysicScores() != o.getPhysicScores()) return  this.getPhysicScores() - o.getPhysicScores();
            else if (this.getCertificate() != o.getCertificate()) return this.getCertificate() - o.getCertificate();
            else return 0;
        }
    }

    public void refresh(){
        this.coincidencesFlag = false;
        this.entered = false;
    }

    @Override
    public String toString() {
        return firstName +
                ";" + secondName +
                ";" + mathScores +
                ";" + physicScores +
                ";" + languageScore +
                ";" + certificate +
                "\n";
    }

    public void setCoincidencesFlag() {
        this.coincidencesFlag = true;
    }

    public void setEntered(){
        this.entered = true;
    }

    public boolean isEntered() {
        return entered;
    }

    public int getAverageScores() {
        return mathScores + physicScores + languageScore + certificate;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getMathScores() {
        return mathScores;
    }

    public int getPhysicScores() {
        return physicScores;
    }

    public int getLanguageScore() {
        return languageScore;
    }

    public int getCertificate() {
        return certificate;
    }

    public void setCertificate(int certificate) {
        this.certificate = certificate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLanguageScore(int languageScore) {
        this.languageScore = languageScore;
    }

    public void setMathScores(int mathScores) {
        this.mathScores = mathScores;
    }

    public void setPhysicScores(int physicScores) {
        this.physicScores = physicScores;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enrollee enrollee = (Enrollee) o;
        return mathScores == enrollee.mathScores &&
                physicScores == enrollee.physicScores &&
                languageScore == enrollee.languageScore &&
                certificate == enrollee.certificate &&
                entered == enrollee.entered &&
                coincidencesFlag == enrollee.coincidencesFlag &&
                Objects.equals(firstName, enrollee.firstName) &&
                Objects.equals(secondName, enrollee.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, mathScores, physicScores, languageScore, certificate, entered, coincidencesFlag);
    }
}
