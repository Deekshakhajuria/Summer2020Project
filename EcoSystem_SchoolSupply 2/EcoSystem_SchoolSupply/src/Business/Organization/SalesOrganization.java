/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.SalesManRole;
import java.util.ArrayList;

/**
 *
 * @author deekshakhajuria
 */
public class SalesOrganization extends Organization {
    public SalesOrganization() {
        super(Organization.Type.Sales.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new SalesManRole());
        return roles;
    } 
}
