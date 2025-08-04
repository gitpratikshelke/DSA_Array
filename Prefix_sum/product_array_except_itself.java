
class Solution {
    public int[] productExceptSelf(int[] nums) {


        int []preprod=new int[nums.length];
        preprod[0]=nums[0];
        

        for(int i=1;i<nums.length;i++){
            preprod[i]=preprod[i-1]*nums[i];
        }
        int suffix=1;
        for(int i=nums.length-1;i>0;i--){
            preprod[i]=preprod[i-1]*suffix;
            suffix=suffix*nums[i];
        }
        preprod[0]=suffix;
        return preprod;
        
    }
}