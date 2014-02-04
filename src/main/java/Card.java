
public abstract class Card {
    private int manaCost;
    private CardEffect effect;

    protected Card(int manaCost,CardEffect effect) {
        this.manaCost = manaCost;
        this.effect = effect;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }
}
