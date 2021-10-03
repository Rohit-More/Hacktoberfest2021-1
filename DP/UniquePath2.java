package DP;

public class UniquePath2 {
  public int uniquePathsWithObstacles(int[][] grid) {
    if (grid[0][0] == 1) {
        return 0;
    }
    grid[0][0] = 1;
    for (int i = 1; i < grid.length; i++) {
        grid[i][0] = (grid[i][0] == 0 && grid[i-1][0] == 1) ? 1 : 0;
    }
    for (int j = 1; j < grid[0].length; j++) {
        grid[0][j] = (grid[0][j] == 0 && grid[0][j-1] == 1) ? 1 : 0;
    }
    
    for (int n = 1; n < grid.length; n++) {
        for (int m = 1; m < grid[n].length; m++) {
            grid[n][m] = (grid[n][m] != 1) ? (grid[n-1][m] + grid[n][m-1]) : 0;
        }
    }
    return grid[grid.length-1][grid[0].length-1];
  }
}
