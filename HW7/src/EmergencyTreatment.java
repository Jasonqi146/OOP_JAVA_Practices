/**
 * Represents a EmergencyTreatment object that treat
 * the patient with the lowest health.
 * It extends abstract class Treatment,
 * which is able to spot the patient, from a list, that is
 * in need of treatment, and perform heal on a patient.
 * @author (Zhengyang Qi)
 * @version 1.0
 */
public class EmergencyTreatment extends Treatment {
    /**
     * Initialize an EmergencyTreatment object with
     * parameter heal.
     * @param heal the amount of healing done by this treatment.
     */
    public EmergencyTreatment(int heal) {
        super(heal);
    }
    @Override
    public void performHeal(Patient[] patients) {
        if (patients.length == 0) {
            return;
        }
        Patient leastHealth = patients[0];
        for (int i = 1; i < patients.length; i++) {
            if (patients[i].getHealth() < leastHealth.getHealth()) {
                leastHealth = patients[i];
            }
        }
        leastHealth.increaseHealth(this);
    }
}