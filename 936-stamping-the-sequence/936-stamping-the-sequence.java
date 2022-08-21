class Solution {
  public int[] movesToStamp(String stamp, String target) {
    List<Integer> ans = new ArrayList<>();
    char[] T = target.toCharArray();
    
    boolean[] stamped = new boolean[target.length()];
    int stampedCount = 0; 

    while (stampedCount < T.length) {
      boolean isStamped = false;
      
      for (int i = 0; i <= T.length - stamp.length(); ++i) {
        if (stamped[i])
          continue;
        final int stampified = stampify(stamp, T, i);
        if (stampified == 0)
          continue;
        stampedCount += stampified;
        isStamped = true;
        stamped[i] = true;
        ans.add(i);
      }
      
      if (!isStamped)
        return new int[] {};
    }

    Collections.reverse(ans);
    return ans.stream().mapToInt(i -> i).toArray();
  }


  private int stampify(final String stamp, char[] T, int s) {
    int stampified = stamp.length();

    for (int i = 0; i < stamp.length(); ++i)
      if (T[s + i] == '*') 
        --stampified;
      else if (T[s + i] != stamp.charAt(i))
        return 0;

    Arrays.fill(T, s, s + stamp.length(), '*');

    return stampified;
  }
}
