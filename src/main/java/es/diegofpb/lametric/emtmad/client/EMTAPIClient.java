package es.diegofpb.lametric.emtmad.client;

import es.diegofpb.lametric.emtmad.model.emt.EMTArrivalBusRequest;
import es.diegofpb.lametric.emtmad.model.emt.login.EMTClientLoginResponse;
import es.diegofpb.lametric.emtmad.model.emt.timearrivalbus.EMTArrivalBusResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "emt-api-client", url = "${config.emtapi.endpoint}${config.emtapi.version}")
public interface EMTAPIClient {

    @GetMapping(value = "/mobilitylabs/user/login/")
    EMTClientLoginResponse getLogin(@RequestHeader("X-ApiKey") String xAPIKey,
                                    @RequestHeader("X-ClientId") String xClientId,
                                    @RequestHeader("passKey") String passKey);

    @PostMapping(value = "/transport/busemtmad/stops/{stopId}/arrives/")
    EMTArrivalBusResponse getTimeArrivalBusForAllLines(@PathVariable String stopId,
                                                       @RequestBody EMTArrivalBusRequest emtArrivalBusRequest);

    @PostMapping(value = "/transport/busemtmad/stops/{stopId}/arrives/{lineArrive}/")
    EMTArrivalBusResponse getTimeArrivalBusForOneLine(@PathVariable String stopId,
                                                      @PathVariable String lineArrive,
                                                      @RequestBody EMTArrivalBusRequest emtArrivalBusRequest);

}
