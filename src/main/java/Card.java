/**
 * Created by gbuh on 02.02.14.
 */
public abstract class Card {
    private int manaCost;

    protected Card(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }
}
