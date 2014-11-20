class Demo
{
	public void test()
	{
		for(Object player : players)
		{
			if(player.getName().equals(name))
			{
				this.detach(player);
			}
    		else
    		{
       			if(player.getType().equals(type))
        		{
            		player.displayTeam(name);
        		}
        		else
        		{
            		player.displayEnemy(name);
        		}
			}
		}

	}
}