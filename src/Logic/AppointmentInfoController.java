
package Logic;

import Persistence.PersistenceController;

public class AppointmentInfoController {
    
    AppointmentInfo appoinmentInfo = new AppointmentInfo();
    PersistenceController persistanceController = new PersistenceController();
    
    public void createAppointment(int clientNum, String name, String race, String color, String allergic, String special, String ownerName, String ownerCel, String observation) {
        appoinmentInfo.setClient_num(clientNum);
        appoinmentInfo.setDog_name(name);
        appoinmentInfo.setRace(race);
        appoinmentInfo.setColor(color);
        appoinmentInfo.setAllergic(allergic);
        appoinmentInfo.setSpecial_attention(special);
        appoinmentInfo.setOwner_name(ownerName);
        appoinmentInfo.setOwner_celphone(ownerCel);
        appoinmentInfo.setObservation(observation);
        
        persistanceController.createDogAppointment(appoinmentInfo);
        
    }
    
}
