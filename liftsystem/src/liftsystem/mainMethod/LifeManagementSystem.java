package liftsystem.mainMethod;

import java.util.Arrays;
import java.util.Scanner;

import liftsystem.lifeservices.ServiceView;

public class LifeManagementSystem {
	
	static Scanner sc = new Scanner(System.in);
	
	private static LifeManagementSystem lifeManagementSystem;

	private String appName = "Life Management System";

	public static LifeManagementSystem getInstance() {
		if (lifeManagementSystem == null) {
			lifeManagementSystem = new LifeManagementSystem();
		}
		return lifeManagementSystem;
	}

	private void create() {
		ServiceView serviceView = new ServiceView();
		System.out.println("--------------" + LifeManagementSystem.getInstance().getAppName()
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
		LifeManagementSystem.getInstance().create();
	}

}
