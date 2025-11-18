package Games;

import java.util.Scanner;
import java.util.Stack;

public class InvertirTexto {

	    public static void main(String[] args) {
	        String s = new Scanner(System.in).nextLine();
	        char[] chars = s.toCharArray();
	        
	        // Pile pour inverser les indices impairs
	        Stack<Character> stack = new Stack()<>() ;
	        for (int i = 1; i < chars.length; i += 2) {
	            stack.push(chars[i]);
	        }
	        
	        for (int i = 1; i < chars.length; i += 2) {
	            chars[i] = stack.pop();
	        }
	        
	        System.out.println(new String(chars));
	    }
	}

