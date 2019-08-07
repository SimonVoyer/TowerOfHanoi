public class Disk implements Comparable<Disk> {
	
	private int size;
	
	public Disk(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
	
	public static Disk [] getArrayOfDisks(int numberOfDisks) {
		Disk [] disks = new Disk[numberOfDisks];
		for (int i =0; i < disks.length; i++) {
			disks[i]= new Disk(i+1);
		}
		return disks;
	}

	public int compareTo(Disk disk) {
		int signum;
		if (equals(disk)) {
			signum = 0;
		} else if (size < disk.getSize()) {
			signum = -1;
		} else {
			signum = 1;
		}
		return signum;
	}
	
	public boolean equals(Object object) {
		boolean isEqual = false;
		if (object instanceof Disk && ((Disk) object).getSize() == size) {
			isEqual = true;
		}
		return isEqual;
	}

	public String toString() {
		String stringRepresentation = "";
		for (int i = 0; i < size; i++) {
			stringRepresentation += "*";
		}
		return stringRepresentation;
	}
	
}
