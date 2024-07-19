// All Unique Permutations of an array
// Given an array arr[] of length n. Find all possible unique permutations of the array in sorted order. A sequence A is greater than sequence B if there is an index i for which Aj = Bj for all j<i and Ai > Bi.
// Time Comp : O(nlogn) + O(n.n!) = O(n.n!) & Space Comp : O(n)
class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(arr); // Sort the array to ensure permutations are generated in lexicographical order
        boolean[] used = new boolean[n];
        backtrack(result, new ArrayList<>(), arr, used);
        return result;
    }

    private static void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tempList, ArrayList<Integer> arr, boolean[] used) {
        if (tempList.size() == arr.size()) {
            result.add(new ArrayList<>(tempList)); // Add a new copy of tempList to result
        } else {
            for (int i = 0; i < arr.size(); i++) {
                if (used[i] || (i > 0 && arr.get(i).equals(arr.get(i - 1)) && !used[i - 1])) {
                    continue; // Skip duplicates
                }
                used[i] = true;
                tempList.add(arr.get(i));
                backtrack(result, tempList, arr, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
