public interface MineSweeper {
    void createEmptyField();
    void generateFilledField(int inputX, int inputY);
    void reveal(int x, int y);
    void fillFieldWithNums();
    void displayField(Cell[][] field);
}
