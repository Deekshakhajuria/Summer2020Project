/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author deekshakhajuria
 */
public class NIDCEnterprise extends Enterprise{
   public NIDCEnterprise(String name){
        super(name,EnterpriseType.NIDC);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    } 
}
