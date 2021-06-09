package mappingRelations;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	private int StudID;
	private String StudName;
	private int StudMarks;
	
	public int getStudID() {
		return StudID;
	}
	public void setStudID(int studID) {
		StudID = studID;
	}
	public String getStudName() {
		return StudName;
	}
	public void setStudName(String studName) {
		StudName = studName;
	}
	public int getStudMarks() {
		return StudMarks;
	}
	public void setStudMarks(int studMarks) {
		StudMarks = studMarks;
	}
	
	@Override
	public String toString() {
		return StudID + " | " + StudName + " | " + StudMarks;
	}
	

}
