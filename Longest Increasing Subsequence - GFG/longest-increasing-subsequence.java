//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
         ArrayList<Integer> al = new ArrayList<>();
        al.add(a[0]);
        for(int i=1;i<size;i++){
            int s = al.size();
            if(a[i]>al.get(s-1)){
                al.add(a[i]);
            }else{
                int index = Collections.binarySearch(al,a[i]);
                if(index<0){
                    index = Math.abs(index+1);
                    al.set(index,a[i]);
                }
            }
        }
        return al.size();
    }
} 