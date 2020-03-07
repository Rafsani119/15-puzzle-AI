import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {



    public static void main(String[] args) throws FileNotFoundException {
        int n;
        int initial[][] = new int[4][4];
        int Goal[][] =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11,12},
                        {13,14,15,0}
                };
        Scanner sc = new Scanner(new File("input.txt"));
        n = sc.nextInt();
        for (int i=0;i<16;i++)
        {
            int a = sc.nextInt();
        }
        for(int loop=0;loop<n;loop++)
        {
            for(int i =0; i<4; i++)
                for(int j=0; j<4; j++)
                {
                    initial[i][j] = sc.nextInt();
                }


            int x=0, y=0;
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    if(initial[i][j] == 0)
                    {
                        x =i;
                        y=j;
                        break;
                    }
                }
            }
            AstarSearch sr = new AstarSearch();
            if(sr.isSolvable(initial,x))
            {
                System.out.println("---- **** ----- solvable -----*********----");
                System.out.println("----------Manhattan Heuristic--------------");
                sr.AstarAlgo(initial,x,y,Goal,1);
                System.out.println("-----------Displacement Heuristic-----------");
                sr.AstarAlgo(initial,x,y,Goal,0);
            }
            else
                System.out.println("Not Solvable");

        }
    }
}
