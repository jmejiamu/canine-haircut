
package Logic;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AppointmentInfo {
    
    @Id
    private int client_num;
    
    @Basic
    private String dog_name;
    private String race;
    private String color;
    private String allergic;
    private String special_attention;
    private String owner_name;
    private String owner_celphone;
    private String observation;

    public AppointmentInfo() {
    }

    public AppointmentInfo(int client_num, String dog_name, String race, String color, String allergic, String special_attention, String owner_name, String owner_celphone, String observation) {
        this.client_num = client_num;
        this.dog_name = dog_name;
        this.race = race;
        this.color = color;
        this.allergic = allergic;
        this.special_attention = special_attention;
        this.owner_name = owner_name;
        this.owner_celphone = owner_celphone;
        this.observation = observation;
    }

    public int getClient_num() {
        return client_num;
    }

    public void setClient_num(int client_num) {
        this.client_num = client_num;
    }

    public String getDog_name() {
        return dog_name;
    }

    public void setDog_name(String dog_name) {
        this.dog_name = dog_name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAllergic() {
        return allergic;
    }

    public void setAllergic(String allergic) {
        this.allergic = allergic;
    }

    public String getSpecial_attention() {
        return special_attention;
    }

    public void setSpecial_attention(String special_attention) {
        this.special_attention = special_attention;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getOwner_celphone() {
        return owner_celphone;
    }

    public void setOwner_celphone(String owner_celphone) {
        this.owner_celphone = owner_celphone;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
    
    
}
