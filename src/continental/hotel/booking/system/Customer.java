/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package continental.hotel.booking.system;

/**
 *
 * @author johnp
 */
public class Customer {

    private String ic;
    private String name;
    private String contactNumber;
    private String email;
    
    public Customer(String ic, String name, String contactNumber, String email){
        this.ic = ic;
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
    }    
    
    public Customer(){
        
    }
    public String getIC(){
        return ic;
    }
    
    public void setIC(String ic){
        this.ic = ic;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getContactNumber(){
        return contactNumber;
    }
    
    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
}
