import java.util.*;
class Chessman
{
	private String label;
	private int x;
	private int y;
	public Chessman(String label,int x,int y)
	{
		this.label = label;
		this.x = x;
		this.y = y;
	}
	public void setLabel(String label) 
	{
		this.label = label; 
	}

	public void setX(int x) 
	{
		this.x = x; 
	}

	public void setY(int y) 
	{
		this.y = y; 
	}

	public String getLabel() {
		return (this.label); 
	}

	public int getX() 
	{
		return (this.x); 
	}

	public int getY() 
	{
		return (this.y); 
	}
	
	public ChessmanMemento save()
	{
		return new ChessmanMemento(this.label,this.x,this.y);
	}
	
	public void restore(ChessmanMemento memento)
	{
		this.label = memento.getLabel();
		this.x = memento.getX();
		this.y = memento.getY();
	}
}

class ChessmanMemento
{
	private String label;
	private int x;
	private int y;
	public ChessmanMemento(String label,int x,int y)
	{
		this.label = label;
		this.x = x;
		this.y = y;
	}
	public void setLabel(String label) 
	{
		this.label = label; 
	}

	public void setX(int x) 
	{
		this.x = x; 
	}

	public void setY(int y) 
	{
		this.y = y; 
	}

	public String getLabel() {
		return (this.label); 
	}

	public int getX() 
	{
		return (this.x); 
	}

	public int getY() 
	{
		return (this.y); 
	}	
}

class MementoCaretaker
{
	private ArrayList mementolist = new ArrayList();
	public ChessmanMemento getMemento(int i)
	{
		return (ChessmanMemento)mementolist.get(i);
	}
	public void setMemento(ChessmanMemento memento)
	{
		mementolist.add(memento);
	}
}

class Test
{
	private static int index = -1;
	private static MementoCaretaker mc = new MementoCaretaker();
	public static void main(String args[])
	{
		Chessman chess = new Chessman("车",1,1);
		play(chess);		
		chess.setY(4);
		play(chess);
		chess.setX(5);
		play(chess);	
		undo(chess,index);
		undo(chess,index);	
		redo(chess,index);
		redo(chess,index);
	}
	
	public static void play(Chessman chess)
	{
		mc.setMemento(chess.save());
		index ++;
		System.out.println("棋子" + chess.getLabel() + "当前位置为：" + "第" + chess.getX() + "行" + "第" + chess.getY() + "列。");
	}
	
	public static void undo(Chessman chess,int i)
	{
		System.out.println("******悔棋******");
		index --;
		chess.restore(mc.getMemento(i-1));
		System.out.println("棋子" + chess.getLabel() + "当前位置为：" + "第" + chess.getX() + "行" + "第" + chess.getY() + "列。");
	}
	
	public static void redo(Chessman chess,int i)
	{
		System.out.println("******撤销悔棋******");	
		index ++;
		chess.restore(mc.getMemento(i+1));
		System.out.println("棋子" + chess.getLabel() + "当前位置为：" + "第" + chess.getX() + "行" + "第" + chess.getY() + "列。");
	}
}