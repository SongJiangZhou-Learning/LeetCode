import java.util.Arrays;

class ReconstructQueueByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, ((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        }));

        System.out.println(Arrays.deepToString(people));
        int[][] result = new int[people.length][];
        for (int[] person : people) {
            int ready = 0;
            int notReady = 0;
            for (int[] seat : result) {
                if (seat == null) {
                    notReady++;
                } else {
                    ready++;
                    continue;
                }
                if (notReady > person[1]) {
                    break;
                }
            }
            result[ready + notReady - 1] = person;
        }
        return result;
    }
}
