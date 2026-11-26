public class WinnerofCircularGame {
    public static void main(String[] args) {

        int n = 5;
        int k = 2;

        int result = findTheWinner(n, k);

        System.out.println(result);
    }

    public static int findTheWinner(int n, int k) {

        int winner = 0;

        for (int i = 1; i <= n; i++) {
            winner = (winner + k) % i;
        }

        return winner + 1;
    }
}