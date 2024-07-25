// Allocate Minimum Pages
// You have n books, each with arr[i] a number of pages. m students need to be allocated contiguous books, with each student getting at least one book.
// Out of all the permutations, the goal is to find the permutation where the sum of the maximum number of pages in a book allotted to a student should be the minimum, out of all possible permutations.
//Time: O(nlogn) & Space: O(n)\
class Solution {
    // Function to find minimum number of pages.
    public static long findPages(int n, int[] arr, int m) {
        // If there are more students than books, it's not possible to allocate
        if (m > n) {
            return -1;
        }
        
        int low = 0, high = 0;
        for (int pages : arr) {
            low = Math.max(low, pages);  // The max number of pages in a single book
            high += pages;  // The sum of all pages
        }
        
        int result = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (isFeasible(arr, n, m, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return result;
    }
    
    // Helper function to check if a given maxPages value is feasible
    private static boolean isFeasible(int[] arr, int n, int m, int maxPages) {
        int studentsRequired = 1, currentPages = 0;
        
        for (int i = 0; i < n; i++) {
            if (currentPages + arr[i] > maxPages) {
                studentsRequired++;
                currentPages = arr[i];
                if (studentsRequired > m) {
                    return false;
                }
            } else {
                currentPages += arr[i];
            }
        }
        
        return true;
    }
}
