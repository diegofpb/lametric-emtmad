
package es.diegofpb.lametric.emtmad.model.emt.timearrivalbus;

import lombok.Data;

import java.util.List;

@Data
public class EMTArrivalBusResponse {

    private String code;
    private List<Datum> data;
    private String datetime;
    private String description;

}
