/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package continental.hotel.booking.system;

import static continental.hotel.booking.system.Rooms.importRooms;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author johnp
 */
public class Booking extends Customer {
    
    
    private String bookingID;
    private String roomID;
    private String roomType;
    private String price;
    private String checkInDate;
    private String checkOutDate;
    
    /**
     * @param bookingID
     * @param ic
     * @param name
     * @param contactNumber
     * @param email
     * @param roomID
     * @param roomType
     * @param checkInDate
     * @param checkOutDate
     * @param price
     */
    public Booking(String bookingID, String ic, String name, String contactNumber,
            String email, String roomID, String roomType, String price, 
            String checkInDate, String checkOutDate) {
        super(ic, name, contactNumber, email);
        this.bookingID = bookingID;
        this.roomID = roomID;
        this.roomType = roomType;
        this.price = price;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
    
    public Booking(){
    }
    
    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }
    
    public String getRoomId() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    
    //if a method name is accidentally misspelled, the compiler will generate an error which helps catching 
    //mistakesn early on
    @Override
    public String getName(){
        return super.getName();
    }
    
    @Override
    public String getIC(){
        return super.getIC();
    }
        
    @Override
    public String getContactNumber(){
        return super.getContactNumber();
    }
    
    
    @Override
    public String getEmail(){
        return super.getEmail();
    }
    
    public boolean isValidBokingID(){
        return bookingID.matches("^B\\d{3}$");
    }
    
    public boolean isValidIc(){
        String ic = super.getIC();
        return !ic.isEmpty();
    }
    
    public boolean isValidName() {
        String name = super.getName();
        return name.matches("^[a-zA-Z\\s]+$"); // Only allow alphabetical characters and spaces
    }

    public boolean isValidPhoneNumber() {
        String contactNumber = super.getContactNumber();
        return contactNumber.matches("^\\+?\\d{1,3}(\\s\\d{1,15})?$|^\\d{1,15}$"); // 
    }

    public boolean isValidEmail() {
        String email = super.getEmail();
        return email.matches("^[^@]+@[^@]+\\.[^@]+$"); // Validate email format
    }

    public boolean isValidRoomID() {
        return roomID.matches("^(1[AB]|[2-9][A-J]|10[B])$"); // Room number should be 2 alphanumeric characters (e.g. 2A)
    }

    public boolean isValidRoomType() {
        // Allow "Single", "Double" or "Deluxe" room types only
        return roomType.equalsIgnoreCase("Single") || roomType.equalsIgnoreCase("Double") || roomType.equalsIgnoreCase("Deluxe");
    }

    public boolean isValidPrice() {
        return price.matches("^\\d+(\\.\\d{1,2})?$"); // Validate price format (e.g. 350.00)
    }  
    
    public boolean isValidCheckIn(){
        return checkInDate.matches("^\\d{4}-\\d{2}-\\d{2}$");
    }
    
    public boolean isValidCheckOut(){
        return checkOutDate.matches("^\\d{4}-\\d{2}-\\d{2}$");
    }
    
    //to validate data in table one by one
    public boolean validateTableData(JTable table) {
        boolean valid = true;
        for (int i = 0; i < table.getRowCount(); i++) {
            boolean rowValid = true;
            for (int j = 0; j < table.getColumnCount(); j++) {
                Object value = table.getValueAt(i, j);
                boolean cellValid = true;
                switch (j) {
                    case 0: // Booking ID
                        setBookingID(value.toString());
                        cellValid = isValidBokingID();
                        break;
                    case 1:
                        setIC(value.toString());
                        cellValid = isValidIc();
                        break;
                    case 2: // Name
                        setName(value.toString());
                        cellValid = isValidName();
                        break;
                    case 3: // Phone Number
                        setContactNumber(value.toString());
                        cellValid = isValidPhoneNumber();
                        break;
                    case 4: // Email
                        setEmail(value.toString());
                        cellValid = isValidEmail();
                        break;
                    case 5: // Room Number
                        setRoomID(value.toString());
                        cellValid = isValidRoomID();
                        break;
                    case 6: // Room Type
                        setRoomType(value.toString());
                        cellValid = isValidRoomType();
                        break;
                    case 7: // Price
                        setPrice(value.toString());
                        cellValid = isValidPrice();
                        break;
                    case 8: // Check-In Date
                        setCheckInDate(value.toString());
                        cellValid = isValidCheckIn();
                        break;
                    case 9: // Check-Out Date
                        setCheckOutDate(value.toString());
                        cellValid = isValidCheckOut();
                        break;
                    default:
                        break;
                }
                if (!cellValid) {
                    rowValid = false;
                    table.changeSelection(i, j, false, false);
                    JOptionPane.showMessageDialog(null, "Invalid data in row " + (i+1) + ", column " + (j+1));
                    break;
                }
            }
            if (!rowValid) {
                valid = false;
                break;
            }
        }
        return valid;
    }

    
   
