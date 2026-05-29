class Solution {
    public int minElement(int[] nums) {

        int min = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++){
            int lastdigit = 0;
            int n = nums[i];
            while(n > 0){
                lastdigit += n % 10;
                n = n/10; 
            }
            if(lastdigit < min){
                min= lastdigit;
            }

        }
        return min;

    }
}