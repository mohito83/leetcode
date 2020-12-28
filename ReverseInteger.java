class ReverseInteger {
    public static int reverse(int x) {
        if (x == 0) {
            return x;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        while (x!=0) {
            queue.addLast(x%10);
            x/=10;
        }

        int result = 0;
        while (!queue.isEmpty()) {
            int num = queue.removeFirst();
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE/10 && num >7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE/10 && num <-8)) {
                return 0;
            }
            result *= 10;
            result += num;
        }

        return result;
    }
 
    public static void main(String[] agrs) {
        System.out.println("result:" + reverse(3321249));
    }
}
