import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Service extends Thread{
    final private String nom;
    private FileWriter fw;

    public Service(String nom, FileWriter fw) {
        this.nom = nom;
        this.fw=fw;
    }

    public void traitement (){
        Random random = new Random();
        int duree = 250+random.nextInt(2000);
        synchronized(fw){
            System.out.println("Bonjour, je suis le processus "+nom);
            System.out.println("Mon traitement prendra "+duree+" millisecondes");
            try{Thread.sleep(duree);}
            catch (Exception e){e.printStackTrace();}
            System.out.println("Fin du traitement pour le processus "+nom);
            try {
                fw.write("Fin d'exécution du processus "+ nom + "\n");
                fw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }


    @Override
    public void run() {
        traitement();
    }
}
