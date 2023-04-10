class Solution {
    public String longestPalindrome(String s) {
        int high = 0;
        String toReturn = "";
        for (int i = 0; i < s.length(); i++) {
            int currAsMiddle = 1;
            int startAsMiddle = i;
            int endAsMiddle = i;
            //two cases, expand as middle, or expand as left of middle.
            //as middle:
            for (int j = 1; i + j < s.length() && i - j >= 0; j++) {
                if (s.charAt(i + j) == s.charAt(i - j)) {
                    currAsMiddle += 2;
                    startAsMiddle = i - j;
                    endAsMiddle = i + j;
                } else {
                    break;
                }
            }
            System.out.println("i: " + i + ", " + currAsMiddle);
            int currLeftMiddle = 0;
            int startLeftMiddle = i;
            int endLeftMiddle = i - 1;
            for (int j = 1; i + j < s.length() && i - j + 1 >= 0; j++) { 
                if (s.charAt(i + j) == s.charAt(i - j + 1)) {
                    currLeftMiddle += 2;
                    startLeftMiddle = i - j + 1;
                    endLeftMiddle = i + j;
                } else {
                    break;
                }
            }

            if (currLeftMiddle > high && currLeftMiddle > currAsMiddle) {
                high = currLeftMiddle;
                System.out.println("Updating size = " + (endLeftMiddle + 1 - startLeftMiddle));
                toReturn = s.substring(startLeftMiddle, endLeftMiddle + 1);
            } else if (currAsMiddle > high && currAsMiddle > currLeftMiddle) {
                high = currAsMiddle;
                System.out.println("Updating size = " + (endAsMiddle + 1 - startAsMiddle));

                toReturn = s.substring(startAsMiddle, endAsMiddle + 1);
            }

        }
        return toReturn;
    }

}