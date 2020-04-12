package es.diegofpb.lametric.emtmad.model.emt;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EMTArrivalBusRequest {

    @JsonProperty("Text_StopRequired_YN")
    private RequestOption isStopRequired;
    @JsonProperty("Text_EstimationsRequired_YN")
    private RequestOption isEstimationRequired;
    @JsonProperty("Text_IncidencesRequired_YN")
    private RequestOption isIncidencesRequired;

    public enum RequestOption {
        Y, N
    }

}
