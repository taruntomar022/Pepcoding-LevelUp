class Solution {
   public List<List<Integer>> subsetsWithDup(int[] nums) {
       if(nums.length == 0) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sans = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums, 0, sans, ans);
        return ans;
    }

    public void subsets(int[] nums, int idx, List<Integer> sans, List<List<Integer>> ans) {
        List<Integer> base = new ArrayList<>(sans);
        ans.add(base);

        int prev = (int) -1e8; // to make unique combinations
        for (int i = idx; i < nums.length; i++) {
            if (nums[i] != prev) {
                prev = nums[i];
                sans.add(nums[i]);
                subsets(nums, i + 1, sans, ans);
                sans.remove(sans.size() - 1);
            }
        }
    }
}
