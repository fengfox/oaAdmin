package com.scal.oa.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name="APP_Ticket_Segment_Define")
public class TicketSegment {
    @Id
    @Column(name="Segment_Code")
    private String segmentCode;
    @Column(name="Segment_Name")
    private String segmentName;
    @Column(name="DOrI")
    private String DOrI;
    @Column(name="op_date")
    private Date op_date;
    public TicketSegment(){}
}
