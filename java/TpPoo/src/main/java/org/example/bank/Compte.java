package org.example.bank;

public class Compte {
    protected static int cpt ;

    protected int code;
    protected float solde;

    public Compte(){

    }
    public Compte( float solde) {
        this.code = cpt++;
        this.solde = solde;
    }

    public void credit(int sum){
        solde += sum;
    }

    public void debit(double sum) {
        if (solde >= sum) {
            solde -= sum;
            System.out.println("Débit effectué avec succès. Nouveau solde : " + getSolde());
        } else {
            System.out.println("Vous ne pouvez pas retirer. Solde insuffisant.");
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "code=" + code +
                ", solde=" + solde +
                '}';
    }
}
