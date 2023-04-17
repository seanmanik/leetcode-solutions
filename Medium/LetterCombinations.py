class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        res = []
        for i in range(len(digits)):
            currDigit = digits[i]
            possibilities = []
            if currDigit == "2":
                possibilities = ["a", "b", "c"]
            elif currDigit == "3":
                possibilities = ["d", "e", "f"]
            elif currDigit == "4":
                possibilities = ["g", "h", "i"]
            elif currDigit == "5":
                possibilities = ["j", "k", "l"]
            elif currDigit == "6":
                possibilities = ["m", "n", "o"]
            elif currDigit == "7":
                possibilities = ["p", "q", "r", "s"]
            elif currDigit == "8":
                possibilities = ["t", "u", "v"]
            elif currDigit == "9":
                possibilities = ["w", "x", "y", "z"]
            if i == 0:
                res = possibilities
            else:
                temp = []
                for s in res:
                    for c in possibilities:
                        temp.append(s + c)
                res = temp
        return res
