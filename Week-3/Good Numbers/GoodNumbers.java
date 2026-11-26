public class GoodNumbers {
    public static void main(String[] args) {

        long n = 4;

        long result = countGoodNumbers(n);

        System.out.println(result);
    }

    public static long countGoodNumbers(long n) {

        long mod = 1000000007;

        long even = (n + 1) / 2;
        long odd = n / 2;

        long a = power(5, even, mod);
        long b = power(4, odd, mod);

        return (a * b) % mod;
    }

    public static long power(long a, long b, long mod) {

        long result = 1;

        while (b > 0) {

            if (b % 2 == 1) {
                result = (result * a) % mod;
            }

            a = (a * a) % mod;
            b = b / 2;
        }

        return result;
    }
}