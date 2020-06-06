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
public class SalesWorkRequest extends WorkRequest{
    private OrphanagePackage orphanagePackage;
     private SchoolPackage schoolPackage;
     private String packageType;
     private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrphanagePackage getOrphanagePackage() {
        return orphanagePackage;
    }

    public void setOrpahanagePackage(OrphanagePackage orpahanagePackage) {
        this.orphanagePackage = orphanagePackage;
    }

    public SchoolPackage getSchoolPackage() {
        return schoolPackage;
    }

    public void setSchoolPackage(SchoolPackage schoolPackage) {
        this.schoolPackage = schoolPackage;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }
}
