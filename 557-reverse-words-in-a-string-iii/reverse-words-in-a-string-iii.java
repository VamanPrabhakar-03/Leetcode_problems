class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        for(int i =0;i<arr.length;i++){
            char array[] = arr[i].toCharArray();
            
            int left = 0;
            int right = array.length-1;
            while(left <= right){
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
            }
            arr[i] = new String(array);
            
        }
        return  String.join(" ",arr);
        
    }
}