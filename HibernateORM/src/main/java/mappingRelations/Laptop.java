package mappingRelations;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laptop {

	@Id
	private int LapID;
	private String LapName;
	
	public int getLapID() {
		return LapID;
	}
	public void setLapID(int lapID) {
		this.LapID = lapID;
	}
	public String getLapName() {
		return LapName;
	}
	public void setLapName(String lapName) {
		this.LapName = lapName;
	}

	
	@Override
	public String toString() {
		return LapID + " | " + LapName;
	}
}
