public class splitNum {
    public static int[] split(int n) {
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        boolean flag = true;

        for (char bit : Integer.toBinaryString(n).toCharArray()) {
            if (bit == '0') {
                left.append(bit);
                right.append(bit);
            } else if (bit == '1') {
                if (flag) {
                    left.append(bit);
                    right.append('0');
                } else {
                    right.append(bit);
                    left.append('0');
                }
                flag = !flag;
            }
        }

        return new int[] { Integer.parseInt(left.toString(), 2), Integer.parseInt(right.toString(), 2) };
    }


    public static void main(String[] args) {
        int n = 13;  
        int[] result = split(n);
        System.out.println(Integer.toBinaryString(result[0]) + " + " + Integer.toBinaryString(result[1]));
    }
}


