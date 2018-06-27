package com.scal.oa.Service;

import com.scal.oa.domain.TicketSegment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.junit.Assert.*;

public class TicketSegmentServiceTest {
    @Autowired
    private TicketSegmentService ticketSegmentService;
    @Test
    public void getOne() throws Exception {
        TicketSegment ticketSegment=ticketSegmentService.getOne("CTU");
    }

    @Test
    public void findAll() throws Exception {
        List<TicketSegment> ticketSegmentList=ticketSegmentService.findAll();
    }

    @Test
    public void findByCode() throws Exception {
    }

}