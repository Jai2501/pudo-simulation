package com.BeepBeep;

import java.util.ArrayList;
import java.util.List;

public class OriginalPUDO implements PUDO {
    // private Berth a1 = new Berth("A1");
    private Berth a2 = new Berth("A2");
    private Berth a3 = new Berth("A3");
    private Berth a4 = new Berth("A4");
    private Berth a5 = new Berth("A5");
    // private Berth a6 = new Berth("A6");
    private Berth a7 = new Berth("A7");
    private Berth a8 = new Berth("A8");
    private Berth a9 = new Berth("A9");
    private Berth pwd = new Berth("PWD");

    private List<Berth> listOfBerths = new ArrayList<>();

    public OriginalPUDO() {
        this.pwd.makeBerthPwdCompatible();
        this.pwd.makeBerthOnlyTaxiCompatible();

        // this.a6.makeBerthOnlyTaxiCompatible();
        this.a7.makeBerthOnlyTaxiCompatible();
        this.a8.makeBerthOnlyTaxiCompatible();
        this.a9.makeBerthOnlyTaxiCompatible();

        // listOfBerths.add(a1);
        listOfBerths.add(a2);
        listOfBerths.add(a3);
        listOfBerths.add(a4);
        listOfBerths.add(a5);
        // listOfBerths.add(a6);
        listOfBerths.add(a7);
        listOfBerths.add(a8);
        listOfBerths.add(a9);
        listOfBerths.add(pwd);

        // A1 -> A2 -> A3 -> A4 -> A5
        // A6 -> PWD -> A7 -> A8 -> A9

//        a1.addNextBerth(a2);
//        a1.addNextBerth(a3);
//        a1.addNextBerth(a4);
//        a1.addNextBerth(a5);

        a2.addNextBerth(a3);
        a2.addNextBerth(a4);
        a2.addNextBerth(a5);

        a3.addNextBerth(a4);
        a3.addNextBerth(a5);

        a4.addNextBerth(a5);

//        a6.addNextBerth(pwd);
//        a6.addNextBerth(a7);
//        a6.addNextBerth(a8);
//        a6.addNextBerth(a9);

        pwd.addNextBerth(a7);
        pwd.addNextBerth(a8);
        pwd.addNextBerth(a9);

        a7.addNextBerth(a8);
        a7.addNextBerth(a9);

        a8.addNextBerth(a9);

        // a1.addNextBerth(a6);
        a2.addNextBerth(pwd);
        a3.addNextBerth(a7);
        a4.addNextBerth(a8);
        a5.addNextBerth(a9);

//        A1 -> A2 -> A3
//        PWD -> A4 -> A5
//        a1.addNextBerth(a2);
//        a1.addNextBerth(a3);
//
//        a1.addNextBerth(pwd);
//
//        a2.addNextBerth(a3);
//
//        a2.addNextBerth(a4);
//
//        a3.addNextBerth(a5);
//
//        pwd.addNextBerth(a4);
//        pwd.addNextBerth(a5);
//
//        pwd.addNextBerth(a1);
//
//        a4.addNextBerth(a5);
//
//        a4.addNextBerth(a2);
//
//        a5.addNextBerth(a3);
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

    public List<Berth> getTaxiBerthsAvailable() {
        List<Berth> listOfTaxiBerthsAvailable = new ArrayList<>();

        for (Berth berth: listOfBerths) {
            if (berth.isBerthOnlyTaxiCompatible() && (!(berth.isBerthOccupied())) && (!(berth.isBerthBlocked()))) {
                listOfTaxiBerthsAvailable.add(berth);
            }
        }

        return listOfTaxiBerthsAvailable;
    }

    public List<Berth> getNormalBerthsAvailable() {
        List<Berth> listOfNormalBerthsAvailable = new ArrayList<>();

        for (Berth berth: listOfBerths) {
            if ((!(berth.isBerthOccupied()) && (!(berth.isBerthPwdCompatible())) && (!(berth.isBerthOnlyTaxiCompatible())) && (!(berth.isBerthBlocked())))) {
                listOfNormalBerthsAvailable.add(berth);
            }
        }

        return listOfNormalBerthsAvailable;
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
        System.out.println("----------------------");
    }
}
