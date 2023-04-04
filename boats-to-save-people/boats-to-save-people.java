class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int number = 0;
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        while( l <= r){
            if(people[l] + people[r] <= limit)
                l++;
            r--;
            number++;
        }
        return number;
    }
}