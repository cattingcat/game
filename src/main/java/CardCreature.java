public abstract class CardCreature extends Card{
    private int health;
    private int attack;
    private int turn;
    private String name;

    public CardCreature(int manaCost,int baseHealth, int baseAttack, int baseTurn, CardEffect effect,String name) {
        super(manaCost,effect);
        this.name = name;
        this.turn = baseTurn;
        this.health= baseHealth;
        this.attack = baseAttack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
