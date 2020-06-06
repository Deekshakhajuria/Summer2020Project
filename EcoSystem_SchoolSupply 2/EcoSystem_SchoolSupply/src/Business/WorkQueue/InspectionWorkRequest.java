/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author Keshav
 */
public class InspectionWorkRequest extends WorkRequest{
    
    private String testResult;
    static private SchoolPackage schoolPackage;

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public SchoolPackage getSchoolPackage() {
        return schoolPackage;
    }

    public void setSchoolPackage(SchoolPackage schoolPackage) {
        this.schoolPackage = schoolPackage;
    }

    
    
    
}
