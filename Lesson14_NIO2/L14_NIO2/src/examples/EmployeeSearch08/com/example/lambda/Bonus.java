package examples.EmployeeSearch08.com.example.lambda;

import javax.management.relation.Role;

/**
 * @author oracle
 */

public enum Bonus {

    STAFF(0.02),
    MANAGER(0.04),
    EXECUTIVE(0.06);

    private final double percent;

    Bonus(double percent) {
        this.percent = percent;
    }

    public double percent() {
        return percent;
    }

    public static double byRole(Role r) {

        double bonusPercent = 0.0d;

        if (r.equals(Bonus.EXECUTIVE)) {
            bonusPercent = EXECUTIVE.percent;
        } else if (r.equals(Bonus.MANAGER)) {
            bonusPercent = MANAGER.percent;
        } else if (r.equals(Bonus.STAFF)) {
            bonusPercent = STAFF.percent;
        }

        return bonusPercent;
    }
}