/* 
 * MIT License
 * 
 * Copyright (c) 2018 Guillermo Facundo Colunga
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package visitor;

import ast.*;
import ast.definitions.Definition;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.Arithmetic;
import ast.expressions.Cast;
import ast.expressions.Comparison;
import ast.expressions.Expression;
import ast.expressions.FieldAccess;
import ast.expressions.Indexing;
import ast.expressions.Invocation;
import ast.expressions.Logical;
import ast.expressions.Negation;
import ast.expressions.UnaryMinus;
import ast.expressions.UnaryNot;
import ast.expressions.Variable;
import ast.literals.CharLiteral;
import ast.literals.IntLiteral;
import ast.literals.RealLiteral;
import ast.literals.RecordField;
import ast.statements.Assignment;
import ast.statements.DoWhileStatement;
import ast.statements.IfStatement;
import ast.statements.Read;
import ast.statements.Return;
import ast.statements.Statement;
import ast.statements.WhileStatement;
import ast.statements.Write;
import ast.types.ArrayType;
import ast.types.CharType;
import ast.types.ErrorType;
import ast.types.FunctionType;
import ast.types.IntType;
import ast.types.RealType;
import ast.types.RecordType;
import ast.types.VoidType;

/**
 * Instance of AbstractVisitor.java
 *
 * @author
 * @version
 * @param <P> the generic type
 * @param <R> the generic type
 */
