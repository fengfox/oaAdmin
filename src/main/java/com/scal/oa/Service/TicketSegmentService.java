package com.scal.oa.Service;

import com.scal.oa.domain.TicketSegment;
import com.scal.oa.repository.TicketSegmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketSegmentService {
    @Autowired
    private TicketSegmentRepository ticketSegmentRepository;
    public TicketSegment getOne(String code)
    {
        return ticketSegmentRepository.getOne(code);
    }
    public Optional<TicketSegment> findById(String code)
    {
        Optional<TicketSegment> ticketSegmentOptional=ticketSegmentRepository.findById(code);
        return ticketSegmentOptional;
    }
    public List<TicketSegment> findBySegmentCodeLike(String code)
    {
        return ticketSegmentRepository.findBySegmentCodeLike("%"+code+"%");
    }
    public List<TicketSegment> findBySegmentNameLike(String name)
    {
        return ticketSegmentRepository.findBySegmentNameLike("%"+name+"%");
    }
    public TicketSegment save(TicketSegment ticketSegment)
    {
        return ticketSegmentRepository.save(ticketSegment);
    }

    public List<TicketSegment> findAll()
    {
        return ticketSegmentRepository.findAll();
    }


}
