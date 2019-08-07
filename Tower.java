import java.util.Stack;
import java.util.Arrays;
import java.util.Collections;

public class Tower {

	private Stack<Disk> peg;
	
	public Tower() {
		peg = new Stack<Disk>();
	}
	
	public Tower(Disk [] disks) {
		peg = new Stack<Disk>();
		addDisks(disks);
	}
	
	public int numberOfDisks() {
		return peg.size();
	}
	public boolean addDisk(Disk disk) {
		boolean isValid = false;
		if (peg.size() == 0 || peg.peek().getSize() > disk.getSize()) {
			peg.push(disk);
			isValid = true;
		} 
		return isValid;
	}
	
	public void addDisks( Disk [] disks) {
		Arrays.sort(disks, Collections.reverseOrder());
		for (int i = 0; i < disks.length; i++) {
			peg.push(disks[i]);
		}
	}
	
	public Disk takeDisk() {
		return peg.pop();
	}
	
	public boolean isEmpty() {
		return peg.isEmpty();
	}
	
	private Disk [] toDiskArray(int numberOfDisks) {
		@SuppressWarnings("unchecked") 
		//warning suppressed because in this context, the cast should be safe
		Stack<Disk> tempPeg = (Stack<Disk>) peg.clone();
		Disk [] disks = new Disk[numberOfDisks];
		for (int i = 0; i < numberOfDisks; i++) {
			disks[i] = tempPeg.pop();
		}
		return disks;
	}
	@Override
	public String toString() {
		String stringRepresentation = "";
		int numberOfDisks = numberOfDisks();
		Disk [] disks = toDiskArray(numberOfDisks);
		Arrays.sort(disks);
		for (int i = 0; i < numberOfDisks; i++) {
			Disk disk = disks[i];
			stringRepresentation += disk.toString() + '\n';
		}
		return stringRepresentation;
	}
	
	public static void showThreeTowers(Tower sourceTower,Tower auxiliaryTower, 
			Tower targetTower) {
		String stringRepresentation = "";
		Disk [] sourceDisks = sourceTower.toDiskArray(sourceTower.numberOfDisks());
		Disk [] auxiliaryDisks = auxiliaryTower.toDiskArray(auxiliaryTower.numberOfDisks());
		Disk [] targetDisks = targetTower.toDiskArray(targetTower.numberOfDisks());
		Arrays.sort(sourceDisks);
		Arrays.sort(auxiliaryDisks);
		Arrays.sort(targetDisks);
		
		boolean  sourcePrinted, auxiliaryPrinted , targetPrinted, allPrinted;
		sourcePrinted = auxiliaryPrinted = targetPrinted = allPrinted = false;
		int counter = 0;
		
		while(!allPrinted) {
			if (counter < sourceDisks.length ) {
				stringRepresentation += sourceDisks[counter].toString();
			} else {
				sourcePrinted = true;
			}
			stringRepresentation += '\t';
			if (counter < auxiliaryDisks.length ) {
				stringRepresentation +=  auxiliaryDisks[counter].toString();
			} else {
				auxiliaryPrinted = true;
			}
			stringRepresentation += '\t';
			if (counter < targetDisks.length ) {
				stringRepresentation += targetDisks[counter].toString();
			} else {
				targetPrinted = true;
			}
			
			stringRepresentation += '\n';
			counter++;
			allPrinted = sourcePrinted && auxiliaryPrinted && targetPrinted;
			
		}
		System.out.print(stringRepresentation);
	}
}
