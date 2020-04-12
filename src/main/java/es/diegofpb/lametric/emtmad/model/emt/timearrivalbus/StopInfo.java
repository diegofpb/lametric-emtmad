
package es.diegofpb.lametric.emtmad.model.emt.timearrivalbus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class StopInfo {

    @JsonProperty("Direction")
    private String direction;
    private Geometry geometry;
    private List<LineInfo> lines;
    private String stopId;
    private String stopName;

}
