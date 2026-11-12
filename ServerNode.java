import java.util.Random;

public class ServerNode {
    private String serverName;
    private String[] securityLayers = {"Ice-Wall", "Proxy-Node", "Cipher-Core", "Mainframe"};
    private int[] firewallCodes = {101, 202, 303, 404};
    private Random random = new Random();

    public ServerNode(String serverName) {
        this.serverName = serverName;
    }

    public String getServerName() { return serverName; }

    /**
     * Matches the player's guessed index position against the server's security array.
     */
    public boolean bypassLayer(int userIndex, int userGuessCode) {
        if (userIndex >= 0 && userIndex < securityLayers.length) {
            System.out.println("Targeting layer: " + securityLayers[userIndex]);
            // Position-based matching check
            if (firewallCodes[userIndex] == userGuessCode) {
                System.out.println(">>> Layer successfully bypassed!");
                return true;
            }
        }
        System.out.println(">>> Breached failed! Alarm triggered.");
        return false;
    }
    
    public int[] getFirewallCodes() {
        return firewallCodes;
    }
}