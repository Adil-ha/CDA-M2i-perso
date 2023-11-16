package org.example.exerciceCondition;

import java.util.Scanner;

public class ExerciceCondition {
    public static void exoUn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est votre prénom ?");
        String nom = scanner.next();
        System.out.println("Bonjour," + nom + "!");
        scanner.close();
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
        scanner.close();

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
        scanner.close();
    }

    public static void exoQuatre(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Entrer nombre 1 ?");
        Integer nb1 = scanner.nextInt();
        System.out.println(" Entrer nombre 2 ?");
        Integer nb2 = scanner.nextInt();

        if ((nb1>0 && nb2>0) || (nb1<0 && nb2 <0) ){
            System.out.println("Le produit des 2 nombres est positif");
        }else{
            System.out.println("Le produit des 2 nombres est negatif");
        }
        scanner.close();

    }

    public static void exoCinq(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer nom 1 ?");
        String nom1 = scanner.next().toLowerCase();
        System.out.println("Entrer nom 2 ?");
        String nom2 = scanner.next().toLowerCase();
        System.out.println("Entrer nom 3 ?");
        String nom3 = scanner.next().toLowerCase();

        if (nom1.compareTo(nom2) < 0 && nom2.compareTo(nom3) < 0){
            System.out.println("Il sont rangé dans l'ordre alphabétique ");
        }else{
            System.out.println("Il ne sont pas rangé dans l'odre alphabétique");
        }
        scanner.close();
    }
    public static void exosix(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer nombre ?");
        Integer nb1 = scanner.nextInt();

        if (nb1 < 0){
            System.out.println("Negatif");
        } else if (nb1 > 0) {
            System.out.println("Positif");
        }else{
            System.out.println("Nulle");
        }
        scanner.close();
    }

    public static void exosept(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer l'âge de l'enfant ?");
        Integer age = scanner.nextInt();

        if (age >= 12){
            System.out.println("Cadet");
        } else if(age >=10 && age <= 11){
            System.out.println("Minime");
        }else if(age >=8 && age <= 9){
            System.out.println("Pupille");
        }else if(age >=6 && age <= 7){
            System.out.println("Poussin");
        }else{
            System.out.println("trop petit");
        }
        scanner.close();
    }

    public static void exoHuit(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer un nombre ?");
        Integer nb1 = scanner.nextInt();

        if (nb1 % 3 == 0){
            System.out.println("divisible par 3");
        }else {
            System.out.println(" Non divisible par 3");
        }
        scanner.close();
    }

    public static void exoNeuf() {
        float prix = 0f;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer un nombre de photocopie ?");
        int nbPhoto = scanner.nextInt();

        if (nbPhoto < 10) {
            prix = nbPhoto * 0.15f;
        } else if ( nbPhoto < 20) {
            prix = nbPhoto * 0.10f;
        } else {
            prix = nbPhoto * 0.05f;
        }
        System.out.println("Le prix est de : " + prix);
        scanner.close();
    }
}
