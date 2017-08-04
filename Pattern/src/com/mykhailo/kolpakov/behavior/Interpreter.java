package com.mykhailo.kolpakov.behavior;

public class Interpreter {
	public static void main(String[] args) {
		Context context = new Context();
		Expression expression = context.evaluate("12-22+33");
		System.out.println(expression.interpret());
	}
}

interface Expression {
	int interpret();
}

class NumberExpression implements Expression {
	int number;

	public NumberExpression(int number) {
		this.number = number;
	}

	@Override
	public int interpret() {
		return number;
	}

}

class MinusExpression implements Expression {

	Expression right;
	Expression left;

	public MinusExpression(Expression right, Expression left) {
		super();
		this.right = right;
		this.left = left;
	}

	@Override
	public int interpret() {
		return left.interpret() - right.interpret();
	}

}

class PlusExpression implements Expression {

	Expression right;
	Expression left;

	public PlusExpression(Expression right, Expression left) {
		super();
		this.right = right;
		this.left = left;
	}

	@Override
	public int interpret() {
		return left.interpret() + right.interpret();
	}
}

class Context {

	Expression evaluate(String s) {
		int pos = s.length() - 1;
		while (pos > 0) {
			if (Character.isDigit(s.charAt(pos))) {
				pos--;
			} else {
				Expression left = evaluate(s.substring(0, pos));
				Expression right = new NumberExpression(Integer.valueOf(s.substring(pos + 1, s.length())));
				char operator = s.charAt(pos);
				switch (operator) {
				case '-':
					return new MinusExpression(right, left);

				case '+':
					return new PlusExpression(right, left);
				}

			}
		}
		int result = Integer.valueOf(s);
		return new NumberExpression(result);
	}

}