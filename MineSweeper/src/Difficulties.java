public enum Difficulties {
    EASY(10),
    MEDIUM(20),
    HARD(35),
    INSANE(50);
    public final int mineGenerationProbability;
    Difficulties(int i) {
        mineGenerationProbability = i;
    }
    int getMineGenerationProbability() {
        return mineGenerationProbability;
    }
}