   //to read from txt file and convert to ArrayList
   public static ArrayList<Booking> importData() {
        ArrayList<Booking> bookings = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Booking.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] list = line.split(":");
                bookings.add(new Booking(list[0], list[1], list[2], list[3], 
                        list[4], list[5], list[6], list[7], list[8], list[9]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookings;
    }
   
   //to import data from txt file to JTable
    public void importDataToTable(JTable table){
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        File file = new File("Booking.txt");
        String path = file.getAbsolutePath();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            String record;
            while ((record = br.readLine()) != null) {
                String[] dataRow = record.split(":");
                model.addRow(dataRow);
            }
            br.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
   //to write data from ArrayList to txt file
    public void writeNewData(ArrayList<Booking> bookings){
        FileWriter pr;
    try{
        pr = new FileWriter("Booking.txt",false);
        for (Booking i:bookings){  //string representation
           String bookingId = i.getBookingID();
           String ic = i.getIC();
           String name = i.getName();
           String contactNumber = i.getContactNumber();
           String email = i.getEmail();
           String roomId = i.getRoomId();
           String roomTypes = i.getRoomType();
           String prices = i.getPrice();
           String checkIndate = i.getCheckInDate();
           String checkOutdate = i.getCheckOutDate();
           
           pr.write(bookingId+":"+ic+":"+name+":"+contactNumber+":"+email+
           ":"+roomId+":"+roomTypes+":"+prices+":"+checkIndate+":"+checkOutdate + "\n");
        }
        pr.close();
    }catch (IOException e) {
        Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, e);
    }
    }
    
    //to write data from JTable to txt file
    public void writeNewData(JTable table){
        try {
        File file = new File("Booking.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String line = "";
        for (int row = 0; row < model.getRowCount(); row++) {
            for (int col = 0; col < model.getColumnCount(); col++)
                line = line + model.getValueAt(row, col) + ":";
            bw.write(line + "\n");
            line = "";
        }
        bw.close();
        JOptionPane.showMessageDialog(null, "Changes saved successfully!");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error saving changes: " 
        + e.getMessage(), "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //to delete the booking from txt file
    public void deleteBooking(String bookingID) {
        try {
            File inputFile = new File("Booking.txt");
            File tempFile = new File("tempBooking.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] lineData = currentLine.split(":");
                if (lineData[0].equals(bookingID)) {
                    continue; // Skip the line to delete
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }

            writer.close();
            reader.close();

            if (!inputFile.delete()) {
                System.out.println("Failed to delete the original file.");
            }
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Failed to rename the temporary file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       
    }
    
     
    //to retrieve the available rooms for a given check-in and check-out date range
    public static ArrayList<Rooms> getAvailableRooms(String checkInDate, String checkOutDate){
        ArrayList<Rooms> availableRooms = new ArrayList<>();
        ArrayList<Booking> bookings = importData(); //read contents of Booking.txt
        ArrayList<Rooms> rooms = importRooms(); //read contents of Rooms.txt
        
        availableRooms.addAll(rooms);
        
        for(Booking booking : bookings){
            LocalDate bookingCheckIn = LocalDate.parse(booking.getCheckInDate());
            LocalDate bookingCheckOut = LocalDate.parse(booking.getCheckOutDate());
            LocalDate selectedCheckIn = LocalDate.parse(checkInDate);
            LocalDate selectedCheckOut = LocalDate.parse(checkOutDate);
            
             //to find the available rooms for selected check-in and check-out date range from the booking txt file
            if(selectedCheckIn.isBefore(bookingCheckOut) && selectedCheckOut.isAfter(bookingCheckIn)){ 
                //remove the room ID matching the room ID of current booking
                availableRooms.removeIf(room -> room.getRoomID().equals(booking.getRoomId()));
            }
        }
     return availableRooms;  //the rooms what are not booked in booking txt file will in an array list
    }
     
    //is to determine if a room is available for booking during a specified check-in and check-out date range (true/flase)
    public static boolean isRoomAvailable(String roomID, String checkInDateStr, String checkOutDateStr, String ignoreBookingID) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date checkInDate = sdf.parse(checkInDateStr);
            Date checkOutDate = sdf.parse(checkOutDateStr);

            // read existing bookings from the file
            File file = new File("Booking.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                String bookedBookingID = parts[0];
                String bookedRoomID = parts[5];
                Date bookedCheckInDate = sdf.parse(parts[8]);
                Date bookedCheckOutDate = sdf.parse(parts[9]);

                // check if the booking ID is not the one to ignore, and if the room is already booked during the given booking period
                if (!bookedBookingID.equals(ignoreBookingID)
                        && bookedRoomID.equals(roomID)
                        && ((bookedCheckInDate.before(checkOutDate) && bookedCheckOutDate.after(checkInDate))
                                || (bookedCheckInDate.equals(checkInDate) && bookedCheckOutDate.equals(checkOutDate)))) {
                    scanner.close();
                    return false;
                }
            }
            scanner.close();
            return true;
        } catch (ParseException | FileNotFoundException e) {
            return false;
        }
    }




}
    
    