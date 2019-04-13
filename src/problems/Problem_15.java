package problems;

import java.util.*;

public class Problem_15 {

    // return a unique list of numbers that have a sum of 0
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> positives = new HashSet<>();
        Set<Integer> negatives = new HashSet<>();
        Arrays.stream(nums).forEach(value -> {
            Integer count = map.get(value);
            if (count == null) map.put(value, 1);
            else map.replace(value, count + 1);
            if (value > 0)
                positives.add(value);
            else if (value < 0)
                negatives.add(value);
        });
        int zeros = 0;
        if (map.containsKey(0)) {
            zeros = map.get(0);
        }
        if (zeros > 2)
            list.add(Arrays.asList(0, 0, 0));
        int finalZeros = zeros;
        map.forEach((n1, c1) -> {
            if (n1.equals(0))
                return;
            if (finalZeros > 0)
                if (n1 > 0 && map.containsKey(-n1)) {
                    list.add(Arrays.asList(-n1, 0, n1));
                }
            if (c1 > 1) {
                if (map.containsKey(-2 * n1)) {
                    if (n1 > 0) list.add(Arrays.asList(-2 * n1, n1, n1));
                    else list.add(Arrays.asList(n1, n1, -2 * n1));
                }
            }
        });
        List<Integer> l1 = new ArrayList<>(positives);
        List<Integer> l2 = new ArrayList<>(negatives);
        for (int i = 0; i < l1.size() - 1; i++)
            for (int j = i + 1; j < l1.size(); j++) {
                int n1 = l1.get(i);
                int n2 = l1.get(j);
                int n3 = -(n1 + n2);
                if (negatives.contains(n3))
                    list.add(Arrays.asList(n1, n2, n3));
            }
        for (int i = 0; i < l2.size() - 1; i++)
            for (int j = i + 1; j < l2.size(); j++) {
                int n1 = l2.get(i);
                int n2 = l2.get(j);
                int n3 = -(n1 + n2);
                if (positives.contains(n3))
                    list.add(Arrays.asList(n1, n2, n3));
            }
        return list;
    }

    public List<List<Integer>> uniquify(List<List<Integer>> nums) {
        List<Integer> skips = new ArrayList<>();
        List<List<Integer>> groupedSimilar = new ArrayList<>();
        List<List<Integer>> uniques = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (skips.contains(i))
                continue;
            List<Integer> similar = getSimilar(nums, i);
            groupedSimilar.add(similar);
            skips.addAll(similar);
        }
        for (List<Integer> l : groupedSimilar) {
            uniques.add(nums.get(l.get(0)));
        }
        return uniques;
    }

    public List<Integer> getSimilar(List<List<Integer>> nums, int position) {
        List<Integer> similars = new ArrayList<Integer>() {{
            add(position);
        }};
        List<Integer> list = nums.get(position);
        for (int i = 0; i < nums.size(); i++) {
            if (i != position && areEqual(list, nums.get(i))) {
                similars.add(i);
            }
        }
        return similars;
    }

    public List<Integer> getSimilar(List<List<Integer>> nums, List<Integer> list) {
        List<Integer> similars = new ArrayList<Integer>() {{
//            add(position);
        }};
        for (int i = 0; i < nums.size(); i++) {
            if (areEqual(list, nums.get(i))) {
                similars.add(i);
            }
        }
        return similars;
    }

    public boolean areEqual(List<Integer> l1, List<Integer> l2) {
        for (int i = 0; i < l1.size(); i++) {
            if (!l1.get(i).equals(l2.get(i)))
                return false;
        }
        return true;
    }
}
