class Solution {
    public int maxLength(List<String> arr) {
        List<String> list = new ArrayList<String>();
        list.add("");
        for (int i = 0; i < arr.size(); i++) {
            String str = arr.get(i);
            if (isUnique(str)) {
                int size = list.size();
                for (int j = 0; j < size; j++) {
                    String temp = list.get(j) + str;
                    if (isUnique(temp)) {
                        list.add(temp);
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i).length());
        }
        return max;
    }

    public static boolean isUnique(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1) {
                return false;
            }
        }
        return true;
    }
}
