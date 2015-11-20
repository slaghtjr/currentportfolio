import java.util.ArrayList;

//Drug is an interface, meaning it has no variables and just the headers of all it's methods. 
//These methods MUST be called and used by any classes that implement drug.

//NOTE: None of these methods have bodies to them.
public interface Drug {

	public void setMedicationId(String aMedicationId);

	public void setMedicationName(String aMedicationName);

	public void setUnitOfMeasurement(String aUnitOfMeasurement);

	public void setSideEffectsList(ArrayList<SideEffects> aSideEffect);

	public String getMedicationId();

	public String getMedicationName();

	public String getUnitPrescribed();

	public ArrayList<SideEffects> getSideEffectsList();

	public String toString();

}
