
package es.diegofpb.lametric.emtmad.model.emt.timearrivalbus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Arrive {

    private Long bus;
    private String destination;
    private Long deviation;
    @JsonProperty("DistanceBus")
    private Long distanceBus;
    private Integer estimateArrive;
    private Geometry geometry;
    private String isHead;
    private String line;
    private String positionTypeBus;
    private String stop;

}
