
public class StoneGame {

    public static boolean winnerSquareGame(int n) {
        
    	double root = Math.sqrt(n);
    	double floorRoot = Math.floor(root);
    	
    	if(floorRoot == root) {
    		return true;
    	}
    	else {
    		
    		boolean results[] = new boolean[n+1];
    		
    		results[1] = true;
    		
    		for(int i = 2; i <= n;i++) {
    			
    			int limit = (int) Math.floor(Math.sqrt(i));
    			for(int j = 1; j <= limit;j++) {
    				
    				if(!results[i - j]) {
    					results[i] = true;
    					break;
    				}
    				
    			}
    			
    			
    		}
    		
    		return results[n];
    		
    	}
    	
    	
    }
	
	public static void main(String[] args) {
		
		int n = 7;
		System.out.println(winnerSquareGame(n));
		
	}
	
}
