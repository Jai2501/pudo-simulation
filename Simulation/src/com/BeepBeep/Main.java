package com.BeepBeep;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();

        // write your code here
//        Car jaiCar = new Car(3.5F, false, false, false, 0);
//        System.out.println(jaiCar);
//        jaiCar.assignBerthSlot();
//        System.out.println(jaiCar);
//        jaiCar.increaseTimeDoneSinceWaitingByOne();
//        System.out.println(jaiCar);
//        jaiCar.increaseTimeDoneSinceWaitingBy(2);
//        System.out.println(jaiCar);
//
//        Berth a1 = new Berth("A1");
//        a1.assignCarToBerth(jaiCar);
//        System.out.println(a1);

        Car jaiCar = new Car(3.0f, false, false, false, 0);
        Car annabelleCar = new Car(3.0f, false, false, false, 0);
        Car garethCar = new Car(4.0f, false, false, false, 0);
        Car karinCar = new Car(2.0f, false, false, false, 0);

        Car pwdCar = new Car(6.0f, true, false, false, 0);

        Car privateHireForColin = new Car(4.0f, false, false, true, 0);
        Car taxiForLee = new Car(3.0f, false, true, false, 0);
        Car jjCar = new Car(4.0f, false, false, false, 0);

        Car pwdCarTwo = new Car(5.0f, true, false, false, 0);

        // Queue<Car> carQueue = new LinkedList<>();
        List<Car> carQueue = new ArrayList<>();

        carQueue.add(jaiCar);
        carQueue.add(annabelleCar);
        carQueue.add(garethCar);
        carQueue.add(karinCar);
        carQueue.add(pwdCar);
        carQueue.add(privateHireForColin);
        carQueue.add(taxiForLee);
        carQueue.add(jjCar);
        carQueue.add(pwdCarTwo);

