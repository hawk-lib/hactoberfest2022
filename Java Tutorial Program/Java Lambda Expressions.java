//Java Lambda Expressions
   public performOperation checkEvenOdd() {
       return (n) -> {           
           return (n % 2 == 0) ? 0 : 1;
       };
   }

    public performOperation checkPrime() {
        return (n) -> {
            return java.math.BigInteger.valueOf(n).isProbablePrime(15) ? 0 : 1;
        };
    }

    public performOperation checkPalindrome() {
        return (n) -> {
            String str = String.valueOf(n);
            
            for (int i = 0; i < str.length() / 2; i++) {
                if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                    return 1;
                }
            }
            
            return 0;
        };
    }
}
