/**
 * Represents a Treatment object with the amount of healing by the
 * treatment.
 * @author (Zhengyang Qi)
 * @version 1.0
 */
public abstract class Treatment implements HealAbility {
    private int heal;

    /**
     * Initializes a Patient object with a parameter list corresponding
     * to all of its fields.
     * @param heal    Amount of healing that can be performed.
     */
    public Treatment(int heal) {
        this.heal = heal;
    }
    @Override
    public String toString() {
        return "Treatment with " + heal + " heal";
    }
    @Override
    public int getHealAmount() {
        return heal;
    }

}