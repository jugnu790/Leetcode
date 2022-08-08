class Solution {
public:
    int shortestSequence(vector<int>& rolls, int k) {
        vector<int> s{};
        int a = rolls.size();
        unordered_set<int> t;
        for(int v = 0; v< a; v++){
            t.insert(rolls[v]);
            if(t.size() == k){
                s.push_back(rolls[v]);
                t.clear();
            }
        }
        for(char l = 1; l <= k + 1;l++){
            if (t.count(l) == 0){
                s.push_back(l);
                return s.size();
            }
        }
        return s.size();
    }
};