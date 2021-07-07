/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author se151045
 */
public class Log { // class trung gian
    // ktra quan he nhieu nhieu
    // ghi nhan service
    // dung class 2 been khai bao 2 field
    Pet pet;
    Services service;
    
    public Log(){
        pet =null;
        service =null; 
    // con tro nen gan null
    }

    public Log(Pet pet, Services service) {
        this.pet = pet;
        this.service = service;
    }

    public Pet getPet() {
        return pet;
    }

    public Services getService() {
        return service;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setService(Services services) {
        this.service = service;
    }
    public void output(){
        System.out.println("Thong tin sd dich vu");
        pet.output();
        service.output();
    }

    @Override
    public String toString() {
        return "Log{" + "pet=" + pet + ", service=" + service + '}';
    }
    
}
