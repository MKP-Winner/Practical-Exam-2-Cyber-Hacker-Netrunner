/* 
  Project: Cyber-Hacker / Netrunner (Level 2 Practical Exam)

  I have only used resources indicated that are allowable.
  The work submitted is my/our, and only my/our work.
  Signature: Mithunkarthick Parthiban
  Date: 11/12/26
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("=== CYBER-HACKER: NETRUNNER ===");
            System.out.print("Enter your Netrunner handle: ");
            String handle = scanner.nextLine();

            // Initialize player with starting resources
            Hacker player = new Hacker(handle, 1000, 16, 100);
            ServerNode corpServer = new ServerNode("Arasaka-Mainframe");

            System.out.println("\n" + player);
            
            // Start Session
            HackSession session = new HackSession(player, corpServer);
            session.startInfiltration();

        } catch (InputMismatchException e) {
            // Exception handling for menu/input errors
            System.out.println("Critical Error: Invalid input type entered. System shutting down.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Terminal session closed.");
        }
    }
}