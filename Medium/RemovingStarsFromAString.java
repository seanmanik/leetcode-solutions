class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        Stack<Character> newSt = new Stack<>();
        while (!st.empty()) {
            newSt.push(st.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!newSt.empty()) {
            sb.append(newSt.pop());
        }
        return sb.toString();
    }
}