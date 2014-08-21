//Maggie Yu

public class HanoiTower
{
	private static void moveTower(int diskCount, String startPeg, String finishPeg, String helperPeg)
	{
		if(diskCount > 0)
		{
			moveTower(diskCount - 1, startPeg, helperPeg, finishPeg);
			System.out.println("Move disk " + diskCount + " from " + startPeg + " to " + finishPeg + ".");
			moveTower(diskCount - 1, helperPeg, finishPeg, startPeg);
		}
	}
	
	public static void main(String[] args)
	{	
		moveTower(6, "Peg A", "Peg C", "Peg B");
	}
}
