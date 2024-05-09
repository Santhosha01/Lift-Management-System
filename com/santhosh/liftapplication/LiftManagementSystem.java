package liftsystem.mainMethod;

import java.util.Scanner;

import liftsystem.liftservices.ServiceView;

public class LiftManagementSystem {

    static Scanner sc = new Scanner(System.in);

    private static LiftManagementSystem liftManagementSystem;
    private String appVersion = "0.0.1";
    private String appName = "Lift Management System";

    public static LiftManagementSystem getInstance() {
        if (liftManagementSystem == null) {
            liftManagementSystem = new LiftManagementSystem();
        }
        return liftManagementSystem;
    }

    private void create() {
        ServiceView serviceView = new ServiceView();
        System.out.println("--------------" + LiftManagementSystem.getInstance().getAppName()
                + " ---------------- \n\t\t  version " + "("
                + LiftManagementSystem.getInstance().getAppVersion() + ")");
        System.out.println("\nEnter the Number of lifts");
        int len = sc.nextInt();
        int[] lifts = new int[len];
        System.out.println("Enter the Capacity of the lift");
        int cap = sc.nextInt();
        int[] capacityofthelift = new int[len];
        serviceView.serviceInit(lifts, capacityofthelift, cap);
    }

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public static void main(String[] arg) {
        LiftManagementSystem.getInstance().create();
    }

}
