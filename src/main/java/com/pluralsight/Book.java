package com.pluralsight;

public class Book {
    private final int id;
    private final String isbn;
    private final String title;
    private boolean isCheckedOut;
    public String checkedOutTo;


    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = null;
    }


    public int getId() { return id; }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public boolean isCheckedOut() { return isCheckedOut; }
    public String getCheckedOutTo() { return checkedOutTo; }

    public void setCheckedOut(boolean isCheckedOut) { this.isCheckedOut = isCheckedOut; }
    public void setCheckedOutTo(String checkedOutTo) { this.checkedOutTo = checkedOutTo; }

    public void checkOut(String name) {
        if (!isCheckedOut) {
            isCheckedOut = true;
            checkedOutTo = name;
            System.out.println(title + " has been checked out ");
        } else {
            System.out.println(title + " is already checked out.");
        }
    }


    public void checkIn() {
        if (isCheckedOut) {
            isCheckedOut = false;
            checkedOutTo = null;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " has not been checked out.");
        }
    }
}

