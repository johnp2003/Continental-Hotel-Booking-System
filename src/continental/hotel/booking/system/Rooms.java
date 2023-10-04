/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package continental.hotel.booking.system;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author johnp
 */
public class Roomss {
    
    private String roomID;
    private String roomType;
    private String price;

    public Rooms(String roomID, String roomType, String price) {
        this.roomID = roomID;
        this.roomType = roomType;
        this.price = price;
    }
    
    public String getRoomID(){
        return roomID;
    }
    
    public String getRoomType(){
        return roomType;
    }
    
    public String getPrice(){
        return price;
    }
            
    

            
    public static ArrayList<Rooms> importRooms(){  //to read data from txt file and return as an array list
        BufferedReader br = null; //determine if BufferReader is successfully created
        ArrayList<Rooms> roomList = new ArrayList<>();
        try{
            ArrayList<String> details = new ArrayList<>();
            br = new BufferedReader(new FileReader("Rooms.txt"));
            String line;
            while((line = br.readLine())!=null){
                details.add(line);
            }
            for(String str:details){  //loop the content of the file itself
                String [] list = str.split(":");
                roomList.add(new Rooms(list[0],list[1],list[2]));
                
                br.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
     return roomList;
    }
}
