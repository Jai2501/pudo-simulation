package com.BeepBeep;

import java.util.*;

public class StressTesting {

    private static Queue<Car> carQueue = new LinkedList<>();

    private static Queue<Car> carQueueCopy = new LinkedList<>();

    private static OriginalPUDO originalPudo = new OriginalPUDO();
    private static NewPUDO newPudo = new NewPUDO();

    private static int maxTailbackQueueLength = 0;
    private static Queue<Car> carTailbackQueue = new LinkedList<>();

    private static Random random = new Random();

    private static int totalTime = 0;

    public static void main(String args[]) {
        addAllCars();

//        Collections.shuffle(carQueue);

        // stressTestNewPudo();
        stressTestOrignalPudo();
    }

    public static void refreshAllVariables() {
        maxTailbackQueueLength = 0;
        carTailbackQueue = new LinkedList<>();

        carQueue = new LinkedList<>();

        originalPudo = new OriginalPUDO();
        newPudo = new NewPUDO();

        totalTime = 0;
    }

    public static void settleTheCarForNewPudo(Car car, Boolean isFromTailback) {
        if (car.isPwdAccessRequired()) {
            List<Berth> pwdBerthsAvailable = newPudo.getPwdBerthsAvailable();

            if (!pwdBerthsAvailable.isEmpty()) {
                if (isFromTailback) {
                    car = carTailbackQueue.poll();
                }

                Berth pwdBerth = pwdBerthsAvailable.get(random.nextInt(pwdBerthsAvailable.size()));

                pwdBerth.assignCarToBerth(car);
                car.assignedBerthSlot();

                // pwdBerth.setNextBerthsAsBlocked();
            } else {
                if (!isFromTailback) {
                    carTailbackQueue.add(car);
                }
            }
        } else {
            List<Berth> normalBerths = newPudo.getBerthsAvailable();

            if (!normalBerths.isEmpty()) {
                if (isFromTailback) {
                    car = carTailbackQueue.poll();
                }

                Berth normalBerth = normalBerths.get(random.nextInt(normalBerths.size()));

                normalBerth.assignCarToBerth(car);
                car.assignedBerthSlot();

                // normalBerth.setNextBerthsAsBlocked();
            } else {
                if (!isFromTailback) {
                    carTailbackQueue.add(car);
                }
            }
        }
    }

    public static void stressTestNewPudo() {
        while ((carQueue.size() != 0) || (carTailbackQueue.size() != 0)) {
            Car car = null;

            maxTailbackQueueLength = Math.max(maxTailbackQueueLength, carTailbackQueue.size());

            if (carTailbackQueue.size() != 0) {
                car = carTailbackQueue.peek();

                settleTheCarForNewPudo(car, true);

                if (carQueue.size() != 0) {
                    carTailbackQueue.add(carQueue.poll());
                }
            } else if (carQueue.size() != 0) {
                car = carQueue.poll();
                settleTheCarForNewPudo(car, false);
            } else {
                System.out.println("HMM BOTH EMPTY");
            }

            newPudo.displayPudoInfo();
            newPudo.updateAllBerths();
            totalTime++;
        }

        while (!newPudo.isPudoEmpty()) {
            System.out.println("Car Queues Done");
            newPudo.displayPudoInfo();
            newPudo.updateAllBerths();
            totalTime++;
        }

        System.out.println("Total Time Taken: " + totalTime);
        System.out.println("Max Tailback Queue Length: " + maxTailbackQueueLength);
    }

    public static void stressTestOrignalPudo() {
        while ((carQueue.size() != 0) || (carTailbackQueue.size() != 0)) {
            Car car = null;

            maxTailbackQueueLength = Math.max(maxTailbackQueueLength, carTailbackQueue.size());

            if (carTailbackQueue.size() != 0) {
                car = carTailbackQueue.peek();

                settleTheCarForOrignalPudo(car, true);

                if (carQueue.size() != 0) {
                    carTailbackQueue.add(carQueue.poll());
                }
            } else if (carQueue.size() != 0) {
                car = carQueue.poll();
                settleTheCarForOrignalPudo(car, false);
            } else {
                System.out.println("HMM BOTH EMPTY");
            }

            originalPudo.displayPudoInfo();
            originalPudo.updateAllBerths();
            totalTime++;
        }

        while (!originalPudo.isPudoEmpty()) {
            System.out.println("Car Queue Done");
            originalPudo.displayPudoInfo();
            originalPudo.updateAllBerths();
            totalTime++;
        }

        System.out.println("Total Time Taken: " + totalTime);
        System.out.println("Max Tailback Queue Length: " + maxTailbackQueueLength);
    }

