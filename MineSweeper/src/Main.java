public class Main {
    public static void main(String[] args) {
        MineSweeperGame sweeperGame = new MineSweeperGame(10, 10, Difficulties.INSANE);
        sweeperGame.generateFilledField(5, 5);
        sweeperGame.fillFieldWithNums();
        sweeperGame.displayField(sweeperGame.getFilledField());
        sweeperGame.displayField(sweeperGame.getEmptyField());

    }
}