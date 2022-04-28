package Main;

import java.util.Scanner;

public class Booking {
    private String bookingId;
    private  String lessonName;
    private String lessonDate;
    private String bookingStatus;
    private String review;
    private int rating;
    private  int price;
    // private int capacity;


    public String getBookingId() {
        return bookingId;
    }

    public String getLessonName() {
        return lessonName;
    }

    public String getLessonDate() {
        return lessonDate;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public void setLessonDate(String lessonDate) {
        this.lessonDate = lessonDate;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    Booking(String id, String lessonName, String date, String status, String review,int rating,int price){
        this.bookingId = id;
        this.lessonName = lessonName;
        this.lessonDate = date;
        this.bookingStatus = status;
        this.review = review;
        this.rating = rating;
        this.price = price;
//        this.capacity = cap;
    }


    Scanner scanner = new Scanner(System.in);

    public void bookingDetails(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%-20s%-20s%-20s%-20s\n",bookingId,lessonName,lessonDate,bookingStatus);
    }

    public void attendLesson(String id){
        if(bookingId.equals(id)){
            bookingStatus = "attended";
            System.out.println("Booking ID:" + bookingId +"   Booking Status:" + bookingStatus);
        }
    }
}
