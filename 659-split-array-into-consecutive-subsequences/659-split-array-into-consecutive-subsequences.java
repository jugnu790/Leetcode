class Solution {
    public boolean isPossible(int[] nums) {


      if (nums == null || nums.length < 3) {


          return false;


      }


      List<List<Integer>> subsequences = new ArrayList<>();


      for (int num : nums) {


          if (subsequences.isEmpty()) {


              List<Integer> subsequence = new ArrayList<>();


              subsequence.add(num);


              subsequences.add(subsequence);


          } else {


              boolean inserted = false;


              List<Integer> firstSubsequence = null;


              for (List<Integer> subsequence : subsequences) {


                  if (subsequence.get(subsequence.size() - 1) == num - 1) {


                      if(null == firstSubsequence){


                          firstSubsequence = subsequence;


                      }


                      if(subsequence.size() < 3) {


                          subsequence.add(num);


                          inserted = true;


                          break;


                      }


                  }




                  if (subsequence.get(subsequence.size() - 1) < num - 1 && subsequence.size() < 3){


                      return false;


                  }


              }




              if (!inserted && firstSubsequence != null) {


                  firstSubsequence.add(num);


                  inserted = true;


              }




              if (!inserted) {


                  List<Integer> subsequence = new ArrayList<>();


                  subsequence.add(num);


                  subsequences.add(subsequence);


              }


          }


      }




      for (List<Integer> subsequence : subsequences) {


          if (subsequence.size() < 3) {


              return false;


          }


      }


      return true;


  }
}
