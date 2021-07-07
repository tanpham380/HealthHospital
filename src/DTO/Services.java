/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import static DTO.Pet.StringInput;
import static DTO.Pet.toTitleCase;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Phạm Thanh Tân - Se151045
 */
public class Services implements Comparable<Services>{

    private int id;
    private String name;
    private int price;

    public Services() {
        id = 0;
        name = "";
        price = 0;
    }

    public Services(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public boolean SetById(String id) {
        boolean flag = false;
            String digit = "\\d";
         if(id.matches(digit)) flag=true;
        try {
                  
                if ((flag==false) && (Integer.parseInt(id) <= 0)) throw new Exception();
                
                this.id = Integer.parseInt(id);
                
            } 
            catch (NumberFormatException e) { System.out.println("errow from input is format number"); return false; }
            catch (InputMismatchException e1) { System.out.println("input agian because ID is mumber"); return false; } 
            catch (Exception e2) {System.out.println("input errow: ID must >0  and ID is number"); return false; }
         return true;
    }
        public void InputID(){
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        do{
            flag=false;
            try{
                sc=new Scanner(System.in);
                System.out.println("Input Service ID: ");
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
    public void input()  {
        Scanner sc=new Scanner(System.in);
        boolean flag = false;
        do {
            flag = false;
            try {
                sc = new Scanner(System.in);
                System.out.println("input Service'Name:");
                name = sc.nextLine();
                if(name.matches(StringInput)==false) throw new Exception();
                name = toTitleCase(name);
                if (name.isEmpty() && name == null) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("input wrong format ");
                flag = true;
            }
        } while (flag == true);
        do {
            flag = false;
            try {
                sc = new Scanner(System.in);
                System.out.println("input Service'price:");
                price = sc.nextInt();
                if (price <= 0) {
                    throw new Exception();
                }
            } catch (NumberFormatException e) {
                System.out.println("errow from input is format number");
                flag = true;
            } catch (InputMismatchException e1) {
                System.out.println("input agian because ID is mumber");
                flag = true;
            } catch (Exception e2) {
                System.out.println("ID must >0");
                flag = true;
            }
        } while (flag == true);

    }

    public void output() {
        System.out.println("ser's id:" + id);
        System.out.println("ser's name:" + name);
        System.out.println("ser's price:" + price);
    }

    @Override
    public int compareTo(Services o) {
        if(id>o.getId()) return 1;
        if(id<o.getId()) return -1;
        return 0;
    }
    @Override
    public String toString() {
        return "Services{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
    }

}
