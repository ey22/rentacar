package eylul.rentacar.protectionplans;

import jakarta.persistence.*;
@Entity
@Table(name="protection_plans")
public class PlansInformation {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Id;
        @Column(name = "planType")
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

