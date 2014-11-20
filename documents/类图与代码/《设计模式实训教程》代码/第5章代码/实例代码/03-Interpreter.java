import java.util.*;

//������ʽ
abstract class AbstractNode
{
	public abstract String interpret();
}

//And���ͣ����ս�����ʽ
class AndNode extends AbstractNode
{
	private AbstractNode left;
	private AbstractNode right;
	public AndNode(AbstractNode left,AbstractNode right)
	{
		this.left = left;
		this.right = right;
	}
	public String interpret()
	{
		return left.interpret() + "��" + right.interpret();
	}
}

//�򵥾��ӽ��ͣ����ս�����ʽ
class SentenceNode extends AbstractNode
{
	private AbstractNode direction;
	private AbstractNode action;
	private AbstractNode distance;
	public SentenceNode(AbstractNode direction,AbstractNode action,AbstractNode distance)
	{
		this.direction = direction;
		this.action = action;
		this.distance = distance;
	}
	public String interpret()
	{
		return direction.interpret() + action.interpret() + distance.interpret();
	}	
}

//������ͣ��ս�����ʽ
class DirectionNode extends AbstractNode
{
	private String direction;
	
	public DirectionNode(String direction)
	{
		this.direction = direction;
	}
	
	public String interpret()
	{
		if(direction.equalsIgnoreCase("up"))
		{
			return "����";
		}
		else if(direction.equalsIgnoreCase("down"))
		{
			return "����";
		}
		else if(direction.equalsIgnoreCase("left"))
		{
			return "����";
		}
		else if(direction.equalsIgnoreCase("right"))
		{
			return "����";
		}
		else
		{
			return "��Чָ��";
		}
	}
}

//�������ͣ��ս�����ʽ
class ActionNode extends AbstractNode
{
	private String action;
	
	public ActionNode(String action)
	{
		this.action = action;
	}
	
	public String interpret()
	{
		if(action.equalsIgnoreCase("move"))
		{
			return "�ƶ�";
		}
		else if(action.equalsIgnoreCase("run"))
		{
			return "�����ƶ�";
		}
		else
		{
			return "��Чָ��";
		}
	}
}

//������ͣ��ս�����ʽ
class DistanceNode extends AbstractNode
{
	private String distance;
	
	public DistanceNode(String distance)
	{
		this.distance = distance;
	}
	
	public String interpret()
	{
		return this.distance;
	}	
}

//ָ����ࣺ������
class InstructionHandler
{
	private String instruction;
	private AbstractNode node;
    
    public void handle(String instruction)
    {
    	AbstractNode left=null,right=null;
    	AbstractNode direction=null,action=null,distance=null;
    	Stack stack=new Stack(); 
    	String[] words=instruction.split(" "); //�Կո�ָ��ַ���
    	for(int i=0;i<words.length;i++)
    	{
    		if(words[i].equalsIgnoreCase("and"))
    		{
    			left=(AbstractNode)stack.pop();
    		    String word1=words[++i];
    		    direction=new DirectionNode(word1);
    		    String word2=words[++i];
    		    action=new ActionNode(word2);
    		    String word3=words[++i];
    		    distance=new DistanceNode(word3);
    		    right=new SentenceNode(direction,action,distance);
    			stack.push(new AndNode(left,right));
    		}
    		else 
    		{	
    		    String word1=words[i];
    		    direction=new DirectionNode(word1);
    		    String word2=words[++i];
    		    action=new ActionNode(word2);
    		    String word3=words[++i];
    		    distance=new DistanceNode(word3);
    		    left=new SentenceNode(direction,action,distance);
    		    stack.push(left);
    		}
    	}
    	this.node=(AbstractNode)stack.pop();
    }
	
	public String output()
	{
		String result = node.interpret();
		return result;
	}
}

class Client
{
	public static void main(String args[])
	{
		String instruction = "up move 5 and down run 10 and left move 5";
		InstructionHandler handler = new InstructionHandler();
		handler.handle(instruction);
		String outString;
		outString = handler.output();
		System.out.println(outString);
	}
}