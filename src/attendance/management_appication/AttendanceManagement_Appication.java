/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.management_appication;

import com.Savindu.Util.DBConnection;
import com.Savindu.Dao.DBHanddler;

/**
 *
 * @author Savindu
 */
public class AttendanceManagement_Appication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        DBConnection connection = new DBConnection();
        connection.openConnection();
        
        DBHanddler users = new DBHanddler();
        users.displayUsers();
    }
    
}
