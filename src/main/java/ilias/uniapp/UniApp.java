package ilias.uniapp;

import ilias.uniapp.Forms.MainForm;
import ilias.uniapp.db.University;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;

public class UniApp {

    
    private static EntityManager em = null;
    
    public static EntityManager getEM(){
    return em;
    }
    
    public static void main(String[] args) {
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ilias_UniApp_jar_1PU");
        em = factory.createEntityManager();
        
        MainForm.showMainForm();
        System.out.println("Hello World!");
    }
}
