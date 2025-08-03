class Solution {
    public int[] runningSum(int[] nums) {
        
        int []arr=new int[nums.length];
        arr[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            arr[i]=arr[i-1]+nums[i];
        }
        return arr;
    }
}
// simple cocde to find running sum of an array
// Time complexity: O(n)
// Space complexity: O(n) for the output array
// where n is the length of the input array nums.   
// The function iterates through the input array once, accumulating the sum in a new array.// The first element of the output array is initialized to the first element of the input array,
// and each subsequent element is the sum of the previous element in the output array and the current element in the input array.
// This approach ensures that the running sum is calculated efficiently in a single pass through the array. 
// The space complexity is O(n) because we are creating a new array of the same length as the input array to store the running sums.
// The function returns the new array containing the running sums.
// Example usage:
// Input: nums = [1, 2, 3, 4]
// Output: [1, 3, 6, 10]
// Explanation: The running sum is calculated as follows:
// - First element: 1
// - Second element: 1 + 2 = 3
// - Third element: 1 + 2 + 3 = 6
// - Fourth element: 1 + 2 + 3 + 4 = 10 
