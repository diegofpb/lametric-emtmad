
package es.diegofpb.lametric.emtmad.model.emt.timearrivalbus;

import lombok.Data;

@Data
public class LineInfo {

    private String label;
    private String line;
    private Long metersFromHeader;
    private String nameA;
    private String nameB;
    private String to;

}
