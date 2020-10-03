package com.akbar.mohd;

import java.util.Arrays;

public class FloodFillLabellingColoring {

    static int dr[]={1,1,0,-1,-1,-1, 0, 1};  // trick to explore an implicit 2D grid
    static int dc[]={0,1,1, 1, 0,-1,-1,-1};  // S,SE,E,NE,N,NW,W,SW neighbors


    public static void main(String[] args) {

        char[][] M = {
                "YYYGGGGGGG".toCharArray(),
                "YYYYYYGXXX".toCharArray(),
                "GGGGGGGXXX".toCharArray(),
                "WWWWWGGGGX".toCharArray(),
                "WRRRRRGXXX".toCharArray(),
                "WWWRRGGXXX".toCharArray(),
                "WBWRRRRRRX".toCharArray(),
                "WBBBBRRXXX".toCharArray(),
                "WBBXBBBBXX".toCharArray(),
                "WBBXXXXXXX".toCharArray()
        };

        int x = 3, y = 9;
        char target = 'X';
        char replacement = 'C';

        int ans=floodFill(x,y,target,replacement,10,10,M);
        System.out.println("Ans ="+ans);
        for (int i = 0; i < M.length; i++) {
            System.out.println(Arrays.toString(M[i]));
        }


    }

    private static int floodFill(int row,int column,char targetColor,char replacementColor,int rowRange,int columnRange,char[][] grid)
    {
        if((row<0||row>=rowRange)||(column<0||column>=columnRange))
            return 0; //Outside Grid

        if(grid[row][column]!=targetColor)
            return 0;

        int ans=1;
        grid[row][column]=replacementColor;
        for(int j=0;j<8;j++)
            ans=ans+floodFill(row+dr[j],column+dc[j],targetColor,replacementColor,rowRange,columnRange,grid);

        return ans;
    }

}