    public static void settleTheCarForOrignalPudo(Car car, Boolean isFromTailback) {
        if (car.isPwdAccessRequired()) {
            List<Berth> pwdBerthsAvailable = originalPudo.getPwdBerthsAvailable();

            if (!pwdBerthsAvailable.isEmpty()) {
                if (isFromTailback) {
                    car = carTailbackQueue.poll();
                }

                Berth pwdBerth = pwdBerthsAvailable.get(random.nextInt(pwdBerthsAvailable.size()));

                pwdBerth.assignCarToBerth(car);
                car.assignedBerthSlot();

                pwdBerth.setNextBerthsAsBlocked();
            } else {
                if (!isFromTailback) {
                    carTailbackQueue.add(car);
                }
            }
        } else if (car.isItATaxi()) {
            List<Berth> taxiBerthsAvailable = originalPudo.getTaxiBerthsAvailable();

            if (!taxiBerthsAvailable.isEmpty()) {
                if (isFromTailback) {
                    car = carTailbackQueue.poll();
                }

                Berth taxiBerth = taxiBerthsAvailable.get(random.nextInt(taxiBerthsAvailable.size()));

                taxiBerth.assignCarToBerth(car);
                car.assignedBerthSlot();

                taxiBerth.setNextBerthsAsBlocked();
            } else {
                if (!isFromTailback) {
                    carTailbackQueue.add(car);
                }
            }
        } else {
            List<Berth> normalBerths = originalPudo.getNormalBerthsAvailable();

            if (!normalBerths.isEmpty()) {
                if (isFromTailback) {
                    car = carTailbackQueue.poll();
                }

                Berth normalBerth = normalBerths.get(random.nextInt(normalBerths.size()));

                normalBerth.assignCarToBerth(car);
                car.assignedBerthSlot();

                normalBerth.setNextBerthsAsBlocked();
            } else {
                if (!isFromTailback) {
                    carTailbackQueue.add(car);
                }
            }
        }
    }

