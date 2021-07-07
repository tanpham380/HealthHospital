/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import static DTO.Pet.StringInput;
import static DTO.Pet.toTitleCase;
import java.util.Scanner;

/**
 *
 * @author Phạm Thanh Tân - Se151045
 */
public class Owner implements  Comparable<Owner>{

    private String id;
    private String name;
    private String address;

    public Owner() {
        id = "";
        name = "";
        address = "";
    }

    public Owner(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void InputID(){
         boolean flag = false;
         Scanner sc = new Scanner(System.in);
                do {
            flag = false;
            try {
                sc = new Scanner(System.in);
                System.out.println("input ID':");
                id = sc.nextLine();
                id = toTitleCase(id);
                if (id.isEmpty() && id == null) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("input wrong format ");
                flag = true;
            }
        } while (flag == true);
    }

    public void Input() {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("input Owner'Name:");
                name = sc.nextLine();
                if(name.matches(StringInput)==false) throw new Exception();
                name = toTitleCase(name);
                if (name.isEmpty() && id == null) {
                    throw new Exception();
                    
                }
            } catch (Exception e) {
                System.out.println("input wrong format ");
                flag = true;
            }
        } while (flag == true);
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("input Owner'address:");
                address = sc.nextLine();
                address = toTitleCase(address);
                if (address.isEmpty() && id == null) {
                    throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("input wrong format ");
                flag = true;
            }
        } while (flag == true);
    }

    public void output() {
        System.out.println("owner's id:" + id);
        System.out.println("owner's name:" + name);
        System.out.println("owner's address:" + address);

    }

    @Override
    public int compareTo(Owner o) {
        return id.compareTo(o.getId());
        
    }
}
