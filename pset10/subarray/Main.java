import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        BigInteger maxProduct = maxProduct(nums);
        System.out.println(maxProduct);

        scanner.close();
    }

    public static BigInteger maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return BigInteger.ZERO;
        }

        BigInteger maxProduct = BigInteger.valueOf(nums[0]);
        BigInteger minProduct = BigInteger.valueOf(nums[0]);
        BigInteger result = BigInteger.valueOf(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            BigInteger num = BigInteger.valueOf(nums[i]);

            if (nums[i] < 0) {
                BigInteger temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = num.max(num.multiply(maxProduct));
            minProduct = num.min(num.multiply(minProduct));
            result = result.max(maxProduct);
        }

        return result;
    }
}
