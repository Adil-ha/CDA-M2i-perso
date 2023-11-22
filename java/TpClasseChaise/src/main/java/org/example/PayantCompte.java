package org.example;

public class PayantCompte extends Compte {

    private final float INTERERT = 5;
    public PayantCompte(float solde) {
        super(solde);
    }

    public void credit(int sum){
        float r = sum * (INTERERT/100);
        setSolde(getSolde()+sum -r);
    }

    public void debit(int sum){
        if (getSolde() >= sum) {
            float r = sum * (INTERERT/100);
            setSolde(getSolde() -sum -r);
            System.out.println("Débit effectué avec succès. Nouveau solde : " + getSolde());
        }else{
            System.out.println("Vous ne pouvez pas retirer. Solde insuffisant.");
        }

    }
}
