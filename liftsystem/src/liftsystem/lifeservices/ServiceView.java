package liftsystem.lifeservices;

import java.util.Arrays;
import java.util.Scanner;


public class ServiceView {
    static Scanner sc=new Scanner(System.in); 
    
	private ServiceModel serviceModel;

	public ServiceView() {
		serviceModel = new ServiceModel(this);
	}
    
	public void serviceInit(int[] lifts, int[] capacityofthelift, int cap) {
		System.out.println("\n -------------lift Services-------------- \n\n 1.Enter lifts Current position \n 2.Display lifts positions \n 3.Assigning lift to User \n 4.Exit");
		System.out.println("\nEnter your choice");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			serviceModel.enterLiftPositions(lifts);
			serviceInit(lifts,capacityofthelift,cap);
			break;
		case 2:
			serviceModel.displayLifts(lifts);
			serviceInit(lifts,capacityofthelift,cap);
			break;
		case 3:
			serviceModel.assignLift(lifts,capacityofthelift,cap);
			serviceInit(lifts,capacityofthelift,cap);
			break;
		case 4:
			System.out.println("-------------Thank your for using Lift Service-------------");
			break;
		default:
			System.out.println("Invalid input");
			serviceInit(lifts,capacityofthelift,cap);
		}
	}
	public static void printLifts(int lifts[]) {
		System.out.println("Position of the lifts");
		System.out.println(Arrays.toString(lifts));
	}
	
}
