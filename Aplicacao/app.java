package Aplicacao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import enums.WorkerLevel;

public class app {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        
        System.out.print("Enter department's name: ");
        String depatamentoname = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter worker data:");
        System.out.print("name: ");
        String workername = sc.nextLine();
        System.out.print("level: ");
        String workerlevel = sc.nextLine();
        System.out.print("base salary: ");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(workername, WorkerLevel.valueOf(workerlevel), baseSalary, new Departament(depatamentoname));
        System.out.println();
        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println();
            System.out.println("Enter contract #" + i + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contracDate = sdf.parse(sc.next());
            System.out.print("value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int durationHours = sc.nextInt();

            HourContract contract = new HourContract(contracDate, valuePerHour, durationHours);

            worker.addContract(contract);
        }
        System.out.println();

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String mouthforYear = sc.next();

        int month = Integer.parseInt(mouthforYear.substring(0, 2));
        int year = Integer.parseInt(mouthforYear.substring(3));

        System.out.println("name: " + worker.getName());
        System.out.println("departament: " + worker.getDepartment().getName());

        System.out.println("income for " + mouthforYear + ": " + String.format("%.2f", worker.income(year, month)));


        sc.close();
    }  
}
