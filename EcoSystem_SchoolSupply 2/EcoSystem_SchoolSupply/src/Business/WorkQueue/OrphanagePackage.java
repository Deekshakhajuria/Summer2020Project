/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author deekshakhajuria
 */
public class OrphanagePackage {
     private int numberOfBeds = 0;
    private int numberOfBlankets = 0;
    private int numberOfNotebooks = 0;
    private int numberOfArtSupplies = 0;
    private int numberOfMasks = 0;

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public int getNumberOfBlankets() {
        return numberOfBlankets;
    }

    public void setNumberOfBlankets(int numberOfBlankets) {
        this.numberOfBlankets = numberOfBlankets;
    }

    public int getNumberOfNotebooks() {
        return numberOfNotebooks;
    }

    public void setNumberOfNotebooks(int numberOfNotebooks) {
        this.numberOfNotebooks = numberOfNotebooks;
    }

    public int getNumberOfArtSupplies() {
        return numberOfArtSupplies;
    }

    public void setNumberOfArtSupplies(int numberOfArtSupplies) {
        this.numberOfArtSupplies = numberOfArtSupplies;
    }

    public int getNumberOfMasks() {
        return numberOfMasks;
    }

    public void setNumberOfMasks(int numberOfMasks) {
        this.numberOfMasks = numberOfMasks;
    }
}
