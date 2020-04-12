
package es.diegofpb.lametric.emtmad.model.emt.timearrivalbus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MoreInfo {

    @JsonProperty("@length")
    private String length;
    @JsonProperty("@type")
    private String type;
    @JsonProperty("@url")
    private String url;

}
