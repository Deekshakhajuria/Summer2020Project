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
public class ManufacturingWorkRequest extends WorkRequest{
    private String packageType;
    private SchoolPackage schoolPackage;    
    private OrphanagePackage OrphanagePackage;

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public SchoolPackage getSchoolPackage() {
        return schoolPackage;
    }

    public void setSchoolPackage(SchoolPackage schoolPackage) {
        this.schoolPackage = schoolPackage;
    }

    public OrphanagePackage getOrphanagePackage() {
        return OrphanagePackage;
    }

    public void setOrphanagePackage(OrphanagePackage OrphanagePackage) {
        this.OrphanagePackage = OrphanagePackage;
    }
}
