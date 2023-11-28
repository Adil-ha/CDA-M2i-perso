package org.example.exoBiblio;

public class DigitalBook extends Book {
    private String format;
    private int byteSize;

    public DigitalBook(String title, String author, String format, int byteSize) {
        super(title, author);
        this.format = format;
        this.byteSize = byteSize;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getByteSize() {
        return byteSize;
    }

    public void setByteSize(int byteSize) {
        this.byteSize = byteSize;
    }

    @Override
    public String toString() {
        return "DigitalBook{" +
                "format='" + format + '\'' +
                ", byteSize=" + byteSize +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}