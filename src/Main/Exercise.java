package Main;

import java.util.concurrent.ThreadLocalRandom;

import static Main.Main.bookings;


public class Exercise {
    private String lessonName;
    private int capacity;
    private String session;
    private String date;
    private int price;


    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    Exercise(String lessname, String sess, String day, int cap, int rate){
        this.lessonName = lessname;
        this.session = sess;
        this.date = day;
        this.capacity = cap;
        this.price = rate;
    }



    public void classTimetable(){
        System.out.println("------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-20s%-20s%-20d%-20d\n",lessonName,session,date,capacity,price);
    }

    public void classDetails(){
        if(capacity > 0){
            System.out.println("------------------------------------------------------------------------------------");
            System.out.printf("%-20s%-20s%-20s%-20d%-20d\n",lessonName,session,date,capacity,price);        }
    }

    public void displayDetailsByDate(String inputDate){
        if(date.equals(inputDate)) {
            System.out.println("------------------------------------------------------------------------------------");
            System.out.printf("%-20s%-20s%-20s%-20d%-20d\n",lessonName,session,date,capacity,price);        }
    }
    public void displayDetailsByClassName(String className){
        if(lessonName.equals(className)){
            System.out.println("------------------------------------------------------------------------------------");
            System.out.printf("%-20s%-20s%-20s%-20d%-20d\n",lessonName,session,date,capacity,price);        }
    }

    public void classBooking(String userLesson, String userDate, String userBookingId){
        if(userBookingId == null){
            if(lessonName.equals(userLesson) && date.equals(userDate) && capacity > 0){
                int rand = ThreadLocalRandom.current().nextInt(55555,99999);
                String bookingId = "hert" + rand;
                String bookingStatus = "booked";
                this.capacity--;

                bookings.add(new Booking(bookingId,lessonName,date,bookingStatus,null,0,price));

                System.out.println("Booking Success with Booking ID:" + bookingId);

            }
            else if(capacity == 0){
                System.out.println("Session is full, please select another date or class");
            }
        }
        else if(userBookingId!=null){
            if(lessonName.equals(userLesson) && date.equals(userDate) && capacity > 0){
                this.capacity--;
                System.out.println("Booking changed for Booking ID:" + userBookingId);
            }
            else if(lessonName.equals(userLesson) && date.equals(userDate) && capacity == 0){
                System.out.println("Session is full, please select another date or class");
            }
        }

    }
}
