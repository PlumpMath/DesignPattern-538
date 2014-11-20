import java.util.*;
interface Node
{
	public int interpret();
}

//终结符表达式类，用于解释一个整型数值
class ValueNode implements Node
{
	private int value;
	public ValueNode(int value)
	{  this.value=value;  }
		
	public int interpret()
	{  return this.value;  }
}

//抽象终结符表达式类
abstract class SymbolNode implements Node
{
	protected Node left;
	protected Node right;
	public SymbolNode(Node left,Node right)
	{
		this.left=left;
		this.right=right;
	}
}

class AddNode extends SymbolNode
{
	public AddNode(Node left,Node right)
	{
		super(left,right);
	}
	
	public int interpret()  //加法解释
	{
		return left.interpret() + right.interpret();
	}
}

class SubNode extends SymbolNode
{
	public SubNode(Node left,Node right)
	{
		super(left,right);
	}
	
	public int interpret()  //加法解释
	{
		return left.interpret() - right.interpret();
	}
}

class Calculator
{
	private String statement;
	private Node node;
    
    public void build(String statement)
    {
    	Node left=null,right=null;
    	Stack stack=new Stack(); //使用栈来存储表达式
    	String[] statementArr=statement.split(" "); //分割输入字符串
    	for(int i=0;i<statementArr.length;i++)
    	{	
    		//如果输入的符号是加号，则将存储在栈中的表达式弹出后作为其左表达式，而将之后的数值作为其右表达式，创建一个新的AddNode对象并存入栈中
    		if(statementArr[i].equalsIgnoreCase("+"))
    		{
    			left=(Node)stack.pop();
    		    int val=Integer.parseInt(statementArr[++i]);
    		    right=new ValueNode(val); 
    			stack.push(new AddNode(left,right));
    		}
    		else if(statementArr[i].equalsIgnoreCase("-"))
    		{
    			left=(Node)stack.pop();
    		    int val=Integer.parseInt(statementArr[++i]);
    		    right=new ValueNode(val); 
    			stack.push(new SubNode(left,right));    			
    		}
    		//如果输入的符号既不是加号也不是减号，则为数值，创建一个新的ValueNode对象并存储栈中
    		else
    		{
    			stack.push(new ValueNode(Integer.parseInt(statementArr[i])));
    		}
    	}
    	this.node=(Node)stack.pop(); //弹出完整的表达式
    }
	
	public int compute()
	{
		return node.interpret();
	}
}

class Test
{
	public static void main(String args[])
	{
		String statement = "2 + 3 - 4 + 1";
		Calculator calculator = new Calculator();
		calculator.build(statement);	
		int result = calculator.compute();	
		System.out.println(statement + " = " + result);	
	}
}



