class Solution {
    
    public static int[] nsrIndex(int[] arr) {
      int n = arr.length;
      int[] res = new int[n];
      Stack<Integer> st = new Stack<>();
      st.push(0); // stack hold index of values
      for(int i = 1; i < n; i++) {
            // pop smaller value from stack and mark their next greater
         while(st.size() > 0 && arr[st.peek()] > arr[i]) {
             int indx = st.pop();
               res[indx] = i; // place value in res
         }
         st.push(i);
      }
      while(st.isEmpty() != true) {
         res[st.pop()] = arr.length;
      }
      return res;
   }

   public static int[] nslIndex(int[] arr) {
      int n = arr.length;
      int[] res = new int[n];
      Stack<Integer> st = new Stack<>();
      st.push( n - 1); // stack hold index of values
      for(int i = n - 2; i >= 0; i--) {
            // pop smaller value from stack and mark their next greater
         while(st.size() > 0 && arr[st.peek()] > arr[i]) {
            int indx = st.pop();
            res[indx] =i; // place value in res
         }
         st.push(i);
      }
      while(st.isEmpty() != true) {
         res[st.pop()] = -1;
      }
      return res;
   }

    
    public int largestRectangleArea(int[] arr) {
    int [] lsi = nslIndex(arr);
      int[] rsi = nsrIndex(arr);

      int area = 0;

      for(int i=0 ;i<arr.length;i++){
         int ht =arr[i];
         int wd = rsi[i]-lsi[i]-1;

         area = Math.max(area,ht*wd);
      }
      return area;
   }

   public static int largestAreaHistogram(int[] arr){
      int [] lsi = nslIndex(arr);
      int[] rsi = nsrIndex(arr);

      int area = 0;

      for(int i=0 ;i<arr.length;i++){
         int ht =arr[i];
         int wd = rsi[i]-lsi[i]-1;

         area = Math.max(area,ht*wd);
      }
      return area;
   }
    public int maximalRectangle(char[][] matrix) {
        int n= matrix[0].length;
        int [] ht = new int[n];
        int area =0;
        for(int r=0;r<matrix.length;r++){
            for(int c=0;c<matrix[0].length;c++){
                if(matrix[r][c]=='0'){
                    ht[c] =0;
                }else{
                    ht[c] +=1;
                }
            }
            area = Math.max(area,largestAreaHistogram(ht));
        }
        return area;
    }
}