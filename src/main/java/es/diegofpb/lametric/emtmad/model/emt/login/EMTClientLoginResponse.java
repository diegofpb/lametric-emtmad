
package es.diegofpb.lametric.emtmad.model.emt.login;

import lombok.Data;

import java.util.List;

@Data
public class EMTClientLoginResponse {

    private String code;
    private List<DataResponse> data;
    private String datetime;
    private String description;

}
