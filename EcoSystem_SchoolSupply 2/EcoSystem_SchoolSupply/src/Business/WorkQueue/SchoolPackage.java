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
public class SchoolPackage {
    private int numberOfBoards = 0;
    private int numberOfTables = 0;
    private int numberOfNotebooks = 0;
    private int numberOfMasks = 0;

    public int getNumberOfBoards() {
        return numberOfBoards;
    }

    public void setNumberOfBoards(int numberOfBoards) {
        this.numberOfBoards = numberOfBoards;
    }

    public int getNumberOfTables() {
        return numberOfTables;
    }

    public void setNumberOfTables(int numberOfTables) {
        this.numberOfTables = numberOfTables;
    }

    public int getNumberOfNotebooks() {
        return numberOfNotebooks;
    }

    public void setNumberOfNotebooks(int numberOfNotebooks) {
        this.numberOfNotebooks = numberOfNotebooks;
    }

    public int getNumberOfMasks() {
        return numberOfMasks;
    }

    public void setNumberOfMasks(int numberOfMasks) {
        this.numberOfMasks = numberOfMasks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    private String status;
}
