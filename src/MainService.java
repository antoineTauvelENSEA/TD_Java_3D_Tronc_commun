import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainService {

    public static void main(String[] args) {
	// write your code here
        FileWriter fw=null;
        try {
            fw = new FileWriter("./test.txt",false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Service> list = new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add (new Service("Thread #"+i,fw));
        }

        for(Service s : list) {
            s.start();
       /*     try{s.join();}
            catch(Exception e){e.getStackTrace();}
        */
        }
    }
}
