/**
 * This ast walker generates dot output for the AST.
 * The constructor also takes as input a mapping of nodes to
 * Strings.  While generating the dot file for the AST, 
 * the string associated with each node will be put in the dot output for
 * the node.  If the node does not have an object in the map then nothing will
 * be printed on that node in addition to the node class name. 
 *
 * 6/06 - Modified from Brian Richard's ParserTest.Java.
 *        Michelle Strout
 */
package ast_visitors;

import java.io.PrintWriter;
import java.util.Stack;
import java.util.HashMap;

import ast.visitor.DepthFirstVisitor;
import ast.node.*;

/**
 * We extend the DepthFirstAdapter.  
 * Visitors invoke a defaultCase method on each node they visit.  
 * We override this method so that it
 * prints out dot info about a node.
 */
public class DotVisitorWithMap extends DepthFirstVisitor {
   private int nodeCount = 0;
   private PrintWriter out;
   private Stack<Integer> nodeStack;
   private HashMap<Node,String> mMap;
   
   /** Constructor takes a PrintWriter, and stores in instance var. */
   public DotVisitorWithMap(PrintWriter out, HashMap<Node,String> map) {
      this.out = out;
      this.nodeStack = new Stack<Integer>();
      this.mMap = map;
   }

   
   /** Upon entering each node in AST, check of this node is the root
   to generate start of .dot file, output the dot output for the node.
   */
   public void defaultIn(Node node) {
       if (nodeStack.empty()) {
           out.println("digraph ASTGraph {");
       }

       nodeDotOutput(node);
       
       // store this node id on the nodeStack
       // the call to nodeDotOutput increments for
       // the next guy so we have to decrement here
       nodeStack.push(nodeCount-1);    
   }
   
   public void defaultOut(Node node) {
       nodeStack.pop();
       if (nodeStack.empty()) {
           out.println("}");
       }
       out.flush();
   }
   
   /* A helper output routine that generates the
    * dot node and the dot edges from the parent
    * to the node.
    */
   private void nodeDotOutput(Node node)
   {
       // dot node
       out.print(nodeCount);
       out.print(" [ label=\"");
       printNodeName(node);
       if (this.mMap.containsKey(node)) {
           out.print("\\n"+this.mMap.get(node));
       }
       if (node instanceof ILiteral) {
           out.print("\\n");
           out.print(node.toString());
       }
       out.println("\" ];");
       
       // print dot edge to parent
       if (!nodeStack.empty()) {
           out.print(nodeStack.peek());
           out.print(" -> ");
           out.println(nodeCount);
       }
       
       // increment for ourseves
       nodeCount++;
   }

   /** A helper that trims a node's class name before printing it.
    * (E.g., "node.Token" --> "Token".) 
    */
   private void printNodeName(Node node) {
      String fullName = node.getClass().getName();
      String name = fullName.substring(fullName.lastIndexOf('.')+1);
      
      out.print(name);
   }
   
}
