class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int i=0;
        while(i<tokens.length){
            String s = tokens[i];
            if(s.equals("+")){
                int op2 = st.pop();
                int op1 = st.pop();
                st.push(op1+op2);
            }else if(s.equals("-")){
                int op2 = st.pop();
                int op1 = st.pop();
                st.push(op1-op2);
            }else if(s.equals("*")){
                int op2 = st.pop();
                int op1 = st.pop();
                st.push(op1*op2);
            }else if(s.equals("/")){
                int op2 = st.pop();
                int op1 = st.pop();
                st.push(op1/op2);
            }else{
                st.push(Integer.valueOf(s));
            }
            i++;
        }
        return st.peek();
    }
}
