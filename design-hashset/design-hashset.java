class MyHashSet {
    boolean[] arr  ;

    /** Initialize your data structure here. */
    public MyHashSet() {
        arr  = new boolean[1000001];
    }
    
    public void add(int i) {
        arr[i] = true;
    }
    
    public void remove(int i) {
        arr[i] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int i) {
        return arr[i];
    }
}