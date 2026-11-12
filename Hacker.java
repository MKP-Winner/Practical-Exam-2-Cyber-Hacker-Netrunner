public class Hacker {
    private String handle;
    private int credits;
    private int ram;
    private int firewallIntegrity;

    public Hacker(String handle, int credits, int ram, int firewallIntegrity) {
        this.handle = handle;
        setCredits(credits);
        setRam(ram);
        setFirewallIntegrity(firewallIntegrity);
    }

    // Accessors (Getters)
    public String getHandle() { return handle; }
    public int getCredits() { return credits; }
    public int getRam() { return ram; }
    public int getFirewallIntegrity() { return firewallIntegrity; }

    // Mutators (Setters) with validation
    public void setCredits(int credits) {
        this.credits = Math.max(0, credits);
    }

    public void setRam(int ram) {
        this.ram = Math.max(0, ram);
    }

    public void setFirewallIntegrity(int firewallIntegrity) {
        this.firewallIntegrity = Math.max(0, Math.min(100, firewallIntegrity));
    }

    public boolean isConnected() {
        return this.firewallIntegrity > 0;
    }

    @Override
    public String toString() {
        return "Netrunner: " + handle + " | Credits: " + credits + "¢ | RAM: " + ram + "GB | Firewall: " + firewallIntegrity + "%";
    }
}