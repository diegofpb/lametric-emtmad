package es.diegofpb.lametric.emtmad.controller;

import es.diegofpb.lametric.emtmad.model.lametric.LametricResponse;
import es.diegofpb.lametric.emtmad.service.EMTService;
import es.diegofpb.lametric.emtmad.service.LametricService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
@Slf4j
public class LametricController {

    private final EMTService emtService;
    private final LametricService lametricService;

    @Autowired
    public LametricController(EMTService emtService, LametricService lametricService) {
        this.emtService = emtService;
        this.lametricService = lametricService;
    }

    @GetMapping
    public LametricResponse getTimeArrivalBus(@RequestParam("stopId") String stopId,
                                              @RequestParam(value = "lineArrive", required = false) String lineArrive){
        return lametricService.parseEmtArrivalBusResponseToLametric(emtService.getTimeArrivalBus(stopId, lineArrive));
    }

}
