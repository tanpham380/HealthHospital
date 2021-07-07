/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Log;
import DTO.LogList;
import DTO.Owner;
import DTO.OwnerList;
import DTO.Pet;
import DTO.PetList;
import DTO.Services;
import DTO.ServicesList;
import java.util.Scanner;

/**
 *
 * @author Phạm Thanh Tân - Se151045
 */
public class Tester {

    public static void main(String[] args) {

        LogList LogList = new LogList();
        PetList PetList = new PetList();
        ServicesList ServicesList = new ServicesList();
        OwnerList OwnerList = new OwnerList();
        Pet p = new Pet();
        Owner o = new Owner();
        Log l = new Log();
        Services s = new Services();
        int ChoiceMainNemu = 0;
        int Choice = 0;
        String Control =new String(); // hàm này để điều khiển chương trình có tiếp tục hay không
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        do {
            flag=true;
            try {
                sc = new Scanner(System.in);
                System.out.println("Main Nemu");
                System.out.println("1.Manager pet list");
                System.out.println("2.Manager Owner list");
                System.out.println("3.Manager Services list");
                System.out.println("4.Manager Log list");
                System.out.println("choose 0 to exit the program");
                ChoiceMainNemu = sc.nextInt();
                if (ChoiceMainNemu < 0 || ChoiceMainNemu >=5 ) {
                    throw new Exception();
                }
//                 if (Control.toLowerCase().compareTo("y") == 0) {
//                     flag = true;
//                    }
                if (ChoiceMainNemu == 0 ) {
                    System.out.println("thank you for using our service");
                    flag=false;
                
                }

            } catch (NumberFormatException e) {
                System.out.println("Errow input must number");
            } catch (Exception e1) {
                System.out.println("Input choice Vaild");
            }
            switch (ChoiceMainNemu) {
                case 1:
                    do {
                        try {
                            System.out.println("Pet Nemu");
                            System.out.println("1.Add pet");
                            System.out.println("2.Display All Pet List");
                            System.out.println("3.Find Pet");
                            System.out.println("4.Update informatin Pet");
                            System.out.println("5.Remove informatin Pet");
                            System.out.println("6.Sort Pet");
                            System.out.println("7.Add Owner");
                            System.out.println("choose another number to exit Pet Mannger");
                            sc = new Scanner(System.in);
                            Choice = sc.nextInt();
                            if (Choice <= 0) {
                                throw new Exception();
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Errow input must number");
                        } catch (Exception e1) {
                            System.out.println("Input choice must >0 and input is number");
                        }
                        switch (Choice) {
                            case 1:
                                System.out.println("Add Pet: ");
                                do {
                                    flag = false;
                                    System.out.println("Input ID");
                                    try {
                                        p = new Pet();
                                        sc = new Scanner(System.in);
                                        if (p.SetById(sc.next()) != true) {
                                            throw new Exception();
                                        }
                                        if (PetList.FindPet(p.getId()) == -1) {
                                            p.Input();
                                            PetList.AddPet(p);
                                        } else {
                                            System.out.println("ID already on the list, please re-enter it");
                                            throw new Exception();
                                        }
                                    } catch (Exception e) {
                                        flag = true;
                                    }
                                    if (flag == false) {
                                        System.out.println("successfull");
                                    }
                                } while (flag == true);
                                break;
                            case 2:
                                if (PetList.DisplayPet() == true) {
                                    System.out.println("Successfull");
                                } else if (PetList.DisplayPet() == false) {
                                    System.out.println("Empty array");
                                }
                                break;
                            case 3:
                                System.out.println("input ID you want to find");
                                p = new Pet();
                                sc = new Scanner(System.in);
                                p.SetById(sc.next());
                                if (PetList.FindPet(p.getId()) != -1) {
                                    System.out.println("pet is located:" + PetList.FindPet(p.getId()) );
                                } else {
                                    System.out.println("There's no pet id");
                                }
                                break;
                            case 4:
                                System.out.println("input ID you want to update");
                                p = new Pet();
                                sc = new Scanner(System.in);
                                p.SetById(sc.next());
                                if (PetList.FindPet(p.getId()) != -1) {
                                    PetList.UpdatePet(p.getId());
                                    System.out.println("Successfull Update");
                                } else {
                                    System.out.println("There's no pet id");
                                }
                                break;
                            case 5:
                                System.out.println("input ID you want to remove");
                                p = new Pet();
                                sc = new Scanner(System.in);
                                p.SetById(sc.next());
                                if (PetList.FindPet(p.getId()) != -1) {
                                    PetList.RemovePet(p.getId());
                                    System.out.println("Successfull remove");
                                } else {
                                    System.out.println("There's no pet id");
                                }
                                break;
                            case 6:
                                System.out.println("Sort Fuction");
                                if (PetList.SortItems()) {
                                    System.out.println("Successfull Sort");
                                } else {
                                    System.out.println("Empty array");
                                }
                                break;
                            case 7:

                                
                                try{
                                    
                                 
                                System.out.println("Add Owner for pet");
                                System.out.println("input Id Pet you want add Owner");
                                Pet p1 = new Pet();
                                p = new Pet();
                                sc = new Scanner(System.in);
                                p.SetById(sc.next());
                                if(PetList.FindPet(p.getId())== -1) throw new Exception();
                                p1 = PetList.SearchPet(p.getId()) ;
                                System.out.println("input Id Owner");
                                sc = new Scanner(System.in);
                                o = OwnerList.SearchOwner(sc.nextLine());
                                if(o==null) throw new Exception();
                                if (PetList.FindPet(p.getId()) != -1) {
                                    if (OwnerList.FindOwner(o.getId()) != -1) {
                                        p1.setOwner(o);
                                        System.out.println("Successfull Setup");
                                    }
                                    System.out.println("There's no Owner id");
                                } else {
                                    System.out.println("There's no pet id");
                                }
                                
                                }
                                catch(Exception e){
                                    System.out.println("InVaild ID");
                                    
                                }
                               
                                break;
                        }
                                
                    } while (Choice <= 7);

                    break;
                case 2:
                    do {
                        try {
                            System.out.println("Owner Nemu");
                            System.out.println("1.Add Owner");
                            System.out.println("2.Display all Owner ");
                            System.out.println("3.Find Owner");
                            System.out.println("4.Update informatin Owner");
                            System.out.println("5.Remove informatin Owner");
                            System.out.println("6.Sort Owner ID");
                            System.out.println("choose another number to exit Owner Mannger");
                            sc = new Scanner(System.in);
                            Choice = sc.nextInt();
                            if (Choice <= 0) {
                                throw new Exception();
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Errow input must number");
                        } catch (Exception e1) {
                            System.out.println("Input choice must >0 and input is number");
                        }
                        switch (Choice) {
                            case 1:
                                System.out.println("Add Owner: ");
                                o.InputID();
                                if (OwnerList.FindOwner(o.getId()) == -1) {
                                    o.Input();
                                    OwnerList.addOwner(o);
                                } else {
                                    System.out.println("ID already on the list, please re-enter it");
                                }
                                break;
                            case 2:
                                if (OwnerList.DisplayOwner() == true) {
                                    System.out.println("Successfull");
                                } else if (OwnerList.DisplayOwner() == false) {
                                    System.out.println("Empty array");
                                }
                                break;
                            case 3:
                                System.out.println("input ID you want to find");
                                o = new Owner();
                                o.InputID();
                                if (OwnerList.FindOwner(o.getId()) != -1) {
                                    System.out.println("pet is located:" + OwnerList.FindOwner(o.getId()));
                                } else {
                                    System.out.println("There's no pet id");
                                }
                                break;
                            case 4:
                                System.out.println("input ID you want to Update");
                                o = new Owner();
                                o.InputID();
                                if (OwnerList.FindOwner(o.getId()) != -1) {
                                    OwnerList.UpdateOwner(o.getId());
                                    System.out.println("Successfull Update");
                                } else {
                                    System.out.println("There's no Owner id");
                                }
                                break;
                            case 5:
                                System.out.println("input ID you want to remove");
                                o = new Owner();
                                o.InputID();
                                if (OwnerList.FindOwner(o.getId()) != -1) {
                                    OwnerList.removeOwner(o.getId());
                                    System.out.println("Successfull remove");
                                } else {
                                    System.out.println("There's no Owner id");
                                }
                                break;

                            case 6:
                                System.out.println("Sort Fuction");
                                if (OwnerList.sortID() == true) {
                                    System.out.println("Successfull Sort");
                                } else {
                                    System.out.println("Empty array");
                                }
                                break;
                        }
                    } while (Choice <= 6);
                    break;
                case 3:
                    do {
                        try {
                            System.out.println("Services Nemu");
                            System.out.println("1.Add Services");
                            System.out.println("2.Services element in list");
                            System.out.println("3.Find Services");
                            System.out.println("4.Update Services Pet");
                            System.out.println("5.Remove Services Pet");
                            System.out.println("6.Sort Services Pet");
                            System.out.println("choose another number to exit Pet list");
                            sc = new Scanner(System.in);
                            Choice = sc.nextInt();
                            if (Choice <= 0) {
                                throw new Exception();
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Errow input must number");
                        } catch (Exception e1) {
                            System.out.println("Input choice must >0 and input is number");
                        }
                        switch (Choice) {
                            case 1:
                                System.out.println("Add Services: ");
                                do {
                                    flag = false;
                                    System.out.println("Input ID");
                                    try {
                                        s = new Services();
                                        sc = new Scanner(System.in);
                                        if (s.SetById(sc.next()) != true) {
                                            throw new Exception();
                                        }
                                        if (ServicesList.FindServices(s.getId()) == -1) {
                                            s.input();
                                            ServicesList.InputServices(s);
                                        } else {
                                            System.out.println("ID already on the list, please re-enter it");
                                            throw new Exception();
                                        }
                                    } catch (Exception e) {
                                        flag = true;
                                    }
                                    if (flag ==false) {
                                        System.out.println("successfull");
                                    }
                                } while (flag == true);
                                break;
                            case 2:
                                if (ServicesList.OutputServices() == true) {
                                    System.out.println("Successfull");
                                } else if (ServicesList.OutputServices() == false) {
                                    System.out.println("Empty array");
                                }
                                break;
                            case 3:
                                System.out.println("input ID you want to find");
                                s = new Services();
                                sc = new Scanner(System.in);
                                s.SetById(sc.next());
                                if (ServicesList.FindServices(s.getId()) != -1) {
                                    System.out.println("pet is located:" + ServicesList.FindServices(s.getId()));
                                } else {
                                    System.out.println("There's no pet id");
                                }
                            case 4:
                                System.out.println("input ID you want to update");
                                s = new Services();
                                sc = new Scanner(System.in);
                                s.SetById(sc.next());
                                if (ServicesList.FindServices(s.getId()) != -1) {
                                    ServicesList.updateServices(s.getId());
                                    System.out.println("Successfull Update");
                                } else {
                                    System.out.println("There's no Services id");
                                }
                                break;
                            case 5:
                                System.out.println("input ID you want to remove");
                                s = new Services();
                                sc = new Scanner(System.in);
                                s.SetById(sc.next());
                                if (ServicesList.FindServices(s.getId()) != -1) {
                                    ServicesList.RemoveServices(s.getId());
                                    System.out.println("Successfull remove");
                                } else {
                                    System.out.println("There's no Services id");
                                }
                                break;
                            case 6:
                                System.out.println("Sort Fuction");
                                if (ServicesList.sortById()) {
                                    System.out.println("Successfull Sort");
                                } else {
                                    System.out.println("Empty array");
                                }
                                break;
                        }
                    } while (Choice <= 6);
                    break;
                case 4:
                    do {
                        try {
                            System.out.println("Log Nemu");
                            System.out.println("1.Add Log");
                            System.out.println("2.Output Log");
                            System.out.println("3.Find Log by ID pet ");
                            System.out.println("4.Update Log By ID pet");
                            System.out.println("5.Remove Log");
                            System.out.println("choose another number to exit Pet list");
                            sc = new Scanner(System.in);
                            Choice = sc.nextInt();
                            if (Choice <= 0) {
                                throw new Exception();
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Errow input must number");
                        } catch (Exception e1) {
                            System.out.println("Input choice must >0 and input is number");
                        }
                        switch (Choice) {
                            case 1:
                                //                                for (int i = 0; i < PetList.ListSize(); i++) {
                                //                                    p = PetList.GetPet(i);
                                //                                    s = ServicesList.GetServices(i);
                                //                                    l = new Log(p, s);
                                //                                    LogList.AddLog(l);
                                //                                }
                                System.out.println("Input information for Pet:");
                                p = new Pet();
                                p.InputID();
                                p.Input();
                                ServicesList s2 = new ServicesList();
                                do {
                                    flag = false;

                                    try {
                                        System.out.println("Input Services for Pet: ");
                                        s = new Services();
                                        s.InputID();
                                        if (s2.FindServices(s.getId()) == -1) {
                                            s.input();
                                            s2.InputServices(s);
                                            l = new Log(p, s);
                                            LogList.AddLog(l);
                                        } else {
                                            System.out.println("ID already on the list, please re-enter it");
                                            throw new Exception();
                                        }
                                    } catch (Exception e) {
                                        flag = true;
                                    }
                                    sc = new Scanner(System.in);
                                    System.out.println("put Y to add more services");
                                     Control = sc.nextLine();
                                    if (Control.toLowerCase().compareTo("y") == 0) {
                                        flag = true;
                                    }
                                } while (flag == true);
                                break;
                            case 2:

                                if (LogList.OutputLog() == true) {
                                    System.out.println("Successfull");
                                } else if (LogList.OutputLog() == false) {
                                    System.out.println("Empty array");
                                }

                                break;
                            case 3:
                                System.out.println("input ID pet, you want to find Log");
                                p = new Pet();
                                Services S = new Services();
                                sc = new Scanner(System.in);
                                p.SetById(sc.next());
                                sc = new Scanner(System.in);
                                System.out.println("input ID Services, you want to find Log");
                                S.SetById(sc.next());
                                p = PetList.SearchPet(p.getId());
                                S = ServicesList.SearchServices(S.getId());
                                if (LogList.FindLog(p,S) != -1 ) {
                                    System.out.println("Log is located: " + LogList.FindLog(p,S));
                                }
                                break;
                            case 4:
                                System.out.println("input ID pet, you want to Update Log");
                                p = new Pet();
                                sc = new Scanner(System.in);
                                p.SetById(sc.next());
                                S = new Services();
                                sc = new Scanner(System.in);
                                System.out.println("input ID Services, you want to find Log");
                                S.SetById(sc.next());
                                p = PetList.SearchPet(p.getId());
                                if (LogList.UpdateLog(p,S) == true) {
                                    System.out.println("Successful Update");
                                } else {
                                    System.out.println("Empty array");
                                }
                                break;
                            case 5:
                                System.out.println("input ID pet, you want to remove Log");
                                p = new Pet();
                                sc = new Scanner(System.in);
                                p.SetById(sc.next());
                                S = new Services();
                                sc = new Scanner(System.in);
                                System.out.println("input ID Services, you want to find Log");
                                S.SetById(sc.next());
                                p = PetList.SearchPet(p.getId());
                                if (LogList.RemoveLog(p,S) == true) {
                                    System.out.println("Successsfull Remove");
                                } else {
                                    System.out.println("Empty array");
                                }
                                break;
                        }
                    } while (Choice <= 5);
                    break;

            }
        } while (flag);

    }
}
