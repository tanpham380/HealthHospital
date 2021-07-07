/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import static DTO.Pet.isDateValid;
import static DTO.Pet.toTitleCase;
import java.util.Scanner;

/**
 *
 * @author Phạm Thanh Tân - Se151045
 */
public class PetList {

    Pet[] list;
    int soluongpet;
    // finall là khai bao hang so
    int Max = 100;

    public PetList() {
        list = new Pet[Max];
        soluongpet = 0;
    }

    public boolean AddPet(Pet p) {
        if (soluongpet >= Max) {
            return false;
        }
        list[soluongpet] = p;
        soluongpet++;
        return true;

    }
    public int ListSize(){
        return soluongpet;
    }
    public boolean DisplayPet() {
        if (soluongpet <= 0 || soluongpet > Max) {
            return false;
        }
        for (int i = 0; i < soluongpet; i++) {
            list[i].output();
        }
        return true;
    }

    public int FindPet(int id) {
        for (int i = 0; i < soluongpet; i++) {
            if (id == list[i].getId()) {
                return i;
            }
        }
        return -1;
    }

    public Pet SearchPet(int id) {
        for (int i = 0; i < soluongpet; i++) {
            if (list[i].getId() == id) {
                return list[i];
            }
        }
        return null;
    }
    public Pet GetPet(int i) {
            return list[i];
    }
    public boolean UpdatePet(int id) {
        Pet p = SearchPet(id);
        if (p == null) {
            return false;
        }
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        do {
            flag=false;
            try {
                sc = new Scanner(System.in);
                System.out.println("input new Pet'name:");
                p.setName(toTitleCase(sc.nextLine()));
                if (p.getName().isEmpty() && p.getName() == null) {
                    throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("input is empty ");
                flag = true;
            }
        } while (flag == true);
        do {
             flag=false;
            sc = new Scanner(System.in);
            System.out.println("input new Pet'birthday: dd-mm-yyyy");
            p.setBirthday(sc.nextLine());
            if (isDateValid(p.getBirthday()) == true) {
                System.out.println("Date Valid");
            } else {
                System.out.println("Date InVaild");
                flag = true;
            }
        } while (flag == true);
        do {
             flag=false;
            try {
                sc = new Scanner(System.in);
                System.out.println("input new Pet'gender:");
                p.setGender(toTitleCase(sc.nextLine()));
                if (p.getGender().isEmpty() && p.getGender() == null) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("input is empty ");
                flag = true;
            }
        } while (flag == true);
        return true;
    }

    public boolean SortItems() {
        if (soluongpet <= 0 || soluongpet >= Max ) return false;
        for (int i = 0; i < soluongpet; i++) {
            for (int j = soluongpet - 1; j > i; j--) {
                if (list[i].getId() > list[j].getId()) {
                    Pet tmp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = tmp;
                }
            }
        }
        return true;
    }

    public boolean RemovePet(int id) {
        Pet p = SearchPet(id);
        if (id == -1) {
            return false;
        }
        //dich chuyen cac ptu len 1 vitri
        for (int j = id; j < soluongpet; j++) {
            list[j] = list[j + 1];
        }
        soluongpet--; //giam 1 ptu
        return true;
    }
}