public class AbstractVisitor<P, R> implements Visitor<P, R> {

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Arithmetic, java.lang.Object)
	 */
	@Override
	public R visit( Arithmetic arithmetic, P param ) {
		if (arithmetic.getLeft() != null)
			arithmetic.getLeft().accept( this, param );
		if (arithmetic.getRight() != null)
			arithmetic.getRight().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.ArrayType, java.lang.Object)
	 */
	@Override
	public R visit( ArrayType arrayType, P param ) {
		if (arrayType.getOf() != null)
			arrayType.getOf().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Assignment, java.lang.Object)
	 */
	@Override
	public R visit( Assignment assignment, P param ) {
		assignment.getLeft().accept( this, param );
		assignment.getRight().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Cast, java.lang.Object)
	 */
	@Override
	public R visit( Cast cast, P param ) {

		if (cast.getExp() != null)
			cast.getExp().accept( this, param );

		if (cast.getCastType() != null)
			cast.getCastType().accept( this, param );

		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.CharLiteral, java.lang.Object)
	 */
	@Override
	public R visit( CharLiteral charLiteral, P param ) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.CharType, java.lang.Object)
	 */
	@Override
	public R visit( CharType charType, P param ) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Comparison, java.lang.Object)
	 */
	@Override
	public R visit( Comparison comparison, P param ) {
		if (comparison.getLeft() != null)
			comparison.getLeft().accept( this, param );

		if (comparison.getRight() != null)
			comparison.getRight().accept( this, param );

		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.FieldAccess, java.lang.Object)
	 */
	@Override
	public R visit( FieldAccess fieldAccess, P param ) {
		if (fieldAccess.getExp() != null)
			fieldAccess.getExp().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.FuncDefinition, java.lang.Object)
	 */
	@Override
	public R visit( FuncDefinition funcDefinition, P param ) {
		for (Statement statement : funcDefinition.getStatements())
			statement.accept( this, param );
		funcDefinition.getType().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.FunctionType, java.lang.Object)
	 */
	@Override
	public R visit( FunctionType functionType, P param ) {
		if (functionType.getParameters() != null)
			for (VarDefinition var : functionType.getParameters())
				var.accept( this, param );
		functionType.getReturnType().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.IfStatement, java.lang.Object)
	 */
	@Override
	public R visit( IfStatement ifStatement, P param ) {
		if (ifStatement.getCondition() != null)
			ifStatement.getCondition().accept( this, param );
		if (ifStatement.getIfBody() != null)
			for (Statement statement : ifStatement.getIfBody())
				statement.accept( this, param );
		if (ifStatement.getElseBody() != null)
			for (Statement statement : ifStatement.getElseBody())
				statement.accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Indexing, java.lang.Object)
	 */
	@Override
	public R visit( Indexing indexing, P param ) {
		if (indexing.getArguments() != null)
			indexing.getArguments().accept( this, param );
		if (indexing.getVariable() != null)
			indexing.getVariable().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.IntLiteral, java.lang.Object)
	 */
	@Override
	public R visit( IntLiteral intLiteral, P param ) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.IntType, java.lang.Object)
	 */
	@Override
	public R visit( IntType intType, P param ) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Invocation, java.lang.Object)
	 */
	@Override
	public R visit( Invocation invocation, P param ) {
		if (invocation.getFuncion() != null)
			invocation.getFuncion().accept( this, param );
		if (invocation.getArguments() != null)
			for (Expression ex : invocation.getArguments())
				ex.accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Logical, java.lang.Object)
	 */
	@Override
	public R visit( Logical logical, P param ) {
		if (logical.getLeft() != null)
			logical.getLeft().accept( this, param );
		if (logical.getRight() != null)
			logical.getRight().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Negation, java.lang.Object)
	 */
	@Override
	public R visit( Negation negation, P param ) {
		if (negation.getOperand() != null)
			negation.getOperand().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Program, java.lang.Object)
	 */
	@Override
	public R visit( Program program, P param ) {
		for (Definition def : program.getDefinitions()) {
			def.accept( this, param );
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Read, java.lang.Object)
	 */
	@Override
	public R visit( Read read, P param ) {
		if (read.getExpression() != null)
			read.getExpression().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.RealLiteral, java.lang.Object)
	 */
	@Override
	public R visit( RealLiteral realLiteral, P param ) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.RealType, java.lang.Object)
	 */
	@Override
	public R visit( RealType realType, P param ) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.RecordField, java.lang.Object)
	 */
	@Override
	public R visit( RecordField recordField, P param ) {
		if (recordField != null)
			recordField.getType().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.RecordType, java.lang.Object)
	 */
	@Override
	public R visit( RecordType recordType, P param ) {
		if (recordType.getFields() != null)
			for (RecordField field : recordType.getFields())
				field.accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Return, java.lang.Object)
	 */
	@Override
	public R visit( Return return1, P param ) {
		if (return1.getExpression() != null)
			return1.getExpression().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.UnaryMinus, java.lang.Object)
	 */
	@Override
	public R visit( UnaryMinus unaryMinus, P param ) {
		if (unaryMinus.getExpression() != null)
			unaryMinus.getExpression().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.VarDefinition, java.lang.Object)
	 */
	@Override
	public R visit( VarDefinition varDefinition, P param ) {
		if (varDefinition.getType() != null)
			varDefinition.getType().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Variable, java.lang.Object)
	 */
	@Override
	public R visit( Variable variable, P param ) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.VoidType, java.lang.Object)
	 */
	@Override
	public R visit( VoidType voidType, P param ) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.WhileStatement, java.lang.Object)
	 */
	@Override
	public R visit( WhileStatement whileStatement, P param ) {
		if (whileStatement.getCondition() != null)
			whileStatement.getCondition().accept( this, param );
		if (whileStatement.getBody() != null)
			for (Statement st : whileStatement.getBody())
				st.accept( this, param );
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.DoWhileStatement, java.lang.Object)
	 */
	@Override
	public R visit( DoWhileStatement doWhileStatement, P param ) {
		if (doWhileStatement.getBody() != null)
			for (Statement st : doWhileStatement.getBody())
				st.accept( this, param );
		if (doWhileStatement.getCondition() != null)
			doWhileStatement.getCondition().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.Write, java.lang.Object)
	 */
	@Override
	public R visit( Write write, P param ) {
		if (write.getExpression() != null)
			write.getExpression().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(errorhandler.ErrorType, java.lang.Object)
	 */
	@Override
	public R visit( ErrorType errorType, P param ) {
		if (errorType.getNode() != null)
			errorType.getNode().accept( this, param );
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.UnaryNot, java.lang.Object)
	 */
	@Override
	public R visit( UnaryNot unaryNot, P param ) {
		unaryNot.getOperand().accept( this, param );
		return null;
	}

}
