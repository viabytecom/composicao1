package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entiites.Departament;
import Entiites.HourContract;
import Entiites.Worker;
import Entiites_enum.WorkLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		
		System.out.print("Enter Departament's Name: ");
		String departamentName = sc.nextLine();
		System.out.println("Enter Work data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level:");
		String workerLevel = sc.nextLine();
		System.out.print("Based Salary");
		double basedSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName,WorkLevel.valueOf(workerLevel), basedSalary, new Departament(departamentName));	
		
		System.out.print("How Many contracts to This Worker?");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.println("Enter contract #" + i + "data:");
			System.out.print("Date: (DD/MM/YYYY): " );
			Date ContractDate = sdf.parse(sc.next());
			System.out.print("Value per Hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration( Hours):");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(ContractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
			System.out.println();
			System.out.print("Enter Month and Year to calculate income (MM/YYYY: ");
			String monthAndYear = sc.next();
			int month = Integer.parseInt(monthAndYear.substring(0,2));
			int year = Integer.parseInt(monthAndYear.substring(3));
			System.out.println("Name: "+ worker.getName() );
			System.out.println("Departament: "+ worker.getDepartment().getName());
			System.out.println("income for: "+ monthAndYear +" : "  +String.format("%.2f", worker.income(year, month)));
			
		
		
		sc.close();
	}

}
