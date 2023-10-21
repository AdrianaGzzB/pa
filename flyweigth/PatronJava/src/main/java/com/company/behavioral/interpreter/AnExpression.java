package com.company.behavioral.interpreter;

public class AnExpression implements Expression{
    private Expression expression1;
    private Expression expression2;

    public AnExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {
        return expression1.interpret(context) && expression2.interpret(context);
    }
}
