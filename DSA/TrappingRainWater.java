import java.util.*;

public class TrappingRainWater {

    // Function to calculate trapped rainwater using two-pointer approach
    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt user to enter input
        System.out.print("Input: ");
        String input = sc.nextLine().trim();

        // Remove brackets and spaces
        input = input.replaceAll("\\[|\\]|\\s", "");

        // Split by commas to get individual numbers
        String[] parts = input.split(",");

        // Convert string array to int array
        int[] height = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            height[i] = Integer.parseInt(parts[i]);
        }

        // Compute and print the result
        int result = trap(height);
        System.out.println("Output: " + result);
    }
}
