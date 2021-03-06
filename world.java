import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;




public class world {
    private Double distance;
    ArrayList<aeroport> list;


    public ArrayList<aeroport> getlist() {
        return list;
    }

    public double distance(double lon1, double lat1, double lon2, double lat2) {
        double dis = Math.pow(lat2 - lat1, 2) + Math.pow((lon2 - lon1) * Math.cos((lat2 + lat1) / 2), 2);
        return dis;
    }

    public aeroport findByCode(String code) {
        for (aeroport codea : list) {
            if (codea.getIATA().equals(code)) {

                return codea;
            }
        }
        System.out.println("Le code IATA ne correspond à aucun aeroport");
        return null;
    }

    public aeroport findNearestAirport(double lon, double lat) {
        double dist = distance(lon, lat, list.get(0).getLongitude(), list.get(0).getLatitude());
        aeroport b = null;
        double index = 0;
        for (aeroport a : list) {
            double lat1 = a.getLatitude();
            double lon1 = a.getLongitude();
            double d = distance(lon, lat, lon1, lat1);
            if (d < dist) {
                b = a;
                dist = d;
            }
        }
        return b;
    }

    public world(String fileName) {
        list = new ArrayList<aeroport>();
        try {
            BufferedReader buf = new BufferedReader(new FileReader(fileName));
            String s = buf.readLine();
            while (s != null) {
                s = s.replaceAll("\"", "");
                String fields[] = s.split(",");
                if (fields[1].equals("large_airport")) {
                    aeroport aero;
                    list.add(aero = new aeroport(fields[9], fields[2], fields[5], Double.parseDouble(fields[12]), Double.parseDouble(fields[11])));
                }
                s = buf.readLine();
            }
        } catch (Exception e) {
            System.out.println("Maybe the file isn't there ?");
            System.out.println(list.get(list.size() - 1));
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        world w = new world("airport-codes_no_comma.csv");
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




