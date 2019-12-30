// easy 
// solution 2: use StringBuilder instead of str+str operation
// however from the running time seems StringBuilder is not faster than str plus str(they are same)

//solution 1
class Solution {
    public String addBinary(String a, String b) {
        if(a.length()>b.length()){
            String c = b;
            b = a;
            a = c;
        }
        int sum = 0,carry = 0;
        String res = "";
        for(int i=0;i<b.length();i++){
            int charA = i>=a.length()? 0:a.charAt(a.length()-i-1)-'0';
            int charB = b.charAt(b.length()-i-1)-'0';
            sum = (carry+charA+charB)%2;
            carry = (carry+charA+charB)/2;
            res = sum+res;
        }
        if(carry==1) res = 1+res;
        return res;
    }
}

//solution 2
class Solution {
    public String addBinary(String a, String b) {
        if(a.length()>b.length()){
            String c = b;
            b = a;
            a = c;
        }
        int sum = 0,carry = 0;
        StringBuilder res = new StringBuilder();
        for(int i=0;i<b.length();i++){
            int charA = i>=a.length()? 0:a.charAt(a.length()-i-1)-'0';
            int charB = b.charAt(b.length()-i-1)-'0';
            sum = (carry+charA+charB)%2;
            carry = (carry+charA+charB)/2;
            res.insert(0,sum);
        }
        if(carry==1) res.insert(0,1);
        return res.toString();
    }
}
