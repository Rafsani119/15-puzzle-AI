import java.util.Arrays;
import java.util.Objects;

public class Node implements Comparable<Node>{
    public Node parent;
    public int Board [][] = new int[4][4];
    public int Gn,Hn,Zx,Zy; //zx zy for co ordinates of 0
    public int cost;

    @Override
    public boolean equals(Object o) {
        Node n = (Node) o;
        for (int i=0; i<4; i++)
        {
            for(int j=0; j<4; j++)
            {
                if(this.Board[i][j] != n.Board[i][j])
                {
                    return false;
                }
            }
        }
        return  true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        for(int i =0; i<4; i++)
            for(int j =0; j<4; j++)
            {
                result = result + Board[i][j];
            }
        return result;
    }

    public Node(int[][] board)
    {
        Board = board;
    }

    public Node(int[][] board, int gn, int zx, int zy,int Nzx,int Nzy, Node parent) {
        this.parent = parent;
        Board = new int[4][4];
        for (int i =0; i<4; i++)
        {
            for(int j=0; j<4; j++)
            {
                Board[i][j] = board[i][j];
            }
        }
        Gn = gn;
        int temp = Board[zx][zy];
        Board[zx][zy] = Board[Nzx][Nzy];
        Board[Nzx][Nzy] = temp;
        Zx = Nzx;
        Zy = Nzy;
    }

    void PrintNode()
    {
        for(int i=0;i<4;i++)
        {
            for (int j=0;j<4;j++)
            {
                System.out.print(this.Board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    @Override
    public int compareTo(Node o) {
        return this.cost-o.cost;
    }
}


