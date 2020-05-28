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
        if (type.getValue().equals(Type.Doctor.getValue())){
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.PrivateLab.getValue())){
            organization = new PrivateLabOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Delivery.getValue())){
            organization = new DeliveryOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Insurance.getValue())){
            organization = new InsuranceOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Supplies.getValue())){
            organization = new SuppliesOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.CDCAnalyst.getValue())){
            organization = new CDCAnalystOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.Sanitization.getValue())){
            organization = new SanitizationOrganization();
            organizationList.add(organization);
        }
        
        return organization;
    }
}