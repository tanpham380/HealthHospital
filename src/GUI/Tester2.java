///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package GUI;
//
//import DTO.Pet;
//import DTO.PetList;
//import java.util.Scanner;
//
///**
// *
// * @author Phạm Thanh Tân - Se151045
// */
//public class Tester2 {
//
//    public static void main(String[] args) {
//        int choiceMainNemu = 0;
//        do {
//            try {
//                Scanner sc = new Scanner(System.in);
//                System.out.println("1.Manager pet list");
//                System.out.println("2.Manager Owner list");
//                System.out.println("3.Manager Services list");
//                System.out.println("4.Manager Log list");
//                System.out.println("Out");
//                choiceMainNemu = sc.nextInt();
//                if (choiceMainNemu < 0) {
//                    throw new Exception();
//                }
//                if (choiceMainNemu >= 5) {
//                    System.out.println("thank you for using our service");
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Errow input must number");
//            } catch (Exception e1) {
//                System.out.println("Input must >0");
//            }
//
//            switch (choiceMainNemu) {
//                case 1: {
//                    PetList obj = new PetList();
//                    int choice = 0;
//                    Scanner sc = new Scanner(System.in);
//                    do {
//                        System.out.println("quan ly danh sach pet");
//                        System.out.println("1. add pet");
//                        System.out.println("2. display pet");
//                        System.out.println("input choice:");
//
//                        choice = sc.nextInt();
//                        switch (choice) {
//                            case 1:
//                                Pet pet1 = new Pet();
//                                do {
//                                    try {
//                                        pet1.input();
//                                        if (obj.searchPet(pet1.getId()) != null) {
//                                            throw new Exception();
//                                        }
//                                    } catch (Exception e) {
//                                        System.out.println("pls input ID agian ");
//                                    }
//
//                                } while (obj.searchPet(pet1.getId()) != null);
//                                if (obj.addpet(pet1)) {
//                                    System.out.println("added");
//                                } else {
//                                    System.out.println("Fail");
//                                }
//                                break;
//                            case 2:
//                                if (obj.display() == false) {
//                                    System.out.println("khong co pet trong danh sach");
//                                }
//                                break;
//                            case 3:
//                                int idupdate;
//                                System.out.println("input id you want to update");
//                                idupdate = sc.nextInt();
//                                obj.updatepet(idupdate);
//                                break;
//                            case 4:
//                                int idremove;
//                                System.out.println("input idremove:");
//                                idremove = sc.nextInt();
//                                obj.removePet(idremove);
//                                break;
//                        }
//                    } while (choice < 5 || choice > 0);
//                    System.out.println("thong tin pet va chu");
//                    System.out.println("input pet id ");
//                    int idPet = sc.nextInt();
//                    System.out.println("input Owner id ");
//                    int idOwner = sc.nextInt();
//                }
//                break;
//                case 2:
//                    break;
//            }
//        } while (choiceMainNemu < 5);
//        /*
//        int ans=0;
//        do{
//            System.out.println("Thong tin Pet and Owner");
//            System.out.println("input Pet'id:");
//            int idPet=sc.nextInt();
//            System.out.println("input Owner'id:");
//            int ownerId=sc.nextInt();
//            Pet p=list1.searchPet(idPet);
//            Owner w=list2.searchOwner(ownerId);
//            p.setOwner(owner);
//            System.out.println("muon lam tiep tuc(1/0)?");
//            ans=sc.nextInt();
//        }while(ans==1);
//         */
//    }
//
//}
