import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HackSession {
    private Hacker hacker;
    private ServerNode server;
    private ArrayList<Software> deck;
    private Scanner scanner;
    private Random random;

    public HackSession(Hacker hacker, ServerNode server) {
        this.hacker = hacker;
        this.server = server;
        this.deck = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        
        // Initialize sample software in ArrayList
        deck.add(new Software("BruteForce.exe", 15));
        deck.add(new Software("StealthSpoof", 25));
    }

    public void startInfiltration() {
        System.out.println("\nConnecting to " + server.getServerName() + "...");
        
        // Resource Tracking: Cost per play / RAM usage
        int sessionCost = 50;
        hacker.setCredits(hacker.getCredits() - sessionCost);
        System.out.println("Access fee paid: " + sessionCost + " credits. Current Balance: " + hacker.getCredits());

        // Position matching puzzle example
        System.out.print("Enter security array index (0-3) to bypass: ");
        try {
            int index = scanner.nextInt();
            System.out.print("Enter override code (Hint - Try: 101, 202, 303, or 404): ");
            int code = scanner.nextInt();

            boolean success = server.bypassLayer(index, code);

            if (success) {
                // Bonus Multiplier System (Criterion 7: 1.0x to 3.0x multiplier)
                double[] multipliers = {1.0, 1.5, 2.0, 3.0};
                double earnedMultiplier = multipliers[random.nextInt(multipliers.length)];
                
                int basePayout = 200;
                int finalPayout = (int)(basePayout * earnedMultiplier);
                
                hacker.setCredits(hacker.getCredits() + finalPayout);
                System.out.println("Hack successful! Multiplier applied: " + earnedMultiplier + "x");
                System.out.println("Credits earned: " + finalPayout + " | New Balance: " + hacker.getCredits());
            } else {
                hacker.setFirewallIntegrity(hacker.getFirewallIntegrity() - 25);
                System.out.println("Security counter-attack! Firewall health dropped to: " + hacker.getFirewallIntegrity() + "%");
            }

        } catch (Exception e) {
            System.out.println("Input error detected. Session aborted.");
            scanner.next(); // clear invalid token
        }
    }
}