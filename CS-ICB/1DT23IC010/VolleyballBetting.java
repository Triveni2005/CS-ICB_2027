import java.util.Scanner;

public class VolleyballBettingSystem {
    public static void main(String[] args) {
        String[] matches = {
            "USA vs Italy",
            "Brazil vs Japan",
            "Russia vs Poland",
            "China vs Serbia"
        };

        double[][] odds = {
            {2.5, 1.9, 1.7},
            {3.0, 2.1, 2.3},
            {1.8, 2.3, 2.9},
            {2.6, 2.0, 2.4}
        };

        Scanner sc = new Scanner(System.in);
        System.out.println("🏐 Welcome to VolleyBet – Volleyball Match Betting 🏆\n");

        // Show matches
        for (int i = 0; i < matches.length; i++) {
            System.out.printf("%d. %s (Win: %.2f | Draw: %.2f | Lose: %.2f)%n",
                i + 1, matches[i], odds[i][0], odds[i][1], odds[i][2]);
        }

        System.out.print("\nChoose a match (1-4): ");
        int matchChoice = sc.nextInt();
        if (matchChoice < 1 || matchChoice > 4) {
            System.out.println("❌ Invalid match selection. Exiting...");
            return;
        }

        System.out.println("\nChoose your bet type:");
        System.out.println("1. Win\n2. Draw\n3. Lose");
        System.out.print("Enter choice: ");
        int betType = sc.nextInt();
        if (betType < 1 || betType > 3) {
            System.out.println("❌ Invalid bet type. Exiting...");
            return;
        }

        System.out.print("Enter bet amount (₹): ");
        double amount = sc.nextDouble();
        if (amount <= 0) {
            System.out.println("❌ Invalid amount. Exiting...");
            return;
        }

        double selectedOdds = odds[matchChoice - 1][betType - 1];
        double potentialWin = amount * selectedOdds;

        System.out.println("\n🎫 Betting Receipt");
        System.out.println("------------------------");
        System.out.println("Match       : " + matches[matchChoice - 1]);
        System.out.println("Bet Type    : " + (betType == 1 ? "Win" : betType == 2 ? "Draw" : "Lose"));
        System.out.println("Bet Amount  : ₹" + amount);
        System.out.printf("Odds        : %.2f%n", selectedOdds);
        System.out.printf("Payout      : ₹%.2f%n", potentialWin);
        System.out.println("------------------------");
        System.out.println("✅ Good luck! Enjoy the match!");

        sc.close();
    }
}
