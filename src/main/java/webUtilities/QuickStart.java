package webUtilities;

public class QuickStart {

    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        System.out.println(new QuickStart().getGreeting());
    }
}
