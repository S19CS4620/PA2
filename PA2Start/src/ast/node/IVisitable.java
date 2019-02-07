package ast.node;

import ast.visitor.*;

/**
 * The IVisitable interface enables objects to be visited by a Visitor
 * subclass to enable the visitor design pattern.
 *
 * @author mstrout
 */
public interface IVisitable
{
    void accept(Visitor v);
}
