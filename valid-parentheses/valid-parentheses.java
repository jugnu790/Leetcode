class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            switch(ch) {
                case '(' : 
                    stack.push('(');
                    break;
                case '{' : 
                    stack.push('{');
                    break;
                case '[' : 
                    stack.push('[');
                    break;
                case ')' : 
                    if(stack.isEmpty()) return false;
                    if(stack.pop() != '('){
                        return false;
                    }
                    break;
                case '}' : 
                    if(stack.isEmpty()) return false;
                    if(stack.pop() != '{'){
                        return false;
                    }
                    break;
                case ']' : 
                    if(stack.isEmpty()) return false;
                    if(stack.pop() != '['){
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty() == true;
    }
}