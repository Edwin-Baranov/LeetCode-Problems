class Solution {
    int result = Integer.MAX_VALUE;
    
    public int minimumMoves(int[][] grid) {

        List<int[]> emptyCells = new ArrayList<>();
        List<int[]> extraCells = new ArrayList<>();
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(grid[i][j] == 0)
                    emptyCells.add(new int[]{i, j});
                
                //Store extra cell's cord and extra count
                if(grid[i][j] > 1)
                    extraCells.add(new int[]{i, j, grid[i][j] - 1});
            }
        }

        solve(emptyCells, extraCells, 0, 0);
        return result;
    }
    
    private void solve(List<int[]> emptyCells, List<int[]> extraCells, int emptyIndex, int moves){
        //If we have no more cells to fill, update result to be min number of moves
        if(emptyIndex == emptyCells.size()) {
            result = Math.min(result, moves);
            return;
        }
        
        int[] emptyCell = emptyCells.get(emptyIndex);
        
        for(int i = 0; i < extraCells.size(); i++){
            int[] extraCell = extraCells.get(i);
            
            //if extraCell still has extra stones to spare
            if(extraCell[2] > 0){
                extraCell[2]--;
                int displacement = Math.abs(extraCell[0] - emptyCell[0]) + Math.abs(extraCell[1] - emptyCell[1]);
                
                solve(emptyCells, extraCells, emptyIndex + 1, moves + displacement);
                
                extraCell[2]++;
            }
        }
    }
}