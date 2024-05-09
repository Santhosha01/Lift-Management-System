package liftsystem.com.santhosh.liftapplication.liftservices;

import java.util.Scanner;

public class ServiceModel {
    static Scanner sc = new Scanner(System.in);
    private ServiceView serviceView;

    public ServiceModel(ServiceView serviceView) {
        this.serviceView = serviceView;
    }


    public void enterLiftPositions(int lifts[]) {
        System.out.println("Enter " + lifts.length + " initial lift positions :");
        for (int i = 0; i < lifts.length; i++) {
            lifts[i] = sc.nextInt();
        }
    }

    public void assignLift(int lifts[], int capacityofthelift[], int cap) {
        int count = 0;
        for (int i = 0; i < lifts.length; i++) {
            if (lifts[i] == -1) {
                count++;
            }
        }
        if (count == lifts.length) {
            System.out.println("\n Sorry,Lifts are Out of Service");
        } else {
            System.out.println("\nAssign Lift to the User :");
            System.out.println("\nEnter User Current floor No (0-10) : ");
            int curfloor = sc.nextInt();
            System.out.println("Enter User Destination Floor No (0-10) : ");
            int desfloor = sc.nextInt();
            int i = 0;
            if ((curfloor < 5 && desfloor >= 6) || (curfloor > 5 && desfloor < 6)) {
                lifts[lifts.length - 1] = desfloor;
                addLiftCapacity(lifts.length - 1, capacityofthelift);
            } else {
                if ((curfloor == 0 || desfloor == 0) || (curfloor >= 6 && desfloor <= 10)) {
                    i = 2;
                }
                int mindis = Integer.MAX_VALUE;
                int minpath = 0, index = 0;
                for (; i < lifts.length; i++) {
                    minpath = Math.abs(curfloor - lifts[i]);
                    if (mindis > minpath) {
                        mindis = Math.min(minpath, mindis);
                        if (capacityofthelift[i] <= 5 && lifts[i] != -1) {
                            index = i;
                        } else {
                            System.out.println("Lift reaches its Capacity");
                        }
                    }
                }
                lifts[index] = desfloor;
                addLiftCapacity(index, capacityofthelift);
            }
        }
    }

    private void addLiftCapacity(int index, int capacityofthelift[]) {
        capacityofthelift[index] += 1;
    }

    public void displayLifts(int[] lifts) {
        serviceView.printLifts(lifts);
    }

}
