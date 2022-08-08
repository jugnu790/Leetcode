class Solution {
   public String bestHand(int[] ranks, char[] suits) {
		Set<Character> suitsSet = new HashSet<>();
		for(char c : suits) suitsSet.add(c);

		Map<Integer, Integer> map = new HashMap();
		for(int i : ranks) map.put(i, map.getOrDefault(i, 0)+1);

		if(suitsSet.size() == 1) return "Flush";

		int value = 0;
		for(Map.Entry<Integer, Integer> entry : map.entrySet())
			value = Math.max(value, entry.getValue());

		if(value >= 3) return "Three of a Kind";
		else if(value == 2) return "Pair";
		return "High Card";
	}
}