
package Persistence;

import Logic.AppointmentInfo;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PersistenceController {
    
    AppointmentInfoJpaController appointmentInfoJpaController = new AppointmentInfoJpaController();

    public void createDogAppointment(AppointmentInfo appoinmentInfo) {
        try {
            appointmentInfoJpaController.create(appoinmentInfo);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
