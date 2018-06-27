package com.scal.oa.Contorller;

import com.scal.oa.Service.TicketSegmentService;
import com.scal.oa.VO.ResultVO;
import com.scal.oa.domain.TicketSegment;
import com.scal.oa.untils.ResultVOUntil;
import net.sourceforge.pinyin4j.PinyinHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class TicketSegmentController
{
    @Autowired
    private TicketSegmentService ticketSegmentService;
    //全查询
    @GetMapping("getAllTicketSegment")
    public ResultVO getAll()
    {
        return ResultVOUntil.success(ticketSegmentService.findAll());
    }
    //根据segmentCode查询
    @GetMapping(value = "getTicketSegment/{code}")
    public ResultVO getTicketSegment(@PathVariable("code") String code)
    {
        Optional<TicketSegment> ticketSegmentOptional=ticketSegmentService.findById(code);

        return ResultVOUntil.success(ticketSegmentOptional);



    }
    //模糊查询,根据segmentCode和segmentName
    @GetMapping(value = "getTicketSegmentLike/{key}")
    public ResultVO getTicketSegmentLike(@PathVariable("key") String key)
    {
        List<TicketSegment> ticketSegmentList=new ArrayList<>();
        ticketSegmentList.addAll(ticketSegmentService.findBySegmentCodeLike(key));
        ticketSegmentList.addAll(ticketSegmentService.findBySegmentNameLike(key));
        return ResultVOUntil.success(ticketSegmentList);

    }

    /***
     * 增加航线的方法,会将出发地的首字添加大写拼音,将code都替换成大写
     * @param from 出发地
     * @param to 目的地
     * @param fromCode 出发地三字码
     * @param toCode 目的地三字码
     * @return
     */
    @PostMapping(value="ticketSegmentAdd")
    public ResultVO ticketSegmentAdd(@RequestParam("from") String from,@RequestParam("to") String to,@RequestParam("fromCode") String fromCode,@RequestParam("toCode") String toCode)
    {
        TicketSegment ticketSegment=new TicketSegment();

        if(ticketSegmentService.findById(fromCode+toCode).isPresent())
        {

            return ResultVOUntil.error("1","此航线已存在");
        }
        else
        {
            ticketSegment.setSegmentCode(fromCode.toUpperCase()+toCode.toUpperCase());
            String[] pinyinArray= PinyinHelper.toHanyuPinyinStringArray(from.charAt(0));
            ticketSegment.setSegmentName(String.valueOf(pinyinArray[0].charAt(0)).toUpperCase()+from+to);
            ticketSegment.setDOrI("D");
            Date date=new Date();
            ticketSegment.setOp_date(date);
            return ResultVOUntil.success(ticketSegmentService.save(ticketSegment));
        }

    }
}
