/**
 * Represents a Doctor object with a certain name, 2 treatment objects,
 * and methods that act on those Treatment objects.
 * @author (Zhengyang Qi)
 * @version 1.0
 */
public class Doctor {
    private String name;
    private Treatment treatment;

    /**
     * Initialies a Doctor object with the given name and 1 additional
     * parameter.
     *
     * @param  name                 the name of this doctor
     * @param  emergencyHealAmount  the amount of health points to pass in to the
     *                              EmergencyTreatment constructor
     */
    public Doctor(String name, int emergencyHealAmount) {
        this.name = name;
        treatment = new EmergencyTreatment(emergencyHealAmount);
    }

    /**
     * Initialies a Doctor object with the given name, and takes in 2 additional
     * parameters.
     *
     * After creating the ScheduledTreatment class, and creating an instance variable
     * of type Treatment above, in this constructor you should initialize an
     * instance of the **ScheduledTreatment** class, whose constructor will take
     * in the value of `scheduledHealAmount` as well as `scheduledPatientID`.
     * This new object should be assigned to an instance variable in this class.
     * @param  name                 the name of this doctor
     * @param  scheduledHealAmount  the amount of health points to pass in to the
     *                              ScheduledTreatment constructor
     * @param  scheduledPatientID   the patientID to pass in to the
     *                              ScheduledTreatment constructor
     */
    public Doctor(String name, int scheduledHealAmount, int scheduledPatientID) {
        this.name = name;
        treatment = new ScheduledTreatment(scheduledHealAmount, scheduledPatientID);
    }

    /**
     * Perform the appropriate treatment to a list of patients.
     * @param patients A list of patients.
     */
    public void performTreatment(Patient[] patients) {
        System.out.println(name + " goes to heal their patients!");
        treatment.performHeal(patients);
    }

    @Override
    public String toString() {
        return String.format("Doctor %s with treatment %s", name, treatment.toString());
    }

    /**
     * Set treatment to a certain to passed in.
     * @param t the treatment we want to set as
     */
    public void setTreatment(Treatment t) {
        treatment = t;
    }
}