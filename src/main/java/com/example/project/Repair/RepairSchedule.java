package com.example.project.Repair;
import java.util.ArrayList;

public class RepairSchedule {
    /** Each element represents a repair by an individual mechanic in a bay. */
    private ArrayList<CarRepair> schedule;

    /** Number of mechanics available in this schedule. */
    private int numberOfMechanics;

    /** Constructs a RepairSchedule object.
     * Precondition: n >= 0
     */
    public RepairSchedule(int n) {
        numberOfMechanics = n;
        schedule = new ArrayList<>();
    }
    

    public ArrayList<CarRepair> getSchedule() {
        return schedule;
    }

    /** Attempts to schedule a repair by a given mechanic in a given bay as described in part (a).
     * Precondition: 0 <= m < numberOfMechanics and b >= 0
     */
    

    public boolean addRepair(int m, int b) {
        for (CarRepair repair : schedule) {
            if (repair.getMechanicNum() == m) {
                return false;
            }
        }

        for (CarRepair repair : schedule) {
            if (repair.getBayNum() == b) {
                return false;
            }
        }

        schedule.add(new CarRepair(m, b));
        return true;
    }


    /** Returns an ArrayList containing the mechanic identifiers of all available mechanics,
     * as described in part (b).
     */
    
    public ArrayList<Integer> availableMechanics() {
        ArrayList<Integer> available = new ArrayList<>();

        for (int i = 0; i < numberOfMechanics; i++) {
            boolean isAvailable = true;
            for (CarRepair repair : schedule) {
                if (repair.getMechanicNum() == i) {
                    isAvailable = false;
                    break;
                }
            }
            if (isAvailable) {
                available.add(i);
            }
        }
        return available;
    }



    /** Removes an element from schedule when a repair is complete.
        THIS METHOD HAS BEEN ADDED FOR ILLUSTRATIVE PURPOSES ONLY,
        AS DESCRIBED IN PART B; you do NOT need to call this
        method as part of your solution to part B
      */
    public void carOut(int b)
    {
        for (int i = 0; i < schedule.size(); i++)
        {
            CarRepair carAtIdx = schedule.get(i);
            if (carAtIdx.getBayNum() == b)
            {
                schedule.remove(i);
            }
        }
    }
}
