/**
 * Represents a ScheduledTreatment object with a patient ID who
 * is going to be treated. It extends abstract class Treatment,
 * which is able to spot the patient, from a list, that is
 * in need of treatment, and perform heal on a patient.
 * @author (Zhengyang Qi)
 * @version 1.0
 */
public class ScheduledTreatment extends Treatment {
    private int treatPatientID;

    /**
     * Initialize a ScheduledTreatment object
     * with parameter heal and treatPatientID.
     * @param heal the amount of healing done by this treatment.
     * @param treatPatientID the right patient ID to be treated.
     */
    public ScheduledTreatment(int heal, int treatPatientID) {
        super(heal);
        this.treatPatientID = treatPatientID;
    }
    @Override
    public void performHeal(Patient[] patients) {
        if (patients.length == 0) {
            return;
        }
        HealAbility.sortPatients(patients);
        int rightIndex = -1;
        int min = 0;
        int max = patients.length - 1;
        int mid;
        boolean found = false;
        while (!found && min < max) {
            mid = (min + max) / 2;
            if (patients[mid].getPatientID() == treatPatientID) {
                found = true;
                rightIndex = mid;
            } else if (patients[mid].getPatientID() > treatPatientID) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        if (rightIndex == -1) {
            return;
        }
        patients[rightIndex].increaseHealth(this);
    }
}