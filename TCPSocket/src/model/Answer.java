/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Ngoc Bich
 */
public class Answer implements Serializable{
    public static final long serialVersionUID=2L;
    Student student;
    Object[] answerd;
    boolean[] isRights;
    boolean alreadyRegistration;

    public Object[] getAnswerd() {
        return answerd;
    }

    public void setAnswerd(Object[] answerd) {
        this.answerd = answerd;
    }

    public boolean[] getIsRights() {
        return isRights;
    }

    public void setIsRights(boolean[] isRights) {
        this.isRights = isRights;
    }

    public boolean isAlreadyRegistration() {
        return alreadyRegistration;
    }

    public void setAlreadyRegistration(boolean alreadyRegistration) {
        this.alreadyRegistration = alreadyRegistration;
    }

    

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    
    
}
