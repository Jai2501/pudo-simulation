package com.BeepBeep;

public class Car {
    private float waitTime;
    private boolean isPwdAccessible;
    private boolean isTaxi;
    private boolean isPrivateHire;
    private float timeDoneSinceWaiting;

    private boolean isBerthSlotAssigned;

    public Car(float waitTime, boolean isPwdAccessible, boolean isTaxi, boolean isPrivateHire, float timeDoneSinceWaiting) {
        this.waitTime = waitTime;
        this.isPwdAccessible = isPwdAccessible;
        this.isTaxi = isTaxi;
        this.isPrivateHire = isPrivateHire;
        this.timeDoneSinceWaiting = timeDoneSinceWaiting;
        this.isBerthSlotAssigned = false;
    }

    public boolean isCarReadyToGo() {
        return (this.waitTime - this.timeDoneSinceWaiting) <= 0;
    }

    public void increaseTimeDoneSinceWaitingByOne() {
        this.timeDoneSinceWaiting += 1;
    }

    public void increaseTimeDoneSinceWaitingBy(float time) {
        this.timeDoneSinceWaiting += time;
    }

    public boolean isPwdAccessRequired() {
        return this.isPwdAccessible;
    }

    public boolean isItATaxi() {
        return this.isTaxi;
    }

    public boolean isItAPrivateHire() {
        return this.isPrivateHire;
    }

    public boolean isBerthSlotAssigned() {
        return (this.isBerthSlotAssigned);
    }

    public void assignedBerthSlot() {
        this.isBerthSlotAssigned = true;
    }

    @Override
    public String toString() {
        String carString = "";

        if (isPrivateHire) {
            carString += "Private Hire";
        } else if (isTaxi) {
            carString += "Taxi";
        } else if (isPwdAccessible) {
            carString += "PWD Vehicle";
        } else {
            carString += "Self Owned Vehicle";
        }

        carString += " expecting to wait for another " + String.valueOf(this.waitTime - this.timeDoneSinceWaiting) + " minutes";

        if (!(this.isBerthSlotAssigned())) {
            carString += " is in Queue";
        }

        return carString;
    }
}
