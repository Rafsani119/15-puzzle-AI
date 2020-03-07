public class Heuristics {
    static int distanceHeuristic(int current[][],int goal[][]){
        int result = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if ( (current[i][j] !=0) && (current[i][j] != goal[i][j])) {
                    result++;
                }
        return  result;
    }
    static  int ManhattanDistance(int current[][],int goal[][])
    {
        int result = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
            {
                int temp = current[i][j];
                for (int p = 0; p < 4; p++)
                    for (int q = 0; q < 4; q++)
                    {
                        if(temp == goal[p][q])
                        {
                            result += Math.abs(i-p) + Math.abs(j-q);
                            break;
                        }
                    }
            }

        return result;

    }
}
