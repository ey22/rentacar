package eylul.rentacar.users;

import jakarta.persistence.*;
//Represent detailed information about users

@Entity
@Table(name="user_information") //Name of table in database

public class UserInformation {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        //Unique identifier for the user
        private Long Id;

        //Other information
        @Column(name = "name") //Column name in the table
        private String name;
        private String password;

        //Constructors
        public UserInformation(){
        }

        public UserInformation(String name, String password){
                this.name=name;
                this.password=password;
        }

        //Getters and Setters
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