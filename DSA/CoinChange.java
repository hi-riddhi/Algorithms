import java.util.Scanner;
import java.util.Arrays;

public class CoinChange {

    // Method to calculate the minimum number of coins required to make the given amount
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        // Initialize dp array with a value larger than the amount (representing infinity)
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1; // Larger than the maximum possible number of coins
        }

        // Loop to calculate the minimum coins for each amount
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still larger than the amount, it means it's impossible to form the amount
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the coins array
        System.out.println("Input:");
        System.out.print("coins: ");
        String coinsInput = scanner.nextLine().trim();

        // Remove unnecessary characters and split the input into individual coin values
        coinsInput = coinsInput.replaceAll("[\\[\\] ]", "");
        String[] coinStrings = coinsInput.split(",");

        // Convert the coin strings to integers
        int[] coins = new int[coinStrings.length];
        for (int i = 0; i < coinStrings.length; i++) {
            coins[i] = Integer.parseInt(coinStrings[i].trim());
        }

        // Prompt user for the amount
        System.out.print("amount: ");
        int amount = scanner.nextInt();

        // Call the coinChange method to calculate the result
        CoinChange solution = new CoinChange();
        int result = solution.coinChange(coins, amount);

        // Print the result as output
        System.out.println();
        System.out.println("Output:");
        System.out.println(result);

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
