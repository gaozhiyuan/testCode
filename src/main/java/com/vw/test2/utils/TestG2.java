package com.vw.test2.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TestG2 {

	public void intialGrah(int[][] g) {		
		g[0][1] = 1;
		g[0][2] = 1;
		g[1][2] = 1;
		g[1][3] = 1;
		g[2][4] = 1;
		g[3][2] = 1;
		g[3][4] = 1;
		g[3][5] = 1;
		g[4][6] = 1;
		g[5][7] = 1;
		g[6][5] = 1;
		
		for(int i = 0; i < g.length; i ++) {
			for(int j = 0; j < g[i].length; j ++) {
				System.out.print(g[i][j]);
			}
			System.out.println();
		}
	}
	
	private static int findPerson(String[] nodes, int[][] g, int[] previous, String name) {
		List<Integer> processed = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		processed.add(0);
		while(!q.isEmpty()) {
			int index = q.poll();
			if(name.equals(nodes[index])) {
				return index;
			}
			
			
			for(int j = 0; j < g[index].length; j ++) {
				if(g[index][j] == 1) {
					if(!processed.contains(j)) {
						q.add(j);						
						previous[j] = index;
						processed.add(j);
					}
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		TestG2 t = new TestG2();
		
		String[] nodes = new String[] {"Bob", "Tom", "Alice", "Frank", "James", "Joyce", "Rita", "Simon"};
		int len = nodes.length;
		
		int[][] g = new int[len][len];
		t.intialGrah(g);
		
		int[] previous = new int[nodes.length];
		for(int i = 0; i < previous.length; i ++)
			previous[i] = -1;
		
		int rs = findPerson(nodes, g, previous, "Alice");
		if(rs != -1) {
			Stack<Integer> path = new Stack<>();
			path.push(rs);
			while(previous[rs] != -1) {
				path.push(previous[rs]);
				rs = previous[rs];
			}
			while(!path.isEmpty()) 
				System.out.print(nodes[path.pop()] + "->");
			System.out.println();
			
		} else
			System.out.println("didn't found!!!");
		
		
	}
}