//        // 5 Normal Cars + Taxi + PHVs
//        carQueue.add(new Car(3.0f, false,false, true, 0));
//        carQueue.add(new Car(2.0f, false,true, false, 0));
//        carQueue.add(new Car(3.0f, false,false, true, 0));
//        carQueue.add(new Car(1.0f, false,false, false, 0));
//        carQueue.add(new Car(2.0f, false,true, false, 0));
//
//        // 1 PWD
//        carQueue.add(new Car(5.0f, true,false, false, 0));
//
//        // 1 Carpark Car
//        carQueue.add(new Car(0.0f, false,false, false, 0));
//
//        // 5 Normal Cars + Taxi + PHVs
//        carQueue.add(new Car(2.0f, false,true, false, 0));
//        carQueue.add(new Car(3.0f, false,true, false, 0));
//        carQueue.add(new Car(1.0f, false,false, true, 0));
//        carQueue.add(new Car(4.0f, false,false, false, 0));
//        carQueue.add(new Car(3.0f, false,false, false, 0));
//
//        // 1 PWD
//        carQueue.add(new Car(6.0f, true,false, false, 0));
//
//        // 5 Normal Cars + Taxi + PHVs
//        carQueue.add(new Car(3.0f, false,false, false, 0));
//        carQueue.add(new Car(4.0f, false,false, true, 0));
//        carQueue.add(new Car(1.0f, false,false, true, 0));
//        carQueue.add(new Car(4.0f, false,false, false, 0));
//        carQueue.add(new Car(2.0f, false,true, false, 0));
//
//        // 1 PWD
//        carQueue.add(new Car(5.0f, true,false, false, 0));
//
//        // 1 Carpark Car
//        carQueue.add(new Car(0.0f, false,false, false, 0));
//
//        // 5 Normal Cars + Taxi + PHVs
//        carQueue.add(new Car(4.0f, false,false, false, 0));
//        carQueue.add(new Car(3.0f, false,false, false, 0));
//        carQueue.add(new Car(2.0f, false,false, true, 0));
//        carQueue.add(new Car(1.0f, false,true, false, 0));
//        carQueue.add(new Car(3.0f, false,false, true, 0));
//
//        // 1 PWD
//        carQueue.add(new Car(6.0f, true,false, false, 0));
//
//        // 5 Normal Cars + Taxi + PHVs + 1 Priority Kid
//        carQueue.add(new Car(3.0f, false,true, false, 0));
//        carQueue.add(new Car(2.0f, false,true, false, 0));
//        carQueue.add(new Car(1.0f, false,false, true, 0));
//        carQueue.add(new Car(4.0f, true,false, false, 0));
//        carQueue.add(new Car(2.0f, false,false, false, 0));
//
//        // 1 Carpark Car
//        carQueue.add(new Car(0.0f, false,false, false, 0));
//
//        // 1 PWD
//        carQueue.add(new Car(7.0f, true,false, false, 0));
//
//        // 5 Normal Cars + Taxi + PHVs
//        carQueue.add(new Car(4.0f, false,true, false, 0));
//        carQueue.add(new Car(4.0f, false,false, true, 0));
//        carQueue.add(new Car(3.0f, false,false, false, 0));
//        carQueue.add(new Car(3.0f, false,true, false, 0));
//        carQueue.add(new Car(2.0f, false,false, true, 0));
//
//        // 1 PWD
//        carQueue.add(new Car(6.0f, true,false, false, 0));
//
//        // 5 Normal Cars + Taxi + PHVs
//        carQueue.add(new Car(3.0f, false,false, false, 0));
//        carQueue.add(new Car(1.0f, false,false, false, 0));
//        carQueue.add(new Car(1.0f, false,false, true, 0));
//        carQueue.add(new Car(4.0f, false,true, false, 0));
//        carQueue.add(new Car(2.0f, false,false, true, 0));
//
//        // 1 PWD
//        carQueue.add(new Car(5.0f, true,false, false, 0));
//
//        // 1 Carpark Car
//        carQueue.add(new Car(0.0f, false,false, false, 0));
//
//        // 5 Normal Cars + Taxi + PHVs
//        carQueue.add(new Car(4.0f, false,false, true, 0));
//        carQueue.add(new Car(3.0f, false,false, true, 0));
//        carQueue.add(new Car(1.0f, false,true, false, 0));
//        carQueue.add(new Car(3.0f, false,false, false, 0));
//        carQueue.add(new Car(2.0f, false,false, true, 0));
//
//        // 1 PWD
//        carQueue.add(new Car(5.0f, true,false, false, 0));
//
//        // 5 Normal Cars + Taxi + PHVs + 1 Priority Kid
//        carQueue.add(new Car(4.0f, false,false, false, 0));
//        carQueue.add(new Car(2.0f, false,true, false, 0));
//        carQueue.add(new Car(1.0f, false,false, true, 0));
//        carQueue.add(new Car(3.0f, false,false, false, 0));
//        carQueue.add(new Car(4.0f, true,false, false, 0));
//
//        // 1 PWD
//        carQueue.add(new Car(6.0f, true,false, false, 0));
//
//        // 1 Carpark Car
//        carQueue.add(new Car(0.0f, false,false, false, 0));
//
//        // 5 Normal Cars + Taxi + PHVs
//        carQueue.add(new Car(1.0f, false,false, true, 0));
//        carQueue.add(new Car(3.0f, false,true, false, 0));
//        carQueue.add(new Car(2.0f, false,false, false, 0));
//        carQueue.add(new Car(2.0f, false,false, false, 0));
//        carQueue.add(new Car(1.0f, false,true, false, 0));
//
//        // 1 PWD
//        carQueue.add(new Car(5.0f, true,false, false, 0));
//
//        // 5 Normal Cars + Taxi + PHVs + 1 Priority Kid
//        carQueue.add(new Car(2.0f, false,true, false, 0));
//        carQueue.add(new Car(2.0f, false,true, false, 0));
//        carQueue.add(new Car(3.0f, false,false, true, 0));
//        carQueue.add(new Car(1.0f, false,false, false, 0));
//        carQueue.add(new Car(5.0f, true,false, false, 0));
//
//        // 1 PWD
//        carQueue.add(new Car(6.0f, true,false, false, 0));
//
//        // 5 Normal Cars + Taxi + PHVs
//        carQueue.add(new Car(2.0f, false,true, false, 0));
//        carQueue.add(new Car(1.0f, false,false, false, 0));
//        carQueue.add(new Car(2.0f, false,true, false, 0));
//        carQueue.add(new Car(3.0f, false,true, false, 0));
//        carQueue.add(new Car(1.0f, false,false, true, 0));
//
//        // 1 PWD
//        carQueue.add(new Car(6.0f, true,false, false, 0));
//
//        // 5 Normal Cars + Taxi + PHVs
//        carQueue.add(new Car(1.0f, false,false, false, 0));
//        carQueue.add(new Car(4.0f, false,true, false, 0));
//        carQueue.add(new Car(3.0f, false,false, true, 0));
//        carQueue.add(new Car(1.0f, false,false, false, 0));
//        carQueue.add(new Car(1.0f, false,false, false, 0));
//
//        // 1 PWD
//        carQueue.add(new Car(4.0f, true,false, false, 0));
//
//        // 5 Normal Cars + Taxi + PHVs + 1 Priority Kid
//        carQueue.add(new Car(1.0f, false,false, false, 0));
//        carQueue.add(new Car(4.0f, false,false, false, 0));
//        carQueue.add(new Car(5.0f, true,false, false, 0));
//        carQueue.add(new Car(3.0f, false,true, false, 0));
//        carQueue.add(new Car(1.0f, false,true, false, 0));
//
//        // 1 PWD
//        carQueue.add(new Car(6.0f, true,false, false, 0));
//
//        // 5 Normal Cars + Taxi + PHVs
//        carQueue.add(new Car(2.0f, false,true, false, 0));
//        carQueue.add(new Car(3.0f, false,false, true, 0));
//        carQueue.add(new Car(3.0f, false,false, true, 0));
//        carQueue.add(new Car(2.0f, false,false, false, 0));
//        carQueue.add(new Car(1.0f, false,true, false, 0));
//
//        // 1 PWD
//        carQueue.add(new Car(5.0f, true,false, false, 0));
//
//        // 5 Normal Cars + Taxi + PHVs
//        carQueue.add(new Car(1.0f, false,false, false, 0));
//        carQueue.add(new Car(4.0f, false,true, false, 0));
//        carQueue.add(new Car(2.0f, false,false, false, 0));
//        carQueue.add(new Car(2.0f, false,false, false, 0));
//        carQueue.add(new Car(3.0f, false,false, true, 0));

