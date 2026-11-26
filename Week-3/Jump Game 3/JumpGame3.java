public class JumpGame3 {
    public static void main(String[] args) {

        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;

        boolean result = canReach(arr, start);

        System.out.println(result);
    }

    public static boolean canReach(int[] arr, int start) {

        boolean[] visited = new boolean[arr.length];

        return dfs(arr, start, visited);
    }

    public static boolean dfs(int[] arr, int index, boolean[] visited) {

        if (index < 0 || index >= arr.length || visited[index]) {
            return false;
        }

        if (arr[index] == 0) {
            return true;
        }

        visited[index] = true;

        return dfs(arr, index + arr[index], visited) ||
               dfs(arr, index - arr[index], visited);
    }
}