
package es.diegofpb.lametric.emtmad.model.emt.login;

import lombok.Data;

@Data
public class ApiCounter {

    private Long current;
    private Long dailyUse;
    private String licenceUse;
    private Long owner;

}
