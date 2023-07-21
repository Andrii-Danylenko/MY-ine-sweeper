import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserLogic {
    private MineSweeperGame mineSweeperGame;
    private final BufferedReader reader;
    public UserLogic() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }
    public void listenCommands() {

     while (true) {

     }
    }
    private Difficulties chooseDifficulty() {
        System.out.println("""
                Choose difficulty:\s
                1. Easy(10 bombs spawn chance per cell)
                2. Medium(20 bombs spawn chance per cell)
                3. Hard(35 bombs spawn chance per cell)
                4. Insane(50 bombs spawn chance per cell)\s""");
        while (true) {
            try {
                switch (reader.readLine().toLowerCase().trim()) {
                    case ("1"):
                    case ("easy"):
                        return Difficulties.EASY;
                    case ("2"):
                    case ("medium"):
                        return Difficulties.MEDIUM;
                    case ("3"):
                    case ("hard"):
                        return Difficulties.HARD;
                    case ("4"):
                    case ("insane"):
                        return Difficulties.INSANE;
                    default:
                        System.out.println("Wrong command. Repeat your input.");
                }
            } catch (IOException exception) {
                System.err.println("Something went wrong with input-output!");
                exception.printStackTrace();
            }
        }
    }
}
