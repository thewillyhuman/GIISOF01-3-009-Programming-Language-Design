package ast;

public class Indexing implements Expression {

    private int row = ASTNode.DEFAULT_ROW_COLUMN, column = ASTNode.DEFAULT_ROW_COLUMN;
    private Expression left, right;

    public Indexing(int i, int j, Expression left, Expression right) {
	this.row = i;
	this.column = j;
	this.right = right;
	this.left = left;
    }

    @Override
    public int getLine() {
	return column;
    }

    @Override
    public int getColumn() {
	return row;
    }

    public Expression getArguments() {
	return left;
    }

    public void setArguments(Expression arguments) {
	this.left = arguments;
    }

    public Expression getVariable() {
	return right;
    }

    public void setVariable(Expression variable) {
	this.right = variable;
    }

    @Override
    public String toString() {
	return this.left.toString() + "[" + this.right.toString() + "]";
    }
}