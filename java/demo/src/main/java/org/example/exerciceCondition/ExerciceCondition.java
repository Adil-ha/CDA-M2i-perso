package org.example.exerciceCondition;

import java.util.Scanner;

public class ExerciceCondition {
    public static void exoUn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est votre prénom ?");
        String nom = scanner.next();
        System.out.println("Bonjour," + nom + "!");
    }

    public static void exoDeux() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est le prix HT ?");
        float prixHT = scanner.nextFloat();
        System.out.println("Nombre d'article ?");
        Integer nbArticle = scanner.nextInt();
        System.out.println("Quel est le taux de TVA ?");
        float tTVA = scanner.nextFloat();
        float prixTTC = prixHT * nbArticle * (1+tTVA/100);
        System.out.println("Le prix TTC est de :" + prixTTC);

    }

    public static void exoTrois(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Donne moi un nombre ?");
        Integer nb = scanner.nextInt();
        if (nb<0){
            System.out.println("Le nombre est un negatif");
        }else {
            System.out.println("Le nombre est positif");
        }
    }

    public static void exoQuatre(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Entrer nombre 1 ?");
        Integer nb1 = scanner.nextInt();
        System.out.println(" Entrer nombre 2 ?");
        Integer nb2 = scanner.nextInt();

        if (nb1>0 && nb2>0 ){
            System.out.println("Le produit des 2 nombres est positif");
        }else{
            System.out.println("Le produit des 2 nombres est negatif");
        }

    }

    public static void exoCinq(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer nom 1 ?");
        String nom1 = scanner.next();
        System.out.println("Entrer nom 2 ?");
        String nom2 = scanner.next();
        System.out.println("Entrer nom 3 ?");
        String nom3 = scanner.next();

        if (nom1.compareTo(nom2) < 0 && nom2.compareTo(nom3) < 0){
            System.out.println("Il sont rangé dans l'ordre alphabétique ");
        }else{
            System.out.println("Il ne sont pas rangé dans l'odre alphabétique");
        }
    }
}
