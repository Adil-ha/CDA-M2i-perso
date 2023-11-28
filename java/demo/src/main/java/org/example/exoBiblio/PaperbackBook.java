package org.example.exoBiblio;

public class PaperbackBook extends Book {
    private int numberOfPages;
    private String publishingHouse;

    public PaperbackBook(String title, String author, int numberOfPages, String publishingHouse) {
        super(title, author);
        this.numberOfPages = numberOfPages;
        this.publishingHouse = publishingHouse;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    @Override
    public String toString() {
        return "PaperbackBook{" +
                "numberOfPages=" + numberOfPages +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

