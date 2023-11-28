package org.example.exoBiblio;

import java.time.LocalDate;


public class Loan {

    private static int cpt = 1 ;
    private int id;
    private Book book;
    private Person person;
    private LocalDate startDate;
    private LocalDate endDate;

    public Loan(Book book, Person person, LocalDate endDate) {
        this.id = cpt++;
        this.book = book;
        this.person = person;
        this.startDate = LocalDate.now();
        this.endDate = endDate;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Loan [book=" + book + ", person=" + person + ", startDate=" + startDate + ", endDate=" + endDate + "]";
    }
}