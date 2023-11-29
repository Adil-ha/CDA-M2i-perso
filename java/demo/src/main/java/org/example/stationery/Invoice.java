package org.example.stationery;

import java.time.LocalDate;
import java.util.Arrays;

public class Invoice {

    private static int cpt;

    private int numInvoice;

    private int nbLines;

    private String client;

    private String date;

    private Line[] lines;

    public Invoice(String client, String date) {
        this.numInvoice = cpt++;
        this.client = client;
        this.date = date;
        this.lines = new Line[10];
        this.nbLines = 0;
    }

    public boolean addLine(int refArticle, int quantity) {

        Article article = ArticleManager.getArticleByReference(refArticle);

        if (article != null && nbLines < lines.length) {
            Line line;
            if (article instanceof ArticleUnitary) {
                line = new Line((ArticleUnitary) article, quantity);
            } else if (article instanceof Batch) {
                line = new Line((Batch) article, quantity);
            } else {
                return false;
            }

            lines[nbLines++] = line;
            return true;
        }
        return false;
    }

    public Double getPriceTotal(int quantity, Double price){
        return quantity * price;
    }

    public int getNumInvoice() {
        return numInvoice;
    }

    public void setNumInvoice(int numInvoice) {
        this.numInvoice = numInvoice;
    }


    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Line[] getLines() {
        return lines;
    }

    public void setLines(Line[] lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "numInvoice=" + numInvoice +
                ", client='" + client + '\'' +
                ", date='" + date + '\'' +
                ", lines=" + Arrays.toString(lines) +
                '}';
    }
}
