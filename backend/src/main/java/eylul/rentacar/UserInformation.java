package eylul.rentacar;

import jakarta.persistence.*;

@Entity
@Table(name="user_information")

public class UserInformation {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Id;
        @Column(name = "name")
        private String name;

        private String password;

        public UserInformation(){
        }

        public UserInformation(String name, String password){
                this.name=name;
                this.password=password;
        }

        public Long getId(){
                return Id;
        }

        public String getName(){
                return name;
        }

        public String getPassword(){
                return password;
        }

        public void setId(Long Id){
                this.Id=Id;
        }

        public void setName(String name){
                this.name=name;
        }

        public void setPassword(String password){
                this.password=password;
        }
}