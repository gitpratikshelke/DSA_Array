// public class find_highest_alitude {
    
// }
class Solution {
    public int largestAltitude(int[] gain) {
        
        int maxalt=0;  
        for(int i=1;i<gain.length;i++){
            gain[i]+=gain[i-1];
        }
         for(int i=0;i<gain.length;i++){
            maxalt=Math.max(maxalt,gain[i]);
        }
        return maxalt;
      
    }
}
// This code finds the highest altitude from a given array of altitude gains.
// Time complexity: O(n)    
// Space complexity: O(1) for the output variable maxalt
// The function iterates through the input array once, accumulating the altitude gains in place.
//link:https://leetcode.com/problems/find-the-highest-altitude/