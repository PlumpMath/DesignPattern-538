import java.util.*;
interface Node
{
	public int interpret();
}

class ValueNode implements Node
{
	private int value;
	public ValueNode(int value)
	{  this.value=value;  }
		
	public int interpret()
	{  return this.value;  }
}

class AndNode implements Node
{
	private Node left;
	private Node right;
	public AndNode(Node left,Node right)
	{
		this.left = left;
		this.right = right;
	}
	
	public int interpret()  
	{
		if(left.interpret()==1&&right.interpret()==1)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}

class OrNode implements Node
{
	private Node left;
	private Node right;
	public OrNode(Node left,Node right)
	{
		this.left = left;
		this.right = right;
	}
	
	public int interpret()
	{
		if(left.interpret()==1||right.interpret()==1)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}

class Context
{
	private String statement;
	private Node node;
    
    public void parse(String statement)
    {
    	Node left=null,right=null;
    	Stack stack=new Stack();
    	String[] statementArr=statement.split(" "); //·Ö¸îÊäÈë×Ö·û´®
    	for(int i=0;i<statementArr.length;i++)
    	{	
    		if(statementArr[i].equalsIgnoreCase("and"))
    		{
    			left=(Node)stack.pop();
    		    int val=Integer.parseInt(statementArr[++i]);
    		    right=new ValueNode(val); 
    			stack.push(new AndNode(left,right));
    		}
    		else if(statementArr[i].equalsIgnoreCase("or"))
    		{
    			left=(Node)stack.pop();
    		    int val=Integer.parseInt(statementArr[++i]);
    		    right=new ValueNode(val); 
    			stack.push(new OrNode(left,right));    			
    		}
    		else
    		{
    			stack.push(new ValueNode(Integer.parseInt(statementArr[i])));
    		}
    	}
    	this.node=(Node)stack.pop(); 
    }
	
	public int execute()
	{
		return node.interpret();
	}
}

class Test
{
	public static void main(String args[])
	{
		String statement = "0 or 1 and 1 or 1";
		Context ctx = new Context();
		ctx.parse(statement);	
		int result = ctx.execute();	
		System.out.println(statement + " = " + result);	
	}
}


