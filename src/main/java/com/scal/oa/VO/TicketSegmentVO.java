package com.scal.oa.VO;

import com.scal.oa.domain.TicketSegment;
import lombok.Data;

@Data
public class TicketSegmentVO {
    private String from;
    private String to;
    private String fromCode;
    private String toCode;
    TicketSegmentVO(){}
}
