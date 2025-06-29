class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1000000007;
        int[] p = new int[nums.length];
        p[0]=1;
        for(int i=1;i<nums.length;i++){
            p[i]=(p[i-1]*2) % mod;
        }
        int left=0;
        int right=nums.length-1;
        int count=0;
        while(left<=right){
            if(nums[left]+nums[right]>target){
                right--;
            }
            else{
                count=(count+p[right-left])%mod;
                left++;
            }
        }
        return count;
    }
}