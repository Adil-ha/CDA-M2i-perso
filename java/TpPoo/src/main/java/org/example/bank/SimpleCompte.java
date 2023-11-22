package org.example.bank;

public class SimpleCompte extends Compte {
    private int discovery;

    public SimpleCompte(float solde, int discovery) {
        super(solde);
        this.discovery = discovery;
    }

    public void debit(int sum) {
        float availableBalance = getSolde() + discovery;

        if (availableBalance >= sum) {
            solde -= sum;
            System.out.println("Débit effectué avec succès. Nouveau solde : " + getSolde());
        } else {
            System.out.println("Vous ne pouvez pas retirer. Solde insuffisant.");
        }
    }
    public int getDiscovery() {
        return discovery;
    }

    public void setDiscovery(int discovery) {
        this.discovery = discovery;
    }
}
