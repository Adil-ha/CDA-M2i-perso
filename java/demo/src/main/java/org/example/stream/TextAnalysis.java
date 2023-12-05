package org.example.stream;
import java.text.BreakIterator;
import java.util.*;
import java.util.stream.Collectors;

public class TextAnalysis {

    public static void main(String[] args) {
        // Exemple de texte
        String texte = "Java Streams est une API puissante, pour le traitement de données en Java. " +
                "Il offre des opérations de traitement parallèle et facilite la manipulation de collections.";

        // Préparation des données
        List<String> mots = preparerMots(texte);

        // Traitement avec Streams
        // Fréquence des mots
        Map<String, Long> frequenceMots = compterFrequenceMots(mots);
        System.out.println("Fréquence des mots : " + frequenceMots);

        // Filtrer les mots selon la longueur
        int longueurMin = 5;
        List<String> motsFiltres = filtrerMotsParLongueur(mots, longueurMin);
        System.out.println("Mots filtrés (longueur > " + longueurMin + ") : " + motsFiltres);

        // Mots uniques
        List<String> motsUniques = trouverMotsUniques(mots);
        System.out.println("Mots uniques : " + motsUniques);

        // Mots les plus fréquents
        int topN = 3;
        List<String> motsPlusFrequents = trouverMotsPlusFrequents(mots, topN);
        System.out.println("Mots les plus fréquents : " + motsPlusFrequents);

        // Statistiques sur les longueurs de mots
        DoubleSummaryStatistics statistiquesLongueurs = calculerStatistiquesLongueurs(mots);
        System.out.println("Statistiques sur les longueurs de mots : " + statistiquesLongueurs);
    }

    // Préparation des mots en retirant la ponctuation et en convertissant en minuscules
    private static List<String> preparerMots(String texte) {
        BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(texte);
        List<String> mots = new ArrayList<>();

        int debut = breakIterator.first();
        int fin;

        while ((fin = breakIterator.next()) != BreakIterator.DONE) {
            String mot = texte.substring(debut, fin).replaceAll("[^\\p{L}]+", "").toLowerCase();
            if (!mot.isEmpty()) {
                mots.add(mot);
            }
            debut = fin;
        }

        return mots;
    }

    // Compter la fréquence des mots
    private static Map<String, Long> compterFrequenceMots(List<String> mots) {
        return mots.stream()
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
    }

    // Filtrer les mots selon la longueur
    private static List<String> filtrerMotsParLongueur(List<String> mots, int longueurMin) {
        return mots.stream()
                .filter(mot -> mot.length() > longueurMin)
                .collect(Collectors.toList());
    }

    // Trouver les mots uniques
    private static List<String> trouverMotsUniques(List<String> mots) {
        return mots.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    // Trouver les mots les plus fréquents
    private static List<String> trouverMotsPlusFrequents(List<String> mots, int topN) {
        return mots.stream()
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    // Calculer les statistiques sur les longueurs de mots
    private static DoubleSummaryStatistics calculerStatistiquesLongueurs(List<String> mots) {
        return mots.stream()
                .mapToDouble(String::length)
                .summaryStatistics();
    }
}

