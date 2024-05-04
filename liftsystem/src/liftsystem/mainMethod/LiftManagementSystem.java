package liftsystem.mainMethod;

import java.util.Arrays;
import java.util.Scanner;

import liftsystem.liftservices.ServiceView;

public class LiftManagementSystem {
	
	static Scanner sc = new Scanner(System.in);
	
	private static LiftManagementSystem liftManagementSystem;

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
				+ " ---------------- \n");
		System.out.println("Enter the Number of lifts");
		int len = sc.nextInt();
		int lifts[] = new int[len];
		System.out.println("Enter the Capacity of the lift");
		int cap=sc.nextInt();
		int capacityofthelift[]= new int[len];
		serviceView.serviceInit(lifts,capacityofthelift,cap);
	}

	public String getAppName() {
		return appName;
	}
	
	public static void main(String arg[]) {
		LiftManagementSystem.getInstance().create();
	}

}
