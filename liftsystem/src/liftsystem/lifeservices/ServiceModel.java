package liftsystem.lifeservices;

import java.util.Arrays;
import java.util.Scanner;

public class ServiceModel {
	static Scanner sc=new Scanner(System.in);
	private ServiceView serviceView;
	public ServiceModel(ServiceView serviceView) {
		this.serviceView = serviceView;
	}
    
	public static void enterLiftPositions(int lifts[]) {
		System.out.println("Enter "+lifts.length+" initial lift positions :");
		for (int i = 0; i < lifts.length; i++) {
			lifts[i] = sc.nextInt();
		}
	}

	public static void assignLift(int lifts[],int capacityofthelift[],int cap) {
		int count=0;
		for(int i=0;i<lifts.length;i++) {
			if(lifts[i]==-1) {
				count++;
			}
		}
		if(count==lifts.length) {
			System.out.println("\n Sorry,Lifts are Out of Service");
		}
		else {
		System.out.println("\nAssign Lift to the User :");
		System.out.println("\nEnter the Current floor No (0-10) : ");
		int curfloor=sc.nextInt();
		System.out.println("Enter the Destination Floor No (0-10) : ");
		int desfloor=sc.nextInt();
		int i=0;
		int floorlimit=5;
        if(curfloor!=0&&curfloor<5&&desfloor>=6) {
		   lifts[lifts.length-1]=desfloor;	
		   addLiftCapacity(lifts.length-1,capacityofthelift);
		}
        else {
        if(curfloor==0&&desfloor>0||curfloor>=6) {
        	i=2;
        }
		if(curfloor>=6&&desfloor==0) {
			i=2;
			floorlimit=4;
		}
		int mindis=Integer.MAX_VALUE;
		int minpath=0,index=0;
		for(;i<floorlimit;i++) {
			minpath=Math.abs(curfloor-lifts[i]);
			if(mindis>minpath) {
	       		mindis=Math.min(minpath, mindis);
	       		if(capacityofthelift[i]<=5) {
	       		if(lifts[i]!=-1) {
   			      index=i;
	       		}
	       		}
	       		else {
	       			System.out.println("Lift reaches its Capacity");
	       		}
			}
		}
		lifts[index]=desfloor;
		addLiftCapacity(index,capacityofthelift);
		System.out.println(Arrays.toString(lifts));
		}
		}
	}

	private static void addLiftCapacity(int index,int capacityofthelift[]) {
		capacityofthelift[index]+=1;
	}

	public void displayLifts(int[] lifts) {
		serviceView.printLifts(lifts);
	}

}
