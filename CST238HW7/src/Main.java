//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int time = 427;
        int S = time % 60;
        int h = time / 60;

        String formattedTime = String.format("%02d:%02d", S, h);
        System.out.println(formattedTime);

    }
}