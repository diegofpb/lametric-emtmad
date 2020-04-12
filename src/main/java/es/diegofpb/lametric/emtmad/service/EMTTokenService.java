package es.diegofpb.lametric.emtmad.service;

import org.springframework.stereotype.Service;

@Service
public class EMTTokenService {

    private String accessToken;

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
