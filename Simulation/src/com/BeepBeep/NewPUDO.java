package com.BeepBeep;

import java.util.ArrayList;
import java.util.List;

public class NewPUDO implements PUDO {
    private Berth a1 = new Berth("A1");
    private Berth a2 = new Berth("A2");
    private Berth a3 = new Berth("A3");
    // private Berth a4 = new Berth("A4");
    private Berth pwd = new Berth("PWD");

    private List<Berth> listOfBerths = new ArrayList<>();

    public NewPUDO() {
        this.pwd.makeBerthPwdCompatible();

        listOfBerths.add(a1);
        listOfBerths.add(a2);
        listOfBerths.add(a3);
        // listOfBerths.add(a4);
        listOfBerths.add(pwd);

        // A1 -> A2 -> A3 -> A4 -> PWD
    }

    public void updateAllBerths() {
        System.out.println("Time Goes By +1");
        for (Berth berth: listOfBerths) {
            if (berth.isBerthOccupied()) {
                Car car = berth.getCarAtBerth();
                car.increaseTimeDoneSinceWaitingByOne();

                if (car.isCarReadyToGo()) {
                    berth.setCarDepartedFromBerth();
                }
            }
        }
    }

    public List<Berth> getBerthsAvailable() {
        List<Berth> listOfBerthsAvailable = new ArrayList<>();

        for (Berth berth: listOfBerths) {
            if ((!(berth.isBerthOccupied()) && (!(berth.isBerthPwdCompatible())) && (!(berth.isBerthOnlyTaxiCompatible())) && (!(berth.isBerthBlocked())))) {
                listOfBerthsAvailable.add(berth);
            }
        }

        return listOfBerthsAvailable;
    }

    public List<Berth> getPwdBerthsAvailable() {
        List<Berth> listOfPwdBerthsAvailable = new ArrayList<>();

        for (Berth berth: listOfBerths) {
            if (berth.isBerthPwdCompatible() && (!(berth.isBerthOccupied())) && (!(berth.isBerthBlocked()))) {
                listOfPwdBerthsAvailable.add(berth);
            }
        }

        return listOfPwdBerthsAvailable;
    }

    public boolean isPudoEmpty() {
        for (Berth berth: listOfBerths) {
            if (berth.isBerthOccupied()) {
                return false;
            }
        }
        return true;
    }

    public void displayPudoInfo() {
        System.out.println("------PUDO UPDATE------");
        for (Berth berth: listOfBerths) {
            if (berth.isBerthOccupied()) {
                System.out.println(berth);
            }
        }
    }
}
