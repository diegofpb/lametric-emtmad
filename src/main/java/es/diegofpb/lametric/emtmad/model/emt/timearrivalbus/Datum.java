
package es.diegofpb.lametric.emtmad.model.emt.timearrivalbus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Datum {

    @JsonProperty("Arrive")
    private List<Arrive> arrives;
    private String cause;
    private String description;
    private String effect;
    @JsonProperty("ExtraInfo")
    private List<Object> extraInfo;
    private String guid;
    @JsonProperty("Incident")
    private Incident incident;
    private MoreInfo moreInfo;
    private String pubDate;
    private String rssFrom;
    private String rssTo;
    @JsonProperty("StopInfo")
    private List<StopInfo> stopInfo;
    private String title;

}
