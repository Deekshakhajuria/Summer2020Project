/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Administration.getValue())){
            organization = new AdministrationOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Inspection.getValue())){
            organization = new InspectionOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Manufacturing.getValue())){
            organization = new ManufacturingOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.Sales.getValue())){
            organization = new SalesOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type. Orphanage.getValue())){
            organization = new  OrphanageOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}