package numberOfIslands;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2d grid grid of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * @author Mengchao Zhong
 */
public class NumberOfIslands {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] map1 = new char[][] {
			{'1', '0', '0', '0', '0'},
			{'0', '0', '0', '1', '1'},
			{'0', '1', '0', '1', '0'},
			{'1', '1', '1', '0', '0'},
			{'1', '1', '0', '0', '1'}
		};
		char[][] map2 = new char[][] {
			{'1', '0', '0', '0', '0'},
			{'0', '0', '0', '1', '1'},
			{'0', '1', '0', '1', '0'},
			{'1', '1', '1', '1', '0'},
			{'1', '1', '0', '1', '1'}
		};
		System.out.println(numIslands(map1));
		System.out.println(numIslands2(map2));
	}

	/**
	 * Solution: TLE.
	 * @param grid
	 * @return
	 */
    public static int numIslands(char[][] grid) {
    	int count = 0;
        for(int i = 0; i < grid.length; ++i) {
        	for(int j = 0; j < grid[i].length; ++j) {
        		if(grid[i][j] == '1') {
        			List<String> queue = new ArrayList<String>(); 
        			queue.add(encodePlot(i, j));
        			while(!queue.isEmpty()) {
        				int[] coordinates = decodePlot(queue.remove(0));
        				int x = coordinates[0];
        				int y = coordinates[1];
        				grid[x][y] = '0';
        				if(x > 0 && grid[x - 1][y] == '1') {
        					queue.add(encodePlot(x - 1, y));
        				}
        				if(x < grid.length - 1 && grid[x + 1][y] == '1') {
        					queue.add(encodePlot(x + 1, y));
        				}
        				if(y > 0 && grid[x][y - 1] == '1') {
        					queue.add(encodePlot(x, y - 1));
        				}
        				if(y < grid[x].length - 1 && grid[x][y + 1] == '1') {
        					queue.add(encodePlot(x, y + 1));
        				}
        			}
        			++count;
        		}
        	}
        }
        return count;
    }
    
    public static String encodePlot(int i, int j) {
    	StringBuilder builder = new StringBuilder();
    	builder.append(i).append(",").append(j);
    	return builder.toString();
    }
    
    public static int[] decodePlot(String plot) {
    	int[] coordinates = new int[2];
    	String[] coordinatesStr = plot.split(",");
    	coordinates[0] = Integer.parseInt(coordinatesStr[0]);
    	coordinates[1] = Integer.parseInt(coordinatesStr[1]);
    	return coordinates;
    }
    
	/**
	 * Solution.
	 * @param grid
	 * @return
	 */
    public static int numIslands2(char[][] grid) {
    	int count = 0;
        for(int i = 0; i < grid.length; ++i) {
        	for(int j = 0; j < grid[i].length; ++j) {
        		if(grid[i][j] == '1') {
        			++count;
        			removeIsland(grid, i, j);
        		}
        	}
        }
        return count;
    }
    
    public static void removeIsland(char[][] grid, int i, int j) {
    	if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[i].length - 1 || grid[i][j] == '0') {
    		return;
    	}
    	grid[i][j] = '0';
    	removeIsland(grid, i - 1, j);
    	removeIsland(grid, i + 1, j);
    	removeIsland(grid, i, j - 1);
    	removeIsland(grid, i, j + 1);
    }
}