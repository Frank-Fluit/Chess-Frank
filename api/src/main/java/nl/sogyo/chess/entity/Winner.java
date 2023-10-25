 package nl.sogyo.chess.entity;

 import jakarta.persistence.Entity;
 import jakarta.persistence.GeneratedValue;
 import jakarta.persistence.GenerationType;
 import jakarta.persistence.Id;

 @Entity
 public class Winner {

     @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
     private Long id;
     private String name;


     protected Winner() {}


     //this is the constructor I use to create instances of Customer to be saved to the database
     public Winner(String name) {
         this.name = name;
     }
// maybe this can be changed to help parsing when showing on the webpage
     @Override
     public String toString() {
         return String.format(
                 "Customer[id=%d, name='%s']",
                 id, name);
     }

     public Long getId() {
         return id;
     }

     public String Name() {
         return name;
     }


 }
