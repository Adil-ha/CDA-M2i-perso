package org.example.bank;

public class EpargneCompte extends Compte {
    private float tauxInteret;

    public EpargneCompte(float solde, float tauxInteret) {
        super(solde);
        this.tauxInteret = tauxInteret;
    }

    public float calculInteret() {
        float interest = getSolde() * (tauxInteret / 100);
        setSolde(getSolde() + interest);
        return interest;
    }

    public float getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(float tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
}
