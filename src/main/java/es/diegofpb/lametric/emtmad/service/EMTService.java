package es.diegofpb.lametric.emtmad.service;

import es.diegofpb.lametric.emtmad.client.EMTAPIClientImpl;
import es.diegofpb.lametric.emtmad.model.emt.login.DataResponse;
import es.diegofpb.lametric.emtmad.model.emt.login.EMTClientLoginResponse;
import es.diegofpb.lametric.emtmad.model.emt.timearrivalbus.EMTArrivalBusResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class EMTService {

    @Value("${config.emtapi.x-apikey}")
    private String xApiKey;
    @Value("${config.emtapi.x-clientId}")
    private String xClientId;
    @Value("${config.emtapi.passKey}")
    private String passKey;


    private final EMTTokenService emtTokenService;
    private final EMTAPIClientImpl emtapiClient;

    @Autowired
    public EMTService(EMTTokenService emtTokenService, EMTAPIClientImpl emtapiClient) {
        this.emtTokenService = emtTokenService;
        this.emtapiClient = emtapiClient;
    }


    @PostConstruct
    public void initializeClient() throws Exception {
        log.info("Initializing EMT Client...");
        if(emtTokenService.getAccessToken() == null){
            EMTClientLoginResponse loginResponse = emtapiClient.getLogin(xApiKey, xClientId, passKey);
            if(loginResponse == null || loginResponse.getData() == null || loginResponse.getData().get(0) == null){
                log.error("Can't parse server response.");
                throw new Exception();
            }
            DataResponse dataResponse = loginResponse.getData().get(0);
            if (dataResponse.getAccessToken() == null){
                log.error("Can't get accessToken from server response.");
                throw new Exception();
            }
            emtTokenService.setAccessToken(dataResponse.getAccessToken());
            log.info("AccessToken is " + emtTokenService.getAccessToken());
            return;
        }
        log.info("Token is ready.");
    }

    public EMTArrivalBusResponse getTimeArrivalBus(String stopId, String line) {
        return (line != null && !line.isEmpty()) ?
                emtapiClient.getTimeArrivalBusForOneLine(stopId, line) :
                emtapiClient.getTimeArrivalBusForAllLines(stopId);
    }

}
