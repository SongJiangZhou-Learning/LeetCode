import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        if (n == 1) {
            return 1;
        }
        int judge = -1;
        HashMap<Integer, HashSet<Integer>> uTrust = new HashMap<>();
        HashSet<Integer> trustU = new HashSet<>();
        for (int[] person : trust) {
            trustU.add(person[0]);
            if (!trustU.contains(person[1])) {
                HashSet<Integer> trustList = uTrust.get(person[1]);
                if (trustList == null) {
                    trustList = new HashSet<>();
                }
                trustList.add(person[0]);
                uTrust.put(person[1], trustList);
            } else {
                uTrust.remove(person[0]);
            }
        }

        for (Map.Entry<Integer, HashSet<Integer>> entry : uTrust.entrySet()) {
            if (entry.getValue().size() == n - 1) {
                if (judge != -1) {
                    return -1;
                } else {
                    judge = entry.getKey();
                }
            }
        }
        return judge;
    }
}