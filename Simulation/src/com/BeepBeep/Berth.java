package com.BeepBeep;

import java.util.ArrayList;
import java.util.List;

public class Berth {
    private String berthName;
    private Car carAtBerth;

    private boolean isForPwd;
    private boolean isOnlyForTaxi;

    private List<Berth> nextBerths;
    private boolean canAccess;

    public Berth(String berthName) {
        this.berthName = berthName;
        this.carAtBerth = null;

        this.isForPwd = false;
        this.isOnlyForTaxi = false;

        this.nextBerths = new ArrayList<>();
        this.canAccess = true;
    }

    public void blockAccess() {
        this.canAccess = false;
    }

    public void unblockAccess() {
        this.canAccess = true;
    }

    public void addNextBerth(Berth nextBerth) {
        this.nextBerths.add(nextBerth);
    }

    public void setNextBerthsAsBlocked() {
        for (Berth nextBerth: this.nextBerths) {
            nextBerth.blockAccess();
        }
    }

    public void setNextBerthsAsUnblocked() {
        for (Berth nextBerth: this.nextBerths) {
            nextBerth.unblockAccess();
        }
    }

    public boolean areNextBerthsBlocked() {
        for (Berth nextBerth: this.nextBerths) {
            if (nextBerth.isBerthBlocked()) {
                return true;
            }
        }
        return false;
    }

    public boolean isBerthBlocked() {
        return !(this.canAccess);
    }

    public void makeBerthPwdCompatible() {
        this.isForPwd = true;
    }

    public void makeBerthOnlyTaxiCompatible() {
        this.isOnlyForTaxi = true;
    }

    public boolean isBerthOnlyTaxiCompatible() {
        return this.isOnlyForTaxi;
    }

    public boolean isBerthPwdCompatible() {
        return this.isForPwd;
    }

    public void assignCarToBerth(Car newCar) {
        this.carAtBerth = newCar;
    }

    public void setCarDepartedFromBerth() {
//        if (this.areNextBerthsBlocked()) {
//            // Do nothing
//            return;
//        }
        this.setNextBerthsAsUnblocked();
        this.carAtBerth = null;
    }

    public Car getCarAtBerth() {
        return this.carAtBerth;
    }

    public boolean isBerthOccupied() {
        return !(this.carAtBerth == null);
    }

    @Override
    public String toString() {
        String berthString = "";
        if (this.isBerthOccupied()) {
            return this.carAtBerth + " is in " + this.berthName + " berth";
        } else if (this.isBerthBlocked()) {
            return this.berthName + " is Blocked";
        }  else {
            return this.berthName + " is Unoccupied";
        }
    }
}
