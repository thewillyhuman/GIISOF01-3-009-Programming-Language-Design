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
package ast.definitions;

import ast.ASTNode;
import ast.statements.Statement;
import ast.types.Type;

/**
 * The Interface Definition.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public interface Definition extends ASTNode, Statement {

	/**
	 * Gets the name of the definition.
	 * 
	 * @return the name of the definition.
	 */
	public String getName();

	/**
	 * Gets the type of the definition.
	 * 
	 * @return the type of the definition.
	 */
	public Type getType();

	/**
	 * Sets the type.
	 * 
	 * @param type to set.
	 */
	public void setType( Type type );

	/**
	 * Gets the scope.
	 *
	 * @return the scope of the definition.
	 */
	public int getScope();

	/**
	 * Sets the scope of the definition.
	 * 
	 * @param scope of the definition.
	 */
	public void setScope( int scope );

}
