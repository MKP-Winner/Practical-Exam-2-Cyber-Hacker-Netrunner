public class Software {
    private String name;
    private int powerBoost;

    public Software(String name, int powerBoost) {
        this.name = name;
        this.powerBoost = powerBoost;
    }

    public String getName() { return name; }
    public int getPowerBoost() { return powerBoost; }

    @Override
    public String toString() {
        return "[" + name + " (Boost: +" + powerBoost + ")]";
    }
}