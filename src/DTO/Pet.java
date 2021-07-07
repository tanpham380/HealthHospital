/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Phạm Thanh Tân - Se151045
 */
public class Pet implements Comparable< Pet> {

    private int id;
    private String name;
    private String birthday;
    private String gender;
    private Owner owner;
    ////Bien de check loi nguoi dung
    final public static String StringInput = "^[a-zA-Z\\s]+";
    public Pet() { // khai bao them class ben 1 nhieu vao (Owner)
        // 1 owner cos nhieu pet
        id = 0;
        name = "";
        birthday = "";
        gender = " ";
        owner = null;
    }

    public Pet(int id, String name, String birthday, String gender, Owner owner) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public Owner getOwner() {
        return owner;
    }
    public void SetID(int id){
        this.id=id;
    }
    /// check errow 
    public boolean SetById(String id) {
        boolean flag = false;
        try {
                  
                if (Integer.parseInt(id) <= 0) throw new Exception();
                
                this.id = Integer.parseInt(id);
                
            } 
            catch (NumberFormatException e) { System.out.println("errow from input is format number"); return false; }
            catch (InputMismatchException e1) { System.out.println("input agian because ID is mumber"); return false; } 
            catch (Exception e2) {System.out.println("input errow: ID must >0  and ID is number"); return false; }
         return true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public void InputID(){
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        do{
            flag=false;
            try{
                sc=new Scanner(System.in);
                System.out.println("Input Pet ID: ");
               id = Integer.parseInt(sc.next());
                 if ((flag==true) && (id <= 0)) throw new Exception();
            }catch(InputMismatchException e ){
                System.out.println("Errow format");
                 flag=true;
            }
            catch(Exception e1){
                System.out.println(" input is number and must >0");
                flag=true;
            }
        } while(flag==true);
    }
    public void Input() {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
       
        do {
            flag = false;
            try {
                sc = new Scanner(System.in);
                System.out.println("input Pet'name:");
                name = sc.nextLine();
                name = toTitleCase(name);
                if(name.matches(StringInput)==false) throw new Exception();
                if (name.isEmpty() || name == null) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("input wrong format ");
                flag = true;
            }
        } while (flag == true);
        do {
            flag=false;
            sc = new Scanner(System.in);
            System.out.println("input Pet'birthday: dd-mm-yyyy");
            birthday = sc.nextLine();
            if (isDateValid(birthday) == true) {
                System.out.println("Date Valid");
            } else {
                System.out.println("Date InVaild");
                flag = true;
            }
        } while (flag == true);
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("input Pet'gender:");
                gender = sc.nextLine();
                gender = toTitleCase(gender);
                if(gender.matches(StringInput)==false) throw new Exception();
                if (gender.isEmpty() && gender == null) {
                    throw new Exception();
                }
                
            } catch (Exception e) {
                System.out.println("input wrong format ");
                flag = true;
            }
        } while (flag == true);
    }

    public void output() {
        System.out.println("Pet's id:" + id);
        System.out.println("Pet's name" + name);
        System.out.println("Pet'birthday:" + birthday);
        System.out.println("Pet'gender:" + gender);
        if (owner != null) {
            System.out.println("chu so huu :");
            owner.output();
        }
    }
    //// format Name 

    public static String toTitleCase(String givenString) {
        String[] arr = givenString.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String arr1 : arr) {
            sb.append(Character.toUpperCase(arr1.charAt(0))).append(arr1.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }
    /// check Date

    public static boolean isDateValid(String date) {
        final String DATE_FORMAT = "dd MM yyyy";
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    //    public int compareTo(Pet o) {
    //     if(id>o.getId()) return 1;
    //     if(id<o.getId()) return -1;
    ////        if(name.length()>o.getName().length()) return 1;
    ////        if(name.length()<o.getName().length()) return -1;
    //        return 0;
    //    }
    @Override
    public int compareTo(Pet o) {
        if (id > o.getId()) {
            return 1;
        }
        if (id < o.getId()) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Pet{" + "id=" + id + ", name=" + name + ", birthday=" + birthday + ", gender=" + gender + ", owner=" + owner + '}';
    }

}
