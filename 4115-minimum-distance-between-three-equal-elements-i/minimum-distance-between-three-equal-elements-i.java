public class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            List<Integer> indices = map.get(nums[i]);
            if (indices.size() >= 3) {
                int k = indices.get(indices.size() - 1);
                int i_idx = indices.get(indices.size() - 3);
                int currentDistance = 2 * (k - i_idx);
                minDistance = Math.min(minDistance, currentDistance);
                found = true;
            }
        }

        return found ? minDistance : -1;
    }
}