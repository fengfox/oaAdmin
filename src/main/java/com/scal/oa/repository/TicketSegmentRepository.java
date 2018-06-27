package com.scal.oa.repository;

import com.scal.oa.domain.TicketSegment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketSegmentRepository extends JpaRepository<TicketSegment,String>
{
     List<TicketSegment> findBySegmentCodeLike(String code);
     List<TicketSegment> findBySegmentNameLike(String name);
}
