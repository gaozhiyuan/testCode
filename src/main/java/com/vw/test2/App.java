package com.vw.test2;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        int[] a = new int[10];
        for(int i = 0; i < a.length; i ++)
        	a[i] = (int)(Math.random() * 100);
        
        printArray(a);
        sort(a, 0, a.length -1);
        printArray(a);
    }
    
    private static void sort(int[] a, int left, int right) {
    	
    	if(a == null)
    		return;
    	if(a.length <= 1)
    		return;
    	if(left >= right)
    		return;
    	
    	int pacemaker = a[left];
    	
    	int l = left;
    	int r = right;
    	
    	while(true)
    	{
    		while(r > l)
    			if(a[r] >= pacemaker)
    				r --;
    			else
    				break;
    		while(l < r)
    			if(a[l] <= pacemaker)
    				l ++;
    			else
    				break;
    		if(l != r) {
    			int temp = a[l];
    			a[l] = a[r];
    			a[r] = temp; 
    			continue;
    		} else {
    			a[left] = a[l];
    			a[l] = pacemaker;
    			break;    			
    		}
    		
    	}

    	sort(a, left, l - 1);
		sort(a, l + 1, right);
    }
    
    private static void printArray(int[] a) {
		for(int i = 0; i < a.length; i ++) {
			System.out.print(a[i] + " , ");
		}
		System.out.println();
	}
}
