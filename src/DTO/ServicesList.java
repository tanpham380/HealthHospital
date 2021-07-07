/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import static DTO.Pet.toTitleCase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Phạm Thanh Tân - Se151045
 */
public class ServicesList {

    ArrayList<Services> list;

    public ServicesList() {
        list = new ArrayList<>();
    }

    public boolean InputServices(Services o) {
        return list.add(o);
    }

    public boolean OutputServices() {
        if(list.isEmpty()) return false;
        for (int i = 0; i < list.size(); i++) {
            list.get(i).output();
        }
        return true;
    }

    public int FindServices(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Services SearchServices(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return list.get(i);
            }

        }
        return null;
    }

    public boolean updateServices(int id) {
        Services S = SearchServices(id);
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        if (S == null) {
            return false;
        }
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("input new Service'Name:");
                S.setName(toTitleCase(sc.nextLine()));
                if (S.getName().isEmpty() && S.getName() == null) {
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
                S.setPrice(sc.nextInt());
                if (S.getPrice() <= 0) {
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

        return true;
    }
    public Services GetServices(int i ){
         return list.get(i);
        
    }

    public boolean RemoveServices(int id) {
        Services S = SearchServices(id);
        if (S == null) {
            return false;
        }
        return list.remove(S);
    }

    public boolean sortById() {
         if(list.isEmpty()) return false;
        Collections.sort(list);
        return true;
    }
}
