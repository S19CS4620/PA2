/* Grouping literal nodes.  All literal nodes have a 
 * toString() to show their lexeme.
 */

package ast.node;

/**
 * The IExp subclass is used to group all nodes that are
 * expression nodes.
 * 
 * @author mstrout
 *
 */
public abstract class ILiteral extends IExp
{
    private String lexeme;
    private int value;
    
    public ILiteral(int _line_, int _pos_, 
            String _lexeme_, int _value_) 
    {
        super(_line_,_pos_);
        this.lexeme = _lexeme_;
        this.value = _value_;
    }

    public String getLexeme() { return this.lexeme; }
    public int getIntValue() { return this.value; }

    public String toString() { return this.lexeme; }
}
