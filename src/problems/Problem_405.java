package problems;

public class Problem_405 {
    // convert a decimal to hex String
    public String toHex(int num) {
        int dev = num;
        StringBuilder builder = new StringBuilder();
        while (Integer.divideUnsigned(dev, 16) != 0) {
            builder.append(HEX[Integer.remainderUnsigned(dev, 16)]);
            dev = Integer.divideUnsigned(dev, 16);
        }
        builder.append(HEX[dev]);
        return builder.reverse().toString();
    }

    private static final char[] HEX = new char[] {
            '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'
    };
}
