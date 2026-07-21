// Time: O(mn)
// Space: O(mn)

// The algorithm can be optimised by using Array Reversal method for in place shifting of elements by k. 
// But the space cannot be reduced further because the return has to be converted from int[][] to List<List<Integer>> **in Java**.
  
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;            
        int n=grid[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        //copy to list
        for(int i=0;i<m;i++){          
            for(int j=0;j<n;j++){
                list.add(grid[i][j]);
            }
        }
        int total = m*n;
        k %= total;
      
        //shift and copy back to grid
        int r=0,c=0;
        for(int i=list.size()-k;i<list.size();i++){ //last k elements
            grid[r][c++]=list.get(i);          
            if(c==n){
                c=0; r++;
            }
        }
        for(int i=0;i<list.size()-k;i++){    //first n-k elements
            grid[r][c++]=list.get(i);
            if(c==n){
                c=0; r++;
            }
            if(r==m) break;
        }
      
      //alternate approach for shift and copy back to grid using single loop
      // for(int ListIdx=0;ListIdx<list.size();ListIdx++){     
      //       grid[ListIdx/n][ListIdx%n] = list.get((ListIdx+total-k)%total);
      //   }
      
        //copy to match return type
        List<List<Integer>> soln = new ArrayList<>();
        for(int i=0;i<m;i++){
            List<Integer> row = new ArrayList<>();    
            for(int j=0;j<n;j++){
                row.add(grid[i][j]);
            }
            soln.add(row);
        }
        return soln;
    }
}
