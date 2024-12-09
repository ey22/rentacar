package eylul.rentacar.protectionplans;

import jakarta.persistence.*;
//Represent detailed information about plans
@Entity
@Table(name="protection_plans") //Name of table in database
public class PlansInformation {
    //Unique identifier for the plan
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    //Other information
    @Column(name = "planType") //Column name in the table
    private String planType;
    private boolean collisionDamageProtection;
    private boolean windscreenGlassTyresProtection;
    private boolean keyAndLicenceAssurance;
    private Float price;

    public PlansInformation(){
    }

    public PlansInformation(String planType, Boolean collisionDamageProtection, Boolean windscreenGlassTyresProtection, Boolean keyAndLicenceAssurance){
        this.planType=planType;
        this.collisionDamageProtection=collisionDamageProtection;
        this.windscreenGlassTyresProtection=windscreenGlassTyresProtection;
        this.keyAndLicenceAssurance=keyAndLicenceAssurance;

    }
    //Getters and Setters
    public Long getId(){
        return Id;
    }

    public String getPlanType(){
        return planType;
    }

    public  boolean getCollisionDamageProtection(){
        return collisionDamageProtection;
    }

    public boolean getWindscreenGlassTyresProtection() {
        return windscreenGlassTyresProtection;
    }

    public boolean getKeyAndLicenceAssurance() {
        return keyAndLicenceAssurance;
    }

    public Float getPrice(){ return price; }
}