//
        OriginalPUDO pudo = new OriginalPUDO();
        // NewPUDO pudo = new NewPUDO();

        int maxTailbackQueueLenght = 0;
        List<Car> carTailbackQueue = new ArrayList<>();

        int i = 0;
        int timeTaken = 0;

        while (carQueue.size() != i) {
            Car car = carQueue.get(i);

            if (car.isPwdAccessRequired()) {
                List<Berth> pwdBerthsAvailable = pudo.getPwdBerthsAvailable();

                if (pwdBerthsAvailable.size() == 0) {
                    // carQueue.add(i, car);
                    // System.out.println(car);
                } else {
                    // Berth pwdBerth = pwdBerthsAvailable.get(0);

                    int max = pwdBerthsAvailable.size();
                    int min = 0;
                    int randomBerthNumberToChoose = (int) (Math.random() * (max - min + 1) + min);

                    System.out.println("RANDOM NUMBER: " + randomBerthNumberToChoose);

                    Berth pwdBerth = pwdBerthsAvailable.get(random.nextInt(pwdBerthsAvailable.size()));

                    pwdBerth.assignCarToBerth(car);
                    car.assignedBerthSlot();

                    pwdBerth.setNextBerthsAsBlocked();
                    i++;
                    // System.out.println(pwdBerth);
                }
            } else if (car.isItATaxi()) {
                List<Berth> taxiBerthsAvailable = pudo.getTaxiBerthsAvailable();

                if (taxiBerthsAvailable.size() == 0) {
                    // Add to the front again (Queue)
                    // carQueue.add(i, car);
                    // System.out.println(car);
                } else {
                    // if many berths available, get the furthest one or randomly select as a human would probably
                    // Berth taxiBerth = taxiBerthsAvailable.get(0);

                    int max = taxiBerthsAvailable.size();
                    int min = 0;
                    int randomBerthNumberToChoose = (int) (Math.random() * (max - min + 1) + min);

                    Berth taxiBerth = taxiBerthsAvailable.get(random.nextInt(taxiBerthsAvailable.size()));

                    System.out.println("RANDOM NUMBER: " + randomBerthNumberToChoose);
                    taxiBerth.assignCarToBerth(car);
                    car.assignedBerthSlot();

                    taxiBerth.setNextBerthsAsBlocked();
                    i++;
                    // System.out.println(taxiBerth);
                }
            } else {
                List<Berth> normalBerths = pudo.getNormalBerthsAvailable();

                if (normalBerths.size() == 0) {
                    // carQueue.add(i, car);
                    // System.out.println(car);
                } else {
                    // Berth normalBerth = normalBerths.get(0);

                    int max = normalBerths.size() - 1;
                    int min = 0;
                    int randomBerthNumberToChoose = (int) (Math.random() * (max - min + 1) + min);

                    Berth normalBerth = normalBerths.get(random.nextInt(normalBerths.size()));

                    normalBerth.assignCarToBerth(car);
                    car.assignedBerthSlot();

                    normalBerth.setNextBerthsAsBlocked();
                    i++;
                    // System.out.println(normalBerth);
                }
            }

            timeTaken++;
            pudo.displayPudoInfo();

            System.out.println("------CAR QUEUE------");

            for (Car displayCar: carQueue) {
                if (!(displayCar.isBerthSlotAssigned())) {
                    System.out.println(displayCar);
                }
            }

            pudo.updateAllBerths();

            System.out.println("--------------------------------------");
        }

        while (!pudo.isPudoEmpty()) {
            pudo.updateAllBerths();
            timeTaken++;
        }


        System.out.println("Time Taken: " + timeTaken);