    public static void addAllCars() {
        // 5 Normal Cars + Taxi + PHVs
        carQueue.add(new Car(3.0f, false,false, true, 0));
        carQueue.add(new Car(2.0f, false,true, false, 0));
        carQueue.add(new Car(3.0f, false,false, true, 0));
        carQueue.add(new Car(1.0f, false,false, false, 0));
        carQueue.add(new Car(2.0f, false,true, false, 0));

        // 1 PWD
        carQueue.add(new Car(5.0f, true,false, false, 0));

        // 1 Carpark Car
        carQueue.add(new Car(0.0f, false,false, false, 0));

        // 5 Normal Cars + Taxi + PHVs
        carQueue.add(new Car(2.0f, false,true, false, 0));
        carQueue.add(new Car(3.0f, false,true, false, 0));
        carQueue.add(new Car(1.0f, false,false, true, 0));
        carQueue.add(new Car(4.0f, false,false, false, 0));
        carQueue.add(new Car(3.0f, false,false, false, 0));

        // 1 PWD
        carQueue.add(new Car(6.0f, true,false, false, 0));

        // 5 Normal Cars + Taxi + PHVs
        carQueue.add(new Car(3.0f, false,false, false, 0));
        carQueue.add(new Car(4.0f, false,false, true, 0));
        carQueue.add(new Car(1.0f, false,false, true, 0));
        carQueue.add(new Car(4.0f, false,false, false, 0));
        carQueue.add(new Car(2.0f, false,true, false, 0));

        // 1 PWD
        carQueue.add(new Car(5.0f, true,false, false, 0));

        // 1 Carpark Car
        carQueue.add(new Car(0.0f, false,false, false, 0));

        // 5 Normal Cars + Taxi + PHVs
        carQueue.add(new Car(4.0f, false,false, false, 0));
        carQueue.add(new Car(3.0f, false,false, false, 0));
        carQueue.add(new Car(2.0f, false,false, true, 0));
        carQueue.add(new Car(1.0f, false,true, false, 0));
        carQueue.add(new Car(3.0f, false,false, true, 0));

        // 1 PWD
        carQueue.add(new Car(6.0f, true,false, false, 0));

        // 5 Normal Cars + Taxi + PHVs + 1 Priority Kid
        carQueue.add(new Car(3.0f, false,true, false, 0));
        carQueue.add(new Car(2.0f, false,true, false, 0));
        carQueue.add(new Car(1.0f, false,false, true, 0));
        carQueue.add(new Car(4.0f, true,false, false, 0));
        carQueue.add(new Car(2.0f, false,false, false, 0));

        // 1 Carpark Car
        carQueue.add(new Car(0.0f, false,false, false, 0));

        // 1 PWD
        carQueue.add(new Car(7.0f, true,false, false, 0));

        // 5 Normal Cars + Taxi + PHVs
        carQueue.add(new Car(4.0f, false,true, false, 0));
        carQueue.add(new Car(4.0f, false,false, true, 0));
        carQueue.add(new Car(3.0f, false,false, false, 0));
        carQueue.add(new Car(3.0f, false,true, false, 0));
        carQueue.add(new Car(2.0f, false,false, true, 0));

        // 1 PWD
        carQueue.add(new Car(6.0f, true,false, false, 0));

        // 5 Normal Cars + Taxi + PHVs
        carQueue.add(new Car(3.0f, false,false, false, 0));
        carQueue.add(new Car(1.0f, false,false, false, 0));
        carQueue.add(new Car(1.0f, false,false, true, 0));
        carQueue.add(new Car(4.0f, false,true, false, 0));
        carQueue.add(new Car(2.0f, false,false, true, 0));

        // 1 PWD
        carQueue.add(new Car(5.0f, true,false, false, 0));

        // 1 Carpark Car
        carQueue.add(new Car(0.0f, false,false, false, 0));

        // 5 Normal Cars + Taxi + PHVs
        carQueue.add(new Car(4.0f, false,false, true, 0));
        carQueue.add(new Car(3.0f, false,false, true, 0));
        carQueue.add(new Car(1.0f, false,true, false, 0));
        carQueue.add(new Car(3.0f, false,false, false, 0));
        carQueue.add(new Car(2.0f, false,false, true, 0));

        // 1 PWD
        carQueue.add(new Car(5.0f, true,false, false, 0));

        // 5 Normal Cars + Taxi + PHVs + 1 Priority Kid
        carQueue.add(new Car(4.0f, false,false, false, 0));
        carQueue.add(new Car(2.0f, false,true, false, 0));
        carQueue.add(new Car(1.0f, false,false, true, 0));
        carQueue.add(new Car(3.0f, false,false, false, 0));
        carQueue.add(new Car(4.0f, true,false, false, 0));

        // 1 PWD
        carQueue.add(new Car(6.0f, true,false, false, 0));

        // 1 Carpark Car
        carQueue.add(new Car(0.0f, false,false, false, 0));

        // 5 Normal Cars + Taxi + PHVs
        carQueue.add(new Car(1.0f, false,false, true, 0));
        carQueue.add(new Car(3.0f, false,true, false, 0));
        carQueue.add(new Car(2.0f, false,false, false, 0));
        carQueue.add(new Car(2.0f, false,false, false, 0));
        carQueue.add(new Car(1.0f, false,true, false, 0));

        // 1 PWD
        carQueue.add(new Car(5.0f, true,false, false, 0));

        // 5 Normal Cars + Taxi + PHVs + 1 Priority Kid
        carQueue.add(new Car(2.0f, false,true, false, 0));
        carQueue.add(new Car(2.0f, false,true, false, 0));
        carQueue.add(new Car(3.0f, false,false, true, 0));
        carQueue.add(new Car(1.0f, false,false, false, 0));
        carQueue.add(new Car(5.0f, true,false, false, 0));

        // 1 PWD
        carQueue.add(new Car(6.0f, true,false, false, 0));

        // 5 Normal Cars + Taxi + PHVs
        carQueue.add(new Car(2.0f, false,true, false, 0));
        carQueue.add(new Car(1.0f, false,false, false, 0));
        carQueue.add(new Car(2.0f, false,true, false, 0));
        carQueue.add(new Car(3.0f, false,true, false, 0));
        carQueue.add(new Car(1.0f, false,false, true, 0));

        // 1 PWD
        carQueue.add(new Car(6.0f, true,false, false, 0));

        // 5 Normal Cars + Taxi + PHVs
        carQueue.add(new Car(1.0f, false,false, false, 0));
        carQueue.add(new Car(4.0f, false,true, false, 0));
        carQueue.add(new Car(3.0f, false,false, true, 0));
        carQueue.add(new Car(1.0f, false,false, false, 0));
        carQueue.add(new Car(1.0f, false,false, false, 0));

        // 1 PWD
        carQueue.add(new Car(4.0f, true,false, false, 0));

        // 5 Normal Cars + Taxi + PHVs + 1 Priority Kid
        carQueue.add(new Car(1.0f, false,false, false, 0));
        carQueue.add(new Car(4.0f, false,false, false, 0));
        carQueue.add(new Car(5.0f, true,false, false, 0));
        carQueue.add(new Car(3.0f, false,true, false, 0));
        carQueue.add(new Car(1.0f, false,true, false, 0));

        // 1 PWD
        carQueue.add(new Car(6.0f, true,false, false, 0));

        // 5 Normal Cars + Taxi + PHVs
        carQueue.add(new Car(2.0f, false,true, false, 0));
        carQueue.add(new Car(3.0f, false,false, true, 0));
        carQueue.add(new Car(3.0f, false,false, true, 0));
        carQueue.add(new Car(2.0f, false,false, false, 0));
        carQueue.add(new Car(1.0f, false,true, false, 0));

        // 1 PWD
        carQueue.add(new Car(5.0f, true,false, false, 0));

        // 5 Normal Cars + Taxi + PHVs
        carQueue.add(new Car(1.0f, false,false, false, 0));
        carQueue.add(new Car(4.0f, false,true, false, 0));
        carQueue.add(new Car(2.0f, false,false, false, 0));
        carQueue.add(new Car(2.0f, false,false, false, 0));
        carQueue.add(new Car(3.0f, false,false, true, 0));
    }
}
