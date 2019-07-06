public class Main {

    public static void main(String[] args) throws Exception {
        String t = "TestSet";
        Cards c = new Cards(t);
        c.loadArr();
        c.displayFacts();
        String question = "Where do I live?";
        String answer = "United Kingdom";
        c.addFact(question, answer);
        c.displayFacts();
    }
}
