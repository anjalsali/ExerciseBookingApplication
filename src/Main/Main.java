package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Booking> bookings = new ArrayList<>();
    static  ArrayList<Exercise> exercises = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    static void changeBooking(String userBookingId){

        for(Booking b:bookings){
            if(b.getBookingId().equals(userBookingId)){
                System.out.println("Booking Details Found\n");
                System.out.println("Booking ID:" + b.getBookingId() + "\nLesson Name:" + b.getLessonName()
                        + "\nDate:" + b.getLessonDate() + "\nBooking Status:" + b.getBookingStatus());
                System.out.println("Are you sure you want to Change the booking (y/n):");
                String confirmation = scanner.next();
                if(confirmation.equals("y")){
                    System.out.println("Available Classes are:\n");
                    for (Exercise e : exercises){
                        e.classDetails();
                    }
                    System.out.println("Enter a date from above in dd-mm-yyyy");
                    String changeDate = scanner.next();
                    System.out.println("Enter the class Name");
                    String changeClass = scanner.next();
                    for (Exercise e : exercises){
                        e.classBooking(changeClass,changeDate,userBookingId);
                    }

                    for (Exercise e : exercises) {
                        if (e.getLessonName().equals(b.getLessonName()) && e.getDate().equals(b.getLessonDate())) {
                            int cap = e.getCapacity();
                            cap++;
                            e.setCapacity(cap);
                        }
                    }
                    b.setLessonName(changeClass);
                    b.setLessonDate(changeDate);
                }

            }
        }
    }

    static void cancelBooking(String userBookingId){

        Booking bookObj = null;
        for(Booking b:bookings){
            if(b.getBookingId().equals(userBookingId)){
                bookObj = b;
                System.out.println("Booking Details Found\n");
                System.out.println("Booking ID:" + b.getBookingId() + "\nLesson Name:" + b.getLessonName()
                        + "\nDate:" + b.getLessonDate() + "\nBooking Status:" + b.getBookingStatus());
                System.out.println("Are you sure you want to cancel the booking (y/n):");
                String confirmation = scanner.next();
                if (confirmation.equals("y")) {
                    for (Exercise e : exercises){
                        if(e.getLessonName().equals(b.getLessonName()) && e.getDate().equals(b.getLessonDate())){
                            int cap = e.getCapacity();
                            cap++;
                            e.setCapacity(cap);
                        }
                    }
                    System.out.println("Booking Cancelled :" + userBookingId);
                }
            }
        }
        bookings.remove(bookObj);

    }

    static void attendClass(String userBookingId){
        for(Booking b:bookings){
            if(b.getBookingId().equals(userBookingId) && b.getBookingStatus().equals("booked")){
                System.out.println("Booking Details Found\n");
                System.out.println("Booking ID:" + b.getBookingId() + "\nLesson Name:" + b.getLessonName()
                        + "\nDate:" + b.getLessonDate() + "\nBooking Status:" + b.getBookingStatus());
                System.out.println("Are you sure you want to attend the Class (y/n):");
                String confirmation = scanner.next();
                if (confirmation.equals("y")) {
                    b.attendLesson(userBookingId);
                    System.out.println("Class Attended\n");
                    System.out.println("Please write a review for the class\n");
                    String userReview = scanner.next();
                    b.setReview(userReview);
                    System.out.println("Please give a rating for the Class [1-5] \n");
                    int userRating= scanner.nextInt();
                    b.setRating(userRating);
                }
            }
            else if (b.getBookingId().equals(userBookingId) && b.getBookingStatus().equals("attended")){
                System.out.println("Class for Booking Id " +userBookingId+ " Already Attended");
                break;
            }
        }
    }

    static void monthlyReport(String userDate ){
        float zrating,yrating,arating,srating,frating,crating;
        zrating=yrating=arating=srating=frating=crating=0;
        int znoOfBookings,ynoOfBookings,cnoOfBookings,fnoOfBookings,snoOfBookings,anoOfBookings;
        znoOfBookings=ynoOfBookings=cnoOfBookings=anoOfBookings=snoOfBookings=fnoOfBookings=0;
        int zincome,yincome,cincome,aincome,fincome,sincome;
        zincome=yincome=cincome=aincome=fincome=sincome=0;
        for(Booking b:bookings){

            if(b.getLessonDate().substring(3,5).equals(userDate)){
                if(b.getLessonName().equals("zumba")){
                    znoOfBookings += 1;
                    zrating+=b.getRating();
                    zincome=b.getPrice();
                }
                else if(b.getLessonName().equals("swimming")){
                    snoOfBookings =+1;
                    srating+=b.getRating();
                    sincome=b.getPrice();
                }
                else if(b.getLessonName().equals("cricket")){
                    cnoOfBookings +=1;
                    crating+=b.getRating();
                    cincome=b.getPrice();
                }
                else if(b.getLessonName().equals("football")){
                    fnoOfBookings +=1;
                    frating+=b.getRating();
                    fincome=b.getPrice();
                }
                else if(b.getLessonName().equals("aquacise")){
                    anoOfBookings +=1;
                    arating+=b.getRating();
                    aincome=b.getPrice();
                }
                else if(b.getLessonName().equals("yoga")){
                    ynoOfBookings +=1;
                    yrating+=b.getRating();
                    yincome=b.getPrice();
                }
            }
        }
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-20s%-20s%-20s%-20s\n","Class Name","Total Bookings","Average Rating","Total Income");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-20s%-20d%-20.2f%-20d\n","Zumba",znoOfBookings,zrating/znoOfBookings,zincome);
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-20s%-20d%-20.2f%-20d\n","Swimming",snoOfBookings,srating/snoOfBookings,sincome);
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-20s%-20d%-20.2f%-20d\n","Cricket",cnoOfBookings,crating/cnoOfBookings,cincome);
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-20s%-20d%-20.2f%-20d\n","Aquacise",anoOfBookings,arating/anoOfBookings,aincome);
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-20s%-20d%-20.2f%-20d\n","Yoga",ynoOfBookings,yrating/ynoOfBookings,yincome);
        System.out.println("------------------------------------------------------------------------");
    }


    public static void main(String[] args) {

        exercises.add(new Exercise("yoga","Morning","01-01-2022",4,5));
        exercises.add(new Exercise("swimming","Afternoon","01-01-2022",4,2));
        exercises.add(new Exercise("football","Evening","01-01-2022",4,6));
        exercises.add(new Exercise("cricket","Morning","02-01-2022",3,8));
        exercises.add(new Exercise("zumba","afternoon","02-01-2022",3,10));
        exercises.add(new Exercise("aquacise","Evening","02-01-2022",4,6));
        exercises.add(new Exercise("yoga","Morning","08-01-2022",4,5));
        exercises.add(new Exercise("swimming","Afternoon","08-01-2022",4,2));
        exercises.add(new Exercise("football","Evening","08-01-2022",3,6));
        exercises.add(new Exercise("cricket","Morning","09-01-2022",4,8));
        exercises.add(new Exercise("zumba","afternoon","09-01-2022",3,10));
        exercises.add(new Exercise("aquacise","Evening","09-01-2022",3,6));
        exercises.add(new Exercise("yoga","Morning","15-01-2022",4,5));
        exercises.add(new Exercise("swimming","Afternoon","15-01-2022",3,2));
        exercises.add(new Exercise("football","Evening","15-01-2022",4,6));
        exercises.add(new Exercise("cricket","Morning","16-01-2022",4,8));
        exercises.add(new Exercise("zumba","afternoon","16-01-2022",4,10));
        exercises.add(new Exercise("aquacise","Evening","16-01-2022",4,6));
        exercises.add(new Exercise("yoga","Morning","22-01-2022",4,5));
        exercises.add(new Exercise("swimming","Afternoon","22-01-2022",4,2));
        exercises.add(new Exercise("football","Evening","22-01-2022",4,6));
        exercises.add(new Exercise("cricket","Morning","23-01-2022",4,8));
        exercises.add(new Exercise("zumba","afternoon","23-01-2022",4,10));
        exercises.add(new Exercise("aquacise","Evening","23-01-2022",4,6));
        exercises.add(new Exercise("yoga","Morning","29-01-2022",4,5));
        exercises.add(new Exercise("swimming","Afternoon","29-01-2022",4,2));
        exercises.add(new Exercise("football","Evening","29-01-2022",4,6));
        exercises.add(new Exercise("cricket","Morning","30-01-2022",4,8));
        exercises.add(new Exercise("zumba","afternoon","30-01-2022",4,10));
        exercises.add(new Exercise("aquacise","Evening","30-01-2022",4,6));
        exercises.add(new Exercise("yoga","Morning","05-02-2022",3,5));
        exercises.add(new Exercise("swimming","Afternoon","05-02-2022",4,2));
        exercises.add(new Exercise("football","Evening","05-02-2022",4,6));
        exercises.add(new Exercise("cricket","Morning","06-02-2022",3,8));
        exercises.add(new Exercise("zumba","afternoon","06-02-2022",4,10));
        exercises.add(new Exercise("aquacise","Evening","06-02-2022",4,6));
        exercises.add(new Exercise("yoga","Morning","12-02-2022",4,5));
        exercises.add(new Exercise("swimming","Afternoon","12-02-2022",4,2));
        exercises.add(new Exercise("football","Evening","12-02-2022",4,6));
        exercises.add(new Exercise("cricket","Morning","13-02-2022",4,8));
        exercises.add(new Exercise("zumba","afternoon","13-02-2022",3,10));
        exercises.add(new Exercise("aquacise","Evening","13-02-2022",3,6));
        exercises.add(new Exercise("yoga","Morning","19-02-2022",4,5));
        exercises.add(new Exercise("swimming","Afternoon","19-02-2022",4,2));
        exercises.add(new Exercise("football","Evening","19-02-2022",4,6));
        exercises.add(new Exercise("cricket","Morning","19-02-2022",4,8));
        exercises.add(new Exercise("zumba","afternoon","19-02-2022",4,10));
        exercises.add(new Exercise("aquacise","Evening","19-02-2022",4,6));

        bookings.add(new Booking("herts69104","zumba","02-01-2022","attended","Very Satisfied",5,10));
        bookings.add(new Booking("herts69105","cricket","02-01-2022","attended","Satisfied",4,8));
        bookings.add(new Booking("herts69106","football","08-01-2022","attended","Very Satisfied",5,6));
        bookings.add(new Booking("herts69107","aquacise","09-01-2022","attended","Ok",3,6));
        bookings.add(new Booking("herts69108","zumba","09-01-2022","attended","Very Satisfied",5,10));
        bookings.add(new Booking("herts69109","swimming","15-01-2022","attended","Dissatisfied",2,2));
        bookings.add(new Booking("herts69110","yoga","05-02-2022","attended","Very Satisfied",5,5));
        bookings.add(new Booking("herts69112","cricket","06-02-2022","attended","Satisfied",4,8));
        bookings.add(new Booking("herts69113","zumba","13-02-2022","attended","Very Satisfied",5,10));
        bookings.add(new Booking("herts69114","aquacise","13-02-2022","attended","Ok",3,6));

        int userOption;
        int userInput;


        while(true){
            System.out.println("---------------------------------------------" +
                    "\n.....Welcome to USC Exercise Booking App....." +
                    "\n---------------------------------------------" +
                    "\nSelect an Option:"+
                    "\n[1] Display Timetable\n[2] Make a Booking" +
                    "\n[3] Change or Cancel Booking"+
                    "\n[4] View all Bookings"+
                    "\n[5] Attend a Lesson \n[6] Monthly report \n[7] Exit");

            userOption = scanner.nextInt();
            switch (userOption){
                case 1:{
                    System.out.println("-----------------------------------TIME TABLE---------------------------------------\n");
                    System.out.printf("%-20s%-20s%-20s%-20s%-20s\n","Lesson Name","Session","Date","Slots","Fees");
                    for(Exercise e:exercises){
                        e.classTimetable();
                    }
                }
                    break;
                case 2:{
                    System.out.println("Select a Booking Option");
                    System.out.println("[1] View classes by Date \n[2] View classes by Name");
                    userInput = scanner.nextInt();
                    if(userInput == 1) {
                        System.out.println("Book By Date" +
                                "\nClasses are scheduled on " +
                                "\n January: " +
                                "\n01-01-2022 \n02-01-2022"+
                                "\n08-01-2022 \n09-01-2022"+
                                "\n15-01-2022 \n16-01-2022"+
                                "\n22-01-2022 \n23-01-2022"+
                                "\n29-01-2022 \n30-01-2022"+
                                "\nFebruary: "+
                                "\n05-02-2022 \n06-01-2022"+
                                "\n12-02-2022 \n13-01-2022"+
                                "\n19-02-2022 \n20-01-2022");
                        String userInputDate;
                        System.out.println("Enter a date from above in dd-mm-yyyy format");
                        userInputDate = scanner.next();
                        for(Exercise e:exercises) {
                            e.displayDetailsByDate(userInputDate);
                        }
                        System.out.println("Please choose a lesson");
                        String userConfirmedLesson = scanner.next();

                        for(Exercise booking:exercises) {
                            booking.classBooking(userConfirmedLesson, userInputDate, null);
                        }
                    }
                    else if(userInput == 2) {
                        System.out.println("Book By Lesson Name");
                        String userInputLesson;
                        System.out.println("Enter a Lesson Name");
                        userInputLesson = scanner.next();
                        for (Exercise e : exercises) {
                            e.displayDetailsByClassName(userInputLesson);
                        }
                        System.out.println("Enter a date in dd-mm-yyyy format");
                        String userConfirmedDate = scanner.next();

                        for(Exercise booking:exercises) {
                            booking.classBooking(userInputLesson, userConfirmedDate,null);
                        }
                    }
                    else
                        System.out.println("Invalid Choice");

                }
                break;
                case 3:{
                    System.out.println("[1] Change Booking\n[2] Cancel Booking");
                    System.out.println("Please Enter Your option: ");
                    int choice = scanner.nextInt();
                    if(choice == 1){
                        System.out.println("Please Enter your Booking ID: ");
                        String userBookingId = scanner.next();
                        changeBooking(userBookingId);
                    }
                    else if(choice ==2) {
                        System.out.println("Please Enter your Booking ID: ");
                        String userBookingId = scanner.next();
                        cancelBooking(userBookingId);
                    }
                    else
                        System.out.println("Invalid Choice");
                }
                break;
                case 4:{
                    System.out.printf("%-20s%-20s%-20s%-20s\n","Booking ID","Lesson Name","Date","Booking Status");
                    for(Booking b:bookings){
                        b.bookingDetails();
                    }
                }
                break;
                case 5:{
                    System.out.println("Please Enter your Booking ID: ");
                    String userBookingId = scanner.next();
                    attendClass(userBookingId);
                }
                break;
                case 6:{
                    System.out.println("Welcome to Monthly Report");
                    System.out.println("Enter a month number for report [01 - 02]");
                    String userDate = scanner.next();
                    monthlyReport(userDate);

                }
                break;
                case 7:{
                    System.out.println("Thank You........");
                    System.exit(0);
                }
                break;
                default:
                    System.out.println("Invalid Option, Try again....");
                    break;
            }
        }
    }
}
