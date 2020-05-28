/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.PathologistRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class PrivateLabOrganization extends Organization{

    public PrivateLabOrganization() {
        super(Organization.Type.PrivateLab.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new PathologistRole());
        return roles;
    }
     
   
    
    
}