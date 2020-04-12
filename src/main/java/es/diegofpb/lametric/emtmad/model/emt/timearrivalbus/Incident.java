
package es.diegofpb.lametric.emtmad.model.emt.timearrivalbus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Incident {

    @JsonProperty("ListaIncident")
    private ListaIncident listaIncident;

}
