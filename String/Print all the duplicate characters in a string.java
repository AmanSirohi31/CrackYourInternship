public class Solution {

    public static ArrayList<Pair> duplicate_char(String s, int n) {
        
        Map<Character, Integer> map = new HashMap<>();
        ArrayList<Pair> ans = new ArrayList<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, 1);
            }else{
                map.put(ch, map.get(ch)+1);
            }
        }

        for(Character key : map.keySet()){
            
            if(map.get(key)>1){
                ans.add(new Pair(key, map.get(key)));
            }
        }
        return ans;
    }
}
