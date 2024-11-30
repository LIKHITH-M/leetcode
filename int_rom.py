class Solution:
    def intToRoman(self, num: int) -> str:
        #corresponding roman symbols for values
        values = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        symbols = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]
        string = ""
        
       #for loop to go through every units
        for i in range(len(values)):
            while num >= values[i]:   # assigning the evry units values completely
                string += symbols[i]  # appending the resultant symbol
                num -= values[i]      # Subtract the value from num
        
        return string #returing the final value
