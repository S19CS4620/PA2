/* This file was copied from NotExp.java
 * Then modified.
 */

package ast.node;

import ast.visitor.*;

@SuppressWarnings("nls")
public final class NegExp extends IExp
{
    private IExp _exp_;

    public NegExp(int _line_, int _pos_, IExp _exp_)
    {
        super(_line_, _pos_);
        setExp(_exp_);

    }

    @Override
    public int getNumExpChildren() { return 1; }
   
    @Override
    public Object clone()
    {
        return new NegExp(
                this.getLine(),
                this.getPos(),
                cloneNode(this._exp_));
    }

    public void accept(Visitor v)
    {
        v.visitNegExp(this);
    }

    public IExp getExp()
    {
        return this._exp_;
    }

    public void setExp(IExp node)
    {
        if(this._exp_ != null)
        {
            this._exp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp_ = node;
    }

    @Override
    void removeChild(Node child)
    {
        // Remove child
        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(Node oldChild, Node newChild)
    {
        // Replace child
        if(this._exp_ == oldChild)
        {
            setExp((IExp) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
