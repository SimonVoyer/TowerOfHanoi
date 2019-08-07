import java.lang.Math;
import java.util.Scanner;

public class TowerOfHanoi {
	
	private Tower sourceTower, auxiliaryTower, targetTower;
	private int numberOfMoves;
	
	public TowerOfHanoi(int numberOfDisks) {
	     sourceTower = new Tower(Disk.getArrayOfDisks(numberOfDisks));
		 auxiliaryTower = new Tower();
		 targetTower = new Tower();
		 numberOfMoves = 0;
	}
	
	public void play() {
		Tower.showThreeTowers(sourceTower, auxiliaryTower, targetTower);
		moveDisk(sourceTower.numberOfDisks(), sourceTower, auxiliaryTower,  targetTower);
	}
	
	private void moveDisk(int numberOfDisks, Tower sourceTower, 
			Tower auxiliaryTower, Tower targetTower) {
		if (numberOfDisks > 0) {
			moveDisk(numberOfDisks - 1, sourceTower, targetTower, auxiliaryTower );
			targetTower.addDisk(sourceTower.takeDisk());
			numberOfMoves++;
			Tower.showThreeTowers(this.sourceTower, this.auxiliaryTower, this.targetTower);
			try {
				Thread.sleep(500);
			} catch (InterruptedException exception) {
				//nothing interesting to do if that exception were to happen
			}
			moveDisk(numberOfDisks - 1, auxiliaryTower, sourceTower, targetTower);
		}
	}
	
	public int getNumberOfMoves() {
		return numberOfMoves;
	}
	
	public static int minimumNumberOfMoves(double numberOfDisks) {
		return (int) Math.pow(2.0, numberOfDisks) - 1;
	}
	
	public static void main (String [] args) {
		System.out.print("Enter the number of disks to play with: ");
		Scanner scanner = new Scanner(System.in);
		int numberOfDisks = scanner.nextInt();
		scanner.close();
		TowerOfHanoi towers = new TowerOfHanoi(numberOfDisks);
		towers.play();
		System.out.println("Number of moves taken: " + towers.numberOfMoves);
		System.out.println("Best possible solution: " +
				TowerOfHanoi.minimumNumberOfMoves(numberOfDisks));
	}
	
}
