// Problem Name: 18. 4Sum
// Time Complexity: O(n^3) & Space Complexity: O(n^2)
class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;
        
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;  // Skip duplicates
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;  // Skip duplicates
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum == target) {
                        result.add(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
                        while (k < l && arr[k] == arr[k + 1]) k++;  // Skip duplicates
                        while (k < l && arr[l] == arr[l - 1]) l--;  // Skip duplicates
                        k++;
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        
        return result;
    }
}