//        System.out.println("WITH NEW PUDO");
//
//        carQueue.add(jaiCar);
//        carQueue.add(annabelleCar);
//        carQueue.add(garethCar);
//        carQueue.add(karinCar);
//        carQueue.add(pwdCar);
//        carQueue.add(privateHireForColin);
//        carQueue.add(taxiForLee);
//        carQueue.add(jjCar);
//        carQueue.add(pwdCarTwo);
//
//        NewPUDO newPudo = new NewPUDO();
//
//        i = 0;
//        timeTaken = 0;
//
//        while (carQueue.size() != i) {
//            Car car = carQueue.get(i);
//
//            if (car.isPwdAccessRequired()) {
//                List<Berth> pwdBerthsAvailable = newPudo.getPwdBerthsAvailable();
//
//                if (pwdBerthsAvailable.size() == 0) {
//                    // carQueue.add(i, car);
//                    // System.out.println(car);
//                } else {
//                    // Berth pwdBerth = pwdBerthsAvailable.get(0);
//
//                    int max = pwdBerthsAvailable.size();
//                    int min = 0;
//                    int randomBerthNumberToChoose = (int) (Math.random() * (max - min + 1) + min);
//
//                    Berth pwdBerth = pwdBerthsAvailable.get(random.nextInt(pwdBerthsAvailable.size()));
//
//                    pwdBerth.assignCarToBerth(car);
//                    car.assignedBerthSlot();
//
//                    pwdBerth.setNextBerthsAsBlocked();
//                    i++;
//                    // System.out.println(pwdBerth);
//                }
//            } else {
//                List<Berth> normalBerths = newPudo.getBerthsAvailable();
//
//                if (normalBerths.size() == 0) {
//                    // carQueue.add(i, car);
//                    // System.out.println(car);
//                } else {
//                    // Berth normalBerth = normalBerths.get(0);
//
//                    int max = normalBerths.size() - 1;
//                    int min = 0;
//                    int randomBerthNumberToChoose = (int) (Math.random() * (max - min + 1) + min);
//
//                    Berth normalBerth = normalBerths.get(random.nextInt(normalBerths.size()));
//
//                    normalBerth.assignCarToBerth(car);
//                    car.assignedBerthSlot();
//
//                    normalBerth.setNextBerthsAsBlocked();
//                    i++;
//                    // System.out.println(normalBerth);
//                }
//            }
//
//            timeTaken++;
//            newPudo.displayPudoInfo();
//
//            System.out.println("------CAR QUEUE------");
//
//            for (Car displayCar: carQueue) {
//                if (!(displayCar.isBerthSlotAssigned())) {
//                    System.out.println(displayCar);
//                }
//            }
//
//            newPudo.updateAllBerths();
//
//            System.out.println("--------------------------------------");
//        }
//
//        while (!newPudo.isPudoEmpty()) {
//            newPudo.updateAllBerths();
//            timeTaken++;
//        }
//
//        System.out.println("Time Taken: " + timeTaken);
//
    }
}
