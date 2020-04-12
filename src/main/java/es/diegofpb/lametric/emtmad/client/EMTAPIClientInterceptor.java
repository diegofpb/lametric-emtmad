package es.diegofpb.lametric.emtmad.client;

import es.diegofpb.lametric.emtmad.service.EMTTokenService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EMTAPIClientInterceptor implements RequestInterceptor {

    private static final String ACCESS_TOKEN_HEADER = "accessToken";
    public final EMTTokenService emtTokenService ;

    @Autowired
    public EMTAPIClientInterceptor(EMTTokenService emtTokenService) {
        this.emtTokenService = emtTokenService;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(ACCESS_TOKEN_HEADER, emtTokenService.getAccessToken());
    }
}