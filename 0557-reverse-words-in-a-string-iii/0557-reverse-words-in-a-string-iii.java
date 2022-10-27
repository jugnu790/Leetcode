class Solution {
    public String reverseWords(String str) {
        char[] arr =str.toCharArray();
        int j = 0, i = 0;
        for( ; i < arr.length ; i++){
            if(arr[i] ==' '){
                reverse(arr, j, i - 1);
                j = i+1;
            }
        }
        reverse(arr, j, arr.length - 1);
        return new String(arr);
    }
    
    static void reverse(char[]arr, int i, int j){
        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}