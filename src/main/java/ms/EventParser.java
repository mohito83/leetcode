package ms;

import org.json.*;

import java.io.*;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * EventParser : EventParser
 *
 */
public class EventParser {
    private  Map<Integer, PublisherDetails> map = new HashMap<>();
    public static void main(String[] args) {
        String filePath = "latest_random_es_events.jsonl";
        EventParser ep = new EventParser();
        ep.parseEventFile(filePath);

        JSONObject report = ep.generateReport();
        System.out.println("Report: "+ report);
    }

    private JSONObject generateReport() {
        JSONObject reportObject = new JSONObject();

        for (Map.Entry<Integer, PublisherDetails> entry : map.entrySet()) {
            JSONObject publisherDetailsObject = new JSONObject();
            publisherDetailsObject.put("impression", entry.getValue().impressionCount);
            publisherDetailsObject.put("clearing_price", entry.getValue().clearing_price);
            publisherDetailsObject.put("deferred_impressions", entry.getValue().defferedImpressionCount);
            publisherDetailsObject.put("click", entry.getValue().clickCount);
            publisherDetailsObject.put("opportunity", entry.getValue().opportunityCount);

            reportObject.put(String.valueOf(entry.getKey()), publisherDetailsObject);
        }

        return reportObject;
    }

    private void parseEventFile(String filePath) {

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(getClass().getClassLoader().getResource(filePath).toURI())))) {
            String line;
            while ((line = reader.readLine()) != null) {
                JSONObject json = new JSONObject(line);
                if (json.has("publisher_id")) {
                    int publisherID = json.getInt("publisher_id");
                    PublisherDetails pd = map.getOrDefault(publisherID, new PublisherDetails());
                    boolean dnc = json.getBoolean("dnc");
                    if (!dnc) {
                        String logType= json.getString("log_type");
                        switch (logType) {
                            case "deferred_impression": pd.defferedImpressionCount++;
                            break;
                            case "impression" : pd.impressionCount++;
                            break;
                            case "opportunity" : pd.opportunityCount++;
                            break;
                            case "click" : pd.clickCount++;
                            break;
                        }

                        if (json.has("clearing_price")) {
                            long clearingPrice = json.getLong("clearing_price");
                            pd.clearing_price += clearingPrice;
                        }
                    }

                    map.put(publisherID, pd);
                }
            }
        } catch (FileNotFoundException fe) {
            System.out.println("Unable to find the file"+ fe.getMessage());
        } catch (IOException e) {
            System.out.print("Failed to parse the event file" + e.getMessage());
        } catch (URISyntaxException e) {
            System.out.print("Failed to parse the event file" + e);
        }
    }
}
