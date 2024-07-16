//122. Best Time to Buy and Sell Stock II
//Time Complexity : O(N) , Space Complexity : O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        for(int i=1; i<prices.length; i++) {
            if(prices[i]>buy) {
                profit += prices[i] - buy;
            }
            buy = prices[i];
        }
        return profit;        
    }
}
