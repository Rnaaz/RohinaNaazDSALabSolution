package com.greatlearning.mentoredLabSession3.Question1;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string expression for which you want to check: ");
		String expression = sc.next();
		boolean result = checkBalance(expression);
		if(result)
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");

	}

	private static boolean checkBalance(String expression) {
		if(expression.length() % 2 == 1) return false;
		
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<expression.length();i++) {
			char character = expression.charAt(i);
			
			if(character == '{' || character =='[' || character =='(') 
				stack.push(character);
			
			else {
				char c = stack.pop();
				switch (character) {
					case '}':
						if(c != '{')
							return false;
						break;
					case ')':
						if(c != '(')
							return false;
						break;
					case ']':
						if(c != '[')
							return false;
						break;
				}
			}
		}
		
		return stack.isEmpty();
	}

}
