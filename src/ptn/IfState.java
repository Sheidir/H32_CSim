/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ptn;

/**
 *
 * @author Alan
 */
public class IfState extends Statement {
    
    public IfState(){
        super(3);
    }
    
    /**
     * return the expression value
     * @return 
     */
    public Expression getTest(){
        return (Expression) children.get(0);
    }

    /**
     * set the expression value 
     * @param expr 
     */
    public void setTest(Expression expr) {
        children.set(0,expr);
    }
    
    /**
     * return the block value from point 1
     * @return 
     */
    public Block getBody(){
        return (Block) children.get(1);
    }

    /**
     * set the block value at point 1
     * @param block 
     */
    public void setBody(Block block) {
        children.set(1,block);
    }
    
    /**
     * return block value from point 2
     * @return 
     */
    public Block getElse(){
        return (Block) children.get(2);
    }

    /**
     * set block value at point 2
     * @param block 
     */
    public void setElse(Block block) {
        children.set(2,block);
    }
    
    /**
     * check to see if point 2 has a value 
     * @return 
     */
    public boolean hasElse(){
        return children.get(2)!=null;
    }
    
    public String format(int indent){
        StringBuilder sb = new StringBuilder();
        sb.append(indent(indent));
        sb.append("if(");
        sb.append(getTest().format(indent));
        sb.append(")");
        sb.append(getBody().format(indent+5));
        if(hasElse()){
            sb.append(indent(indent));
            sb.append("else ");
            sb.append(getElse().format(indent+5));
        }
        return sb.toString();
    }
    
    @Override
    public ast.Conditional toAST(){
        ast.Conditional conditional = new ast.Conditional();
        conditional.setTest(getTest().toAST());
        conditional.setIfBlock(getBody().toAST());
        if(hasElse()){
            conditional.setElseBlock(getElse().toAST());
        }
        return conditional;
    }
    
}
