package rushabhformula;

public class RushabhTriplets {
    public static int[][] rushabh(int n)
    {
        int a,b,c;
        int[][] rushabh_triplets = new int[n*n][3];
        int k=0;
        for(a = 1; a <= n; a++)
        {
            for(b = a; b <= n; b++)
            {
                for(c = b; c <= n; c++)
                {
                    if(c == Math.pow(a,2) - b) 
                    {
                        rushabh_triplets[k][0] = a;
                        rushabh_triplets[k][1] = b;
                        rushabh_triplets[k++][2] = c;
                    }
                }
            }
        }
        return rushabh_triplets;
    }
}
