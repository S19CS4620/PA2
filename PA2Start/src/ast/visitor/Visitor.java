/**
 *  Visitor class with a method to visit each AST node type.
 *  All implementations in this file call a defaultVisit method.
 */

package ast.visitor;

import ast.node.*;

public class Visitor
{
    public void defaultVisit(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }

    public void visitAndExp(AndExp node)
    {
        defaultVisit(node);
    }

    public void visitArrayAssignStatement(ArrayAssignStatement node)
    {
        defaultVisit(node);
    }

    public void visitArrayExp(ArrayExp node)
    {
        defaultVisit(node);
    }

    public void visitAssignStatement(AssignStatement node)
    {
        defaultVisit(node);
    }

    public void visitBlockStatement(BlockStatement node)
    {
        defaultVisit(node);
    }

    public void visitBoolType(BoolType node)
    {
        defaultVisit(node);
    }

    public void visitButtonLiteral(ButtonLiteral node)
    {
        defaultVisit(node);
    }

    public void visitButtonType(ButtonType node)
    {
        defaultVisit(node);
    }

    public void visitByteCast(ByteCast node)
    {
        defaultVisit(node);
    }

    public void visitByteType(ByteType node)
    {
        defaultVisit(node);
    }

    public void visitCallExp(CallExp node)
    {
        defaultVisit(node);
    }

    public void visitCallStatement(CallStatement node)
    {
        defaultVisit(node);
    }

    public void visitChildClassDecl(ChildClassDecl node)
    {
        defaultVisit(node);
    }

    public void visitClassType(ClassType node)
    {
        defaultVisit(node);
    }

    public void visitColorLiteral(ColorLiteral node)
    {
        defaultVisit(node);
    }

    public void visitColorArrayType(ColorArrayType node)
    {
        defaultVisit(node);
    }

    public void visitColorType(ColorType node)
    {
        defaultVisit(node);
    }

    public void visitEqualExp(EqualExp node)
    {
        defaultVisit(node);
    }

    public void visitFalseLiteral(FalseLiteral node)
    {
        defaultVisit(node);
    }

    public void visitFormal(Formal node)
    {
        defaultVisit(node);
    }

    public void visitIdLiteral(IdLiteral node)
    {
        defaultVisit(node);
    }

    public void visitIfStatement(IfStatement node)
    {
        defaultVisit(node);
    }

    public void visitIntArrayType(IntArrayType node)
    {
        defaultVisit(node);
    }

    public void visitIntLiteral(IntLiteral node)
    {
        defaultVisit(node);
    }

    public void visitIntType(IntType node)
    {
        defaultVisit(node);
    }

    public void visitLengthExp(LengthExp node)
    {
        defaultVisit(node);
    }

    public void visitLtExp(LtExp node)
    {
        defaultVisit(node);
    }

    public void visitMainClass(MainClass node)
    {
        defaultVisit(node);
    }
    
    public void visitMeggyCheckButton(MeggyCheckButton node)
    {
        defaultVisit(node);
    }
    
    public void visitMeggyDelay(MeggyDelay node)
    {
        defaultVisit(node);
    }
    
    public void visitMeggyGetPixel(MeggyGetPixel node)
    {
        defaultVisit(node);
    }
    
    public void visitMeggySetAuxLEDs(MeggySetAuxLEDs node)
    {
        defaultVisit(node);
    }
    
    public void visitMeggySetPixel(MeggySetPixel node)
    {
        defaultVisit(node);
    }
    
    public void visitMeggyToneStart(MeggyToneStart node)
    {
        defaultVisit(node);
    }
    
    public void visitMethodDecl(MethodDecl node)
    {
        defaultVisit(node);
    }

    public void visitMinusExp(MinusExp node)
    {
        defaultVisit(node);
    }

    public void visitMulExp(MulExp node)
    {
        defaultVisit(node);
    }
    
    public void visitNewArrayExp(NewArrayExp node)
    {
        defaultVisit(node);
    }

    public void visitNewExp(NewExp node)
    {
        defaultVisit(node);
    }
    
    public void visitNegExp(NegExp node)
    {
        defaultVisit(node);
    }

    public void visitNotExp(NotExp node)
    {
        defaultVisit(node);
    }

    public void visitPlusExp(PlusExp node)
    {
        defaultVisit(node);
    }

    public void visitProgram(Program node)
    {
        defaultVisit(node);
    }

    public void visitThisLiteral(ThisLiteral node)
    {
        defaultVisit(node);
    }

    public void visitToneLiteral(ToneLiteral node)
    {
        defaultVisit(node);
    }

    public void visitToneType(ToneType node)
    {
        defaultVisit(node);
    }

    public void visitTopClassDecl(TopClassDecl node)
    {
        defaultVisit(node);
    }

    public void visitTrueLiteral(TrueLiteral node)
    {
        defaultVisit(node);
    }

    public void visitVarDecl(VarDecl node)
    {
        defaultVisit(node);
    }

    public void visitVoidType(VoidType node)
    {
        defaultVisit(node);
    }

    public void visitWhileStatement(WhileStatement node)
    {
        defaultVisit(node);
    }



}
