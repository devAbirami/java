//Using HashMap to store if prefix sums. 
//For every prefix sum x, check if a key (x-k) exists in map. If yes, k exists in the current subarray. 
//Map entries are stored as (sum,index) instead of (index,sum) for easier access. 
//Note that if existing sum in map is found again, map isn't updated. Only the left most keys are retained to achieve longest length later.

class Solution {
    public int longestSubarray(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap<>();
       int sum=0,maxLen=0; //base case solution
       for(int i=0;i<nums.length;i++){
        sum+=nums[i];
        if(!map.containsKey(sum)) map.put(sum,i); //Only the left most keys are retained to achieve longest length later
        if(sum==k) maxLen=Math.max(maxLen,i+1);
        if(map.containsKey(sum-k)){
            maxLen=Math.max(maxLen,i-map.get(sum-k)); 
        }
       }
       return maxLen;
    }
}
