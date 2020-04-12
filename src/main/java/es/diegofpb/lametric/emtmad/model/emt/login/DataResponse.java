
package es.diegofpb.lametric.emtmad.model.emt.login;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataResponse {

    private String accessToken;
    private ApiCounter apiCounter;
    private String email;
    private Boolean flagAdvise;
    private String idUser;
    private String nameApp;
    private String priv;
    private Long tokenSecExpiration;
    private String updatedAt;
    private String userName;
    private String username;


}
