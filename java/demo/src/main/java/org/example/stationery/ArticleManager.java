package org.example.stationery;
import java.util.HashMap;
import java.util.Map;

public class ArticleManager {

    private static Map<Integer, Article> articleHashMap = new HashMap<>();

    public static void addArticle(Article article) {
        articleHashMap.put(article.getReference(), article);
    }

    public static Article getArticleByReference(int reference) {
        return articleHashMap.get(reference);
    }
}
