
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {


        Map<Integer,Integer>map=new HashMap<>();

        int psum=0;
        for(int i=0;i<nums.length;i++){
            psum+=nums[i];
            int mod=psum %k;

            if((i>0 && mod==0)|| (map.containsKey(mod) && map.get(mod) <i-1)) return true;

            if(!map.containsKey(mod)) map.put(mod,i);
        }
        return false;


        
    }
}



// nums = [23, 2, 4, 6, 7], k = 6
// Prefix Sum & Modulo Table:

// i	nums[i]	prefixSum	mod = prefixSum % 6	map
// 0	23	23	5	{5: 0}
// 1	2	25	1	{5: 0, 1: 1}
// 2	4	29	5	5 is in map at 0, i=2 → 2-0 > 1 ✅

// ➡ mod = 5 has occurred before at index 0. Current index is 2 → (2 - 0) = 2 ≥ 2
// So, subarray [2, 4] (indexes 1 to 2) sums to a multiple of 6.

// Output: true