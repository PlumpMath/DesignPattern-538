import java.util.*;
interface Node
{
	public int interpret();
}

//�ս�����ʽ�࣬���ڽ���һ��������ֵ
class ValueNode implements Node
{
	private int value;
	public ValueNode(int value)
	{  this.value=value;  }
		
	public int interpret()
	{  return this.value;  }
}

//�����ս�����ʽ��
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
	
	public int interpret()  //�ӷ�����
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
	
	public int interpret()  //�ӷ�����
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
    	Stack stack=new Stack(); //ʹ��ջ���洢���ʽ
    	String[] statementArr=statement.split(" "); //�ָ������ַ���
    	for(int i=0;i<statementArr.length;i++)
    	{	
    		//�������ķ����ǼӺţ��򽫴洢��ջ�еı��ʽ��������Ϊ������ʽ������֮�����ֵ��Ϊ���ұ��ʽ������һ���µ�AddNode���󲢴���ջ��
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
    		//�������ķ��żȲ��ǼӺ�Ҳ���Ǽ��ţ���Ϊ��ֵ������һ���µ�ValueNode���󲢴洢ջ��
    		else
    		{
    			stack.push(new ValueNode(Integer.parseInt(statementArr[i])));
    		}
    	}
    	this.node=(Node)stack.pop(); //���������ı��ʽ
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



