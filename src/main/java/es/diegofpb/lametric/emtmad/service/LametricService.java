package es.diegofpb.lametric.emtmad.service;

import es.diegofpb.lametric.emtmad.model.emt.timearrivalbus.Arrive;
import es.diegofpb.lametric.emtmad.model.emt.timearrivalbus.EMTArrivalBusResponse;
import es.diegofpb.lametric.emtmad.model.emt.timearrivalbus.StopInfo;
import es.diegofpb.lametric.emtmad.model.lametric.LametricFrame;
import es.diegofpb.lametric.emtmad.model.lametric.LametricResponse;
import es.diegofpb.lametric.emtmad.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class LametricService {

    public LametricResponse parseEmtArrivalBusResponseToLametric(EMTArrivalBusResponse busResponse) {
        LametricResponse lametricResponse = new LametricResponse();
        List<LametricFrame> lametricFrameList = new ArrayList<>();
        lametricFrameList.add(new LametricFrame("EMT", Constants.EMT_DARK, lametricFrameList.size()));

        // Error.
        if (busResponse == null || !busResponse.getCode().equals("00")) {
            lametricFrameList.add(new LametricFrame(Constants.EMT_NO_INFO_RETURNED, Constants.EMT_DARK, lametricFrameList.size()));
            lametricResponse.setFrames(lametricFrameList);
            return lametricResponse;
        }

        if (busResponse.getData() != null && busResponse.getData().get(0) != null) {

            List<Arrive> arrives = busResponse.getData().get(0).getArrives();
            List<StopInfo> stopInfo = busResponse.getData().get(0).getStopInfo();

            if (stopInfo != null && stopInfo.get(0) != null) {
                String stopId = stopInfo.get(0).getStopId();
                String stopName = stopInfo.get(0).getStopName();
                lametricFrameList.add(new LametricFrame(stopId + " - " + stopName, Constants.EMT_STOP, lametricFrameList.size()));
            }

            if (arrives != null) {
                if (arrives.isEmpty()) {
                    lametricFrameList.add(new LametricFrame(Constants.EMT_NO_NEXT_ARRIVALS,
                            Constants.EMT_STOP_NO_ARRIVALS, lametricFrameList.size()));
                    lametricResponse.setFrames(lametricFrameList);
                    return lametricResponse;
                }

                Map<String, List<String>> arrivalMap = new HashMap<>();

                for (Arrive arrive : arrives) {
                    arrivalMap.computeIfAbsent(arrive.getLine(), key -> new ArrayList<>()).add(getArriveTime(arrive));
                }

                for (Map.Entry<String, List<String>> lineEntry : arrivalMap.entrySet()) {
                    String arrivals = String.join(" - ", lineEntry.getValue());
                    lametricFrameList.add(new LametricFrame(lineEntry.getKey() + ": " + arrivals,
                            Constants.EMT_STOP, lametricFrameList.size()));
                }
            }

        }

        lametricResponse.setFrames(lametricFrameList);
        return lametricResponse;
    }

    private String getArriveTime(Arrive arrive) {
        String arriveTime;
        if (arrive.getEstimateArrive().equals(Constants.MORE_THAN_45_MINUTES)) {
            arriveTime = "+45 min";
        } else if (TimeUnit.SECONDS.toMinutes(arrive.getEstimateArrive()) == 0) {
            arriveTime = "Entrando";
        } else {
            arriveTime = TimeUnit.SECONDS.toMinutes(arrive.getEstimateArrive()) + " min";
        }
        return arriveTime;
    }

}
