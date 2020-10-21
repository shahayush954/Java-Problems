import java.util.*;



class LCSImplementationRecursivePlusMemoization{

    int t[][];

    public LCSImplementationRecursivePlusMemoization(int l1,int l2){
        t = new int[l1+1][l2+1];

        for(int i=0; i<l1+1; i++){
            for(int j=0; j<l2+1; j++){
                t[i][j] = -1;
            }
        }
    }

    public int LCS(String text1, String text2, int l1, int l2){
        if(l1 == 0 || l2 == 0){
            return 0;
        }
        
        if(t[l1-1][l2-1] != -1){
            return t[l1-1][l2-1];
        }
        
        if(text1.charAt(l1-1) == text2.charAt(l2-1)){
            
            t[l1-1][l2-1] = (1 + LCS(text1,text2, l1-1, l2-1));
            return t[l1-1][l2-1];
        }
        else{
            t[l1-1][l2-1] = Math.max(LCS(text1,text2,l1-1,l2), LCS(text1,text2,l1,l2-1));
            return t[l1-1][l2-1];
        }
    }

}

class LCSImplementationRecurssive{


    public int LCS(String a, String b, int n, int m){
        if( (n==0) || (m==0) ){
            return 0;
        }

        if(a.charAt(n-1) == b.charAt(m-1)){
            return 1 + LCS(a,b,n-1,m-1);
        }
        else{
            return Math.max(LCS(a,b,n-1,m), LCS(a,b,n,m-1));
        }
    }
}

public class LCSImplementation{
    public static void main(String[]args){

        String a = "abcdegh";
        String b = "abdhr";

        LCSImplementationRecurssive obj1 = new LCSImplementationRecurssive();

        int result1 = obj1.LCS(a,b,a.length(),b.length());

        LCSImplementationRecursivePlusMemoization obj2 = new LCSImplementationRecursivePlusMemoization(a.length(), b.length());

        int result2 = obj2.LCS(a,b,a.length(),b.length());
        
        System.out.println(result2);
    }
}