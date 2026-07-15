class Solution {
    public void rotate(int[][] matrix) {
        for(int i =0;i<matrix.length-1;i++){
            for(int j =i+1;j<matrix.length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0;i<=matrix.length-1;i++){
            int left = 0;
            int right = matrix[i].length-1;
            int[] mat = matrix[i];
            while(left <= right){
                int temp = mat[left];
                mat[left] = mat[right];
                mat[right] = temp;
                left++;
                right--;   

            }
        }
        
    }
}