import java.util.HashSet;
import java.util.PriorityQueue;

public class AstarSearch {
    int rowMove[] = { 1, 0, -1, 0 };
    int colMove[] = { 0, -1, 0, 1 };


    boolean isSolvable(int [][] mat,int x)
    {
        int rowx = 4 - x;
        int[] ara = new int[16];
        int os=0;
        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++)
            {
                ara[os] = mat[i][j];
                os++;
            }

        int inversionCount = 0;

        for (int i = 0; i < 16 - 1; i++)
        {
            for (int j = i + 1; j < 16; j++)
            {
                if (ara[j] != 0 && ara[i] != 0 && ara[i] > ara[j])
                    inversionCount++;
            }
        }

        //System.out.println(inversionCount +"   "+rowx);

        if((inversionCount%2) ==0 && (rowx%2) != 0)
        {
            return  true;
        }
        else if((inversionCount%2) !=0 && (rowx%2) == 0)
        {
            return  true;
        }
        else
            return false;

    }


    boolean isValidMove(int x, int y)
    {
        return (x >= 0 && x < 4 && y >= 0 && y < 4);
    }


    void printpath(Node n)
    {
        while(n.parent != null)
        {
            n.PrintNode();
            n = n.parent;
            System.out.println("");
        }
    }


    int calculate_H_value(int Current[][], int Goal[][],int mode)
    {
        int count;
        if(mode==1)
            count = Heuristics.ManhattanDistance(Current, Goal);
        else
            count = Heuristics.distanceHeuristic(Current,Goal);

        return count;
    }


    void AstarAlgo(int StartState[][], int x, int y, int  GoalState [][],int heuristic)
    {
        int Explorednodes =0;
        PriorityQueue<Node> openlist  = new PriorityQueue<>();
        HashSet<Node> closedlist = new HashSet<>();

        Node root = new Node(StartState, 0, x, y, x, y, null);
        root.cost = root.Gn + calculate_H_value(StartState, GoalState,heuristic);
        Node goal = new Node(GoalState);

        openlist.add(root);

        while (!openlist.peek().equals(goal))
        {
            Node poped = openlist.poll();
            Explorednodes++;
            closedlist.add(poped);


            for (int i = 0; i < 4; i++)
            {
                if (isValidMove(poped.Zx + rowMove[i], poped.Zy + colMove[i]))
                {
                    Node child = new Node(poped.Board, poped.Gn+1, poped.Zx, poped.Zy, poped.Zx + rowMove[i], poped.Zy + colMove[i] , poped);
                    child.Hn = calculate_H_value(child.Board,goal.Board,heuristic);
                    child.cost = child.Gn + child.Hn;
                    if(!closedlist.contains(child))
                    openlist.add(child);
                }
            }
        }
        Node matched = openlist.poll();
        System.out.println("Cost = " + matched.Gn);
        System.out.println("Total explored Nodes = " + closedlist.size());
        printpath(matched);
        root.PrintNode();
        openlist.clear();
        closedlist.clear();
    }
}
