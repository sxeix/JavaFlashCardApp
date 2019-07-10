import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Cards {
    private String topic;
    private ArrayList<Fact> arr;

    public Cards(String t){
        this.topic = t;
        try {
            loadArr();
        } catch  (Exception e){
            System.out.println("Exception occurred");
        }
    }

    public ArrayList<Fact> getArr() {
        return arr;
    }

    public void loadArr() throws Exception {
        arr = new ArrayList<Fact>();
        File file = new File("src\\qa.txt");
        Scanner information = new Scanner(file);
        String q;
        String a;
        while (information.hasNextLine()) {
            q = information.nextLine();
            a = information.nextLine();
            Fact f = new Fact();
            f.setQuestion(q);
            f.setAnswer(a);
            arr.add(f);
        }
        information.close();
    }

    public void addFact(String q, String a) {
        try {
            Fact f = new Fact();
            f.setQuestion(q);
            f.setAnswer(a);
            arr.add(f);
            File file = new File("src\\qa.txt");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pw = new PrintWriter(br);
            pw.println(q);
            pw.println(a);
            pw.close();
            br.close();
            fr.close();
        } catch(Exception e) {
            System.out.println(e.toString());
        }

    }

    public Fact getFact() {
        Random r = new Random();
        return arr.get(r.nextInt(arr.size()));
    }

    public void displayFacts() {
        System.out.println("TOPIC: " + this.topic);
        for (Fact fact : arr) {
            System.out.println(fact.getQuestion());
            System.out.println(fact.getAnswer());
        }
    }
}
