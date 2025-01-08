package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room Number: ");
            int roomNumber = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkinDate = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkoutDate = sdf.parse(sc.next());

            Reservation reservation = new Reservation(checkinDate, checkoutDate, roomNumber);
            System.out.println("Reservation: " + reservation);
            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkinDate = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkoutDate = sdf.parse(sc.next());

            reservation.updateDates(checkinDate, checkoutDate);
            System.out.println("Reservation: " + reservation);
        }
        catch(ParseException e){
            System.out.println("Invalid date format");
        }
        catch(DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        }
        sc.close();
    }
}