import java.util.*;

class CoinExchangeProblemRecurssive{
    public int findMaxNumberOfWays(int[] coins, int sum, int n){
        if(sum==0){
            return 1;
        }

        if(sum < 0){
            return 0;
        }

        if(n <= 0 && sum >= 1){
            return 0;
        }

        return findMaxNumberOfWays(coins,sum-coins[n-1],n) + findMaxNumberOfWays(coins, sum, n-1);

    }
}

class CoinExchangeProblemTopDown{
    int t[][];

    public CoinExchangeProblemTopDown(int n, int sum){
        t = new int[n+1][sum+1];
    }

    public int findMaxNumberOfWays(int[] coins, int n, int sum){
        for(int i=0; i<t.length; i++){
            t[i][0] = 1;
        }

        // for(int j=0; j<sum+1; j++){
        //     t[0][j] = 0;
        // }

        for(int i=1; i<=n; i++){
            for(int j=0; j<=sum; j++){
                if(coins[i-1] > j){
                    t[i][j] = t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j] + t[i][j-coins[i-1]];
                }
            }
        }

        return t[n][sum];
    }
}

public class CoinExchangeProblemImplementation{
    public static void main(String[]args){
        int coins[] = {1,2,3};
        int sum = 5;
        int n = coins.length;

        CoinExchangeProblemRecurssive obj1 = new CoinExchangeProblemRecurssive();
        CoinExchangeProblemTopDown obj2 = new CoinExchangeProblemTopDown(n,sum);

        int result2 = obj2.findMaxNumberOfWays(coins,n,sum);
        System.out.println(result2);
    }
}