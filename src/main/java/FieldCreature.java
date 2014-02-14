public class FieldCreature {
    private int health;
    private int attack;
    private int turn;
    private int baseHealth;
    private int baseAttack;
    private int baseTurn;
    private CardEffect effect;
    private String name;

    public FieldCreature(int baseHealth, int baseAttack, int baseTurn, CardEffect effect,String name) {
        this.baseHealth = baseHealth;
        this.baseAttack = baseAttack;
        this.baseTurn = baseTurn;
        this.effect = effect;
        this.name = name;
        this.turn = baseTurn;
        this.health= baseHealth;
        this.attack = baseAttack;
    }
    public FieldCreature() {
        this(1,1,1,null,"Бесполезный бес");
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
}
