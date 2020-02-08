package busautomation;

import java.sql.Date;
/*
    Author ~ Erdem Çamlıoğlu - 2020
*/
public class Car {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car(int id, String plate, Date entry_date, int inlet_weight, String driver, Date exit_date, int output_weight, String registry_person, Date registry_date, String car_brand, String destination, String exit_point) {
        this.id = id;
        this.plate = plate;
        this.entry_date = entry_date;
        this.inlet_weight = inlet_weight;
        this.driver = driver;
        this.exit_date = exit_date;
        this.output_weight = output_weight;
        this.registry_person = registry_person;
        this.registry_date = registry_date;
        this.car_brand = car_brand;
        this.destination = destination;
        this.exit_point = exit_point;
    }
    private String plate;
    private Date entry_date;
    private int inlet_weight;
    private String driver;
    private Date exit_date;
    private int output_weight;
    private String registry_person;
    private Date registry_date;
    private String car_brand;
    private String destination;
    private String exit_point;

    public Car(String plate, Date entry_date, int inlet_weight, String driver, Date exit_date, int output_weight, String registry_person, Date registry_date, String car_brand, String destination, String exit_point) {
        this.plate = plate;
        this.entry_date = entry_date;
        this.inlet_weight = inlet_weight;
        this.driver = driver;
        this.exit_date = exit_date;
        this.output_weight = output_weight;
        this.registry_person = registry_person;
        this.car_brand = car_brand;
        this.destination = destination;
        this.exit_point = exit_point;
        this.registry_date = registry_date;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Date getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }

    public int getInlet_weight() {
        return inlet_weight;
    }

    public void setInlet_weight(int inlet_weight) {
        this.inlet_weight = inlet_weight;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Date getExit_date() {
        return exit_date;
    }

    public void setExit_date(Date exit_date) {
        this.exit_date = exit_date;
    }

    public int getOutput_weight() {
        return output_weight;
    }

    public void setOutput_weight(int output_weight) {
        this.output_weight = output_weight;
    }

    public String getRegistry_person() {
        return registry_person;
    }

    public void setRegistry_person(String registry_person) {
        this.registry_person = registry_person;
    }

    public Date getRegistry_date() {
        return registry_date;
    }

    public void setRegistry_date(Date registry_date) {
        this.registry_date = registry_date;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getExit_point() {
        return exit_point;
    }

    public void setExit_point(String exit_point) {
        this.exit_point = exit_point;
    }
    
}
