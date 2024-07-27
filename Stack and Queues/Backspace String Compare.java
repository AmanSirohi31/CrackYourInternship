class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        int i=0;
        while(i<s.length() || i<t.length()){
            if(i<s.length()){
                char ch = s.charAt(i);
                if(ch=='#'){
                    if(!st1.isEmpty())st1.pop();
                }else{
                    st1.push(ch);
                }
            }
            if(i<t.length()){
                char ch = t.charAt(i);
                if(ch=='#'){
                    if(!st2.isEmpty())st2.pop();
                }else{
                    st2.push(ch);
                }
            }
            i++;

        }
        while(!st1.isEmpty() && !st2.isEmpty()){
            if(st1.pop()!=st2.pop()){
                return false;
            }
        }
        if(!st1.isEmpty() || !st2.isEmpty()){
            return false;
        }
        return true;
    }
}
