/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import static DTO.Pet.isDateValid;
import static DTO.Pet.toTitleCase;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Phạm Thanh Tân - Se151045
 */
public class LogList {

    ArrayList<Log> list;

    public LogList() {
        list = new ArrayList<>();
    }

    public boolean AddLog(Log L) {
        return list.add(L);
    }

    public boolean OutputLog() {
        if(list.isEmpty()) return false; 
        for (int i = 0; i < list.size(); i++) {
            list.get(i).output();
        }
        return true;
    }

    public int FindLog(Pet P, Services S) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPet().getId() == P.getId()) 
                if (list.get(i).getService().getId() == S.getId())
                return i;
            
        }
        return -1;
    }

    public Log SearchLog(Pet P, Services S) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getPet().getId() == P.getId()) 
                if (list.get(i).getService().getId() == S.getId())
                    return list.get(i);
        }
        return null;
    }
    public boolean UpdateLog(Pet P,Services S) {
        Log L=SearchLog(P,S);
        boolean flag = false;
        Pet pet = new Pet();
        Services Service = new Services();
        if(L==null) return false;
        Scanner sc=new Scanner(System.in);
                 do {
            try {
                sc = new Scanner(System.in);
                System.out.println("input new Pet'name:");
                pet.setName(toTitleCase(sc.nextLine())); 
                if (pet.getName().isEmpty() && pet.getName() == null) {
                    throw new Exception();
                }
                
            } catch (Exception e) {
                System.out.println("input is empty ");
                flag = true;
            }
        } while (flag == true);
        do {
            sc = new Scanner(System.in);
            System.out.println("input new Pet'birthday: dd-mm-yyyy");
            pet.setBirthday(sc.nextLine());
            if (isDateValid(pet.getBirthday()) == true) {
                System.out.println("Date Valid");
            } else {
                System.out.println("Date InVaild");
                flag = true;
            }
        } while (flag == true);
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("input new Pet'gender:");
                pet.setGender(toTitleCase(sc.nextLine()));
                if (pet.getGender().isEmpty() && pet.getGender() == null) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("input is empty ");
                flag = true;
            }
        } while (flag == true);
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("input new Service'Name:");
                Service.setName(toTitleCase(sc.nextLine()));
                if (Service.getName().isEmpty() && Service.getName() == null) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("input is empty ");
                flag = true;
            }
        } while (flag == true);
        do {
            flag = false;
            try {
                sc = new Scanner(System.in);
                System.out.println("input new Service'price:");
                Service.setPrice(sc.nextInt());
                if (Service.getPrice() <= 0) {
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
        
// Renew
//        Pet pet = new Pet();
//        Services Service = new Services();
//        pet.input();
//        Service.input();
        L.setPet(pet);
        L.setService(Service);
        return true;
    }
    public boolean RemoveLog(Pet p,Services S){
        Log L=SearchLog(p,S);
                if (L == null) {
            return false;
        }       
        return list.remove(L);
    }


}
