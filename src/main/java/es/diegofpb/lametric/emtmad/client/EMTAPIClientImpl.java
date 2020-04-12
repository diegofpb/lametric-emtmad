package es.diegofpb.lametric.emtmad.client;

import es.diegofpb.lametric.emtmad.model.emt.EMTArrivalBusRequest;
import es.diegofpb.lametric.emtmad.model.emt.login.EMTClientLoginResponse;
import es.diegofpb.lametric.emtmad.model.emt.timearrivalbus.EMTArrivalBusResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EMTAPIClientImpl {

    private final EMTAPIClient emtapiClient;

    @Autowired
    public EMTAPIClientImpl(EMTAPIClient emtapiClient) {
        this.emtapiClient = emtapiClient;
    }

    //@HystrixCommand(fallbackMethod = "loginFallback")
    public EMTClientLoginResponse getLogin(String xAPIKey, String xClientId, String passKey) {
        return emtapiClient.getLogin(xAPIKey, xClientId, passKey);
    }

    //@HystrixCommand(fallbackMethod = "loginFallback")
    public EMTArrivalBusResponse getTimeArrivalBusForAllLines(String stopId) {
        EMTArrivalBusRequest emtArrivalBusRequest = new EMTArrivalBusRequest(
                EMTArrivalBusRequest.RequestOption.Y,
                EMTArrivalBusRequest.RequestOption.Y,
                EMTArrivalBusRequest.RequestOption.Y);
        return emtapiClient.getTimeArrivalBusForAllLines(stopId, emtArrivalBusRequest);
    }

    //@HystrixCommand(fallbackMethod = "loginFallback")
    public EMTArrivalBusResponse getTimeArrivalBusForOneLine(String stopId, String lineArrive) {
        EMTArrivalBusRequest emtArrivalBusRequest = new EMTArrivalBusRequest(
                EMTArrivalBusRequest.RequestOption.Y,
                EMTArrivalBusRequest.RequestOption.Y,
                EMTArrivalBusRequest.RequestOption.Y);
        return emtapiClient.getTimeArrivalBusForOneLine(stopId, lineArrive, emtArrivalBusRequest);
    }

    @SuppressWarnings("unused")
    public void loginFallback(Throwable e) {
        log.error(e.getMessage());
    }
}
