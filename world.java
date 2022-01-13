import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class world {
    private Double distance;
    ArrayList<aeroport> list;

    public ArrayList<aeroport> getlist() {
        return list;
    }

    public world (String fileName) {
        list = new ArrayList<aeroport>();
        try {
            BufferedReader buf = new BufferedReader(new FileReader(fileName));
            String s = buf.readLine();
            while (s != null) {
                s = s.replaceAll("\"", "");
                        String fields[]=s.split(",");
                if (fields[1].equals("large_airport")) {


                }
                s = buf.readLine();
            }
        } catch (Exception e) {
            System.out.println("Maybe the file isn't there ?");
            System.out.println(list.get(list.size()-1));
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {



        world w = new world("ressources_java/airport-codes_no_comma.csv");
        System.out.println("Found " + w.getlist().size() + " airports.");
        aeroport paris = w.findNearestAirport(2.316, 48.866);
        aeroport cdg = w.findByCode("CDG");
        double distance = w.distance(2.316, 48.866, paris.getLongitude(), paris.getLatitude());
        System.out.println(paris);
        System.out.println(distance);
        double distanceCDG = w.distance(2.316, 48.866, cdg.getLongitude(), cdg.getLatitude());
        System.out.println(cdg);
        System.out.println(distanceCDG);
    }
}




