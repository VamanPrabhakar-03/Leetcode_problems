class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");     
            for(int i =0,j = arr.length-1; i<j;i++,j--){
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
        }
return String.join(" ",arr);          

        
    }
}