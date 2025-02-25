package ilias.uniapp;

import ilias.uniapp.Forms.MainForm;
import ilias.uniapp.db.University;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;

public class UniApp {

    //Δημιουργία του entity manager
    private static EntityManager em = null;

    //Επιστροφή του entity manager
    public static EntityManager getEM(){
    return em;
    }

    //Επιστροφή των πανεπιστημίων από τη βάση δεδομένων
    public static void main(String[] args) {


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ilias_UniApp_jar_1PU");
        em = factory.createEntityManager();
        
        MainForm.showMainForm();
        System.out.println("Hello World!");
    }
}
