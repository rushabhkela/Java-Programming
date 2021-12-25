package correctformula;

public class PythagoreanTriplets {
    public static int[][] correct(int n)
    {
        int a,b,c;
        int[][] correct_triplets = new int[n*n][3];
        int k=0;
        for(a = 1; a <= n; a++)
        {
            for(b = a; b <= n; b++)
            {
                for(c = b; c <= n; c++)
                {
                    if(Math.pow(a,2) + Math.pow(b,2) == Math.pow(c, 2)) 
                    {
                        correct_triplets[k][0] = a;
                        correct_triplets[k][1] = b;
                        correct_triplets[k++][2] = c;
                    }
                }
            }
        }

        return correct_triplets;
    }
}
