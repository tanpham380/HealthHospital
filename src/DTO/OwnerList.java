/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import static DTO.Pet.toTitleCase;
import java.util.Scanner;

/**
 *
 * @author Phạm Thanh Tân - Se151045
 */
public class OwnerList {

    Owner[] list;
    int soluongOwner;
    final int Max = 100;

    public OwnerList() {
        list = new Owner[Max];
        soluongOwner = 0;
    }

    public boolean addOwner(Owner p) {
        if (soluongOwner >= Max) {
            return false;
        }
        list[soluongOwner] = p;
        soluongOwner++;
        return true;

    }

    public boolean DisplayOwner() {
        if (soluongOwner <= 0 || soluongOwner > Max) {
            return false;
        }
        for (int i = 0; i < soluongOwner; i++) {
            list[i].output();
        }
        return true;
    }

    public int FindOwner(String id) {
        for (int i = 0; i < soluongOwner; i++) {
            if(list[i].getId().compareTo(id)==0) return i;
        }
        return -1;
    }

    public Owner SearchOwner(String id) {
        for (int i = 0; i < soluongOwner; i++) {
            if (list[i].getId().compareTo(id)==0) {
                return list[i];
            }
        }
        return null;
    }

    public boolean UpdateOwner(String id) {
        Owner p = SearchOwner(id);
        if (p == null) {
            return false;
        }
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("input new Owner'Name:");
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
            try {
                sc = new Scanner(System.in);
                System.out.println("input new Owner'address:");
                p.setAddress(sc.nextLine());
                if (p.getAddress().isEmpty() && p.getAddress() == null) {
                    throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("input is empty ");
                flag = true;
            }
        } while (flag == true);
        return true;
    }

    public boolean sortID() {
        if (soluongOwner <= 0 || soluongOwner >= Max ) return false;
        for (int i = 0; i < soluongOwner; i++) {
            for (int j = soluongOwner - 1; j > i; j--) {
                if (list[i].getId().length() > list[j].getId().length()) {
                    Owner tmp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = tmp;
                }
            }
        }
        return true;
    }

    public boolean removeOwner(String id) {
        Owner p = SearchOwner(id);
        if (id.length() == -1) {
            return false;
        }
        //dich chuyen cac ptu len 1 vitri
        for (int j = id.length(); j < soluongOwner; j++) {
            list[j] = list[j + 1];
        }
        soluongOwner--; //giam 1 ptu
        return true;
    }
}
