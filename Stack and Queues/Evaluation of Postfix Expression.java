
class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        Stack<Integer> st = new Stack<>();
        int i=0;
        while(i<S.length()){
            char ch = S.charAt(i);
            if(ch-'0'>=0 && ch-'0'<=9){
                st.push(ch-'0');
            }else{
                int op2 = st.pop();
                int op1 = st.pop();
                if(ch=='+')st.push(op1+op2);
                else if(ch=='-')st.push(op1-op2);
                else if(ch=='*')st.push(op1*op2);
                else if(ch=='/')st.push(op1/op2);
            }
            i++;
        }
        return st.peek();
    }
}
