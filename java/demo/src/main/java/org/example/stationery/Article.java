package org.example.stationery;

public abstract class Article {

    protected static int cpt;

    protected int reference;


    public Article() {
        this.reference = cpt++;
        ArticleManager.addArticle(this);
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "Article{" +
                "reference=" + reference +
                '}';
    }
}
