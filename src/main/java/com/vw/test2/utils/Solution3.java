package com.vw.test2.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3 {

	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0)
			return 0;
		
		char[] chars = s.toCharArray();
		int max = 1;
		
		for(int i = 0; i < chars.length; i ++) {
			int start = i;
			int end = chars.length;
			while(start < end) {
				for(int j = start + 1; j < end; j++) {
					if(chars[start] == chars[j]) {
						end = j;
						break;
					}
				}
				start ++;
			}
			int len = end - i;
			max = Math.max(max, len);
		}
        
		return max;
    }
	
	public int lengthOfLongestSubstring2(String s) {
		int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;

        while(i < n && j < n) {
        	if(!set.contains(s.charAt(j))) {
    			set.add(s.charAt(j++));
    			ans = Math.max(ans, set.size());
        	}
        	else {
        		set.clear();
        		i++;
        		j = i;
        	}
        }
        return ans;
	}
	
	public int lengthOfLongestSubstring3(String s) {
		int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;

        while(i < n && j < n) {
        	if(!set.contains(s.charAt(j))) {
    			set.add(s.charAt(j++));
    			ans = Math.max(ans, set.size());
        	}
        	else
        		set.remove(s.charAt(i++));
        }
        return ans;
	}
	
	public int lengthOfLongestSubstring4(String s) {
		int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0, i = 0, j = 0;

        while(i < n && j < n) {
        	if(map.containsKey(s.charAt(j))) {
        		i = Math.max(i, map.get(s.charAt(j)));
        	}
        	map.put(s.charAt(j++), j);
        	ans = Math.max(ans, j - i);
        	
        }
        return ans;
	}
	
	public static void main(String[] args) {
		Solution3 t = new Solution3();
		System.out.println(t.lengthOfLongestSubstring4("abcdcd"));
	}
}
